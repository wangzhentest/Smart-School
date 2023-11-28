<template>
  <div class="main">
    <div class="search-bar">
      <el-select v-model="searchType" placeholder="请选择搜索列">
        <el-option label="事故类型" value="事故类型"></el-option>
        <el-option label="事故日期" value="事故日期"></el-option>
        <el-option label="发生地点" value="发生地点"></el-option>
        <el-option label="事故原因" value="事故原因"></el-option>
        <el-option label="处理人员" value="处理人员"></el-option>
      </el-select>
      <el-input v-model="search" placeholder="输入搜索关键字" style="margin-left: 2%"></el-input>
      <el-button type="info" @click="handleSearch" style="margin-left: 2%">搜索</el-button>
    </div>
    <el-table :data="filteredData || tableData" style="width: 98%" table-layout="auto" stripe border class="incident_table" height="92%" size="large">
      <el-table-column label="索引" prop="id" align="center"/>
      <el-table-column label="事故类型" prop="incident_type" align="center"/>
      <el-table-column label="事故日期" prop="occur_date" align="center"/>
      <el-table-column label="发生地点" prop="occur_place" align="center"/>
      <el-table-column label="事故原因" prop="incident_reason" align="center"/>
      <el-table-column label="解决日期" prop="dispose_date" align="center"/>
      <el-table-column label="相关操作" align="center">
        <template #default="scope">
          <el-button type="danger" @click="handleGetReport(scope.$index)" size="large">查看报表</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog v-model="reportBoxShow" title="报表查看" top="5vh">
      <div class="reportBox" v-if="reportBoxShow">
        <Report :reportObj="reportObj"></Report>
      </div>
    </el-dialog>
  </div>
</template>

<script setup>
import {ref, onMounted, onBeforeUnmount} from 'vue';
import apiService from "../../services/apiService";
import {useRouter} from 'vue-router';
import Report from '../commen/Report.vue'

const reportObj = ref(null)
const reportBoxShow = ref(false)
const search = ref('');
const tableData = ref(null);
const searchType = ref(null);
const filteredData = ref(null);
const router = useRouter();
const timer = ref(null);

onMounted(() => {
  getSummaries();
  startTimer()
});

onBeforeUnmount(() => {
  stopTimer()
});

function startTimer() {
  if (timer.value === null) {
    timer.value = setInterval(() => {
      getSummaries()
    }, 2000);
  }
}

function stopTimer() {
  clearInterval(timer.value);
  timer.value = null;
}

const getSummaries = async () => {
  tableData.value = await apiService.get_summaries();
};

const get_summary_by_id = async (reportId) => {
  reportObj.value = await apiService.get_summary_by_id(reportId);
};

const handleGetReport = (index) => {
  reportBoxShow.value = true
  get_summary_by_id(tableData.value[index].incident_id)
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
        return item.incident_type.includes(keyword);
      case '事故日期':
        return item.incident_date.includes(keyword);
      case '发生地点':
        return item.incident_position.includes(keyword);
      case '事故原因':
        return item.incident_reason.includes(keyword);
      case '解决日期':
        return item.dispose_date.includes(keyword);
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

.reportBox {
  margin-bottom: 10%;
}
</style>
