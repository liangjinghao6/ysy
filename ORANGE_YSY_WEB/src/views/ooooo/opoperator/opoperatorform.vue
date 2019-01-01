<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">

        
        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="管理员账户" prop="account" :rules="$r(1,0,20)">
            <el-input type="text" v-model="formInfo.account" placeholder="请输入管理员账户">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="管理员组织" prop="companyId" :rules="$r(0,0,36)">
            <el-input type="text" v-model="formInfo.companyId" placeholder="请输入管理员组织">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="管理员姓名" prop="name" :rules="$r(1,0,20)">
            <el-input type="text" v-model="formInfo.name" placeholder="请输入管理员姓名">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="管理员密码" prop="password" :rules="$r(1,0,32)">
            <el-input type="text" v-model="formInfo.password" placeholder="请输入管理员密码">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否锁定" prop="isLock"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isLock"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否停用" prop="isStop"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isStop"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否密码过期" prop="isPwdExpire"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isPwdExpire"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="密码有效时长" prop="pwdDuration" :rules="$r(0,0,1)">
            <el-input type="text" v-model="formInfo.pwdDuration" placeholder="请输入密码有效时长">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
             <el-form-item label="密码修改时间" prop="pwdTime" :rules="$r(1)">
            <el-date-picker
		      v-model="formInfo.pwdTime"
		      type="datetime"
		      placeholder="请输入密码修改时间"
		      value-format="yyyy-MM-dd HH:mm:ss">
		    </el-date-picker>
		</el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="登录是否改密" prop="isPwdChange"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isPwdChange"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="账号是否过期" prop="isAccountExpire"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isAccountExpire"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
             <el-form-item label="账号有效时间" prop="accountTime" :rules="$r(0)">
            <el-date-picker
		      v-model="formInfo.accountTime"
		      type="datetime"
		      placeholder="请输入账号有效时间"
		      value-format="yyyy-MM-dd HH:mm:ss">
		    </el-date-picker>
		</el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="皮肤" prop="skin" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.skin" placeholder="请输入皮肤">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="语言" prop="language" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.language" placeholder="请输入语言">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="token" prop="token" :rules="$r(0,0,36)">
            <el-input type="text" v-model="formInfo.token" placeholder="请输入token">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
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
    name: 'opoperatorform',
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
        this.$http.get('/iweb/opoperator/detail/' + id).then(response => {
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
        this.$http.post('/iweb/opoperator/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/opoperator/update', this.formInfo).then(response => {
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
