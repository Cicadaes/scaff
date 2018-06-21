<template>
  <div class="setting-manager">
    <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
      <el-tab-pane label="基础字典" name="/setting/dicts-base">
        <router-view v-if="activeName === '/setting/dicts-base'"></router-view>
      </el-tab-pane>
      <el-tab-pane label="插件字典" name="/setting/dicts-plug">
        <router-view v-if="activeName === '/setting/dicts-plug'"></router-view>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>

  export default {
    name: 'Dictionary',
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
