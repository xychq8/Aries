<template>
  <el-row class="aries-container">
    <mheader></mheader>
    <el-col :span="24" class="aries-main">
      <aside class="aries-menu-aside">
        <el-menu default-active="2" class="el-menu-vertical-demo aries-menu" @select="handleSelect" theme="light">
          <template v-for="m1 in menus" >
            <el-submenu :index="m1.id+''" >
                <template slot="title">
                  <i :class="m1.icon"></i>&nbsp;
                  <span class="aries-menu-title">{{m1.name}}</span>
                </template>
                <template v-for="m2 in m1.subMenu" >
                  <el-menu-item :index="m2.id+''">
                    <template>
                      <span class="aries-menu-title" >{{m2.name}}</span>
                    </template>
                  </el-menu-item>
                </template>
            </el-submenu>
          </template>
        </el-menu>
      </aside>
      <section class="content-container">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/dashboard' }">首页</el-breadcrumb-item>
          <template v-for="bread in breadcrumb">
            <el-breadcrumb-item :to="{path:bread.path}">{{bread.name}}</el-breadcrumb-item>
          </template>
        </el-breadcrumb>
        <div>
          <el-col :span="24">
            <transition name="fade" mode="out-in">
              <router-view></router-view>
            </transition>
          </el-col>
        </div>
      </section>
    </el-col>
  </el-row>
</template>
<script>
import mheader from '@/components/view/dashboard/mheader'
import smenu from '@/components/view/dashboard/smenu'
import mcontainer from '@/components/view/dashboard/mcontainer'
import {getMenu,getIcon} from "@/api/api";
import {formatDate} from "@/components/view/common/date"
export default {
  name: 'dashboard',
  data () {
    return {
    	menus:[],
      menuMap:{},
      breadcrumb:[]
    };
  },
  mounted:function(){
  	getMenu(this.$store.state.token).then(resp => {
          if(resp.code == 'W10000'){
              if(resp.data){
                this.loadMenu(resp.data);
              }
          }
    });     
  },
  methods: {
      loadMenu:function(menus){
        var obj = {};
        getIcon().then(resp => {
          var icon = resp.data;
          if(menus){
            $.each(menus,function(index,m1){
                if(icon[m1["id"]]){
                  m1.icon = icon[m1["id"]].icon;
                }else{
                  m1.icon = icon["default"].icon;
                }
                var m1Obj = {path:"/dashboard",name:m1.name}
                obj[m1.id] = m1Obj;
                $.each(m1.subMenu,function(index,m2){
                  if(!this.menuMap){
                    this.menuMap = {};
                  }
                  var m2Obj = {path:m2.path,name:m2.name}
                  obj[m2.id] = m2Obj;
                });
            });
          };
          this.menuMap = obj;
          this.menus = menus;
        });
      },
      handleSelect:function(key,keyPath){
          if(this.menuMap){
            if(this.menuMap[key]){
              if(keyPath&&keyPath.length&&keyPath.length>=2){
                var map = this.menuMap;
                var breadcrumb = [];
                $.each(keyPath,function(index,id){
                  var obj = {path:map[id].path,name:map[id].name}
                  breadcrumb.push(obj);
                })
                this.breadcrumb = breadcrumb;
              }
              this.$router.push({path:this.menuMap[key].path})
            }
          }
      }
  },
  components:{mheader,smenu,mcontainer}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.aries-container{
    position: absolute;
    left: 0px;
    top: 0px;
    bottom: 0px;
    right: 0px;
    width: 100%;
}
.aries-main{
    display: flex;
    position: absolute;
    top: 60px;
    bottom: 0px;
    overflow: hidden;
}
</style>
