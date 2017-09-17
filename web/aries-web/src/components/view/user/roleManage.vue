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
            <el-table-column prop="createDate" label="邮箱" width="180">
            </el-table-column>
            <el-table-column
              fixed="right"
              label="操作"
              width="100">
              <template scope="scope">
                <el-button type="text" size="small">修改密码</el-button>
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
</template>
<script>
import {getRoles} from "@/api/api";
export default {
    name: 'roleManager',
    data () {
      return {
        tableData: []
      };
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		getRoles().then(resp => {
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
 }
</script>
<style scoped>
</style>