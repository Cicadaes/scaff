<template>
  <div class="app-navbar">
    <el-menu class="nav-menu" mode="horizontal" @select="handleSelect">
      <div class="toggle-collapse">
        <el-menu-item class="toggle-button" index="1" @click="toggleSider"  style="cursor:pointer;"><icon name="bars" /></el-menu-item>
      </div>
      <el-menu-item disabled class="route-name" index="2">{{$route.name}}</el-menu-item>
      <div class="userinfo">
        <el-submenu class="setting" index="3">
          <template slot="title">我的工作台</template>
          <el-menu-item index="2-1">选项1</el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-submenu>
        <el-menu-item class="logout" index="/account/login" @click="openConfirm" style="cursor:pointer;"><i class="el-icon-upload2"></i></el-menu-item>
      </div>
    </el-menu>
  </div>
</template>
<script>
export default {
  name: 'Navbar',
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      // console.log(key, keyPath);
    },
    toggleSider() {
      this.$emit('toggle-sider')
    },
    openConfirm(){
      this.$confirm('此操作将永久退出系统, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$router.push('/account/login');
          this.$message({
            type: 'success',
            message: '退出成功!'
          });
        }).catch(() => {
          console.log('取消退出');
        });
    }
  }
}
</script>
<style lang="less">
@import "../../assets/styles/navbar";
</style>
