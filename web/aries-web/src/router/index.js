import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/view/login'
import Dashboard from '@/components/view/dashboard/dashboard'
import DefaultContainer from '@/components/view/dashboard/defaultContainer'
import UserManage from  '@/components/view/user/userManage'
import RoleManage from  '@/components/view/user/roleManage'
import ScheduleList from  '@/components/view/delivery/scheduleList'
import ConsumeStat from  '@/components/view/delivery/consumeStat'
import PositionList from  '@/components/view/delivery/positionList'

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
          { path: '/user/userManage', component: UserManage, name: '用户管理' ,meta:{requireAuth:true}},
          { path: '/user/roleManage', component: RoleManage, name: '角色管理' ,meta:{requireAuth:true}},
          { path: '/delivery/scheduleList', component: ScheduleList, name: '计划列表' ,meta:{requireAuth:true}},
          { path: '/delivery/consumeStat', component: ConsumeStat, name: '消耗统计' ,meta:{requireAuth:true}},
          { path: '/delivery/positionList', component: PositionList, name: '投放位置(今日)' ,meta:{requireAuth:true}} 
      ]
    }
  ]
})
