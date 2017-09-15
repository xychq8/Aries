<template>
  <!--main-container-part-->
  <div class="container-fluid">
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
        dLength:0
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
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
