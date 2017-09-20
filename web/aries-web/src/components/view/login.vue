<template>
    <div class="login">
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="http://themedesigner.in/demo/matrix-admin/index.html">
                <div class="control-group normal_text"> <h3><img src="/static/img/logo.png" alt="Logo" /></h3></div>
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
                    <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">Lost password?</a></span>
                    <span class="pull-right"><a href="javascript:;" id="" v-on:click="handleLogin()" class="btn btn-success"> Login</a></span>
                </div>
            </form>
            <form id="recoverform" action="#" class="form-vertical">
                <p class="normal_text">Enter your e-mail address below and we will send you instructions how to recover a password.</p>
                <div class="controls">
                    <div class="main_input_box">
                        <span class="add-on bg_lo"><i class="icon-envelope"></i></span><input type="text" placeholder="E-mail address" />
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
                    <span class="pull-right"><a class="btn btn-info"/>Reecover</a></span>
                </div>
            </form>
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
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#logo, #loginbox {    width: 32%;    margin-left: auto;    margin-right: auto;    position: relative;}
#logo img {  margin: 0 auto;    display: block;}
#loginbox { overflow: hidden !important;    text-align: left;    position: relative; }
#loginbox form{ width:100%; background:#2E363F; position:relative; top:0; left:0; }
#loginbox .form-actions { padding: 14px 20px 15px;}
#loginbox .form-actions .pull-left { margin-top:0px;}
#loginbox form#loginform { z-index: 200; display:block;}
#loginbox form#recoverform { z-index: 100;     display:none;}
#loginbox form#recoverform .form-actions {    margin-top: 10px;}
#loginbox .main_input_box { margin:0 auto; text-align:center; font-size:13px;}
#loginbox .main_input_box .add-on{  padding:9px 9px; *line-height:31px; color:#fff;  width:30px; display:inline-block;}
#loginbox .main_input_box input{ height:30px; border:0px; display:inline-block; width:75%; line-height:28px;  margin-bottom:3px;}
#loginbox .controls{ padding:0 20px;}
#loginbox .control-group{ padding:20px 0; margin-bottom:0px;}
.form-vertical, .form-actions {  margin-bottom: 0; background:none; border-top:1px solid #3f4954; }
#loginbox .normal_text{ padding:15px 10px; text-align:center; font-size:14px; line-height:20px; background:#2E363F; color:#fff; }
@media (max-width:800px){
#logo { width: 60%; }
#loginbox{ width:80%}
}
@media (max-width: 480px){
#logo { width: 40%; }
#loginbox{ width:90%}
#loginbox .control-group{ padding:8px 0; margin-bottom:0px;}
}
</style>