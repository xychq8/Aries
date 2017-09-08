import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/view/login'
import Dashboard from '@/components/view/dashboard/dashboard'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      meta:{
        requireAuth:true
      },
      component: Dashboard,
      children: [
          
      ]
    }
  ]
})
