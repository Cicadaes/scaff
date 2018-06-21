<template>
  <div id="axis-core" ref="core" style="width: 100%; height: 300px;"></div>
</template>
<script>
  export default {
    name: 'CoreStatistic',
    data() {
      let _this = this;
      return {
        options: {
            color: ['#3398DB'],
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
                data: ['微信','QQ','手机号','微博','身份证','家庭住址']
            },
            series: [
                {
                    name: '连接数',
                    type: 'bar',
                    barWidth: '50%',
                    data: [19325, 23438, 31000, 121594, 134141, 681807]
                }
            ]
        }
      }
    },
    mounted() {
      let axisChart = this.$echarts.init(this.$refs.core)
      axisChart.setOption(this.options);

    },
  }
</script>
