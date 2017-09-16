<template>
  <!--main-container-part-->
  <div class="container-fluid">
    <el-dialog title="修改密码" :visible.sync="dialogTableVisible" >
      <el-form >
        <el-form-item label="新密码" :label-width="formLabelWidth">
          <el-input auto-complete="off" size="large" :rows="1" type="password" ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" :label-width="formLabelWidth">
          <el-input auto-complete="off" size="large" :rows="1" type="password" ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogTableVisible = false">取 消</el-button>
        <el-button type="primary" @click="updateUser">确 定</el-button>
      </div>
    </el-dialog>
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <el-table :data="tableData" border style="width: 100%">
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
                <el-button @click="handleDetail(id)" type="text" size="small">修改密码</el-button>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <div class="block pagination-el">
          <el-pagination
            :page-size="10"
            layout="total, prev, pager, next"
            :total="dLength">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
  <!--end-main-container-part-->
</template>
<script>
  import {getUser} from "@/api/api";
  export default {
    name: 'dashboard',
    data () {
      return {
        tableData: [],
        dLength:0,
        dialogTableVisible:false,
        formLabelWidth:'150px',
        currentId:''
      };
    },
    mounted:function(){
      getUser().then(resp => {
            if(resp.code == 'W10000'&&resp.data){
              this.tableData = resp.data;
              this.dLength = resp.data.length
            }else{
                if(resp.message){
                    alert(resp.message)  
                }
            }
      });
    },
    methods:{
      handleDetail:function(id){
        this.dialogTableVisible = true
        currentId = this.id;
      },
      updatePassword:function(){
        ialogTableVisible = false;
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
