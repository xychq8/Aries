<template>
  	<!--main-container-part-->
	<section>
		<el-dialog title="实时投放" size="tiny" :visible.sync="dialog.consumeDialogTableVisible" top="30%" >
			<span style="margin-left: 50px;height: 10px">投放曝光量:{{delivery.consume}}</span>
			</br>
			<span style="margin-left: 50px">实际曝光量:{{delivery.actualConsume}}</span>
			<span slot="footer" class="dialog-footer">
		        <el-button type="primary" @click="dialog.consumeDialogTableVisible = false" >确 定</el-button>
			</span>
	    </el-dialog>
		<div class="row-fluid">
      		<div class="span12">
      			<el-col  :offset="1" class="toolbar" style="padding-top: 20px">
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
		            <el-table-column prop="frequence" label="频次" width="120" :formatter="formatFrequence" >
		            </el-table-column>
		            <el-table-column prop="ideaType" label="素材类型" width="120">
		            </el-table-column>
		            <el-table-column prop="castSpeed" label="速率" width="160">
		            </el-table-column>
		            <el-table-column prop="hours" label="投放时间" >
		            </el-table-column>
		            <el-table-column
		              fixed="right"
		              label="操作"
		              width="130">
		              <template scope="scope">
		                <el-button type="text" size="small" @click.native.prevent="handleConsume(scope.row.uuid)" >实时投放</el-button>
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
import {getSchedule,getConsume} from "@/api/api";
import {formatDate} from "@/components/view/common/date"
export default {
    name: 'scheduleList',
    data () {
       	return {
       		tableData: [],
        	count:0,
        	currentPage:1,
        	loading: false,
       		filters: {
					uuid: ''
			},
			dialog:{
				consumeDialogTableVisible:false,
			},
        	delivery:{
        		consume:0,
        		actualConsume:0
        	}
    	}  
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		this.loading = true;
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
		        this.loading = false;
	        });
    	},
    	handleCurrentChange:function(val){
    		this.loading = true;
    		var dateStr = formatDate(new Date(),'yyyyMMdd');
    		var param = "/"+val+"/10/"+dateStr;
    		getSchedule(param).then(resp => {
		        if(resp.code == 'DD10000'){
		            if(resp.data){
		                this.tableData = resp.data.data;
		                this.count = resp.data.total
		            }
		        }
		        this.loading = false;
	        });
    	},
    	handleConsume:function(uuid){
    		getConsume(uuid).then(resp => {
    			this.dialog.consumeDialogTableVisible = true;
		        if(JSON.parse(resp.data).consume){
		        	this.delivery.consume = JSON.parse(resp.data).consume;
		        }else{
		        	this.delivery.consume = 0;
		        }
		        if(JSON.parse(resp.data).actualConsume){
		        	this.delivery.actualConsume = JSON.parse(resp.data).actualConsume;
		        }else{
		        	this.delivery.actualConsume = 0;
		        }
	        });
    	},
    	formatFrequence:function(row, column, cellValue){
    		if(!cellValue || cellValue == 0){
    			return "无"
    		}
    		return cellValue+"次";
    	}
    }
 }
</script>
<style scoped>
</style>