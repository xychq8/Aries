<template>
  	<!--main-container-part-->
	<div class="container-fluid">
		<!-- tree -->
		<el-dialog title="菜单" :visible.sync="dialogTableVisible" >
	      	<el-tree
			  :data="treeData"
			  show-checkbox
			  node-key="id"
			  :default-expanded-keys="[]"
			  :default-checked-keys="checkData"
			  ref="tree"
			  :props="defaultProps">
			</el-tree>
	      <div slot="footer" class="dialog-footer">
	        <el-button @click="dialogTableVisible = false">取 消</el-button>
	        <el-button type="primary" @click="saveMenuRole">确 定</el-button>
	      </div>
	    </el-dialog>
	    <hr>
	    <div class="row-fluid">
	      <div class="span12">
	        <div class="widget-box">
	          <el-table :data="tableData" border style="width: 100%">
	            <el-table-column label="序号" width="180">
	                <template scope="scope">
	                    <a href="javascript:;">{{scope.row.id}}</a>
	                </template>
	            </el-table-column>
	            <el-table-column prop="name" label="名称" width="180">
	            </el-table-column>
	            <el-table-column prop="createDate" label="创建时间" >
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
	            :total="dLength">
	          </el-pagination>
	        </div>
	      </div>
	    </div>
	</div>
</template>
<script>
import {getRoles,getUserMenu,saveMenuRole} from "@/api/api";
export default {
    name: 'roleManager',
    data () {
      return {
        tableData: [],
        treeData:[],
        checkData:[],
        dLength:0,
        currentRoleId:'',
        dialogTableVisible:false,
        defaultProps: {
          children: 'subMenu',
          label: 'name'
        }
      };
    },
    mounted:function(){
    	this.getTableData();
    },
    methods:{
    	getTableData:function(){
    		getRoles().then(resp => {
	            if(resp.code == 'W10000'&&resp.data){
	              this.tableData = resp.data;
	              this.dLength = resp.data.length
	            }else{
	                if(resp.message){
	                    alert(resp.message)   
	                }
	            }
      		});
    	},
    	handleMenuDetail:function(id){
    		this.dialogTableVisible = true;
    		this.currentRoleId = id;
    		getUserMenu(id).then(resp=>{
    			if(resp.code == 'W10000'&&resp.data){
    				this.treeData = resp.data.menus;
    				this.checkData = resp.data.check;
    			}else{

    			}
    		})
    	},
    	saveMenuRole:function(){
    		var param = {'menus':this.$refs.tree.getCheckedKeys(),'id':this.currentRoleId};
    		saveMenuRole(param).then(resp=>{
    			alert(resp)
    		})
    	}
    }
 }
</script>
<style scoped>
</style>