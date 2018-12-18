<template>
  <div class="app-container calendar-list-container">
    <div class="filter-container">
      <el-select class="filter-item" v-model="tmpId" placeholder="请选择类型" @change="doQuery(tmpId)">
        <el-option  v-for="template in hdtemplate" :value="template.id" :key="template.id" :label="template.name">
        </el-option>
      </el-select>
      <el-input style="width: 200px;" class="filter-item" v-model="hdQuery.q" placeholder="请输入名称"
                @keyup.enter.native="doQuery">
      </el-input>
      <el-button class="filter-item" type="primary" icon="search" @click="doQuery">搜索</el-button>
      <el-button class="filter-item" style="margin-left: 10px;" icon="edit" type="primary" @click="doEdit('', 'add', tmpId)">添加
      </el-button>
    </div>
    <el-col :span="8">
      <el-tree :data="hdTree" :props="defaultProps" @node-click="handleHdTree"></el-tree>
    </el-col>
    <el-col :span="16">
      <el-table :data="hdResult.data" v-loading="listLoading" border fit highlight-current-row
                style="width: 100%;height:100%" :default-sort="{prop: 'updTimestamp',order: 'descending'}"
                @sort-change="hdQuery.doSort" sortable="custom">

        <el-table-column width="120px" align="center" label="名称" prop="name" sortable>
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.name}}</span>
          </template>
        </el-table-column>

        <el-table-column width="120px" align="center" label="描述" prop="description" sortable>
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.description}}</span>
          </template>
        </el-table-column>

        <el-table-column width="120px" align="center" label="最大数量" prop="times" sortable>
          <template slot-scope="scope">
            <span style='color:red;'>{{scope.row.times}}</span>
          </template>
        </el-table-column>


        <!--<el-table-column width="100px" align="center" label="创建人" prop="insAccount" sortable>
          <template slot-scope="scope">
            <span>{{scope.row.insAccount}}</span>
          </template>
        </el-table-column>

        <el-table-column width="170px" align="center" label="创建时间" prop="insTimestamp" sortable>
          <template slot-scope="scope">
            <span>{{scope.row.insTimestamp}}</span>
          </template>
        </el-table-column>

        <el-table-column width="100px" align="center" label="更新人" prop="updAccount" sortable>
          <template slot-scope="scope">
            <span>{{scope.row.updAccount}}</span>
          </template>
        </el-table-column>

        <el-table-column width="170px" align="center" label="更新时间" prop="updTimestamp" sortable>
          <template slot-scope="scope">
            <span>{{scope.row.updTimestamp}}</span>
          </template>
        </el-table-column>-->

        <el-table-column align="center" label="操作">
          <template slot-scope="scope">
            <el-button size="small" type="success" @click="doEdit(scope.row.id, 'update', tmpId)">编辑
            </el-button>
            <el-button size="small" type="danger" @click="doRemove(scope.row.id)">删除
            </el-button>
          </template>
        </el-table-column>

      </el-table>
      <div class="pagination-container">
        <el-pagination :current-page.sync="hdQuery.page" :page-size="hdQuery.rows"
                       :page-sizes="[10,20,30, 50]" @size-change="hdQuery.doSizeChg"
                       @current-change="hdQuery.doCurPageChange" layout="total, sizes, prev, pager, next, jumper"
                       :total="hdResult.recordsFiltered">
        </el-pagination>
      </div>
    </el-col>
    <editform ref="editform" @save-ok="doQuery"></editform>

  </div>
</template>

<script>
  import editform from './editform'
  import HdQuery from '@/utils/HdQuery'

  export default {
    components: {
      editform
    },
    data() {
      return {
        hdTree : [],
        defaultProps: {
          children: 'children',
          label: 'label'
        },
        hdResult: {},
        listLoading: true,
        visiable: false,
        hdQuery: new HdQuery(this),
        tmpId:'',
        hdtemplate : {}
      }
    },
    mounted() {
      this.$http.get('/edi/edi/tmp/list/2').then(response => {
        const data = response.data.result;
        this.hdtemplate = data;
      })
      this.doQuery()
    },
    methods: {
      doEdit(id, method, tmpId) {
        if(!tmpId) {
          this.$message({
            type: 'error',
            message:'请选择模板'
          });
          return;
        }
        this.$refs['editform'].show(id, method, tmpId)
      },
      doRemove(id) {
        this.$confirm('确定删除本数据?', '提示', {}).then(() => {
          this.listLoading = true
          this.$http.get('/edi/xml/column/delete?id=' + id).then(response => {
            const data = response.data
            this.listLoading = false
            this.$message({
              type: data.status ? 'success' : 'error',
              message: data.description
            })
            if (!data.status) {
              return
            }
            this.doQuery()
          })
        }).catch(() => {
        })

      },
      doQuery(tmpId) {
        this.tmpId = tmpId;
        this.doQuery();
      },
      doQuery() {
        this.listLoading = true;
        this.hdQuery.add("tmpId", this.tmpId);
        this.$http.post('/edi/xml/column/find', this.hdQuery).then(response => {
          const data = response.data == null ? {} : response.data.result;
          this.hdResult = data
          this.listLoading = false
        })
        this.$http.get('/edi/edi/column/tree/' + this.tmpId).then(response => {
          const data = response.data.result.children == null ? [] : response.data.result.children;
          this.hdTree = data
          this.listLoading = false
        })
      },
      handleHdTree() {}
    }

  }
</script>
