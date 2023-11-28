<template>
  <div class="login-container">
    <h1 class="login-title">{{ $t('SystemTitle') }}</h1>
    <form class="login-form">
      <el-input
          style="margin-top: 10%"
          class="login-input"
          v-model="account"
          placeholder="Account"
          clearable
      ></el-input>
      <el-input
          class="login-input"
          v-model="pwd"
          placeholder="Password"
          show-password
          clearable
      ></el-input>
      <el-button class="login-button" @click="login">{{ $t('Login') }}</el-button>
    </form>
  </div>
</template>

<script setup>
import { ref} from "vue";
import apiService from "../services/apiService.js";
import { ElNotification } from "element-plus";
import { setCookie } from "../utils/cookie";
import { useRouter } from 'vue-router';
import { useI18n } from 'vue-i18n';
const i18n = useI18n();
const account = ref("");
const pwd = ref("");
const router = useRouter();
const redirectToMainPage = (data) => {
  router.replace({
    path: 'MainPage',
    query: { data: JSON.stringify(data.value) }
  });
};

async function login() {
  try {
    const data = await apiService.Login(account.value, pwd.value);
    if (data !== "") {
      redirectToMainPage(data)
      setCookie("userInfo", JSON.stringify(data), 6);
      ElNotification({
        title: i18n.t('Success'),
        message: i18n.t('Login successful'),
        type: "success",
      });
    } else {
      ElNotification({
        title: i18n.t('Error'),
        message: i18n.t('Login failed'),
        type: "error",
      });
    }
  } catch (error) {
    console.error(error);
  }
}
</script>

<style scoped>
.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #222;
}

.login-title {
  font-size: 2.5rem;
  margin-bottom: 2rem;
  color: #ddd;
}

.login-form {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 30%;
  height: 30%;
  background-color: #333;
  padding: 2rem;
  border-radius: 5px;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.3);
}

.login-input {
  width: 80%;
  height: 20%;
  margin-bottom: 1rem;
  background-color: #444;
}

.login-button {
  font-size: 20px;
  color: white;
  width: 60%;
  height: 20%;
  border-radius: 20px;
  background-color: #555;
}
</style>