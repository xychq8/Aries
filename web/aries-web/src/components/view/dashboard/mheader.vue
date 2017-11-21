<template>
  <!-- header -->
  <el-col :span="24" class="header">
    <el-col :span="10" class="header-logo"  >
      <img src="/static/img/logo2.png" alt="Logo"/>
    </el-col>

    <span class="icon-close" v-on:click="logout" >
      <i class="fa fa-sign-out fa-2x"></i>
    </span>
  </el-col>
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
.icon-close{
  cursor: pointer;
  color:#ffffff;
  float:right;
  width: 50px;
}
.icon-close i{
  padding-right: 100px;
  padding-top: 13px;
}

</style>
