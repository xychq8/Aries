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
	            <el-table-column prop="uuid" label="uuid" width="130">
	            </el-table-column>
	            <el-table-column prop="orderType" label="售卖模式" width="160">
	            </el-table-column>
	            <el-table-column prop="ideaType" label="素材类型" width="160">
	            </el-table-column>
	            <el-table-column prop="cast_speed" label="速率" width="160">
	            </el-table-column>
	            <el-table-column prop="hours" label="投放时间" >
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
	            :total="count"
				:current-page="currentPage"
	            >
	          </el-pagination>
	        </div>
	      </div>
	    </div>
	</div>
</template>
<script>
import {getSchedule} from "@/api/api";
export default {
    name: 'scheduleList',
    data () {
       	return {
        	tableData: [],
        	count:0,
        	currentPage:1
    	}  
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		var param = "/"+this.currentPage+"/10";
    		getSchedule(param).then(resp => {
		        if(resp.code == 'DD10000'){
		            if(resp.data){
		                this.tableData = resp.data.data;
		                this.count = resp.data.total
		            }
		        }
	        });
    	}
    }
 }
</script>
<style scoped>
</style>