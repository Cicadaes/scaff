<template>
  <div class="grid-content app-main">
    <breadcrumb></breadcrumb>
    <div class="app-view">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
import Breadcrumb from './Breadcrumb';
export default {
  name: 'AppMain',
  components: {
    Breadcrumb
  },
  computed: {

  },
  watch: {

  },
  methods: {

  }
}
</script>
