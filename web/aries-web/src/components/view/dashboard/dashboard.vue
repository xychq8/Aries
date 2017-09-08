<template>
  <div>
    <mheader></mheader>
    <smenu></smenu>
    <mcontainer></mcontainer>
  </div>
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

</style>
