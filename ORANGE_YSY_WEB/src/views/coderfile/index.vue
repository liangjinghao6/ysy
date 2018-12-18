<template>
  <div class="app-container calendar-list-container">
    <div class="filter-container">
      <el-input @keyup.enter.native="doQuery" style="width: 200px;" class="filter-item" placeholder="模板名"
                v-model="hdQuery.others.anyQuery">
      </el-input>
      <el-button class="filter-item" type="primary" icon="search" @click="doQuery">搜索</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" @click="doEdit('')" type="primary" icon="edit">添加
      </el-button>
    </div>

    <el-table :data="hdResult.rows" v-loading="listLoading" element-loading-text="加载中..." border fit
              highlight-current-row :default-sort="{prop: 'sorter'}" @sort-change="hdQuery.doSort"
              sortable="custom">

      <el-table-column align="center" label="模板名" width="140" prop="fileName"
                       sortable>
        <template slot-scope="scope">
          <span style='color:red;'>{{scope.row.fileName}}</span>
        </template>
      </el-table-column>
      <el-table-column align=" center
      " label="排序号" width="100" prop="sorter" sortable>
      </el-table-column>
      <el-table-column align="center" label="共享" width="90" prop="isShare" sortable>
        <template slot-scope="scope">
          <span>{{scope.row.isShare == '1' ? '√' : ''}}</span>
        </template>
      </el-table-column>
      <el-table-column width="100px" align="center" label="创建人" prop="recNam" sortable>
      </el-table-column>

      <el-table-column width="150px" align="center" label="创建时间" prop="recTim" sortable>
      </el-table-column>
      <el-table-column width="100px" align="center" label="更新人" prop="updNam" sortable>
      </el-table-column>

      <el-table-column width="150px" align="center" label="更新时间" prop="updTim" sortable>
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" v-if='scope.row.isShare!="1"||$store.getters.isAdmin'
                     @click="doEditDetail(scope.row.fileId,true)">模板明细
          </el-button>
          <el-button size="small" type="success" v-if='scope.row.isShare=="1"&&!$store.getters.isAdmin'
                     @click="doEditDetail(scope.row.fileId,false)">查看明细
          </el-button>
          <el-button size="small" type="success" v-if='scope.row.isShare!="1"||$store.getters.isAdmin'
                     @click="doEdit(scope.row.fileId)">编辑
          </el-button>
          <el-button size="small" type="danger" v-if='scope.row.isShare!="1"||$store.getters.isAdmin'
                     @click="doRemove(scope.row.fileId)">删除
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

    <coderfileform ref="coderfileform" @save-ok="doQuery"></coderfileform>
    <coderdetail ref="coderdetail"></coderdetail>
  </div>
</template>

<script>
  import coderfileform from './coderfileform'
  import coderdetail from './coderdetail'
  import HdQuery from '@/utils/HdQuery'

  export default {
    name: 'table_demo',
    components: {coderfileform, coderdetail},
    data() {
      return {
        hdQuery: new HdQuery(this),
        hdResult: {},
        listLoading: true,
        visiable: false

      }
    },

    mounted() {
      this.doQuery()
    },
    methods: {
      doQuery() {
        this.listLoading = true
        this.$http.post('/webresources/coderfile/find', this.hdQuery).then(response => {
          const data = response.data
          this.hdResult = data
          this.listLoading = false
        })
      },
      doEdit(fileId) {
        this.$refs['coderfileform'].show(fileId);
      },
      doRemove(fileId) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.$http.post('/webresources/coderfile/removeOne?fileId=' + fileId).then(response => {
            const data = response.data
            this.$message({
              type: data.code == '-1' ? 'error' : 'success',
              message: data.message
            })
            if (data.code == '-1') {
              return
            }
            this.doQuery()
          })
        }).catch(() => {

        })
      },
      doEditDetail(fileId, canEdit) {
        this.$refs['coderdetail'].show(fileId, canEdit);
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";

</style>
