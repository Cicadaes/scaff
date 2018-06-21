<template>
  <div>
    <div class="el-collapse-item info-collapse">
      <div class="el-collapse-item__header"><i class="el-collapse-item__header__arrow el-icon-arrow-right"></i>
        当前数据监控时间为:  <b>{{dateTime}}</b>
          <el-tag v-if="errors > 0" type="danger" class="pound-info"><i class="el-icon-information"></i>  异常：{{errors}}</el-tag>
          <el-button type="success" @click="dialogVisible = true" style="float:right; margin: 8px 15px;"  size="small">立即体检</el-button>
      </div>
    </div>
    <el-dialog :modal="false" :close-on-click-modal="false" :visible.sync="dialogVisible" top="10%;" @close="closeDialog" @open="openDialog">
      <template slot="title">
        <div class="dialogHeader">
          <svg width="126" height="126">
            <circle cx="63" cy="63" r="50" stroke-width="6" stroke="rgb(229, 233, 242)" fill="none"></circle>
            <circle cx="63" cy="63" r="50" stroke-width="6" stroke="rgb(19, 206, 102)" fill="none" transform="matrix(0,-1,1,0,0,126)" :stroke-dasharray="strokeDasharray"></circle>
            <text fill="rgb(19, 206, 102)" x="55" y="67" text-anchor="middle" dy=".1em" dx=".5em">{{tweeningValue}}%</text>
          </svg>
          <div class="right">
            <span v-if="loading">正在进行体检，请稍等......</span>
            <span v-else>体检完成，系统正常运行</span>
          </div>
        </div>
      </template>
      <div class="dialog-body">
        <div class="panel">
          <div class="panel-header">
            <div v-if="errors > 0">
              <i class="el-icon-information"></i>共检查了<strong>18</strong>项，以下<b>6</b>项有问题，需要修复：
            </div>
            <div v-else>
              <i class="el-icon-check"></i>共检查了<strong>18</strong>项，以下项目没有问题：
            </div>
          </div>
          <div class="panel-body">
            <el-collapse :value="['0', '1', '2']" id="dialog-body">
              <el-collapse-item v-for="(item, index) in tweeningModules" :name="String(index)" :key="item" class="animated fadeInUp" style="padding: 0 15px;">
                <template slot="title">
                  <strong>{{item.name}}</strong>检测，共<strong>{{item.children.length}}</strong>项，以下<b>2</b>项有问题：
                </template>
                <div class="items">
                  <div class="item" v-for="child in item.children" :key="child">
                    <div class="icon" :style="itemStyle(child.status)">
                      <icon name="bug"></icon>
                    </div>
                    <el-tag :type="itemType(child.status)">{{child.name}}</el-tag>
                  </div>
                </div>
              </el-collapse-item>
            </el-collapse>
          </div>
        </div>
      </div>
    </el-dialog>
  </div>
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
      dialogVisible: false,
      tweeningValue: 0,
      duration: 5000,
      loading: true,
      timers: [],
      tweeningModules: [],
      modules: [{
        name: 'data2x',
        count: 6,
        error: 2,
        children: [{
          name: 'bug',
          status: '2'
        }, {
          name: 'bug',
          status: '2'
        }, {
          name: '警告',
          status: '1'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: 'bug',
          status: '0'
        }]
      },{
        name: 'timer',
        children: [{
          name: 'bug',
          status: '2'
        }, {
          name: 'bug',
          status: '2'
        }, {
          name: '警告',
          status: '1'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: 'bug',
          status: '0'
        }]
      }, {
        name: 'es',
        children: [{
          name: 'bug',
          status: '2'
        }, {
          name: 'bug',
          status: '2'
        }, {
          name: '警告',
          status: '1'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: '成功',
          status: '0'
        }, {
          name: 'bug',
          status: '0'
        }]
      }]
    }
  },
  computed: {
    ...mapGetters({
      errors: 'listError',
    }),
    strokeDasharray(){
      return (this.tweeningValue/100) * 314 + " 1069"
    },
  },

  watch: {

  },

  mounted() {
    document.getElementsByClassName('el-dialog--small')[0].style = 'width: 65%';

  },
  methods: {
    tween(startValue, endValue) {
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
        }, vm.duration)
        .onUpdate(function() {
          vm.tweeningValue = this.tweeningValue.toFixed(0)
        })
        .start()
      animate()
    },
    closeDialog() {
      this.loading = false;
      this.tweeningModules = [];
      for (var i = 0; i < this.timers.length; i++) {
        clearTimeout(this.timers[i]);
      }
      this.timers = []
    },
    openDialog() {
      this.loading = true;
      this.timers.push(setTimeout(() => {
        this.loading = false;
      }, this.duration));
      this.tween(0, 75);
      for (var i = 0; i < this.modules.length; i++) {
        let module = this.modules[i];
        let tweening = this.tweeningModules;
        this.timers.push(setTimeout(() => {
          tweening.unshift(module);
        }, 1500 * (i + 1)));
      }


    },
    itemStyle(status) {
      if (status === '0') {
        return "border-color: #13ce66; background-color: #13ce66;"
      }else if(status === '1') {
        return "border-color: #f7ba2a; background-color: #f7ba2a;"
      }else {
        return "border-color: #ff4949; background-color: #ff4949;"
      }
    },
    itemType(status) {
      if (status === '0') {
        return "success"
      }else if(status === '1') {
        return "warning"
      }else {
        return "danger"
      }
    }
  }
}
</script>
<style lang='less'>@import '../../assets/styles/dashboard';</style>
