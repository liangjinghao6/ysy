<template>
  <div class="app-container calendar-list-container">
    <div class="filter-container">
      <el-input style="width: 200px;" class="filter-item" v-model="queryInfo.query.q" placeholder="请输入姓名或账号"
                @keyup.enter.native="doQuery">
      </el-input>
      <el-button class="filter-item" type="primary" icon="search" @click="doQuery">搜索</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" icon="edit" type="primary" @click="doEdit('', 'add')">添加
      </el-button>
    </div>

    <el-table :data="pageBean.list" v-loading="listLoading" border fit highlight-current-row
              style="width: 100%;height:100%" :default-sort="{prop: 'updTimestamp',order: 'descending'}"
              @sort-change="queryInfo.doSort" sortable="custom">

        	<el-col :span="12">
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="品牌名称" prop="brandName" >
		<template slot-scope="scope">
		  <span>{{scope.row.brandName}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="品牌描述" prop="description" >
		<template slot-scope="scope">
		  <span>{{scope.row.description}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
            <el-table-column width="250px" align="center" label="创建时间" prop="createTime" >
		<template slot-scope="scope">
		  <span>{{scope.row.createTime}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
            <el-table-column width="250px" align="center" label="修改时间" prop="updateTime" >
		<template slot-scope="scope">
		  <span>{{scope.row.updateTime}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
        </el-col>

      <el-table-column width="150px" align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="doEdit(scope.row.brandId, 'update')">编辑
          </el-button>
          <el-button size="small" type="danger" @click="doRemove(scope.row.brandId)">删除
          </el-button>
        </template>
      </el-table-column>
        

    </el-table>
    <div class="pagination-container">
      <el-pagination :current-page.sync="pageBean.pageNum" :page-size="queryInfo.pageSize"
                     :page-sizes="[10,20,30, 50]" @size-change="queryInfo.doSizeChg"
                     @current-change="queryInfo.doCurPageChange" layout="total, sizes, prev, pager, next, jumper"
                     :total="pageBean.totalRecords">
      </el-pagination>
    </div>
    <goodsbrandform ref="goodsbrandform" @save-ok="doQuery"></goodsbrandform>

  </div>
</template>

<script>
  import goodsbrandform from './goodsbrandform'
  import QueryInfo from '@/utils/entity/QueryInfo'

  export default {
    components: {
      goodsbrandform
    },
    data() {
      return {
        pageBean: {},
        listLoading: true,
        visiable: false,
        queryInfo: new QueryInfo(this)
      }
    },
    mounted() {
      this.queryInfo.query.q = '';
      this.doQuery()
    },
    methods: {
      doEdit(id, method) {
        this.$refs['goodsbrandform'].show(id, method)
      },
      doRemove(id) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/iweb/goodsbrand/delete?id=' + id).then(response => {
            const data = response.data
            this.listLoading = false
            this.$message({
              type: data.status,
              message: data.description
            })
            if (!data.status) {
              return
            }
            this.doQuery()
          })
        })
      },
      doQuery() {
        this.listLoading = true
        this.$http.get(`/iweb/goodsbrand/find?q=${this.queryInfo.query.q}&pageNum=${this.queryInfo.pageNum}&pageSize=${this.queryInfo.pageSize}`).then(response => {
          console.log(response.data.result)
          const data = response.data.result
          this.pageBean = data
          this.listLoading = false
        })
      },

    }
  }
</script>
