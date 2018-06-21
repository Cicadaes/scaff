<template>
  <div class="setting-manager">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="组件类型" name="/setting/business-modules">
        <router-view v-if="activeName === '/setting/business-modules'"></router-view>
      </el-tab-pane>
      <el-tab-pane label="组件数据" name="/setting/modules">
        <router-view v-if="activeName === '/setting/modules'"></router-view>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>

  export default {
    name: 'SettingModuleIndex',

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
