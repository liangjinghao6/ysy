<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form label-width="100px" :model="hdform" ref="hdform">
      <el-row>
        <el-col :span="12">
          <el-form-item label="数据源名称" prop="srcName" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.srcName" placeholder="请输入名称">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="数据库地址" prop="dbUrl" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.dbUrl" placeholder="请输入地址">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数据库账号">
            <el-input type="text" v-model="hdform.dbAccount" placeholder="请输入账号">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数据库密码">
            <el-input type="password" v-model="hdform.dbPassword" placeholder="请输入密码">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="test" type="primary" :loading="tsLoading"> 连接测试</el-button>
      <el-button @click="visiable = false">取 消</el-button>
      <el-button type="primary" @click="submit" :loading="loading"> 确 定</el-button>
    </div>
  </el-dialog>

</template>

<script>
  export default {
    name: 'datasrcform',
    data() {
      return {
        hdform: {},
        visiable: false,
        tsLoading: false,
        loading: false

      }
    },
    methods: {
      show(srcId) {
        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true
        this.$http.get('/webresources/codersrc/findOne?srcId=' + srcId).then(response => {
          const data = response.data
          this.hdform = data
        })
      },
      test() {//测试db
        this.tsLoading = true
        this.$http.post('/webresources/codersrc/testConnection', this.hdform).then(response => {
          this.tsLoading = false
          const data = response.data
          this.$message({
            type: data.code == '-1' ? 'error' : 'success',
            message: data.message
          })
        })
      },
      submit() {
        // console.debug(this.hdform)
        this.$refs['hdform'].validate((valid) => {
          if (!valid) {
            return false;
          }
          this.loading = true
          this.$http.post('/webresources/codersrc/saveOne', this.hdform).then(response => {
            this.loading = false
            const data = response.data
            this.$message({
              type: data.code == '-1' ? 'error' : 'success',
              message: data.message
            })
            if (data.code == '-1') {
              return
            }
            this.$emit('save-ok')
            this.visiable = false
          })
        })
      }
    }
  }
</script>

