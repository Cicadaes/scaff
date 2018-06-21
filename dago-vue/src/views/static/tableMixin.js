import Vue from 'vue';
import axios from 'axios';
import VueAxios from 'vue-axios';
import  qs from 'qs';
Vue.use(VueAxios, axios);
Vue.axios.defaults.timeout = 5000;
export default {
  methods: {
    fetchData(url, params, method){
      if(method === 'get') {
        return this.fetch(url,params)
      }else{
        return this.fetchPost(url, params)
      }
    },
    fetch(url, params = {}){
      return Vue.axios({
        method: 'get',
        url: '/monitor'+ url,
        params,
      }).then(function(response) {
        return Promise.resolve(response.data);
      }).catch((error) => {
        return Promise.reject(error.statusText);
      });
    },
    fetchPost(url,params = {}) {
      return Vue.axios({
        method: 'post',
        url: '/monitor'+url,
        params,
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        },
      }).then(function(response) {
        return Promise.resolve(response.data);
      }).catch((error) => {
        return Promise.reject(error.statusText);
      });
    },
    upLoadIntegration(url,params = {}) {
      let data = new FormData();
      data.append('file', params.file.raw)
      data.append('type', params.type)
      data.append('fileName', params.fileName)
      return Vue.axios({
        method: 'post',
        url: '/monitor'+url,
        headers: {
          'Content-Type': 'multipart/form-data'
        },
        data: data
      }).then(function(response) {
        return Promise.resolve(response.data);
      }).catch((error) => {
        return Promise.reject(error.statusText);
      });
    },
    _fetchPost(url,params = {}) {
      return Vue.axios({
        method: 'post',
        url: '/monitor'+url,
        data: JSON.stringify(params),
        headers: {
          'Content-Type': 'application/json'
        },
      }).then(function(response) {
        return Promise.resolve(response.data);
      }).catch((error) => {
        return Promise.reject(error.statusText);
      });
    },
    getter(data, start) {
        data.forEach(function(item, index) {
            item.number = start++
        })
        return data
    },
  }
}
