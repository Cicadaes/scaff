<template>
  <div id="axis-core" ref="core" style="width: 100%; min-height: 300px;"></div>
</template>
<script>
import { theme } from './echartsTheme/macarons.js'
  export default {
    name: 'CoreStatistic',
    data() {
      let _this = this;
      return {
        options: {
            // color: ['#3398DB'],
            color: ['#3E98C5'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },

            grid: {
                left: '3%',
                right: '4%',
                top: '2%',
                bottom: '2%',
                containLabel: true
            },
            xAxis: {
                type: 'value',
                boundaryGap: [0, 0.01]
            },
            yAxis: {
                type: 'category',
                data: ['完整性','规范性','一致性','准确性 ','唯一性','关联性']
            },
            series: [
                {
                    name: '连接数',
                    type: 'bar',
                    barWidth: '50%',
                    data: [559325, 513438, 461000, 621594, 534141, 681807]
                }
            ]
        }
      }
    },
    created() {

    },
    mounted() {
      let echarts = this.$echarts
      let axisChart = this.$echarts.init(this.$refs.core,'macarons')
      axisChart.setOption(this.options);
    },
  }
</script>
