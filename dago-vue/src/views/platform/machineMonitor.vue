<template>
  <div class="platform platform-monitor">
    <el-card v-for="(machine, index) in machines" :body-style="{ padding: '0px' }" :key="machine.codeId" :index="index">
      <el-tooltip placement="right" effect="light">
        <div>
          <img :src="machine.src" class="image">
          <div style="padding: 14px; text-align:center;">
            <el-tag :type="machine.tagType">{{ machine.machine_type }}</el-tag>
            <div class="bottom clearfix">
              <span>{{ machine.machine_ip }}({{machine.machine_name}})</span>
            </div>
          </div>
        </div>
        <div slot="content">
          <table>
            <tbody>
              <tr valign="top">
                <td>机器状态：</td><td><span :style="{color: machine.statusColor}">{{machine.statusText}}</span></td>
              </tr>
              <tr valign="top">
                <td width=80>机器负载：</td><td>{{machine.load_average ? machine.load_average.join(',') : ''}}</td>
              </tr>
              <tr valign="top" v-for="disk_usage in machine.disk_usage">
                <td>磁盘目录：</td><td style="color: #1ab394">“{{disk_usage.dir}}” </td>
                <td>磁盘使用率：</td><td style="color: #20A0FF">“{{disk_usage.usage}}%” </td>
                <td>磁盘大小：</td><td>“{{disk_usage.capacity}}” </td>
                <td>已使用容量：</td><td>“{{disk_usage.usedDisk}}” </td>
                <td>可用容量：</td><td>“{{disk_usage.availableDisk}}” </td>
              </tr>
            </tbody>
          </table>
        </div>
      </el-tooltip>

    </el-card>
  </div>
</template>
<script>
  import machineGray from '../../assets/machine-gray.png';
  import machineGreen from '../../assets/machine-green.png';
  import machineRed from '../../assets/machine-red.png';
  import machineYellow from '../../assets/machine-yellow.png';
  import { mapGetters, mapActions, mapState } from 'vuex';
  export default {
    name: 'PlatformMachineMonitor',
    data() {
      return {
        tab: this.$route.meta.tab,
        intervalID: '',
        machines: [],
      }
    },
    computed: {
      ...mapGetters({
        items: 'listitems',
      }),
    },
    watch: {
      items(to, from){
        this.machines = [];
        for (var i = 0; i < to.length; i++) {
          let newMachine = { ...to[i] }; //由于javascript的特性限制，Vue无法识别数组浅复制，必须使用push或splice等方法触发视图更新
          if(to[i].status === 0){
            newMachine.src = machineGreen
            newMachine.tagType = 'success'
            newMachine.statusText = '正常'
            newMachine.statusColor = '#13ce66'
          }else if(to[i].status === 1){
            newMachine.src = machineGray
            newMachine.tagType = 'default'
            newMachine.statusText = '连接异常'
            newMachine.statusColor = '#8391a5'
          }else if(to[i].status === 2) {
            newMachine.src = machineYellow
            newMachine.tagType = 'warning'
            newMachine.statusText = '磁盘异常(某个磁盘使用率超过80%)'
            newMachine.statusColor = '#f7ba2a'
          }else{
            newMachine.src = machineRed
            newMachine.tagType = 'danger'
            newMachine.statusText = '机器异常(负载超过20)'
            newMachine.statusColor = '#FF4949'
          }
          this.machines.push(newMachine);
        }
      }
    },
    beforeMount() {
      let tab = this.tab;
      this.refreshList({
        tab
      });
      this.fetchDataIfNeeded({
        tab,
      });
    },

    mounted() {
      this.intervalID = setInterval(() => {
        this.changeColor()
      }, 500)
    },
    beforeDestroy() {
      clearInterval(this.intervalID)
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
        'refreshList'
      ]),
      changeColor() {
        for (var i = 0; i < this.machines.length; i++) {
          if(this.machines[i].src === machineGray){
            switch (this.machines[i].status) {
              case 0:
                this.machines[i].src = machineGreen
                break;
              case 1:
                this.machines[i].src = machineGray
                break;
              case 2:
                this.machines[i].src = machineYellow
                break;
              case 3:
                this.machines[i].src = machineRed
                break;
              default:
                this.machines[i].src = machineGray
            }
          }else{
            this.machines[i].src = machineGray
          }
        }

      }
    }
  }
</script>
<style>
.bottom {
  margin-top: 13px;
  line-height: 12px;
}
.bottom > span{
  font-size: 13px;
  color: #999;
}
</style>
