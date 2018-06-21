<template>
  <div class="app-breadcrumb">
    <el-breadcrumb separator="/">
    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item v-if="prev.fullPath !== '/'" :to="prev.fullPath">{{prev.name}}</el-breadcrumb-item>
    <el-breadcrumb-item>{{active}}</el-breadcrumb-item>
    </el-breadcrumb>
  </div>

</template>
<script>
export default {
  name: 'Breadcrumb',
  data(){
    return {
      active: this.$route.name,
    }
  },
  computed: {
    prev() {
      return this.$store.state.route.from
    }
  },
  watch: {
    $route(route){
      this.active = route.name;
    }
  }
}

</script>
<style lang="less">
@import '../../assets/styles/breadcrumb';
</style>
