<template>
  <section>
    <div class="login-logo"><h3><img src="/static/img/logo.png" alt="Logo" /></h3></div>
    <el-form id="loginform" class="login-form">
      <el-form-item prop="account">
        <el-input type="text" v-model="user.username" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="checkPass">
        <el-input type="password" v-model="user.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click.native.prevent="handleLogin" >登录</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>
<script>
import {login} from "@/api/api";
import * as types from "@/store/type";
export default {
  name: 'login',
  data () {
    return {
      showForm : true,
      user : {
        username : '',
        password : ''
      }
    }
  },  
  methods:{
    handleLogin:function(){
        if(!this.user.username){
            this.$message({
                      showClose: true,
                      message: '请填写用户名称!',
                      type: 'error'
            });
            return;
        }
        if(!this.user.password){
            this.$message({
                      showClose: true,
                      message: '请填写密码!',
                      type: 'error'
            });
            return;
        }
        var loginParams = { username : this.user.username, password : this.user.password};
        login(loginParams).then(resp => {
            if(resp&&resp.code&&resp.code == 'W10000'){
                this.$store.commit(types.LOGIN,resp.data.token)
                this.$router.push({
                    path: 'dashboard'
                });
            }else{
                if(resp.message){
                    this.$message({
                      showClose: true,
                      message: resp.message,
                      type: 'error'
                    });
                }
            }
      });  
    },
    handleFormChange:function(){
      this.showForm = !this.showForm;
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>