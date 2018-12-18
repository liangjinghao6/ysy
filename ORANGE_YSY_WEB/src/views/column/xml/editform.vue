<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="hdform" ref="hdform" :inline="true">
      <el-row justify="space-around">
        <el-col :span="12" >
          <el-form-item label="名称" prop="name" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.name" placeholder="请输入名称">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="描述" prop="description" >
            <el-input type="text" v-model="hdform.description" placeholder="请输入描述">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="所属模板" prop="tmpId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.tmpId" placeholder="请选择类型" disabled="disabled">
              <el-option  v-for="template in hdtemplate" :value="template.id" :key="template.id" :label="template.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="所属父级" prop="parentId">
            <el-select v-model="hdform.parentId" placeholder="请选择类型" clearable>
              <el-option  v-for="column in hdcolumn" :value="column.id" :key="column.id" :label="column.name">
                {{column.name}}|{{column.description}}
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="数量" prop="times" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.times" placeholder="请输入数量">
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
  import HdQuery from "../../../utils/HdQuery";
  export default {

  name: 'editform',
    data() {
      return {
        hdform: {},
        visiable: false,
        loading: false,
        method: 'add',
        hdtemplate : '',
        hdcolumn : '',
      }
    },
    methods: {
      show(id, method, tmpId) {
        this.method = method
        this.$http.get('/edi/edi/tmp/list/2').then(response => {
          const data = response.data.result;
          this.hdtemplate = data;
        })
        var hdquery = new HdQuery(this);
        hdquery.add("tmpId", tmpId);
        this.$http.post('/edi/xml/column/list', hdquery).then(response => {
          const data = response.data.result;
          this.hdcolumn = data;
        })

        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.hdform.tmpId = tmpId;
        this.visiable = true
        if (method == 'add') {
          return;
        }
        this.$http.get('/edi/xml/column/detail/' + id).then(response => {
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
        this.$http.post('/edi/xml/column/add', this.hdform).then(response => {
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
        this.$http.post('/edi/xml/column/update', this.hdform).then(response => {
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

