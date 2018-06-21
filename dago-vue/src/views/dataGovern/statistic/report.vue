<template>
<div class="report">
  <div class="select-button">
  <el-button @click="week">近一周</el-button>
  <el-button @click="month">近一月</el-button>
  </div>
  <div ref="types" style="width: 100%; min-height: 300px;">
  </div>
  </div>
</template>

<script>

import {
    theme
}
from './echartsTheme/macarons.js'
import mixin from '../../static/tableMixin'
export default {
    name: 'ReportStatistic',
    mixins: [mixin],
    data() {
        return {
            options: {
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['有效性', '延時性', '穩定性']
                },
                toolbox: {
                    show: true,
                    feature: {
                        // mark: {
                        //     show: true
                        // },
                        // dataView: {
                        //     show: true,
                        //     readOnly: false
                        // },
                        // magicType: {
                        //     show: true,
                        //     type: ['line', 'bar', 'stack', 'tiled']
                        // },
                        // restore: {
                        //     show: true
                        // },
                        // saveAsImage: {
                        //     show: true
                        // }
                    }
                },
                calculable: true,
                xAxis: [{
                    type: 'category',
                    boundaryGap: false,
                    data: [],
                    axisLabel:{
                      interval: 0,
                      rotate:-30
                    },
                }],
                yAxis: [{
                    type: 'value'
                }],
                series: [{
                    name: '有效性',
                    type: 'line',
                    stack: '总量',
                    data: []
                }, {
                    name: '延時性',
                    type: 'line',
                    stack: '总量',
                    data: []
                }, {
                    name: '穩定性',
                    type: 'line',
                    stack: '总量',
                    data: []
                }]
            }

        }
    },
    created() {
      this.getList({dataRange: ''})
    },
    mounted() {
        // let chart = this.$echarts.init(this.$refs.types, 'macarons')
        // chart.setOption(this.options);

    },
    methods: {
      getList(params) {
        const _this = this
        this.fetchData('/dataManage/profile/report', params, 'get').then(response => {
          console.log(response.data);
            if (response.isOk === true) {
              let xAxis = []
              let validatorNum = []
              let delayNum = []
              let stableNum = []
              response.data.forEach(function(item, index) {
                xAxis.push(item.reportDate)
                validatorNum.push(item.validatorNum)
                delayNum.push(item.delayNum)
                stableNum.push(item.stableNum)
              })
              this.options.xAxis[0].data = xAxis
              this.options.series[0].data = validatorNum
              this.options.series[1].data = delayNum
              this.options.series[2].data = stableNum
            } else {
                this.$message.error(response.msg)
            }
        }).then(() => {
          let chart = _this.$echarts.init(_this.$refs.types, 'macarons')
          chart.setOption(_this.options);
        }).catch(error => {

        });
      },
      week() {
        this.getList({dataRange: ''})
      },
      month() {
        this.getList({dataRange: '30'})
      }
    }
}

</script>
<style lang="less">
.report{
  .select-button{
    display: flex;
    justify-content: flex-end;
  }
}
</style>
