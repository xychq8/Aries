<template>
  <!--main-container-part-->
  <div id="content">
    <!--breadcrumbs-->
    <div id="content-header">
      <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
    </div>
    <!--End-breadcrumbs-->
    <router-view></router-view>
  </div>
  <!--end-main-container-part-->
</template>
<script>
export default {
  name: 'cdefault',
  data () {
    return {
      msg:''
    };
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
