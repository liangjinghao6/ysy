<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">


        <el-col :span="12">
          <el-form-item label="特征名称" prop="featureName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.featureName" placeholder="请输入特征名称">
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
  export default {
    name: 'goodsfeatureform',
    data() {
      return {
        formInfo: {},
        visiable: false,
        loading: false,
        method: 'add'
      }
    },
    methods: {
      show(id, method) {
        this.method = method

        //弹窗重复使用时,清除校验项目
        if (this.$refs['formInfo'])
          this.$refs['formInfo'].resetFields()
        this.visiable = true
        if (method == 'add') {
          return;
        }
        this.$http.get('/iweb/goodsfeature/detail/' + id).then(response => {
          const data = response.data.result
          this.formInfo = data
        })
      },
      submit() {
        this.$refs['formInfo'].validate((valid) => {
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
        this.$http.post('/iweb/goodsfeature/add', this.formInfo).then(response => {
          this.loading = false
          const data = response.data
          this.$message({
            type: data.status ? 'success' : 'error',
            message: data.message
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
        this.$http.post('/iweb/goodsfeature/update', this.formInfo).then(response => {
          this.loading = false
          const data = response.data
          this.$message({
            type: data.status ? 'success' : 'error',
            message: data.message
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
