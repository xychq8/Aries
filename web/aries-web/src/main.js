// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store/store'
import axios from 'axios';

Vue.config.productionTip = false
router.beforeEach((to, from, next) => {
    if (to.matched.some(r => r.meta.requireAuth)) {
      next();
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
    console.log("main token:"+store.state.token)
    if (localStorage.token) {
        config.headers.token = localStorage.token;
    }
    return config;
}, function (err) {
    return Promise.reject(err);
});