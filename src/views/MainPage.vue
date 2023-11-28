<template>
  <div class="container">
    <div class="left-box">
      <Clock/>
      <hr>
      <div class="person_message">
        <h1>Hi!&nbsp;{{ user.name }}</h1>
        <h3>{{ user.position }}</h3>
      </div>
      <hr>
      <ul>
        <li class="item" @click="other_router(0)">
          <el-icon :size="25">
            <School/>
          </el-icon>&nbsp;{{ $t('Campus model') }}
        </li>
        <li class="item" @click="other_router(1)">
          <el-icon :size="25">
            <Monitor/>
          </el-icon>&nbsp;{{ $t('Real-time monitoring') }}
        </li>
        <li class="item" @click="other_router(2)">
          <el-icon :size="25">
            <Warning/>
          </el-icon>
          <el-badge :value="untreated_incidents_length" class="item">
            &nbsp;{{ $t('List of incidents') }}
          </el-badge>
        </li>
        <li class="item" @click="other_router(4)">
          <el-icon :size="25">
            <User/>
          </el-icon>&nbsp;{{ $t('Personnel information') }}
        </li>
        <li class="item" @click="other_router(5)">
          <el-icon :size="25">
            <Tickets/>
          </el-icon>&nbsp;{{ $t('Accident report') }}
        </li>
        <li class="item" @click="other_router(6)">
          <el-icon :size="25">
            <Notebook/>
          </el-icon>&nbsp;{{ $t('System log') }}
        </li>
        <li class="item" @click="other_router(7)">
          <el-icon :size="25">
            <Upload/>
          </el-icon>&nbsp;{{ $t('Exception feedback') }}
        </li>
        <br>
        <hr>
        <li class="item" @click="other_router(8)">
          <el-icon :size="25">
            <Phone/>
          </el-icon>&nbsp;{{ $t('Contact us') }}
        </li>
        <li class="item" @click="other_router(9)">
          <el-icon :size="25">
            <Back/>
          </el-icon>&nbsp;{{ $t('Log out') }}
        </li>
      </ul>
      <div class="user-info">
        <img src="../assets/images/monitor.png" alt="">
        <span>{{ $t('SystemTitle') }}</span>
        <i class="icon icon-gear"></i>
      </div>
    </div>
    <el-dialog v-model="dialogFormVisible" :title="$t('Exception feedback')" destroy-on-close width="30vw">
      <el-form :model="form" v-if="dialogFormVisible">
        <el-form-item :label="$t('Feedback type')" :label-width="formLabelWidth">
          <el-select v-model="form.type" :placeholder="$t('Please select a type')">
            <el-option :label="$t('System malfunction')" :value="$t('System malfunction')"/>
            <el-option :label="$t('Campus abnormal events')" :value="$t('Campus abnormal events')"/>
          </el-select>
        </el-form-item>
        <el-form-item :label="$t('Reason for feedback')" :label-width="formLabelWidth">
          <el-input v-model="form.reason" autocomplete="off" :placeholder="$t('Please enter the reason')"/>
        </el-form-item>
        <el-form-item :label="$t('Additional information')" :label-width="formLabelWidth">
          <el-input v-model="form.other" autocomplete="off" :placeholder="$t('No additional information, optional to leave blank')"/>
        </el-form-item>
      </el-form>
      <template #footer>
      <span class="dialog-footer">
        <el-button @click="cancel_form">{{ $t('Cancel') }}</el-button>
        <el-button type="danger" @click="input_form">
          {{ $t('Input') }}
        </el-button>
      </span>
      </template>
    </el-dialog>
    <el-dialog v-model="centerDialogVisible" :title="$t('Contact us')" width="50vh" center>
      <span style="text-align: center">
        {{ $t('If you encounter an unresolved issue, you can contact us through the following means') }}<br>
        {{ $t('Phone: 123456') }}<br>
        {{ $t('Address: Hangzhou, Zhejiang Province, China') }}
      </span>
    </el-dialog>
    <div class="right-box">
      <div class="middle">smart campus system</div>
      <div class="handler" :class="{close: isClose}" @click="toggleHandler"></div>
      <div class="router_area" v-show="if_show">
        <transition name="el-fade-in">
          <router-view></router-view>
        </transition>
      </div>
    </div>
  </div>
