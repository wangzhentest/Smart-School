<template>
  <div class="main">
    <div class="search-bar">
      <el-button  @click="getGuards">安保人员</el-button>
      <el-button style="margin-left: 1%" @click="getMedicalStaffs">医护人员</el-button>
      <el-button style="margin-left: 1%" @click="getRepairmen">维修人员</el-button>
      <el-button style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);" disabled="0">系统操作人员</el-button>
    </div>
    <div class="descriptionsArea">
      <div style="width: 100%;height: 3%"></div>
      <el-descriptions size="large" border style="margin-left:1%;margin-right:1%;width: 98%;margin-bottom: 1%" v-for="(item,index) in tableData" :key="index">
        <el-descriptions-item >
          <template #label>
            <el-icon :size="20">
              <UserFilled/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;员工号</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.user_id"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <user/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;姓名</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.name"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <Medal/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;职位</span>
          </template>
          <el-tag size="large">&nbsp;{{item.position}}</el-tag>
        </el-descriptions-item>

        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <Calendar/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;年龄</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.age"/>
        </el-descriptions-item>

        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <Male/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;性别</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.sex"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <iphone/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;联系方式</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.phone"/>
        </el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script setup>
import apiService from "../../../services/apiService";
import {onMounted, ref} from "vue";
import {useRouter} from "vue-router";
onMounted(() =>{
  get_users()
})
const tableData = ref(null);
const get_users = async () => {
  tableData.value = await apiService.get_users();
};
const router = useRouter();

function getGuards(){
  router.push('/Guards')
}

function getMedicalStaffs(){
  router.push('/MedicalStaffs')
}

function getRepairmen(){
  router.push('/Repairmen')
}
</script>

<style scoped>
.main {
  border-radius: 5%;
  width: 100%;
  height: 100%;
}
.search-bar {
  width: 100%;
  height: 4%;
  margin-left: 1%;
  display: flex;
  align-items: center;
  margin-top: 1%;
  position: relative;
}
.descriptionsArea{
  background-color: white;
  margin-left: 1%;
  width: 100%;
  height: 91%;
  margin-top: 1%;
  overflow: auto;
}
</style>