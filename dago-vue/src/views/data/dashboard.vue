<template>
<div class="data-dashboard">
  <div class="filter">
    <el-select v-model="companyId" clearable placeholder="请选择厂商" @change="handleChange">
      <el-option v-for="(item, index) in companyOptions" :key="index" :label="item.name" :value="item.code">
      </el-option>
    </el-select>
    <el-date-picker v-model="dateTime" type="daterange" align="right" placeholder="选择监控日期范围" :picker-options="pickerOptions" @change="handleChange">
    </el-date-picker>
  </div>
  <div class="total">
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="green">4%</i> From last Week
      </div>
    </div>
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="green">4%</i> From last Week
      </div>
    </div>
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="green">4%</i> From last Week
      </div>
    </div>
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="red">12%</i> From last Week
      </div>
    </div>
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="red">12%</i> From last Week
      </div>
    </div>
    <div class="child">
      <div class="top">
        <icon name="user" />记录总数
      </div>
      <strong>2500</strong>
      <div class="bottom">
        <i class="red">12%</i> From last Week
      </div>
    </div>

  </div>
  <div class="panel" >
    <div class="panel-left" style="flex: 3;">
      <div id="axis-chart"  ref="axis" class="chart" style="width: 100%; height: 300px;"></div>
    </div>
    <div class="panel-right" style="flex: 1;">
      <div id="gauge-chart" ref="gauge" class="chart" style="width: 100%; height: 350px;"></div>
    </div>
  </div>
  <div class="panel">
    <div class="panel-left" style="flex: 1;">
      <div id="pie-chart" ref="pie" class="chart" style="width: 100%; height: 300px;"></div>
    </div>
    <div class="panel-right" style="flex: 3">
      <div id="mix-chart" ref="mix" class="chart" style="width: 100%; height: 300px;"></div>
    </div>
  </div>

</div>
</template>
<script>
import {
  mapGetters,
} from 'vuex';
import {
  TWEEN
} from '../../assets/js/tween';
export default {
  name: 'DataDashboard',
  data() {
    let _this = this;
    return {
      timer: false,
      screenWidth: document.body.clientWidth,
      companyId: '',
      dateTime: [this.moment().subtract(7, 'days'), this.moment()],
      pickerOptions: {
        shortcuts: [{
          text: '一周',
          onClick(picker) {
            const end = _this.moment();
            const start = _this.moment().subtract(7, 'days');
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '一个月',
          onClick(picker) {
            const end = _this.moment();
            const start = _this.moment().subtract(1, 'months');
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '三个月',
          onClick(picker) {
            const end = _this.moment();
            const start = _this.moment().subtract(3, 'months');
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      option: {
        title: {
          text: '某站点用户访问来源',
          x: 'left'
        },
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },

        series: [{
          name: '访问来源',
          type: 'pie',
          radius: '55%',
          center: ['50%', '60%'],
          data: [{
              value: 335,
              name: '直接访问'
            },
            {
              value: 310,
              name: '邮件营销'
            },
            {
              value: 234,
              name: '联盟广告'
            },
            {
              value: 135,
              name: '视频广告'
            },
            {
              value: 1548,
              name: '搜索引擎'
            }
          ],
          itemStyle: {
            emphasis: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }]
      },
      axisOption: {
        title: {
          text: '堆叠区域图'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            label: {
              backgroundColor: '#6a7985'
            }
          }
        },
        legend: {
          data: ['邮件营销', '联盟广告']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          boundaryGap: false,
          data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        }],
        yAxis: [{
          type: 'value'
        }],
        series: [{
            name: '邮件营销',
            type: 'line',
            stack: '总量',
            areaStyle: {
              normal: {}
            },
            data: [120, 132, 101, 134, 90, 230, 210]
          },
          {
            name: '联盟广告',
            type: 'line',
            stack: '总量',
            areaStyle: {
              normal: {}
            },
            data: [220, 182, 191, 234, 290, 330, 310]
          }
        ]
      },
      mixOption: {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        legend: {
          data: ['蒸发量', '降水量', '平均温度']
        },
        xAxis: [{
          type: 'category',
          data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
          axisPointer: {
            type: 'shadow'
          }
        }],
        yAxis: [{
            type: 'value',
            name: '水量',
            min: 0,
            max: 250,
            interval: 50,
            axisLabel: {
              formatter: '{value} ml'
            }
          },
          {
            type: 'value',
            name: '温度',
            min: 0,
            max: 25,
            interval: 5,
            axisLabel: {
              formatter: '{value} °C'
            }
          }
        ],
        series: [{
            name: '蒸发量',
            type: 'bar',
            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
          },
          {
            name: '降水量',
            type: 'bar',
            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
          },
          {
            name: '平均温度',
            type: 'line',
            yAxisIndex: 1,
            data: [2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
          }
        ]
      },
      gaugeOption: {
        tooltip: {
          formatter: "{a} <br/>{b} : {c}%"
        },
        series: [{
          name: '业务指标',
          type: 'gauge',
          detail: {
            formatter: '{value}%'
          },
          data: [{
            value: 50,
            name: '完成率'
          }]
        }]
      },
    }
  },
  computed: {
    ...mapGetters({
      companyOptions: 'factory',
    }),
    isMini() {
      return this.$store.state.menu.isMini
    }
  },
  watch: {
    screenWidth (val) {
      if (!this.timer) {
        this.screenWidth = val
        this.timer = true
        let _this = this;
        setTimeout(function () {
            _this.initChart()
            _this.timer = false
        }, 400)
      }
    },
    isMini(to, from){
      let charts = ['axis', 'gauge', 'mix', 'pie'];
      for (var i = 0; i < charts.length; i++) {
        this.$refs[charts[i]].childNodes[0].style.margin = '0 auto';
        // this.$refs[charts[i]].childNodes[0].childNodes[0].style.width = '100%';
        // this.$refs[charts[i]].childNodes[0].childNodes[0].style.height = 'auto';
      }
    }
  },
  mounted() {
    let _this = this;
    window.onresize = () => {
      return (() => {
        window.screenWidth = document.body.clientWidth;
        _this.screenWidth = window.screenWidth
      })()
    }
    this.initChart()
  },
  methods: {
    initChart(){
      let _this = this;
      let pieChart = this.$echarts.init(this.$refs.pie);
      pieChart.setOption(this.option);
      let axisChart = this.$echarts.init(this.$refs.axis);
      axisChart.setOption(this.axisOption);
      let mixChart = this.$echarts.init(this.$refs.mix);
      mixChart.setOption(this.mixOption);
      let gaugeChart = this.$echarts.init(this.$refs.gauge);
      gaugeChart.setOption(this.gaugeOption);
    },
    handleChange() {

    }
  }
}
</script>
<style lang='less'>@import '../../assets/styles/dashboard';</style>
