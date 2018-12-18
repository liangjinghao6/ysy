<template>

  <el-dialog title="注册" :visible.sync="visiable">
    <el-form label-width="100px" :model="hdform" ref="hdform" :rules="checkRules">
      <el-row>
        <el-col :span="24">
          <el-form-item label="姓名" prop="name">
            <el-input type="text" v-model="hdform.name" placeholder="请输入姓名">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="登录账号" prop="account">
            <el-input type="text" v-model="hdform.account" placeholder="请输入登录账号">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="密码" prop="passwordTemp">
            <el-input type="password" v-model="hdform.passwordTemp" placeholder="请输入密码">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="重复确认" prop="passwordTemp2">
            <el-input type="password" v-model="hdform.passwordTemp2" placeholder="请重复输入密码">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visiable = false">取 消</el-button>
      <el-button type="primary" @click="doRegist" :loading="loading"> 确 定</el-button>
    </div>
  </el-dialog>

</template>

<script>
  export default {
    name: 'registform',
    data() {

      const validateName = (rule, value, callback) => {
        if (!value || value.length < 1) {
          callback(new Error('姓名不能为空'))
        } else {
          callback()
        }
      }
      const validateAccount = (rule, value, callback) => {
        if (!value || value.length < 3) {
          callback(new Error('账户长度不能少于3'))
        } else {
          callback()
        }
      }
      const validatePassword = (rule, value, callback) => {
        if (!value || value.length < 2) {
          callback(new Error('密码不能小于2位'))
        } else {
          callback()
        }
      }
      const validatePasswordSame = (rule, value, callback) => {
        if (this.hdform.passwordTemp != this.hdform.passwordTemp2) {
          callback(new Error('两次输入密码不一致'))
        } else {
          callback()
        }
      }
      return {
        hdform: {},
        visiable: false,
        tsLoading: false,
        loading: false,
        checkRules: {
          name: [{required: true, trigger: 'blur', validator: validateName}],
          account: [{required: true, trigger: 'blur', validator: validateAccount}],
          passwordTemp: [{required: true, trigger: 'blur', validator: validatePassword}],
          passwordTemp2: [{required: true, trigger: 'blur', validator: validatePasswordSame}]
        }
      }
    },
    methods:
      {
        show() {
          //弹窗重复使用时,清除校验项目
//        if (this.$refs['hdform'])
//          this.$refs['hdform'].resetFields()
          this.visiable = true
        },
        doRegist() {
          this.$refs['hdform'].validate((valid) => {
            if (!valid) {
              return false;
            }
            if (this.hdform.passwordTemp2 != this.hdform.passwordTemp) {
              this.$alert('两次密码输入不一致', '错误')
              return false
            }
            this.loading = true
            this.$http.post('/webresources/coderuser/registOne', this.hdform).then(response => {
              this.loading = false
              const data = response.data
              this.$message({
                type: data.code == '-1' ? 'error' : 'success',
                message: data.message
              })
              if (data.code == '-1') {
                return
              }
              this.visiable = false
            })
          })
        }
      }
  }
</script>

