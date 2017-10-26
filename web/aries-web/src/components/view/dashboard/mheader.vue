<template>
	<div>
		<div>
			<!--Header-part-->
			<div id="header">
	  			<h1><a href="dashboard.html">Matrix Admin</a></h1>
			</div>
			<!--close-Header-part--> 
			<!--top-Header-menu-->
			<div id="user-nav" class="navbar navbar-inverse">
			  <ul class="nav">
			    <li  class="dropdown" id="profile-messages" ><a title="" href="javascript:;" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome User</span></a>
			      
			    </li>
			    <li class=""><a title="" href="#" v-on:click='logout'><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
			  </ul>
			</div>
		</div>
		<!--close-top-Header-menu-->
		<!--start-top-search
		<div id="search">
		  <input type="text" placeholder="Search here..."/>
		  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		close-top-search-->
	</div>
</template>
<script>
import * as types from "@/store/type"
export default {
  name: 'mheader',
  data () {
    return {
    	msg:''
    };
  },
  methods:{
  	logout:function(){
  		this.$store.commit(types.LOGOUT)
		this.$router.push({path:'/'});
  	}
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
