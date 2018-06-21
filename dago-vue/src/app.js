import Vue from 'vue';
import VueAuth from '@websanova/vue-auth';
import { sync } from 'vuex-router-sync';
import NProgress from 'vue-nprogress';
import App from './App.vue';
import store from './store';
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/packages/theme-default/lib/index.css';
import 'vue-awesome/icons'
import Icon from 'vue-awesome/components/Icon.vue';
import moment from 'moment';
import echarts from 'echarts';
moment.locale('zh-CN');

Vue.prototype.moment = moment;
Vue.prototype.$echarts = echarts;
Vue.prototype.$pageSize = 20;

Vue.component('icon', Icon);
// Vue.use(VueAuth, {
//     auth: {},
//     http: require('@websanova/vue-auth/drivers/http/axios.1.x.js'),
//     router: require('@websanova/vue-auth/drivers/router/vue-router.2.x.js'),
// });
Vue.use(ElementUI);

const options = {
  latencyThreshold: 200, // Number of ms before progressbar starts showing, default: 100,
  router: true, // Show progressbar when navigating routes, default: true
  http: true // Show progressbar when doing Vue.http, default: true
};
Vue.use(NProgress, options);
// sync the router with the vuex store.
// this registers `store.state.route`
sync(store, router);
const nprogress = new NProgress({ parent: '.nprogress-container' })

// create the app instance.
// here we inject the router and store to all child components,
// making them available everywhere as `this.$router` and `this.$store`.
const app = new Vue({
  router,
  store,
  nprogress,
  ...App,
});

// expose the app, the router and the store.
// note we are not mounting the app here, since bootstrapping will be
// different depending on whether we are in a browser or on the server.
export default app;
