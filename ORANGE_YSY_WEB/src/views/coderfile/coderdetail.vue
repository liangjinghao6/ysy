<template>
  <div height="200">
    <el-dialog title="内容明细" :visible.sync="visiable">
      <div>
        <div class="filter-container">
          <el-input @keyup.enter.native="doQuery" style="width: 200px;" class="filter-item" placeholder="名称"
                    v-model="hdQuery.others.anyQuery">
          </el-input>
          <el-button class="filter-item" type="primary" icon="search" @click="doQuery">搜索</el-button>
          <el-button class="filter-item" style="margin-left: 10px;" @click="doEdit('',true)" type="primary" icon="edit"
                     v-if="canEdit">添加
          </el-button>
        </div>

        <el-table :data="hdResult.rows" v-loading="listLoading" element-loading-text="给我一点时间" border fit
                  highlight-current-row  :default-sort="{prop: 'sorter'}"
                  @sort-change="hdQuery.doSort"
                  sortable="custom">

          <el-table-column align="center" label="生成名">
            <template slot-scope="scope">
              <span>{{scope.row.detailName}}</span>
            </template>
          </el-table-column>
          <el-table-column align="center" label="操作">
            <template slot-scope="scope">
              <el-button size="small" type="success" @click="doEdit(scope.row.detailId,true)" v-if="canEdit">编辑
              </el-button>
              <el-button size="small" type="success" @click="doEdit(scope.row.detailId,false)" v-if="!canEdit">查看
              </el-button>
              <el-button size="small" type="danger" @click="doRemove(scope.row.detailId)" v-if="canEdit">删除
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
      </div>
      <coderdetailform ref="coderdetailform" @save-ok="doQuery"></coderdetailform>
    </el-dialog>
  </div>
</template>

<script>
  import HdQuery from '@/utils/HdQuery'
  import coderdetailform from './coderdetailform'

  export default {
    name: 'coderdetail',
    components: {coderdetailform},
    data() {
      return {
        fileId: '',
        hdResult: {},
        listLoading: true,
        visiable: false,
        hdQuery: new HdQuery(),
        canEdit: true//false是不可编辑状态
      }
    },

    created() {

    },
    methods: {
      show(fileId, canEdit) {
        this.canEdit = canEdit
        this.fileId = fileId
        this.visiable = true;
        this.hdQuery.add('fileId', fileId)
        this.doQuery()
      },
      doQuery() {
        this.listLoading = true
        this.$http.post('/webresources/coderfiledetail/find', this.hdQuery).then(response => {
          const data = response.data
          this.hdResult = data
          this.listLoading = false
        })
      },
      doEdit(detailId, canEdit) {
        this.$refs['coderdetailform'].show(detailId, this.fileId, canEdit);
      },
      doRemove(detailId) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.$http.post('/webresources/coderfiledetail/removeOne?detailId=' + detailId).then(response => {
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
      }
    }
  }
</script>
