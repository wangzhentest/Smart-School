<template>
  <div class="main">
    <h3 style="color: rgba(255,255,255,0.34)">&nbsp;事故类型汇总</h3>
    <div ref="chartContainer" style="width: 100%; height: 100%; margin-top: -10%"></div>
  </div>
</template>

<script>
import {ref, onMounted, onBeforeUnmount} from 'vue';
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
      const data = [41, 9, 44, 33, 13];
      const min = Math.min(...data); // 最小值
      const max = Math.max(...data); // 最大值

      const options = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: ['受伤', '火灾', '设备', '告警', '闯入'],
            axisTick: {
              alignWithLabel: true
            }
          }
        ],
        yAxis: [
          {
            type: 'value'
          }
        ],
        series: [
          {
            name: 'Direct',
            type: 'bar',
            barWidth: '60%',
            data: data,
            animation: true,
            itemStyle: {
              color: {
                type: 'linear',
                x: 0,
                y: 0,
                x2: 0,
                y2: 1,
                colorStops: [
                  {
                    offset: 0,
                    color: 'red' // 最低值的颜色
                  },
                  {
                    offset: 1,
                    color: 'gray' // 最高值的颜色
                  }
                ]
              }
            }
          }
        ],
        visualMap: {
          type: 'continuous',
          show: false,
          min: min,
          max: max,
          inRange: {
            color: ['gray', 'red'] // 渐变颜色范围
          }
        }
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

    onBeforeUnmount(() => {
      if (resizeObserver) {
        resizeObserver.disconnect();
      }
    });

    return {chartContainer};
  }
};
</script>

<style>
.main {
  width: 100%;
  height: 100vh;
}
</style>
