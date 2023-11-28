<template>
  <div class="error-page">
    <div class="error_pic"/>
    <h2 style="color: rgba(255,255,255,0.76)">访问被拒绝</h2>
    <h2 style="color: rgba(255,255,255,0.76)">被检测到您并非本人</h2>
    <h2 style="color: rgba(255,255,255,0.76)" v-if="countdown > 0">在 {{ countdown }} 秒后，将进行重新登录</h2 >
  </div>
</template>

<script setup>
import {ref, watch, onMounted} from 'vue';
import {useRouter} from 'vue-router';

const countdown = ref(5);
const router = useRouter();
const startCountdown = () => {
  let timer = setInterval(() => {
    countdown.value--;
    if (countdown.value <= 0) {
      clearInterval(timer);
    }
  }, 1000);
};

watch(countdown, (newValue) => {
  if (newValue <= 0) {
    router.replace('/')
  }
});

onMounted(() => {
  startCountdown();
});
</script>

<style>
.error_pic{
  margin: auto;
  height: 600px;
  width: 600px;
  background-image: url('src/assets/images/403.png'); /* 设置背景图像的路径 */
  background-size: cover;
  background-position: center;
}
.error-page {
  height: 100%;
  text-align: center;
  background-color: #555555;
}

.error-page h1 {
  font-size: 72px;
  margin-bottom: 10px;
}

.error-page h3 {
  font-size: 24px;
  margin-bottom: 20px;
}

.error-page p {
  font-size: 16px;
}
</style>
