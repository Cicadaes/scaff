import Vue from 'vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import  qs from 'qs';
Vue.use(VueAxios, axios);
Vue.axios.defaults.timeout = 5000;
// Vue.axios.defaults.baseURL = '/monitor';

// Vue.axios.interceptors.request.use(
//     config => {
//         if (store.state.token) {
//             config.headers.Authorization = `token ${store.state.token}`;
//         }
//         return config;
//     },
//     err => {
//         return Promise.reject(err);
//     });
// Vue.axios.interceptors.response.use(
//     response => {
//         return response;
//     },
//     error => {
//         if (error.response) {
//             switch (error.response.status) {
//                 case 401:
//                     // 401 清除token信息并跳转到登录页面
//                     store.commit(types.LOGOUT);
//                     router.replace({
//                         path: '/account/login',
//                         query: {redirect: router.currentRoute.fullPath}
//                     })
//             }
//         }
//         // console.log(JSON.stringify(error));//console : Error: Request failed with status code 402
//         return Promise.reject(error.response.data)
//     });

export const fetch = (url) => {
  return Vue.axios({
    method: 'get',
    url: url,
  }).then(function(response) {
    return Promise.resolve(response.data);
  }).catch((error) => {
    return Promise.reject(error.statusText);
  });
}
export const fetchPost = (url, params={}) => {
  return Vue.axios({
    method: 'post',
    url: url,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    data: qs.stringify(params)
  }).then(function(response) {
    return Promise.resolve(response.data);
  }).catch((error) => {
    return Promise.reject(error.statusText);
  });
};

/**
 * 封装业务模块的通用请求
 * @param  {string}   tab       请求的接口URL
 * @param  {object}   params      传的参数，没有则传空对象
 * @param  {string}   companyId  厂商代码，没有则为空
 * @param  {string}   centerCode  介入中心，没有则为空
 * @param  {string}   dataType  数据类型，没有则为空
 * @param  {string}   dataTime  日期时间，没有则为空
 * @param  {string}   name  组件名称，没有则为空
 */
export const fetchServiceData = (tab, params, method)  => {
  if(method === 'get') {
    if(tab === '/monitor/service/detail'){
      return fetch(`/monitor/sysMonitor/service/${params.moduleName}`)
    }
    return fetch(`/monitor/sysMonitor/${tab}`)
  }else{
    if(tab === 'businessModules'){
      return fetchPost('/monitor/sysMonitor/businessModule/list', params)
    }
    return fetchPost(`/monitor/sysMonitor/${tab}`, params)
  }

}
