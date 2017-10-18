<template>
  	<!--main-container-part-->
	<section>
		<div class="row-fluid">
      		<div class="span12">
      			<el-col  :offset="1" class="toolbar" style="padding-bottom: -100px;padding-top: 20px">
					<el-form :inline="true" >
						<el-form-item>
							<el-input auto-complete="off" size="large" placeholder="uuid" v-model="filters.uuid"  autosize style="width: 250px"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" v-on:click="getTableData" >查询</el-button>
						</el-form-item>
					</el-form>
			  	</el-col>
	          <!--工具条-->
	          	<el-table :data="tableData"  style="width: 100%" v-loading="loading">
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
		            <el-table-column prop="castSpeed" label="速率" width="160">
		            </el-table-column>
		            <el-table-column prop="hours" label="投放时间" >
		            </el-table-column>
		            <el-table-column
		              fixed="right"
		              label="操作"
		              width="100">
		              <template scope="scope">
		                <el-button type="text" size="small" @click.native.prevent="handleMaterialInfo(scope.row.id)" >素材</el-button>
		                <el-button type="text" size="small" @click.native.prevent="handleMenuDetail(scope.row.id)" >实时投放</el-button>
		              </template>
		            </el-table-column>
	         	</el-table>
	        </div>
	        <div class="block pagination-el">
	          <el-pagination
	          	@current-change="handleCurrentChange"
	            layout="total, prev, pager, next"
	            :total="count"
				:current-page="currentPage"
	            :page-size="10"
	            >
	          </el-pagination>
	        </div>
	    </div>
	  </section>
</template>
<script>
import {getSchedule} from "@/api/api";
import {formatDate} from "@/components/view/common/date"
export default {
    name: 'scheduleList',
    data () {
       	return {
       		filters: {
					uuid: ''
			},
        	tableData: [],
        	count:0,
        	currentPage:1,
        	loading:false
    	}  
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		var dateStr = formatDate(new Date(),'yyyyMMdd');
    		var param = "/"+this.currentPage+"/10/"+dateStr;
    		if(this.filters.uuid){
    			param = param + "/" + this.filters.uuid	
    		}
    		getSchedule(param).then(resp => {
		        if(resp.code == 'DD10000'){
		            if(resp.data){
		                this.tableData = resp.data.data;
		                this.count = resp.data.total
		            }
		        }
	        });
    	},
    	handleCurrentChange:function(val){
    		var dateStr = formatDate(new Date(),'yyyyMMdd');
    		var param = "/"+val+"/10/"+dateStr;
    		getSchedule(param).then(resp => {
		        if(resp.code == 'DD10000'){
		            if(resp.data){
		                this.tableData = resp.data.data;
		                this.count = resp.data.total
		            }
		        }
	        });
    	},
    	handleMaterialInfo:function(id){
    		
    	}
    }
 }
</script>
<style scoped>
</style>