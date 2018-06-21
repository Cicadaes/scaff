<template>
  <div id="app">
    <nprogress-container></nprogress-container>
    <router-view></router-view>
  </div>
</template>
<script>
  import NprogressContainer from 'vue-nprogress/src/NprogressContainer';
  import { mapActions } from 'vuex'
  import $ from 'jquery';

  export default {
    name: 'App',
    components: {
      NprogressContainer,
    },

    computed: {
      params() {
        return this.filters;
      },
    },
    beforeMount() {
      let sSearch = {
        status: 1
      }
      this.fetchDataIfNeeded({tab: 'dict/factory', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/input_data_type', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/center', method: 'get'});
      this.fetchDataIfNeeded({tab: 'businessModules', params: {
        sSearch: JSON.stringify(sSearch),
        iDisplayStart: 0,
        iDisplayLength: 100,
        iSortCol_0: 'create_time',
        sSortDir_0: 'ASC'
      }});
      this.fetchDataIfNeeded({tab: 'dict/business_type', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/log_type', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/log_code', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/business_alarm_type', method: 'get'});
      this.fetchDataIfNeeded({tab: 'dict/dataGovern', method: 'get'});
    },
    methods: {
      ...mapActions([
        'fetchDataIfNeeded',
      ]),
    }
  }
</script>
<style lang='less'>
body {
  overflow: auto !important;
}
@import './assets/styles/app';
</style>
