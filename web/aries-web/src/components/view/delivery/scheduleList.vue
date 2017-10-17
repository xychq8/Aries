<template>
  	<!--main-container-part-->
	<div class="container-fluid">
		<div class="row-fluid">
	      <div class="span12">
	        <div class="widget-box">
	          <el-table :data="tableData" border style="width: 100%">
	            <el-table-column label="序号" width="80" >
	                <template scope="scope">
	                    {{scope.$index+1}}
	                </template>
	            </el-table-column>
	            <el-table-column prop="name" label="uuid" width="130">
	            </el-table-column>
	            <el-table-column prop="orderType" label="售卖模式" width="160">
	            </el-table-column>
	            <el-table-column prop="ideaType" label="素材类型" width="160">
	            </el-table-column>
	            <el-table-column prop="ideaType" label="速率" width="160">
	            </el-table-column>
	            <el-table-column prop="hours" label="投放时间" width="240">
	            </el-table-column>
	            <el-table-column
	              fixed="right"
	              label="操作"
	              width="100">
	              <template scope="scope">
	                <el-button type="text" size="small" @click.native.prevent="handleMenuDetail(scope.row.id)" >查看菜单</el-button>
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
</template>
<script>
import {getRoles,getUserMenu,saveMenuRole} from "@/api/api";
export default {
    name: 'scheduleList',
    data () {
       	return {
        	tableData: [],
        	count:0
    	}  
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		
    	}
    }
 }
</script>
<style scoped>
</style>