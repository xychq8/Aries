<template>
  <el-row class="aries-container">
    <mheader></mheader>
    <el-col :span="24" class="aries-main">
      <smenu></smenu>
      <mcontainer></mcontainer>
    </el-col>
  </el-row>
</template>
<script>
import mheader from '@/components/view/dashboard/mheader'
import smenu from '@/components/view/dashboard/smenu'
import mcontainer from '@//components/view/dashboard/mcontainer'
export default {
  name: 'dashboard',
  data () {
    return {
    	
    };
  },
  mounted:function(){
  	
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
