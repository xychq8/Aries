<template>
  	<!--main-container-part-->
	<section>
		<div class="row-fluid">
      		<div class="span12">
      			<el-col :span="24" class="search-toolbar" >
					<el-form :inline="true" >
						<el-form-item>
							<el-select v-model="filters.category" multiple placeholder="平台"  >
						    <el-option
						      v-for="item in filters.categoryOps"
						      :key="item.value"
						      :label="item.label"
						      :value="item.value">
						    </el-option>
						  </el-select>
						</el-form-item>
						<el-form-item>
							<el-button type="primary" v-on:click="getData" >查询</el-button>
						</el-form-item>
					</el-form>
				</el-col>
	          	<el-table :data="tableData" style="width: 100%">
				    <el-table-column type="expand">
				      <template scope="props">
				        <el-form label-position="left" inline class="position-table-expand" >
		          			<el-form-item label="保量计划数:">
		            			<span>{{ props.row.gdSize }}</span>
			         		</el-form-item>
			          		<el-form-item label="不保量计划数:">
			            		<span>{{ props.row.ngdSize }}</span>
			          		</el-form-item>
			          		<el-form-item label="保量计划:">
			            		<span class="content-span" v-html="breakWord(nullToDefault(props.row.gdUuids))" ></span>
			          		</el-form-item>
			          		<el-form-item label="不保量计划:">
			            		<span class="content-span" v-html="breakWord(nullToDefault(props.row.ngdUuids))" ></span>
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
       		tableData:[],
       		filters:{
				category:'',
				categoryOps:[
		        	{
				        value: '7A16FBB6',
				        label: '新闻客户端'
			        },
			        {
				        value: '3E0F733C',
				       	label: '邮箱大师'
			        }
			   	]
       		}
    	}  
    },
    mounted:function(){
    	this.getData();
    },
    methods:{
    	getData:function(){
    		var param = [];
    		if(this.filters.category && this.filters.category.length>0){
    			param = this.filters.category;
    		}
    		getPositionInfo(param).then(resp => {
    			if(resp && resp.data){
    				this.tableData = resp.data;
    			}
	        })
    	},
    	nullToDefault:function(value){
    		if(!value){
    			return '-';
    		}
    		return value;
    	},
    	breakWord:function(value){
    		if(value){
    			var arr = value.split(",");
    			var strs = "";
    			$.each(arr,function(index,str){
    				if(index == 0){
    					strs = str;
    					return;
    				}
    				if(index>0&&(index%10==0)){
    					strs = strs+","+"</br>"+str;
    					return;
    				}
    				strs = strs+","+str;
    			})
    			return strs;
    		}
    	}
    },
    filters: {
    	
    }
 }
</script>
<style scoped>
  .position-table-expand {
    font-size: 0;
  }
  .position-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .position-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
  .position-table-expand .content-span{
  	word-wrap : break-word ;overflow: hidden ;width: 10px;
  }
</style>