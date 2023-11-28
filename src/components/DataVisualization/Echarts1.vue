<template>
  <div class="main">
    <div ref="chartContainer" style="width: 100%; height: 100%;"></div>
  </div>
</template>

<script>
import { ref, onMounted, onBeforeUnmount } from 'vue';
import * as echarts from 'echarts';

export default {
  name: 'ChartComponent',
  setup() {
    const chartContainer = ref(null);
    const chartInstance = ref(null);
    let resizeObserver = null;

    onMounted(() => {
      createChart();
      observeContainerResize();
    });

    function createChart() {
      const chart = echarts.init(chartContainer.value);
      const options = {
        title: {
          text: '事故发生时间段汇总',
          subtext: ''
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross'
          }
        },
        toolbox: {
          show: true,
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: [
            '00:00', '01:15', '02:30', '03:45', '05:00', '06:15', '07:30', '08:45', '10:00', '11:15',
            '12:30', '13:45', '15:00', '16:15', '17:30', '18:45', '20:00', '21:15', '22:30', '23:45'
          ]
        },
        yAxis: {
          type: 'value',
          axisLabel: {
            formatter: '{value} 次'
          },
          axisPointer: {
            snap: true
          }
        },
        visualMap: {
          show: false,
          dimension: 0,
          pieces: [
            { lte: 6, color: 'green' },
            { gt: 6, lte: 8, color: 'red' },
            { gt: 8, lte: 14, color: 'green' },
            { gt: 14, lte: 17, color: 'red' },
            { gt: 17, color: 'green' }
          ]
        },
        series: [
          {
            name: 'Electricity',
            type: 'line',
            smooth: true,
            data: [
              10, 20, 2, 8, 12, 30, 40, 50, 10, 12, 40, 60,
              10, 12, 13, 21, 11, 44, 11, 22
            ],
            markArea: {
              itemStyle: {
                color: 'rgba(255, 173, 177, 0.4)'
              },
              data: [
                [{ name: 'Morning Peak', xAxis: '07:30' }, { xAxis: '10:00' }],
                [{ name: 'Evening Peak', xAxis: '17:30' }, { xAxis: '21:15' }]
              ]
            }
          }
        ]
      };

      chart.setOption(options);
      chartInstance.value = chart;
    }

    function observeContainerResize() {
      resizeObserver = new ResizeObserver(() => {
        resizeChart();
      });

      resizeObserver.observe(chartContainer.value);
    }

    function resizeChart() {
      if (chartInstance.value) {
        chartInstance.value.resize();
      }
    }
    // 在组件卸载时停止监听
    onBeforeUnmount(() => {
      if (resizeObserver) {
        resizeObserver.disconnect();
      }
    });

    return { chartContainer };
  }
};
</script>

<style>
.main{
  width: 100%;
  height: 100vh;
}
</style>