</template>
<script setup>
import Clock from "../components/commen/Clock.vue";
import {onMounted, reactive, ref, onBeforeUnmount} from 'vue';
import {getCookie} from '../utils/cookie';
import {useRouter} from 'vue-router';
import apiService from "../services/apiService";
import {ElMessage, ElNotification, ElMessageBox} from 'element-plus'
import { useI18n } from 'vue-i18n';
const i18n = useI18n();
let untreated_incidents_length = ref(null);
let if_show = ref(false)
let isClose = ref(false)
const user = reactive(JSON.parse(getCookie("userInfo")))
const router = useRouter();
const dialogFormVisible = ref(false)
const centerDialogVisible = ref(false)
const formLabelWidth = '140px'
const form = reactive({
  reason: '',
  type: '',
  other: ''
})

onMounted(() => {
  go_online()
  startTimer()
});

onBeforeUnmount(() => {
  stopTimer()
});

function other_router(id) {
  if (id === 0) {
    router.push('/SchoolModel')
    if_show.value = true
  } else if (id === 1) {
    router.push('/Monitoring')
    if_show.value = true
  } else if (id === 2) {
    router.push('/Incidents')
    if_show.value = true
  } else if (id === 4) {
    router.push('/Staffs')
    if_show.value = true
  } else if (id === 5) {
    router.push('/IncidentReport')
    if_show.value = true
  } else if (id === 6) {
    router.push('/SystemLogs')
    if_show.value = true
  } else if (id === 7) {
    dialogFormVisible.value = true
  } else if (id === 8) {
    centerDialogVisible.value = true
  } else if (id === 9) {
    ElMessageBox.confirm(
        i18n.t('Are you sure you want to exit?'),
        'Warning',
        {
          confirmButtonText: i18n.t('Confirm'),
          cancelButtonText: i18n.t('Cancel'),
          type: 'warning',
        }
    ).then(() => {
      router.replace('/')
      ElNotification({
        title: i18n.t('Logout successful'),
        message: i18n.t('Thank you for using it'),
        type: "success",
      });
      down_online()
      stopTimer()
    }).catch(() => {
      ElMessage({
        type: 'info',
        message: i18n.t('Logout cancellation confirmed'),
      })
    })
  }
}

function cancel_form() {
  dialogFormVisible.value = false
  ElMessage({
    type: 'info',
    message: i18n.t('Submission canceled'),
  })
}

function input_form() {
  if (form.reason === '' && form.type === '') {
    ElMessage({
      type: 'warning',
      message: i18n.t('Please fill in all required fields'),
    })
  }else {
    dialogFormVisible.value = false
    ElMessage({
      type: 'success',
      message: i18n.t('Submission successful'),
    })
  }
}

const toggleHandler = () => {
  isClose.value = !isClose.value
  const leftBox = document.querySelector('.left-box')
  if (isClose.value) {
    leftBox.style.width = 0
  } else {
    leftBox.style.width = '250px'
  }
}

async function go_online() {
  await apiService.go_online(user.user_id);
}

async function down_online() {
  await apiService.down_online(user.user_id);
}

const timer = ref(null);

function startTimer() {
  if (timer.value === null) {
    if (user === null) {
      router.replace('/LoginIn')
      ElMessage({
        type: 'info',
        message: i18n.t('Information has expired. Please log in again.'),
      })
    }
    timer.value = setInterval(() => {
      get_not_reminded_messages()
      get_untreated_incidents()
    }, 2000);
  }
}

function stopTimer() {
  clearInterval(timer.value);
  timer.value = null;
}

const get_untreated_incidents = async () => {
  const untreated_incidents = await apiService.get_untreated_incidents();
  untreated_incidents_length.value = untreated_incidents.length
};

const not_reminded_messages = ref(null)

function showMessage(newMessage){
  const message = `监控:${newMessage.camera_id}发出警告${newMessage.occur_date}时,在${newMessage.occur_place}发生${newMessage.alarm_reason}`
  remind_message(newMessage.id)
  ElNotification({
    title: "警告",
    message: message,
    type: "warning",
    duration: 0,
  });
}

