<template>
    <section class="content-container">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>当前页</el-breadcrumb-item>
      </el-breadcrumb>
      <div>
        <el-col :span="24">
          <transition name="fade" mode="out-in">
            <router-view></router-view>
          </transition>
        </el-col>
      </div>
    </section>
  </div>
</template>
<script>
export default {
  name: 'container',
  data () {
    return {
      msg:''
    };
  },
  methods:{
    backToHome:function(){
      this.$router.push({path: "/dashboard"});
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
