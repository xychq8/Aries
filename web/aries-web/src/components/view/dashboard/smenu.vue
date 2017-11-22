<template>
  <aside class="aries-menu-aside">
    <el-menu default-active="2" class="el-menu-vertical-demo aries-menu" @select="handleSelect" theme="light">
      <template v-for="m1 in menus" >
        <el-submenu :index="m1.id+''" >
            <template slot="title">
              <i class="fa fa-fire icon-fire-red"></i>
              <span class="aries-menu-title" >{{m1.name}}</span>
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
</template>
<script>
import {getMenu} from "@/api/api";
export default {
  name: 'smenu',
  data () {
    return {
      menus:[],
      menuMap:{}
    };
  },
  mounted:function(){
      getMenu(this.$store.state.token).then(resp => {
          if(resp.code == 'W10000'){
              if(resp.data){
                this.loadMenu(resp.data);
              }
          }else{
              
          }
        });      
  },
  updated:function(){
    //this.bindMenuClick();
  },
  methods: {
      loadMenu:function(menus){
        this.menus = menus;
        var obj = {};
        if(menus){
          $.each(menus,function(index,m1){
              $.each(m1.subMenu,function(index,m2){
                if(!this.menuMap){
                  this.menuMap = {};
                }
                obj[m2.id] = m2.path;
              });
          });
        };
        this.menuMap = obj;
      },
      handleSelect:function(key,keyPath){
          if(this.menuMap){
            if(this.menuMap[key]){
              this.$router.push({path:this.menuMap[key]})
            }
          }
      }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
