<template>
	<!--sidebar-menu-->
<div id="sidebar">
  <ul id="menubar">
    <li class="submenu active"> <a href="#"><i class="icon icon-th-list"></i> <span>Forms</span> <span class="label label-important">3</span></a>
      <ul>
        <li><a href="form-common.html">Basic Form</a></li>
        <li><a href="form-validation.html">Form with Validation</a></li>
        <li><a href="form-wizard.html">Form with Wizard</a></li>
      </ul>
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
    	msg:''
    };
  },mounted:function(){
      getMenu(this.$store.state.token).then(data => {
            if(data.code == 'U10000'){
                
            }else{
                
            }
          });
  },
  methods: {
        load:function(menus){
            
        }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
