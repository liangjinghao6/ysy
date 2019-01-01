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
        <el-table-column width="150px" align="center" label="账号" prop="userName" >
          <template slot-scope="scope">
            <span>{{scope.row.userName}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="昵称" prop="nickName" >
          <template slot-scope="scope">
            <span>{{scope.row.nickName}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="100px" align="center" label="是否为会员" prop="isVip" >
          <template slot-scope="scope">
            <span>{{scope.row.isVip=='0'?'×':'√'}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="微信号" prop="wx" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.wx}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="手机号" prop="phone" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.phone}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="用户级别" prop="userLevel" >
          <template slot-scope="scope">
            <span>{{scope.row.userLevel}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="邀请码" prop="inviteNo" >
          <template slot-scope="scope">
            <span>{{scope.row.inviteNo}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="介绍人" prop="inviteId" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.inviteId}}</span>
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
        <el-table-column width="250px" align="center" label="关联时间" prop="inviteTime" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.inviteTime}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="250px" align="center" label="成会员时间" prop="vipTime" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.vipTime}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
        <el-table-column width="150px" align="center" label="token" prop="token" >
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.token}}</span>
          </template>
        </el-table-column>
      </el-col>
      <el-col :span="12">
      </el-col>

      <el-table-column width="150px" align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="doEdit(scope.row.userId, 'update')">编辑
          </el-button>
          <el-button size="small" type="danger" @click="doRemove(scope.row.userId)">删除
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
    <userform ref="userform" @save-ok="doQuery"></userform>

  </div>
</template>

<script>
  import userform from './userform'
  import QueryInfo from '@/utils/entity/QueryInfo'

  export default {
    components: {
      userform
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
        this.$refs['userform'].show(id, method)
      },
      doRemove(id) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/iweb/user/delete?id=' + id).then(response => {
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
        this.$http.get(`/iweb/user/find?q=${this.queryInfo.query.q}&pageNum=${this.queryInfo.pageNum}&pageSize=${this.queryInfo.pageSize}`).then(response => {
          console.log(response.data.result)
          const data = response.data.result
          this.pageBean = data
          this.listLoading = false
        })
      },

    }
  }
</script>
