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
       		}
    	}  
    },
    mounted:function(){
    	
    },
    methods:{
    	getData:function(){
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
    		getConsumeByDay(uuid,dateStr)
    	},
    	getChart:function(){
	        // 基于准备好的dom，初始化echarts实例
	        let myChart = echarts.init(document.getElementById('myChart'))
	        // 绘制图表
	        myChart.setOption({
	            title: { text: '投放量折线' },
	            tooltip: {},
	            xAxis: {
	                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
	            },
	            yAxis: {},
	            series: [{
	                name: '销量',
	                type: 'line',
	                data: [5, 20, 36, 10, 10, 20]
	            }]
	        });
    	}
    }
 }
</script>
<style scoped>
</style>