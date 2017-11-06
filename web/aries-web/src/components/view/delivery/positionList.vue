<template>
  	<!--main-container-part-->
	<section>
		<div class="row-fluid">
      		<div class="span12">
      			<el-col  :offset="1" class="toolbar" style="padding-top: 20px">
					<el-form :inline="true" >
						<el-form-item>
							<el-input auto-complete="off" size="large" placeholder="uuid"  autosize style="width: 250px"></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" v-on:click="getData" >查询</el-button>
						</el-form-item>
					</el-form>
			  	</el-col>
	          	<el-table :data="tableData" style="width: 100%">
				    <el-table-column type="expand">
				      <template scope="props">
				        <el-form label-position="left" inline class="demo-table-expand">
		          			<el-form-item label="保量计划数:">
		            			<span>{{ props.row.gdSize }}</span>
			         		</el-form-item>
			          		<el-form-item label="不保量计划数:">
			            		<span>{{ props.row.ngdSize }}</span>
			          		</el-form-item>
			          		<el-form-item label="保量计划:">
			            		<span>{{ props.row.gdUuids | nullToDefault }}</span>
			          		</el-form-item>
			          		<el-form-item label="不保量计划:">
			            		<span>{{ props.row.ngdUuids | nullToDefault }}</span>
			          		</el-form-item>
		        		</el-form>
				      </template>
				    </el-table-column>
				    <el-table-column
				      label="平台"
				      prop="position.channel">
				    </el-table-column>
				    <el-table-column
				      label="栏目"
				      prop="position.categoryName">
				    </el-table-column>
					<el-table-column
				      label="位置"
				      prop="position.locationName">
				    </el-table-column>
				    
				  </el-table>
	        </div>
	    </div>
	</section>
</template>
<script>
import {getPositionInfo} from "@/api/api";
export default {
    name: 'scheduleList',
    data () {
       	return {
       		tableData:[]
    	}  
    },
    mounted:function(){
    	this.getData();
    },
    methods:{
    	getData:function(){
    		getPositionInfo().then(resp => {
    			if(resp.data){
    				this.tableData = resp.data;
    			}
	        })
    	}
    },
    filters: {
    	nullToDefault:function(value){
    		if(!value){
    			return '-';
    		}
    		return value;
    	}
    }
 }
</script>
<style scoped>
  .demo-table-expand {
    font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>