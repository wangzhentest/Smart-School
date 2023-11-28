<template>
  <div class="container">
    <canvas ref="canvasDom" id="canvasDom"></canvas>
    <el-progress type="circle" :percentage="percentageNum" class="progress" v-if="ifShow"/>
    <el-button @click="changeDay" class="btn" style="top: 10px">白天</el-button>
    <el-button @click="changeNight" class="btn" style="margin-left: 120px;top: 10px">夜晚</el-button>
    <el-button @click="backToOrigin" class="btn" style="top: 50px">视角返回</el-button>
  </div>
</template>

<script setup>
import * as THREE from 'three'
import Base from './School.js'
import {onMounted, ref, watch} from "vue";
import {GLTFLoader} from 'three/examples/jsm/loaders/GLTFLoader'
import {OrbitControls} from 'three/examples/jsm/controls/OrbitControls'
import {GUI} from 'three/examples/jsm/libs/lil-gui.module.min'
import {gsap} from "gsap";

const rayCaster = new THREE.Raycaster();
rayCaster.layers.set(1)
const pointer = new THREE.Vector2()
let amLight = new THREE.AmbientLight(0xffffff);
let dirLight = new THREE.DirectionalLight(0xffffff);
let base, controls, camera, schoolModel
let ambientLightIntensity = ref(0.8);
let directionalLightIntensity = ref(0.8);
const percentageNum = ref(0)
const ifShow = ref(true)
let ball = []
const canvasDom = ref(null)
onMounted(() => {
  base = new Base(canvasDom.value)
  controls = new OrbitControls(base.camera, base.renderer.domElement)
  controls.enablePan = false;
  addLight()
  loadModel()
  update()
  window.addEventListener('pointerdown', onPointerDown);
  // createGui()
  // controls.addEventListener('change', function() {
  //   // 输出相机的位置
  //   console.log('Camera position:', base.camera.position);
  //   // 获取相机的朝向
  //   const cameraDirection = new THREE.Vector3();
  //   base.camera.getWorldDirection(cameraDirection);
  //   console.log('Camera direction:', cameraDirection);
  // });
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
  base.changeSize(newWidth, newHeight)
})

function createGui(model) {
  const gui = new GUI()
  let obj = {x: 0, y: 0, z: 0, rx: 0, ry: 0, rz: 0}
  gui.add(obj, 'x', -100.0, 100.0, 0.1).onChange((val) => {
    base.camera.position.x = val
  })
  gui.add(obj, 'y', -100.0, 100.0, 0.1).onChange((val) => {
    base.camera.position.y = val
  })
  gui.add(obj, 'z', -100.0, 100.0, 0.1).onChange((val) => {
    base.camera.position.z = val
  })
  gui.add(obj, 'rx', -100.0, 100.0, 0.1).onChange((val) => {
    model.rotation.x = val
  })
  gui.add(obj, 'ry', -100.0, 100.0, 0.1).onChange((val) => {
    model.rotation.y = val
  })
  gui.add(obj, 'rz', -100.0, 100.0, 0.1).onChange((val) => {
    model.rotation.z = val
  })
}

function loadModel() {
  const loader = new GLTFLoader();
  loader.load(
      'schoolModel.glb',
      (obj) => {
        schoolModel = obj.scene;
        console.log(obj)
        let model = obj.scene;
        gsap.to(model.rotation, {
          y: 2 * Math.PI,
          duration: 2
        });
        addObj(model.children);
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

let isClickCamera = false

function addObj(obj) {
  obj.forEach(val => {
    if (val instanceof THREE.Mesh) {
      if (val.name.includes('camera')) {
        val.layers.enable(1)
      }
      if (val.name.includes('ball')) {
        let color = new THREE.Color(1, 1, 1)
        let light = new THREE.PointLight(color.getHex(), 0, 5)
        light.matrixWorld = val.matrixWorld
        ball.push(light)
        base.scene.add(light)
      }
      if (val.name.includes('warning')) {
        gsap.to(val.position, {
          y: "+=2",
          yoyo: true,
          repeat: -1,
          duration: 1,
          ease: "power1.inOut",
        });
      }
    } else {
      addObj(val.children)
    }
  })
}

function update() {
  requestAnimationFrame(update)
  rayCaster.setFromCamera(pointer, base.camera);
  const intersects = rayCaster.intersectObjects(base.scene.children);
  if (intersects.length > 0) {
    if (intersects[0].object.name === 'camera_carPark' && isClickCamera) {
      isClickCamera = false
      console.log('camera_carPark')
    } else if (intersects[0].object.name === 'camera_playground' && isClickCamera) {
      isClickCamera = false
      console.log('camera_playground')
    }
  }
  controls.update()
  base.renderer.render(base.scene, base.camera)
  base.resize()
}

function changeDay() {
  gsap.to([amLight, dirLight], {
    intensity: 0.8,
    duration: 2,
  });
  for (let i = 0; i < ball.length; i++) {
    gsap.to(ball[i], {
      intensity: 0,
      duration: 2,
    });
  }
}

function changeNight() {
  gsap.to([amLight, dirLight], {
    intensity: 0.1,
    duration: 2,
  });
  for (let i = 0; i < ball.length; i++) {
    gsap.to(ball[i], {
      intensity: 10,
      duration: 2,
    });
  }
}

function goToCameraCarPark() {
  gsap.to(base.camera.position, {
    x: 0,
    y: 1.727,
    z: 8.477,
    duration: 1,
    ease: 'power2',
    onUpdate: function () {
      // 更新相机的朝向
      base.camera.lookAt(-0.201, -0.012, 0.002);
    }
  });
}

function goToCameraPlayGround() {
  gsap.to(base.camera.position, {
    x: -5.714,
    y: 6.457,
    z: 2.647,
    duration: 1,
    ease: 'power2',
    onUpdate: function () {
      // 更新相机的朝向
      base.camera.lookAt(-0.405, -0.467, -0.785);
    }
  });
}

function backToOrigin() {
  gsap.to(base.camera.position, {
    x: 0,
    y: 20,
    z: 35,
    duration: 1,
    ease: 'power2',
  });
}

function addLight() {
  amLight.intensity = ambientLightIntensity.value;
  base.scene.add(amLight);

  dirLight.intensity = directionalLightIntensity.value;
  base.scene.add(dirLight);
}

function onPointerDown(event) {
  isClickCamera = true
  pointer.x = (event.clientX / window.innerWidth) * 2 - 1;
  pointer.y = -(event.clientY / window.innerHeight) * 2 + 1;
}

</script>

<style scoped>
#canvasDom {
  width: 100px;
  height: 100px;
  position: absolute;
  z-index: 1;
}

.btn {
  position: absolute;
  z-index: 2;
  margin-left: 50px;
}

.container {
  width: 100px;
  height: 100px;
}

.progress {
  position: absolute;
  z-index: 2;
  left: 45%;
  top: 45%;
}
</style>
