<template>
  	<!--main-container-part-->
	<section>
		<el-dialog title="实时投放" size="tiny" :visible.sync="dialog.consumeDialogTableVisible" top="30%" >
			<el-row :gutter="20">
				<el-col :span="10" >
					<el-row>
						<el-col id="myChart" style="width: 100%;height: 100px" >
						</el-col>
					</el-row>
				</el-col>
				<el-col :span="10" >
					<el-row>
						<el-col>&nbsp;
						</el-col>
						<el-col>&nbsp;
						</el-col>
						<el-col>
							投放曝光量:{{delivery.consume}}
						</el-col>
						<el-col>
							实际曝光量:{{delivery.actualConsume}}
						</el-col>
					</el-row>
				</el-col>
				
			</el-row>
			<span slot="footer" class="dialog-footer">
		        <el-button type="primary" @click="dialog.consumeDialogTableVisible = false" >确 定</el-button>
			</span>
	    </el-dialog>
	    <el-dialog title="投放位置" size="tiny" :visible.sync="dialog.positionDialogTableVisible" top="30%" >
			<el-table :data="positionData">
    			<el-table-column property="channel" label="平台" width="150"></el-table-column>
    			<el-table-column property="categoryName" label="栏目" width="150"></el-table-column>
    			<el-table-column property="locationName" label="位置" width="200"></el-table-column>
  			</el-table>
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
	            	<el-table-column label="序号" width="70" >
	                	<template scope="scope">
	                    	{{scope.$index+1}}
	                	</template>
	            	</el-table-column>
		            <el-table-column prop="uuid" label="uuid" width="80">
		            </el-table-column>
		            <el-table-column prop="frequence" label="频次" width="80" :formatter="formatFrequence" >
		            </el-table-column>
		            <el-table-column prop="ideaType" label="素材类型" width="120">
		            </el-table-column>
		            <el-table-column prop="castSpeed" label="速率" width="100">
		            </el-table-column>
		            <el-table-column prop="cpm" label="投放量" width="80">
		            </el-table-column>
		            <el-table-column prop="repair" label="补量" width="80">
		            </el-table-column>
		            <el-table-column prop="hours" label="投放时间" >
		            </el-table-column>
		            <el-table-column
		              fixed="right"
		              label="操作"
		              width="150">
		              <template scope="scope">
		                <el-button type="text" size="small" @click.native.prevent="handleConsume(scope.row.uuid,scope.row.cpm,scope.row.repair)" >实时投放</el-button>
						<el-button type="text" size="small" @click.native.prevent="handleGetPosition(scope.row.uuid)" >投放位置</el-button>
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
import {getSchedule,getConsume,getPosition} from "@/api/api";
import {formatDate} from "@/components/view/common/date"
import echarts from 'echarts';
export default {
    name: 'scheduleList',
    data () {
       	return {
       		tableData: [],
       		positionData:[{}],
        	count:0,
        	currentPage:1,
        	loading: false,
       		filters: {
					uuid: ''
			},
			dialog:{
				consumeDialogTableVisible:false,
				positionDialogTableVisible:false
			},
        	delivery:{
        		consume:0,
        		actualConsume:0,
        		unDeliveryNum:0
        	},
        	myChart:null
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
    	handleConsume:function(uuid,cpm,repair){
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
		        
	        }).then(()=>{
	        	this.handleConsumeStat(cpm,repair);
	        });
    	},
    	formatFrequence:function(row, column, cellValue){
    		if(!cellValue || cellValue == 0){
    			return "无"
    		}
    		return cellValue+"次";
    	},
    	handleGetPosition:function(uuid){
    		getPosition(uuid).then(resp => {
    			if(resp.data){
    				this.positionData = resp.data;
    				this.dialog.positionDialogTableVisible = true;
    			}
	        });
    	},
    	handleConsumeStat:function(cpm,repair){
    		this.delivery.unDeliveryNum = 1000*(cpm+repair) - this.delivery.actualConsume;
    		if(!this.delivery.unDeliveryNum||this.delivery.unDeliveryNum<0){
    			this.delivery.unDeliveryNum = 0;
    		}
    		this.drawChart();
    	},
    	drawChart:function(){
    		var radius = [40, 55];
    		let myChart = echarts.getInstanceByDom(document.getElementById('myChart'))
    		if(!myChart){
    			myChart = echarts.init(document.getElementById('myChart'));
    		}
    		var labelTop = {
			    normal : {
			    	color: '#0080FF',
			        label : {
			            show : true,
			            position : 'center',
			            formatter : '{b}',
			            textStyle: {
			                baseline : 'bottom'
			            }
			        },
			        labelLine : {
			            show : false
			        }
			    }
			};
			var labelFromatter = {
			    normal : {
			        label : {
			            formatter : function (params){
			                return ((1-(params.percent/100.00))*100.00).toFixed(2)+'%';
			            },
			            textStyle: {
			                baseline : 'top'
			            }
			        }
			    },
			}
			var labelBottom = {
			    normal : {
			        color: '#980000',
			        label : {
			            show : true,
			            position : 'center'
			        },
			        labelLine : {
			            show : false
			        }
			    }
			};
	        // 绘制图表
	        myChart.setOption({
	        	tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    toolbox: {
			        show : false,
			    },
			    calculable : true,
			    series : [
			        {
			            name:'投放',
			            type:'pie',
			            radius : ['50%', '70%'],
			            itemStyle : labelFromatter,
			            data:[
			                {value:this.delivery.actualConsume,name:'已投放',itemStyle:labelBottom},
			                {value:this.delivery.unDeliveryNum,name:'未投放',itemStyle:labelTop}
			            ]
			        }
			    ]
	        });
    	}
    }
 }
</script>
<style scoped>
</style>