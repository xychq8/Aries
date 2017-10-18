<template>
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li v-for="m1 in menus" class="submenu"> <a href="#"><i class="icon  icon-fire"></i> <span>{{m1.name}}</span> </a>
      <ul>
        <li v-for="m2 in m1.subMenu" ><a v-on:click="jump(m2.path)" >{{m2.name}}</a></li>
      </ul>
    </li> 
  </ul>
</div>
</template>
<script>
import {getMenu} from "@/api/api";
export default {
  name: 'smenu',
  data () {
    return {
      menus:[]
    };
  },
  mounted:function(){
      getMenu(this.$store.state.token).then(resp => {
          if(resp.code == 'W10000'){
              if(resp.data){
                this.loadMenu(resp.data,this);
              }
          }else{
              
          }
        });      
  },
  updated:function(){
    this.bindMenuClick();
  },
  methods: {
      loadMenu:function(menus){
        this.menus = menus;
      },
      bindMenuClick:function(event){
            // === Sidebar navigation === //
            $('.submenu > a').click(function(e){ 
              e.preventDefault();
              var submenu = $(this).siblings('ul');
              var li = $(this).parents('li');
              var submenus = $('#sidebar li.submenu ul');
              var submenus_parents = $('#sidebar li.submenu');
              if(li.hasClass('open')){
                if(($(window).width() > 768) || ($(window).width() < 479)) {
                  submenu.slideUp();
                } else {
                  submenu.fadeOut(250);
                }
                li.removeClass('open');
                li.removeClass('active');
              }else{
                if(($(window).width() > 768) || ($(window).width() < 479)) {
                  submenus.slideUp();     
                  submenu.slideDown();
                } else {
                  submenus.fadeOut(250);      
                  submenu.fadeIn(250);
                }
                submenus_parents.removeClass('open');   
                submenus_parents.removeClass('active');   
                li.addClass('open');  
                li.addClass('active');  
              }
            });
            var ul = $('#sidebar > ul');            
            $('#sidebar > a').click(function(e){
              e.preventDefault();
              var sidebar = $('#sidebar');
              if(sidebar.hasClass('open')){
                sidebar.removeClass('open');
                ul.slideUp(250);
              }else{
                sidebar.addClass('open');
                ul.slideDown(250);
              }
            });
      },
      jump:function(_path){
        this.$router.push({path: _path});
      } 
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
