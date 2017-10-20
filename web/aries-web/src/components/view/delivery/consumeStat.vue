<template>
  	<!--main-container-part-->
	<section>
		<el-col  :offset="1" class="toolbar" style="padding-top: 20px">
			<el-form :inline="true" >
				<el-form-item>
					<el-input auto-complete="off" size="large" placeholder="uuid" v-model="filters.uuid"  autosize style="width: 250px"></el-input>
					</el-form-item>
					<el-form-item>
						<el-button type="primary" @click="getData" >查询</el-button>
					</el-form-item>
			</el-form>
		</el-col>
		<div id="myChart" :style="{width: '100%', height: '300px'}"></div>
	</section>
</template>
<script>
import {getConsumeByDay} from "@/api/api";
import {formatDate} from "@/components/view/common/date";
import echarts from 'echarts';
export default {
    name: 'scheduleList',
    data () {
       	return {
       		filters:{
       			uuid:''
       		},
       		chart:{
       			xData:[],
       			yData:[]
       		}
    	}  
    },
    mounted:function(){
    	
    },
    methods:{
    	getData:function(){
    		this.chart.xData = [];
		    this.chart.yData = [];
    		var uuid = this.filters.uuid ;
    		if(!uuid || uuid==''){
    			this.$message({
                    showClose: true,
                    message: '请输入uuid!',
                    type: 'error'
                });
    			return ;
    		}
    		var dateStr = formatDate(new Date(),'yyyyMMdd');
    		getConsumeByDay(uuid,dateStr).then(resp => {
    			var x = [];
    			var y = [];
		        for(consume in resp.data){
		        	x.push(consume.createDate);
		        	y.push(consume.actualConsume);
		        }
		        this.chart.xData = x;
		        this.chart.yData = y;
	        })
    	},
    	getChart:function(){
	        // 基于准备好的dom，初始化echarts实例
	        let myChart = echarts.init(document.getElementById('myChart'))
	        // 绘制图表
	        myChart.setOption({
	            title: { text: '投放量折线' },
	            tooltip: {},
	            xAxis: {
	                data: this.chart.xData
	            },
	            yAxis: {},
	            series: [{
	                name: '投放量',
	                type: 'line',
	                data: this.chart.yData
	            }]
	        });
    	}
    }
 }
</script>
<style scoped>
</style>