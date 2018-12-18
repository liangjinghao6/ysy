<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input style="width: 200px;" class="filter-item" v-model="hdQuery.others.srcName" placeholder="请输入数据源名称"
                @keyup.enter.native="doQuery">
      </el-input>
      <el-button class="filter-item" type="primary" icon="search" @click="doQuery">搜索</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" icon="edit" type="primary" @click="doEdit('')">添加
      </el-button>

    </div>

    <el-table :data="hdResult.rows" v-loading="listLoading" border fit highlight-current-row
              :default-sort="{prop: 'updTim',order: 'descending'}"
              @sort-change="hdQuery.doSort" sortable="custom">

      <el-table-column width="120px" align="center" label="数据源名称" prop="srcName" sortable>
        <template slot-scope="scope">
          <span style='color:red;'>{{scope.row.srcName}}</span>
        </template>
      </el-table-column>

      <el-table-column width="330px" align="center" label="JDBC地址">
        <template slot-scope="scope">
          <span class="link-type">{{scope.row.dbUrl}}</span>
        </template>
      </el-table-column>

      <el-table-column width="100px" align="center" label="创建人" prop="recNam" sortable>
        <template slot-scope="scope">
          <span>{{scope.row.recNam}}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="创建时间" prop="recTim" sortable>
        <template slot-scope="scope">
          <span>{{scope.row.recTim}}</span>
        </template>
      </el-table-column>
      <el-table-column width="100px" align="center" label="更新人" prop="updNam" sortable>
        <template slot-scope="scope">
          <span>{{scope.row.updNam}}</span>
        </template>
      </el-table-column>

      <el-table-column width="150px" align="center" label="更新时间" prop="updTim" sortable>
        <template slot-scope="scope">
          <span>{{scope.row.updTim}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="doEdit(scope.row.srcId)">编辑
          </el-button>
          <el-button size="small" type="danger" @click="doRemove(scope.row.srcId)">删除
          </el-button>
        </template>
      </el-table-column>

    </el-table>
    <div class="pagination-container">
      <el-pagination :current-page.sync="hdQuery.page" :page-size="hdQuery.rows"
                     :page-sizes="[10,20,30, 50]" @size-change="hdQuery.doSizeChg"
                     @current-change="hdQuery.doCurPageChange" layout="total, sizes, prev, pager, next, jumper"
                     :total="hdResult.total">
      </el-pagination>
    </div>
    <datasrcform ref="datasrcform" @save-ok="doQuery"></datasrcform>

  </div>
</template>

<script>
  import datasrcform from './datasrcform'
  import HdQuery from '@/utils/HdQuery'

  export default {
    components: {
      datasrcform
    },
    data() {
      return {
        hdResult: {},
        listLoading: true,
        visiable: false,
        hdQuery: new HdQuery(this)
      }
    },
    mounted() {
      this.doQuery()
    },
    methods: {
      doEdit(srcId) {
        this.$refs['datasrcform'].show(srcId)
      },
      doRemove(srcId) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/webresources/codersrc/remove?srcId=' + srcId).then(response => {
            const data = response.data
            this.listLoading = false
            if (data.code === '-1') {
              this.$message({
                type: 'error',
                message: data.message
              })
            }
            else {
              this.doQuery()
              this.$message({
                type: 'success',
                message: data.message
              })
            }

          })
        }).catch(() => {

        })

      },
      doQuery() {
        this.listLoading = true
        this.$http.post('/webresources/codersrc/find', this.hdQuery).then(response => {
          //console.debug(response.data)
          const data = response.data
          this.hdResult = data
          this.listLoading = false
        })
      },
    }
  }
</script>
<!--<style rel="stylesheet/scss" lang="scss" scoped>-->
  <!--.el-table {-->
    <!--height:65vh;-->

  <!--}-->
<!--</style>-->

