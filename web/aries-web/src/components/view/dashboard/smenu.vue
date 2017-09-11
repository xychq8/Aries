<template>
	<!--sidebar-menu-->
<div id="sidebar">
  <ul id="menubar">
    <li v-for="level_1 in menus" class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>{{level_1.name}}</span> <span class="label label-important">3</span></a>
    </li>  
  </ul>

</div>
<!--sidebar-menu-->
</template>
<script>
import {getMenu} from "../../../api/api";
export default {
  name: 'smenu',
  data () {
    return {
    	menus:[]
    };
  },mounted:function(){
      getMenu(this.$store.state.token).then(resp => {
          if(resp.code == 'U10000'){
              if(resp.data){
                this.loadMenu(resp.data);
              }
          }else{
              
          }
        });
  },methods: {
      loadMenu:function(menus){
        this.menus = menus;
        
      }
      
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
