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
          <el-table-column width="150px" align="center" label="商品id" prop="goodsId" >
		<template slot-scope="scope">
		  <span>{{scope.row.goodsId}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="商品数量" prop="goodsNum" >
		<template slot-scope="scope">
		  <span>{{scope.row.goodsNum}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="订单id" prop="orderId" >
		<template slot-scope="scope">
		  <span>{{scope.row.orderId}}</span>
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

      <el-table-column width="150px" align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="doEdit(scope.row.odId, 'update')">编辑
          </el-button>
          <el-button size="small" type="danger" @click="doRemove(scope.row.odId)">删除
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
    <lnkordergoodsform ref="lnkordergoodsform" @save-ok="doQuery"></lnkordergoodsform>

  </div>
</template>

<script>
  import lnkordergoodsform from './lnkordergoodsform'
  import QueryInfo from '@/utils/entity/QueryInfo'

  export default {
    components: {
      lnkordergoodsform
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
        this.$refs['lnkordergoodsform'].show(id, method)
      },
      doRemove(id) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/iweb/lnkordergoods/delete?id=' + id).then(response => {
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
        this.$http.get(`/iweb/lnkordergoods/find?q=${this.queryInfo.query.q}&pageNum=${this.queryInfo.pageNum}&pageSize=${this.queryInfo.pageSize}`).then(response => {
          console.log(response.data.result)
          const data = response.data.result
          this.pageBean = data
          this.listLoading = false
        })
      },

    }
  }
</script>
