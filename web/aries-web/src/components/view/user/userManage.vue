
<template>
  <!--main-container-part-->
  <div class="container-fluid">
    <el-dialog title="修改密码" :visible.sync="dialogTableVisible" >
      <el-form >
        <el-form-item label="新密码" :label-width="formLabelWidth">
          <el-input auto-complete="off" size="large" :rows="2" type="password" v-model="password" ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" :label-width="formLabelWidth">
          <el-input auto-complete="off" size="large" :rows="2" type="password" v-model="passwordConfirm" ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogTableVisible = false">取 消</el-button>
        <el-button type="primary" @click="updatePassword">确 定</el-button>
      </div>
    </el-dialog>
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <el-table :data="tableData" border style="width: 100%">
            <el-table-column label="序号" width="180">
                  <template scope="scope">
                      {{scope.$index+1}}
                  </template>
            </el-table-column>
            <el-table-column prop="name" label="名称" width="180">
            </el-table-column>
            <el-table-column prop="username" label="登录名称" width="180">
            </el-table-column>
            <el-table-column prop="email" label="邮箱" width="180">
            </el-table-column>
            <el-table-column prop="phone" label="手机号码">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="100">
              <template scope="scope">
                <el-button @click.native.prevent="handleModify(scope.row.id)" type="text" size="small">修改密码</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div class="block pagination-el">
          <el-pagination
            :page-size="10"
            layout="total, prev, pager, next"
            :total="count">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
  <!--end-main-container-part-->
</template>
<script>
  import {getUser,updateUser} from "@/api/api";
  export default {
    name: 'dashboard',
    data () {
      return {
        tableData: [],
        count:0,
        dialogTableVisible:false,
        formLabelWidth:'100px',
        currentId:'',
        password:'',
        passwordConfirm:''
      };
    },
    mounted:function(){
      getUser().then(resp => {
            if(resp.code == 'W10000'){
              this.tableData = resp.data;
              if(resp.data){
                this.count = resp.data.length
              }
            }else{
              this.$message({
                  showClose: true,
                  message: resp.message,
                  type: 'error'
              });
            }
      });
    },
    methods:{
      handleModify:function(id){
        this.password = null;
        this.passwordConfirm = null;
        this.dialogTableVisible = true
        this.currentId = id;
      },
      updatePassword:function(){
        var param = {'password':this.password,'id':this.currentId}        
        updateUser(param).then(resp => {
            if(resp&&resp.code&&resp.code=='W10000'){
              this.$message({
                  showClose: true,
                  message: resp.message,
                  type: 'success'
              });
              this.dialogTableVisible = false;
            }else{
              this.$message({
                  showClose: true,
                  message: resp.message,
                  type: 'error'
              });
            }
        });  
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .el-input { 
    width: 400px; 
  }
</style>
