<template>
  <h3 style="color: rgba(255,255,255,0.34)">&nbsp;事故告警<el-button style="position: absolute;right: 1%" @click="dialogFormVisible = true">告警测试</el-button></h3>

  <el-collapse class="custom-collapse" v-model="activeNames" >
    <el-collapse-item :name="index" v-for="(item,index) in messages" :key="index">
      <template v-slot:title>
        <div class="title-container">
          &nbsp;<el-tag type="danger" effect="dark" class="right-aligned-tag">{{item.alarm_reason}}</el-tag>
          <span>&nbsp;{{item.occur_date}}</span>
        </div>
      </template>
      <div>
        监控名:{{item.camera_id}}<br>
        发生地点:{{item.occur_place}}<br>
        <el-button type="danger" size="small" style="margin-left: 80%" @click="delete_message(item.id)">删除</el-button>
      </div>
    </el-collapse-item>
  </el-collapse>
  <el-dialog v-model="dialogFormVisible" title="添加新的事故，用于模拟事故发生" destroy-on-close width="30vw">
    <el-form :model="form" v-if="dialogFormVisible">
      <el-form-item label="发出告警的监控" :label-width="formLabelWidth">
        <el-select v-model="form.camera_id" placeholder="请选择监控">
          <el-option label="EastCamera1" value="EastCamera1"/>
          <el-option label="EastCamera2" value="EastCamera2"/>
          <el-option label="EastCamera3" value="EastCamera3"/>
          <el-option label="EastCamera4" value="EastCamera4"/>
        </el-select>
      </el-form-item>
      <el-form-item label="事故类型" :label-width="formLabelWidth">
        <el-select v-model="form.alarm_reason" placeholder="请事故类型">
          <el-option label="人员受伤" value="人员受伤"/>
          <el-option label="火灾事故" value="火灾事故"/>
          <el-option label="设备损坏" value="设备损坏"/>
          <el-option label="危险告警" value="危险告警"/>
          <el-option label="人员闯入" value="人员闯入"/>
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="danger" @click="input_form">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>
<script setup>
import {getCookie} from '../../utils/cookie';
import {onBeforeUnmount, onMounted, reactive, ref} from "vue";
import apiService from "../../services/apiService";
import {ElMessage, ElMessageBox, ElNotification} from "element-plus";
const timer = ref(null);
const user = reactive(JSON.parse(getCookie("userInfo")))
const activeNames = ref(['1'])
const messages = ref(null);
const dialogFormVisible = ref(false)
const formLabelWidth = '140px'
const form = reactive({
  camera_id: '',
  alarm_reason: ''
})

onMounted(() => {
  get_messages()
  startTimer()
})

onBeforeUnmount(() => {
  stopTimer()
});

function startTimer() {
  if (timer.value === null) {
    timer.value = setInterval(() => {
      get_messages()
    }, 2000);
  }
}

function stopTimer() {
  clearInterval(timer.value);
  timer.value = null;
}

async function delete_message(id) {
  ElMessageBox.confirm(
      '您确定要删除吗?',
      'Warning',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }
  ).then(async () => {
    ElMessage({
      type: 'success',
      message: '删除成功',
    });
    await apiService.delete_message(id, user.user_id);
  }).catch(() => {
    ElMessage({
      type: 'info',
      message: '删除已取消',
    })
  })
}

const get_messages = async () => {
  messages.value = await apiService.get_messages();
}

function input_form(){
  if (form.camera_id === '' && form.alarm_reason === '') {
    ElMessage({
      type: 'warning',
      message: '请填写完整',
    })
  }else {
    dialogFormVisible.value = false
    add_messages(form.camera_id,form.alarm_reason)
  }
}

async function add_messages(camera_id,alarm_reason) {
  await apiService.add_messages(camera_id,alarm_reason);
  await apiService.add_incident(camera_id,alarm_reason);
  ElMessage({
    type: 'success',
    message: '模拟事故发生成功',
  });
}

</script>
<style>
.custom-collapse {
  background-color: rgba(63, 63, 64, 0.22);
  color: white;
  margin-top: 10px;
}

.custom-collapse .el-collapse-item__header {
  background-color: rgba(63, 63, 64, 0.22);
  color: white;
}

.custom-collapse .el-collapse-item__content {
  background-color: rgba(0, 0, 0, 0.9);
  color: white;
}

.title-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.right-aligned-tag {
  margin-left: auto;
}
</style>
