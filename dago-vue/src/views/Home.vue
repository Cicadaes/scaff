<template>
  <div class="grid" :class="{'sidebar-collapse': isMini}">
    <transition appear appear-active-class="animated fadeInLeft">
      <div class="sider">
        <sidebar></sidebar>
      </div>
    </transition>
    <transition appear appear-active-class="animated fadeInDown">
      <navbar @toggle-sider="toggleSider"></navbar>
    </transition>
    <transition appear appear-active-class="animated fadeInRight"><app-main></app-main></transition>
  </div>
</template>
<script>
import Navbar from '@/components/layout/Navbar'
import Sidebar from '@/components/layout/Sidebar'
import AppMain from '@/components/layout/AppMain'
import { mapActions } from 'vuex';
export default {
  name: 'Home',
  components: {
    Navbar,
    Sidebar,
    AppMain,
  },
  data() {
    return {
      isMini: false
    }
  },
  methods: {
    ...mapActions([
      'changeSider'
    ]),
    toggleSider() {
      this.isMini = !this.isMini;
      this.changeSider()
    }
  }

}
</script>
