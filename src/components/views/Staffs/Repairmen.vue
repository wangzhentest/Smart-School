<template>
  <div class="main">
    <div class="search-bar">
      <el-button @click="getOperates">系统操作人员</el-button>
      <el-button style="margin-left: 1%" @click="getGuards">安保人员</el-button>
      <el-button style="margin-left: 1%" @click="getMedicalStaffs">医护人员</el-button>
      <el-button style="position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%);" disabled="0">维修人员</el-button>
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
          <el-input style="width: 180px;" :readonly="true" :model-value="item.repairman_id"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <user/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;姓名</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.repairman_name"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <OfficeBuilding/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;办公室</span>
          </template>
          <el-tag size="large">&nbsp;{{item.repairman_office}}</el-tag>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <Calendar/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;年龄</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.repairman_age"/>
        </el-descriptions-item>

        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <Male/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;性别</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.repairman_sex"/>
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <el-icon :size="20">
              <iphone/>
            </el-icon>
            <span style="font-size: 18px">&nbsp;联系方式</span>
          </template>
          <el-input style="width: 180px;" :readonly="true" :model-value="item.repairman_phone"/>
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
  get_repairmen()
})
const tableData = ref(null);
const get_repairmen = async () => {
  tableData.value = await apiService.get_repairmen();
};

const router = useRouter();
function getOperates(){
  router.push('/Operator')
}

function getMedicalStaffs(){
  router.push('/MedicalStaffs')
}

function getGuards(){
  router.push('/Guards')
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