<template>
  <div class="main">
    <h3 style="color: rgba(255,255,255,0.34)">&nbsp;事故汇总</h3>
    <div ref="chart" class="chart-container"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';

export default {
  mounted() {
    this.createChart();
    this.observeContainerResize();
  },
  methods: {
    createChart() {
      const chart = echarts.init(this.$refs.chart);

      const option = {
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '5%',
          left: 'center'
        },
        series: [
          {
            name: '数据',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center',
              color:'#fff'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 20,
                fontWeight: 'bold',
                color: '#fff'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 1048, name: '人员受伤' },
              { value: 735, name: '火灾事故' },
              { value: 580, name: '设备损坏' },
              { value: 484, name: '危险告警' },
              { value: 300, name: '人员闯入' }
            ]
          }
        ]
      };

      chart.setOption(option);
    },
    observeContainerResize() {
      const chartContainer = this.$refs.chart;
      const resizeObserver = new ResizeObserver(() => {
        this.resizeChart();
      });

      resizeObserver.observe(chartContainer);
    },
    resizeChart() {
      const chart = echarts.getInstanceByDom(this.$refs.chart);
      if (chart) {
        chart.resize();
      }
    }
  }
};
</script>

<style scoped>
.main{
  width: 100%;
  height: 100%;
}

.chart-container {
  width: 100%;
  height: 100%;
}
</style>
