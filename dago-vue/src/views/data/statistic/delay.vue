<template>
  <el-tabs v-model="activeName" type="card" @tab-click="handleClick" style="margin-top: -62px;">
    <el-tab-pane label="厂商" name="first">
      <div id="axis-company-validator" ref="company"></div>
    </el-tab-pane>
    <el-tab-pane label="中心" name="second">
      <div id="axis-center-validator" ref="center"></div>
    </el-tab-pane>

  </el-tabs>
</template>
<script>
  import mixin from './axisMixin';
  export default {
    name: 'DelayStatistic',
    mixins: [mixin],
  }
</script>
<style>
.statistics .el-tabs__nav{
  float: right;
}
</style>
