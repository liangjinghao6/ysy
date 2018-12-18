<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="hdform" ref="hdform" :inline="true">
      <el-row justify="space-around">
        <el-col :span="12" >
          <el-form-item label="参数父级节点" prop="columnInParentId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.columnInParentId" placeholder="请选择类型">
              <el-option  v-for="column in hdColumnIn" :value="column.id" :key="column.id" :label="column.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="输出结果节点" prop="columnOutId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.columnOutId" placeholder="请选择类型">
              <el-option  v-for="column in hdColumnOut" :value="column.id" :key="column.id" :label="column.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row justify="space-around">
        <el-col :span="24" >
          <el-form-item label="请输入规则" prop="rule" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input style="width: 635px" type="textarea" :autosize="{ minRows: 10}" v-model="hdform.rule" placeholder="请输入规则">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visiable = false">取 消</el-button>
      <el-button type="primary" @click="submit" :loading="loading"> 确 定</el-button>
    </div>
  </el-dialog>

</template>

<script>
  import HdQuery from '@/utils/HdQuery'
  export default {
    name: 'editform',
    data() {
      return {
        hdform: {},
        visiable: false,
        loading: false,
        method: 'add',
        hdColumnIn : '',
        hdColumnOut : '',
        hdcolumn : '',
      }
    },
    methods: {
      show(id, method, tmpId) {
        this.method = method
        this.hdform.lnkTmpId = tmpId;
        this.$http.get('/edi/lnk/tmp/detail/' + tmpId).then(response => {
          const tmp = response.data.result;
          var query1 = new HdQuery(this);
          query1.add("tmpId", tmp.tmpInId);
          this.$http.post('/edi/edi/column/list', query1).then(response => {
            const data = response.data.result;
            this.hdColumnIn = data;
          });
          var query2 = new HdQuery(this);
          query2.add("tmpId", tmp.tmpOutId);
          this.$http.post('/edi/edi/column/list', query2).then(response => {
            const data = response.data.result;
            this.hdColumnOut = data;
          });
        });
        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true
        if (method == 'add') {
          return;
        }
        this.$http.get('/edi/lnk/column/detail/' + id).then(response => {
          const data = response.data.result
          this.hdform = data
        })

      },
      submit() {
        this.$refs['hdform'].validate((valid) => {
          if (!valid) {
            return false;
          }
          if (this.method == 'add') {
            this.add();
          } else if (this.method == 'update') {
            this.update();
          }
        })
      },
      add() {
        this.loading = true
        this.$http.post('/edi/lnk/column/add', this.hdform).then(response => {
          this.loading = false
          const data = response.data
          this.$message({
            type: data.status ? 'success' : 'error',
            message: data.description
          })
          if (!data.status) {
            return
          }
          this.$emit('save-ok')
          this.visiable = false
        }, () => {
          this.loading = false
          this.$message({
            type: 'error',
            message: "操作失败",
          })
        })
      },
      update() {
        this.loading = true
        this.$http.post('/edi/lnk/column/update', this.hdform).then(response => {
          this.loading = false
          const data = response.data
          this.$message({
            type: data.status ? 'success' : 'error',
            message: data.description
          })
          if (!data.status) {
            return
          }
          this.$emit('save-ok')
          this.visiable = false
        }, () => {
          this.loading = false
          this.$message({
            type: 'error',
            message: "操作失败",
          })
        })
      },

    }
  }
</script>
<!--<style scoped>-->
<!--.el-input {-->
<!--display: inline-block;-->
<!--height: 47px;-->
<!--width: 851%;-->
<!--}</style>-->

