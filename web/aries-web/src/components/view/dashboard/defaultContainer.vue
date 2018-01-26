<template>
	<section>
		<el-row class="index_container" :gutter="20">
		  <el-col :span="7">
		  	<el-card class="index_card" :body-style="{ padding: '0px' ,margin: '0px'}">
		  		<el-row class="index_card_container" :gutter="20">
		  			<el-col :span=8 >
						<i class="fa fa-exclamation-triangle fa-5x warning"></i>
		  			</el-col>
		  			<el-col :span=16 >
		  				<div class="content">
							<p>投放时间 &gt <em>30%</em> , 曝光量 &lt <em>10%</em></p>
							<p><em>{{posIndex}}</em> 个广告位</p>
							<p><em>{{warnIndex}}</em> 个投放计划</p>
						</div>
						<div class="detail">
							<a @click="downloadExcel">下载</a>
						</div>
		  			</el-col>
		  		</el-row>
			</el-card>
		  </el-col>
		</el-row>
	</section>
</template>
<!-- 改为指标页面 -->
<script>
import {getIndex,getToken} from "@/api/api";
export default {
	name: 'defaultContainer',
  	data () {
    	return {
    		posIndex:'0',
    		warnIndex:'0',
      		msg:''
    	};
  	},
  	mounted:function(){
    	this.getIndexData();
  	},
	methods:{
		getIndexData:function(){
			getIndex().then(resp => {
				if(resp.data){
					if(resp.data.posIndex && resp.data.warnIndex){
						this.posIndex = resp.data.posIndex
						this.warnIndex = resp.data.warnIndex
					}
				}
			})
		},
		downloadExcel:function(){
			console.log(getToken() + `/data/warning/excel?&token`+this.$store.getters.getToken)
			window.open(getToken() + `/download/warning/excel?&token=`+this.$store.getters.getToken)
		}
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 .index_container{
 	padding-top: 30px;
	padding-left: 30px;
	font-size: 12px;

 }
 .index_card{
 	height: 110px
 }
 .index_card_container{
 	padding-top: 14px;
 	padding-left: 20px;
 }
 .index_card_container i{
	padding-top: 10px
 }
 .index_card_container .content{
 	line-height:6px;
 	margin-left: -20px;
 }
 .index_card_container .detail{
 	padding-left: 70%;
 	color:#A5DEE4;
 }
 .index_card_container .detail a:hover{
 	cursor:pointer;
 	color:red;
 }
 .warning{
 	color : red;
 }
 
</style>
