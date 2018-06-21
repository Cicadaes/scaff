<template>
  <div class="app-sidebar">
    <div class="app-logo">

    </div>
    <el-menu default-active="2" @open="handleOpen" @close="handleClose" theme="dark" :router=true :default-active="defaultActive" :unique-opened=true>
      <template v-for="(item, index) in menu">
        <el-menu-item :index="item.path" v-if="!item.children">
          <i :class="item.meta.icon"></i>
          <span>{{item.name}}</span>
        </el-menu-item>
        <el-submenu :index="item.path" v-else>
          <template slot="title">
            <i :class="item.meta.icon"></i>
            <icon :name="item.meta.fa" v-if="item.meta.fa"></icon>
            <span>{{item.name}}</span>
          </template>
          <template v-for="(children, children_index) in item.children">
            <el-submenu :index="children.path" v-if="children.level">
              <template slot="title">{{children.name}}</template>
              <el-menu-item v-for="(child,child_index) in children.children" :key="child_index" :index="child.path">
              {{child.name}}
              </el-menu-item>
            </el-submenu>
            <el-menu-item v-else :index="children.path">
              {{children.name}}
            </el-menu-item>
          </template>
        </el-submenu>
      </template>
    </el-menu>
  </div>
</template>
<script>
  import { mapGetters } from 'vuex'
  export default {
    name: 'Sidebar',
    data() {
      let data = {
        defaultActive: this.$route.path,
      }
      return data;
    },
    computed: {
      ...mapGetters({
        menu: 'menuitems'
      })
    },
    beforeMount() {
      if(this.$route.path === '/setting/business-modules' || this.$route.path === '/setting/modules'){
        this.defaultActive = '/setting/business';
      }
      if(this.$route.path === '/setting/alarm-records' || this.$route.path === '/setting/alarm-standard'){
        this.defaultActive = '/setting/alarm';
      }
      if(this.$route.path === '/setting/dicts-base' || this.$route.path === '/setting/dicts-plug'){
        this.defaultActive = '/setting/dicts';
      }
    },
    watch: {
      $route (route) {
        this.defaultActive = route.path;
        if(route.path === '/setting/business-modules' || route.path === '/setting/modules'){
          this.defaultActive = '/setting/business';
        }
        if(route.path === '/setting/alarm-records' || route.path === '/setting/alarm-standard'){
          this.defaultActive = '/setting/alarm';
        }
        if(route.path === '/setting/dicts-base' || route.path === '/setting/dicts-plug'){
          this.defaultActive = '/setting/dicts';
        }
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        // console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        // console.log(key, keyPath);
      }
    }
  }
</script>
<style lang="less">
@import "../../assets/styles/sidebar";
</style>
