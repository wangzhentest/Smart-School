<template>
  <div class="main">
    <div class="search-bar">
      <el-select v-model="searchType" placeholder="请选择搜索列">
        <el-option label="数据类型" value="数据类型"></el-option>
        <el-option label="数据id" value="数据id"></el-option>
        <el-option label="改变日期" value="改变日期"></el-option>
        <el-option label="修改人员id" value="修改人员id"></el-option>
        <el-option label="操作" value="操作"></el-option>
      </el-select>
      <el-input v-model="search" placeholder="输入搜索关键字" style="margin-left: 2%"></el-input>
      <el-button type="info" @click="handleSearch" style="margin-left: 2%">搜索</el-button>
    </div>

    <el-table :data="filteredData || tableData" style="width: 98%;" stripe border class="incident_table" height="92%" size="large">
      <el-table-column label="索引" prop="id" align="center" width="150" />
      <el-table-column label="数据类型" prop="change_type" align="center"/>
      <el-table-column label="数据id" prop="change_id" align="center" width="150" />
      <el-table-column label="改变日期" prop="change_date" align="center"/>
      <el-table-column label="修改人员id" prop="user_id" align="center" />
      <el-table-column label="操作" prop="operate" align="center"/>
    </el-table>
  </div>
</template>

<script setup>
import {ref, onMounted, onBeforeUnmount} from 'vue';
import apiService from "../../services/apiService";
import {useRouter} from 'vue-router';

const search = ref('');
const tableData = ref(null);
const searchType = ref(null);
const filteredData = ref(null);
const router = useRouter();
const timer = ref(null);
onMounted(() => {
  get_logs()
  startTimer()
});

onBeforeUnmount(() => {
  stopTimer()
});

function startTimer() {
  if (timer.value === null) {
    timer.value = setInterval(() => {
      get_logs()
    }, 2000);
  }
}

function stopTimer() {
  clearInterval(timer.value);
  timer.value = null;
}

const get_logs = async () => {
  tableData.value = await apiService.get_logs();
};

const handleSearch = () => {
  if (search.value.trim() === '') {
    filteredData.value = null;
    return;
  }

  const type = searchType.value;
  const keyword = search.value.trim();

  filteredData.value = tableData.value.filter((item) => {
    switch (type) {
      case '事故类型':
        return item.change_type.includes(keyword);
      case '数据id':
        return item.change_id.includes(keyword);
      case '改变日期':
        return item.change_date.includes(keyword);
      case '修改人员id':
        return item.user_id.includes(keyword);
      case '操作':
        return item.operate.includes(keyword);
      default:
        return false;
    }
  });
};
</script>
<style scoped>
.main {
  width: 100%;
  height: 100%;
}
.incident_table {
  margin: 1%;
}
.search-bar {
  width: 100%;
  margin-left: 1%;
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  margin-top: 1%;
}
</style>
