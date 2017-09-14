import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/view/login'
import Dashboard from '@/components/view/dashboard/dashboard'
import UserList from  '@/components/view/user/userList'
import DefaultContainer from '@/components/view/dashboard/defaultContainer'


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
          { path: '/', component: DefaultContainer, name: '默认列表' ,meta:{requireAuth:true}},
          { path: '/user/userList', component: UserList, name: '用户列表' ,meta:{requireAuth:true}} 
      ]
    }
  ]
})
