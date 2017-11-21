// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/store'
import * as types from "@/store/type"
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import { Message } from 'element-ui'
import 'font-awesome/css/font-awesome.min.css'

Vue.use(ElementUI);
Vue.config.productionTip = false
router.beforeEach((to, from, next) => {
    if (to.matched.some(r => r.meta.requireAuth)) {
      if(store.state.token){
        next();
      }else{
        next(
        {
            path: '/',
            query: { redirect: to.fullPath }
        }
        )
      }
    }else{
      next();
    }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})


axios.interceptors.request.use(function (config) {    // 这里的config包含每次请求的内容
    if (store.state.token) {
        config.headers.token = localStorage.token;
    }
    return config;
}, function (err) {
    return Promise.reject(err);
});


axios.interceptors.response.use(
  function (response) {
    return response;
  }, 
  function (error,response) {
    var mess ='加载失败!';
    switch(error.response.status){
      case 403:
        if(error.response.data){
          mess = error.response.data.message;
        }
        Message.error({   
          showClose: true,
          duration:1500,
          message: mess
        })
        store.commit(types.LOGOUT);
        router.push({path:'/'});
        break;
      case 500:
        Message.error({   
          showClose: true,
          duration:1500,
          message: '服务繁忙'
        })
        break;
    }
    return Promise.reject(error);
});