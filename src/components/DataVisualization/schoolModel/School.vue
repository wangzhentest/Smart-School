<template>
  <h3 style="color: rgba(255,255,255,0.34);position: absolute">&nbsp;学校模型</h3>
  <el-progress type="circle" :percentage="percentageNum" class="progress" v-if="ifShow"/>
  <canvas ref="canvasDom" ></canvas>
</template>

<script setup>
import * as THREE from 'three'
import Base from './School.js'
import {onMounted, watch,ref} from "vue";
import {GLTFLoader} from 'three/examples/jsm/loaders/GLTFLoader'
import {OrbitControls} from 'three/examples/jsm/controls/OrbitControls'
import {gsap} from "gsap";
import {GUI} from "three/examples/jsm/libs/lil-gui.module.min";
const rayCaster = new THREE.Raycaster();
rayCaster.layers.set(1)
let amLight = new THREE.AmbientLight(0xffffff);
let dirLight = new THREE.DirectionalLight(0xffffff);
let base,controls,schoolModel
let ambientLightIntensity = ref(0.8);
let directionalLightIntensity = ref(0.8);
const canvasDom = ref(null)
const percentageNum = ref(0)
const ifShow = ref(true)
onMounted(() => {
  base = new Base(canvasDom.value)
  controls = new OrbitControls(base.camera, base.renderer.domElement)
  addLight()
  loadModel()
  update()
  // createGui()
})
const props = defineProps({
  areaWidth: {
    type: Number,
    default: 0
  },
  areaHeight: {
    type: Number,
    default: 0
  }
})

watch(() => [props.areaWidth, props.areaHeight], ([newWidth, newHeight]) => {
  base.resize(newWidth,newHeight)
})

function createGui(model){
  const gui = new GUI()
  let obj = {x:0,y:0,z:0,rx:0,ry:0,rz:0}
  gui.add(obj,'x',-100.0,100.0,0.1).onChange((val)=>{
    base.camera.position.x=val
  })
  gui.add(obj,'y',-100.0,100.0,0.1).onChange((val)=>{
    base.camera.position.y=val
  })
  gui.add(obj,'z',-100.0,100.0,0.1).onChange((val)=>{
    base.camera.position.z=val
  })
  gui.add(obj,'rx',-100.0,100.0,0.1).onChange((val)=>{
    model.rotation.x = val
  })
  gui.add(obj,'ry',-100.0,100.0,0.1).onChange((val)=>{
    model.rotation.y = val
  })
  gui.add(obj,'rz',-100.0,100.0,0.1).onChange((val)=>{
    model.rotation.z = val
  })
}

function loadModel() {
  const loader = new GLTFLoader();
  loader.load(
      'schoolModel.glb',
      (obj) => {
        schoolModel = obj.scene;
        let model = obj.scene;
        gsap.to(obj.scene.rotation, {
          y: 2*Math.PI,
          yoyo:true,
          repeat: -1,
          duration: 40,
        })
        base.scene.add(model);
        ifShow.value = false
      },
      (xhr) => {
        percentageNum.value = Math.round(xhr.loaded / xhr.total * 100 * 10) / 10;
      },
      (error) => {
        console.error('Error loading model:', error);
      }
  );
}



function update() {
  requestAnimationFrame(update)
  controls.update()
  base.renderer.render(base.scene, base.camera)
}


function addLight() {
  amLight.intensity = ambientLightIntensity.value;
  base.scene.add(amLight);

  dirLight.intensity = directionalLightIntensity.value;
  base.scene.add(dirLight);
}

</script>

<style>

* {
  margin: 0;
  padding: 0;
}
.progress {
  position: absolute;
  z-index: 2;
  left: 35%;
  top: 35%;
}
</style>
