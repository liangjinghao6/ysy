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
          <el-table-column width="150px" align="center" label="订单编号" prop="orderNo" >
		<template slot-scope="scope">
		  <span>{{scope.row.orderNo}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="用户id" prop="userId" >
		<template slot-scope="scope">
		  <span>{{scope.row.userId}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="地址id" prop="addressId" >
		<template slot-scope="scope">
		  <span>{{scope.row.addressId}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="物流号" prop="logisticsNo" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.logisticsNo}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="物流公司" prop="logisticsName" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.logisticsName}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="发票类型" prop="billType" >
		<template slot-scope="scope">
		  <span>{{scope.row.billType}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="商品总额" prop="totalPrice" >
		<template slot-scope="scope">
		  <span>{{scope.row.totalPrice}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="优惠金额" prop="cutPrice" >
		<template slot-scope="scope">
		  <span>{{scope.row.cutPrice}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="运费金额" prop="transPrice" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.transPrice}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="订单状态" prop="orderStatus" >
		<template slot-scope="scope">
		  <span>{{scope.row.orderStatus}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="订单类型" prop="orderType" >
		<template slot-scope="scope">
		  <span>{{scope.row.orderType}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
          <el-table-column width="150px" align="center" label="订单备注" prop="orderDesc" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.orderDesc}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
            <el-table-column width="250px" align="center" label="完成时间" prop="finishTime" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.finishTime}}</span>
		</template>
	      </el-table-column>
        </el-col>
	<el-col :span="12">
            <el-table-column width="250px" align="center" label="支付时间" prop="payTime" >
		<template slot-scope="scope">
		  <span style='color:red;'>{{scope.row.payTime}}</span>
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
          <el-button size="small" type="success" @click="doEdit(scope.row.orderId, 'update')">编辑
          </el-button>
          <el-button size="small" type="danger" @click="doRemove(scope.row.orderId)">删除
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
    <orderform ref="orderform" @save-ok="doQuery"></orderform>

  </div>
</template>

<script>
  import orderform from './orderform'
  import QueryInfo from '@/utils/entity/QueryInfo'

  export default {
    components: {
      orderform
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
        this.$refs['orderform'].show(id, method)
      },
      doRemove(id) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/iweb/order/delete?id=' + id).then(response => {
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
        this.$http.get(`/iweb/order/find?q=${this.queryInfo.query.q}&pageNum=${this.queryInfo.pageNum}&pageSize=${this.queryInfo.pageSize}`).then(response => {
          console.log(response.data.result)
          const data = response.data.result
          this.pageBean = data
          this.listLoading = false
        })
      },

    }
  }
</script>
