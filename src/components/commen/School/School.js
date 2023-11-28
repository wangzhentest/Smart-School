import * as THREE from 'three'

export default class Base{
    constructor(canvas) {
        this.scene = new THREE.Scene()
        this.camera = new THREE.PerspectiveCamera(
            75,
            window.innerWidth/window.innerHeight,
            0.001,
            10000
        )
        this.camera.position.x = 0
        this.camera.position.y = 20
        this.camera.position.z = 35

        this.camera.updateProjectionMatrix()
        this.camera.updateProjectionMatrix()

        this.renderer = new THREE.WebGLRenderer({canvas,antialias:true})
        this.renderer.setSize(1399 , 948)
        this.renderer.setPixelRatio(window.devicePixelRatio)
    }
    resize(){
        this.camera.aspect = window.innerWidth/window.innerHeight
        this.camera.updateProjectionMatrix()
    }
    changeSize(width,height){
        this.renderer.setSize(width,height)
    }
}