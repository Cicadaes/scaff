<template>
<el-collapse accordion class="info-collapse " @change="handleCollapse">
  <el-collapse-item name="1">
    <template slot="title">
      当前数据监控时间为:  <b>{{dateTime}}</b>
        <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
    </template>
    <div class="infos">
      <transition appear enter-active-class="animated fadeInLeft" leave-active-class="animated fadeOutLeft">
        <div v-show="show" class="statistics">
          <el-card class="box-card">
            <div class="media-left">
              <p>数量</p>
              <p>{{tweeningValue['0']}}</p>
            </div>
            <div class="media-right">
              <icon name="database"></icon>
            </div>
          </el-card>
          <el-card class="box-card">
            <div class="media-left">
              <p>数量</p>
              <p>{{tweeningValue['1']}}</p>
            </div>
            <div class="media-right">
              <icon name="eye"></icon>
            </div>
          </el-card>
        </div>
      </transition>
      <transition appear enter-active-class="animated fadeInRight" leave-active-class="animated fadeOutRight">
        <div v-show="show" class="rate">
          <div class="rate-body">
            <div id="info-echarts-radar" ref="radar" style="width: 400px; height: 300px;">
            </div>
            <ul class="rate-items">
              <li v-for="item in rateItems">
                <span>{{item.name}}</span>
                <el-rate
                  :value="item.value"
                  disabled
                  show-text
                  text-color="#ff9900"
                  text-template="{value}" ></el-rate>
              </li>
            </ul>
          </div>
          <div class="rate-footer">
            <i class="el-icon-information"></i><span>  异常：{{errors}}</span>
          </div>
        </div>
      </transition>
    </div>
  </el-collapse-item>
</el-collapse>
</template>
<script>
import {
  mapGetters
} from 'vuex';
import {
  TWEEN
} from '../../assets/js/tween';
export default {
  name: 'Dashboard',
  props: {
    dateTime: String,
  },
  data() {
    return {
      show: true,
      value1: 0,
      value2: 0,
      tweeningValue: {
        '0': 0,
        '1': 0
      }
    }
  },
  computed: {
    rateItems() {
      return [{
        name: '总分',
        value: 3.7,
        max: 5
      }, {
        name: '系统核心流程',
        value: 2.7,
        max: 5
      }, {
        name: '组件状态',
        value: 4.5,
        max: 5
      }, {
        name: '服务器状况',
        value: 3.0,
        max: 5
      }, {
        name: '数据及时性',
        value: 4.7,
        max: 5
      }, {
        name: '服务稳定性',
        value: 2.5,
        max: 5
      }]
    },
    radarOptions() {
      return {
        tooltip: {},
        radar: {
          // shape: 'circle',
          indicator: [{
            name: '系统核心流程',
            max: 5
          }, {
            name: '组件状态',
            max: 5
          }, {
            name: '服务器状况',
            max: 5
          }, {
            name: '数据及时性',
            max: 5
          }, {
            name: '服务稳定性',
            max: 5
          }]
        },
        series: [{
          name: '',
          type: 'radar',
          lineStyle: {
            normal: {
              color: '#20a0ff'
            }
          },
          itemStyle: {
            normal: {
              color: '#20a0ff',
              width: 7
            }
          },
          areaStyle: {
            normal: {
              opacity: 0.8,
              color: 'rgba(32, 160, 255, 0.38)'
            }
          },
          data: [{
            value: [2.7, 4.5, 3.0, 4.7, 2.5],
            name: '评分'
          }]
        }]
      }
    },
    ...mapGetters({
      errors: 'listError',
    })
  },
  watch: {
    value1(to, from) {
      this.tween(0, this.value1, '0')
    },
    value2(to, from) {
      this.tween(0, this.value2, '1')
    }
  },
  mounted() {
    let radarChart = this.$echarts.init(this.$refs.radar);
    radarChart.setOption(this.radarOptions);
    setTimeout(() => {
      this.value1 = 10000;
    }, 1000)
    setTimeout(() => {
      this.value2 = 999;
    }, 1700)
  },
  methods: {
    handleCollapse(activeNames) {
      this.show = activeNames === '1';
    },
    tween(startValue, endValue, index) {
      let vm = this

      function animate(time) {
        requestAnimationFrame(animate)
        TWEEN.update(time)
      }
      new TWEEN.Tween({
          tweeningValue: startValue
        })
        .to({
          tweeningValue: endValue
        }, 700)
        .onUpdate(function() {
          vm.tweeningValue[index] = this.tweeningValue.toFixed(0)
        })
        .start()
      animate()
    }
  }
}
</script>
<style lang='less'>@import '../../assets/styles/dashboard';</style>
