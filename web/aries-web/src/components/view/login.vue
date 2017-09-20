<template>
    <div class="login">
        <div id="loginbox">
          <div class="control-group normal_text"> <h3><img src="/static/img/logo.png" alt="Logo" /></h3></div>
          <el-collapse-transition>    
            <form v-show="showForm" id="loginform" class="form-vertical" action="http://themedesigner.in/demo/matrix-admin/index.html">
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" v-model="user.username" placeholder="Username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input type="password" v-model="user.password" placeholder="Password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" @click="handleFormChange" class="flip-link btn btn-info" id="to-recover">Lost password?</a></span>
                    <span class="pull-right"><a href="javascript:;" id="" v-on:click="handleLogin()" class="btn btn-success"> Login</a></span>
                </div>
            </form>
          </el-collapse-transition>
          <el-collapse-transition>  
            <form v-show="!showForm" id="recoverform" action="#" class="form-vertical">
                <p class="normal_text">填写你的登录名称,管理员会将你的密码重置为默认密码。</p>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_lg"><i class="icon-user"></i></span><input type="text" placeholder="username" />
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" @click="handleFormChange" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
                    <span class="pull-right"><a href="#" @click="handleFormChange" class="btn btn-info" id="to-login">&laquo; Reecover</a></span>
                </div>
            </form>
          </el-collapse-transition>
        </div>
    </div>
</template>
<script>
import {login} from "@/api/api";
import * as types from "@/store/type"
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
.transition-box {
    margin-bottom: 10px;
    width: 200px;
    height: 100px;
    border-radius: 4px;
    background-color: #20A0FF;
    text-align: center;
    color: #fff;
    padding: 40px 20px;
    box-sizing: border-box;
    margin-right: 20px;
  }
</style>