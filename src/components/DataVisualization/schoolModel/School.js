import * as THREE from 'three'

export default class Base {
    constructor(canvas) {
        const canvasWidth = canvas.width;
        const canvasHeight = canvas.height;

        this.scene = new THREE.Scene()
        this.scene.background = new THREE.Color('#0f0f11'); // 设置背景颜色
        this.camera = new THREE.PerspectiveCamera(
            75,
            canvasWidth / canvasHeight,
            0.001,
            10000
        )
        this.camera.position.x = 0
        this.camera.position.y = 8
        this.camera.position.z = 40

        this.camera.updateProjectionMatrix()

        // 创建渲染器，指定大小为 canvas 的宽度和高度
        this.renderer = new THREE.WebGLRenderer({ canvas, antialias: true })
        this.renderer.setSize(400, 400)
        this.renderer.setPixelRatio(window.devicePixelRatio)
    }
    resize(width,height){
        this.renderer.setSize(width,height)
    }
}