async function remind_message(id) {
  await apiService.remind_message(id);
}

const get_not_reminded_messages = async () => {
  stopTimer()
  not_reminded_messages.value = await apiService.get_not_reminded_messages();
  if (not_reminded_messages.value.length > 0){
    for (let i = 0; i < not_reminded_messages.value.length; i++) {
      await remind_message(not_reminded_messages.value[i].id)
      setTimeout(showMessage(not_reminded_messages.value[i]), 1000);
    }
  }
  startTimer()
};

</script>
<style>
.router_area {
  width: 96%;
  height: 100%;
  position: absolute;
  right: 2%;
  background-color: #333;
  z-index: 2
}

* {
  margin: 0;
  padding: 0;
}

.item {
  font-size: 20px;
}

.person_message {
  width: 100%;
  height: 6%;
  text-indent: 30px;
}

.container {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  background-size: cover;
  display: flex;
}

.icon {
  color: #fff;
  font-size: 30px;
}

.left-box {
  width: 250px;
  height: 100%;
  background-color: #333;
  backdrop-filter: blur(30px);
  position: relative;
  color: #fff;
  font-size: 14px;
  display: flex;
  flex-direction: column;
  transition: 0.5s ease;
  white-space: nowrap;
}

.left-box ul {
  list-style: none;
  width: 90%;
  margin: 25px auto;
  flex: 1;
}

.left-box li {
  height: 46px;
  display: flex;
  align-items: center;
  padding-left: 12px;
  border-radius: 10px;
  cursor: pointer;
  transition: 0.3s;
}

.left-box li:hover {
  background-color: rgba(255, 255, 255, 0.1);
}

.left-box hr {
  width: 90%;
  margin: 18px auto;
  border: none;
  border-top: 1px solid rgba(255, 255, 255, 0.2);
}

.left-box .icon {
  margin-right: 16px;
}

.user-info {
  border-top: 1px solid rgba(255, 255, 255, 0.2);
  display: flex;
  align-items: center;
  padding: 24px;
}

.user-info img {
  width: 32px;
  height: 32px;
  border-radius: 50%;
  object-fit: cover;
  margin-right: 14px;
}

.user-info span {
  flex: 1;
}

.user-info .icon {
  font-size: 20px;
  margin-right: 0;
}

.right-box {
  background-color: #0f0f11;
  flex: 1;
  position: relative;
  display: flex;
  flex-direction: column;
}

.right-box .middle {
  position: absolute;
  top: 43%;
  right: 5%;
  z-index: 1;
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #222;
  font-size: 6vw;
  font-weight: bold;
  text-transform: uppercase;
}

.right-box .handler {
  width: 10px;
  height: 50px;
  position: absolute;
  left: 10px;
  top: 50%;
  transform: translateY(-50%);
  z-index: 1;
  cursor: pointer;
  opacity: 0;
  transition: opacity 0.3s;
}

.right-box .handler::before,
.right-box .handler::after {
  content: "";
  background-color: rgba(255, 255, 255, 0.2);
  position: absolute;
  left: 0;
  width: 100%;
  height: 50%;
  border-radius: 10px 10px 0 0;
  transition: 0.2s;
}

.right-box .handler::after {
  bottom: 0;
  border-radius: 0 0 10px 10px;
}

.right-box:hover .handler {
  opacity: 1;
}

.right-box .handler:hover::before {
  transform: skewX(-15deg);
}

.right-box .handler:hover::after {
  transform: skewX(15deg);
}

.right-box .handler.close:hover::before {
  transform: skewX(15deg);
}

.right-box .handler.close:hover::after {
  transform: skewX(-15deg);
}

.el-button--text {
  margin-right: 15px;
}

.el-select {
  width: 300px;
}

.el-input {
  width: 300px;
}

.dialog-footer button:first-child {
  margin-right: 10px;
}

.el-fade-in-enter-active,
.el-fade-in-leave-active {
  transition: opacity 0.3s;
}

.el-fade-in-enter,
.el-fade-in-leave-to {
  opacity: 0;
}
</style>
