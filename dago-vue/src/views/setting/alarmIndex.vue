<template>
  <div class="setting-manager">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="报警记录" name="/setting/alarm-records">
        <router-view v-if="activeName === '/setting/alarm-records'"></router-view>
      </el-tab-pane>
      <el-tab-pane label="报警标准" name="/setting/alarm-standard">
        <router-view v-if="activeName === '/setting/alarm-standard'"></router-view>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>

  export default {
    name: 'SettingAlarmIndex',

    data() {
      return{
        activeName: this.$route.path
      }

    },
    methods: {
      handleClick(tab, event) {
        this.$router.push(this.activeName)
      }
    }
  }
</script>
<style>
.setting-manager .el-tabs__content{
  border: 1px solid #d1dbe5;
  margin-top: -15px;
  border-top: 0;
}
</style>
