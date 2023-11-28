<template>
  <div class="main">
    <div class="messages"><Echarts2/></div>
    <div class="messages" style="top: 32%"><Echarts4/></div>
    <div class="video_area">
      <h3 style="width:100%;color: white;text-align: center">{{cameraName}}</h3>
    </div>
    <div class="messages2"><Echarts3/></div>
    <div class="video">
      <div class="videoArea" ref="videoAreaRef">
        <div style="overflow: auto;width: 100%;height: 100%" @dblclick="toggleFullscreen">
          <div class="video-container" style="width: 46%;height: 45%;" v-for="(item,index) in cameras" :key="index">
            <span style="position: absolute;color: white;">{{item.camera_id}}-{{item.camera_position}}</span>
            <video ref="videoRef" autoplay loop muted style="height: 100%;width: 100%">
              <source :src="item.camera_source" type="video/mp4">
            </video>
          </div>
        </div>
      </div>
      <div class="conBtnArea">
        <div style="margin: auto">
          <el-button  type="info" @click="getCameras('校园东区')">校园东区</el-button>
          <el-button  type="info" @click="getCameras('校园西区')">校园西区</el-button>
          <el-button  type="info" @click="getCameras('校园南区')">校园南区</el-button>
          <el-button  type="info" @click="getCameras('校园北区')">校园北区</el-button>
        </div>
      </div>
    </div>
    <div class="incident_messages">
      <Messages/>
    </div>
    <div class="bottom_messages" ref="bottom_messages">
      <SchoolModel :areaWidth="areaWidth" :areaHeight="areaHeight" />
    </div>
    <div class="bottom_messages2"><Echarts1/></div>
  </div>
</template>

<script setup>
import Echarts1 from '../DataVisualization/Echarts1.vue'
import Echarts2 from '../DataVisualization/Echarts2.vue'
import Echarts3 from '../DataVisualization/Echarts3.vue'
import Echarts4 from '../DataVisualization/Echarts4.vue'
import Messages from '../DataVisualization/Messages.vue'
import SchoolModel from '../DataVisualization/schoolModel/School.vue'
import {onMounted, ref} from "vue";
import apiService from "../../services/apiService";

const bottom_messages = ref(null)
const areaWidth = ref(0)
const areaHeight = ref(0)
const cameraName = ref('校园东区')
const cameras = ref(null)

onMounted(() => {
  const observer = new ResizeObserver((entries) => {
    entries.forEach((entry) => {
      areaWidth.value = entry.contentRect.width
      areaHeight.value = entry.contentRect.height
    });
  });
  observer.observe(bottom_messages.value);
  getCameras("校园东区")
});

const videoAreaRef = ref(null);

async function getCameras(areaName) {
  cameraName.value = areaName
  cameras.value = null
  cameras.value = await apiService.get_cameras(areaName);
}

const toggleFullscreen = () => {
  const videoArea = videoAreaRef.value;
  if (!document.fullscreenElement) {
    if (videoArea.requestFullscreen) {
      videoArea.requestFullscreen();
    } else if (videoArea.mozRequestFullScreen) {
      videoArea.mozRequestFullScreen();
    } else if (videoArea.webkitRequestFullscreen) {
      videoArea.webkitRequestFullscreen();
    } else if (videoArea.msRequestFullscreen) {
      videoArea.msRequestFullscreen();
    }
  } else {
    if (document.exitFullscreen) {
      document.exitFullscreen();
    } else if (document.mozCancelFullScreen) {
      document.mozCancelFullScreen();
    } else if (document.webkitExitFullscreen) {
      document.webkitExitFullscreen();
    } else if (document.msExitFullscreen) {
      document.msExitFullscreen();
    }
  }
};

</script>

<style scoped>
.videoImg{
  margin: auto;
  height: 100%;
  width: 100%;
}
.video-container {
  width: 96%;
  height: 96%;
  position: relative;
  overflow: hidden;
  border: 2px white solid;
  background-color: #333333;
  float: left;
  margin-left: 2%;
  margin-top: 2%
}

.video-container video {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
}
.main {
  width: 100%;
  height: 100%;
}
.video_area {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 44%;
  height: 5%;
  background-color: #0f0f11;
  position: absolute;
  left: 28%;
  top: 1%;
}
.video {
  width: 44%;
  height: 55%;
  background-color: #0f0f11;
  position: absolute;
  left: 28%;
  top: 7%;
}
.messages {
  width: 26%;
  height: 30%;
  background-color: #0f0f11;
  position: absolute;
  left: 1%;
  top: 1%;
}
.messages2 {
  width: 26%;
  height: 35%;
  background-color: #0f0f11;
  position: absolute;
  right: 1%;
  top: 1%;
}
.incident_messages{
  overflow: auto;
  width: 26%;
  height: 62%;
  background-color: #0f0f11;
  position: absolute;
  right: 1%;
  top: 37%;
}
.bottom_messages{
  width: 26%;
  height: 36%;
  background-color: #0f0f11;
  position: absolute;
  left: 1%;
  bottom: 1%;
}
.bottom_messages2{
  width: 44%;
  height: 36%;
  background-color: #0f0f11;
  position: absolute;
  left: 28%;
  bottom: 1%;
}
.videoArea{
  width: 100%;
  height: 90%;
}
.conBtnArea {
  display: flex;
  align-items: center;
  width: 100%;
  height: 10%;
}
</style>