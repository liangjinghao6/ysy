<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="hdform" ref="hdform" :inline="true">
      <el-row justify="space-around">
        <el-col :span="12" v-if="method=='update' || method=='add'">
          <el-form-item label="姓名" prop="name" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.name" placeholder="请输入姓名">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="登录账号" prop="account" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input v-bind:readonly="method=='update' || method=='password'" type="text" v-model="hdform.account" placeholder="请输入账号">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="method=='password'">
          <el-form-item label="旧密码">
            <el-input type="password" v-model="hdform.oldpassword">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="method=='add'">
          <el-form-item label="密码">
            <el-input type="password" v-model="hdform.password">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" v-if="method=='password'">
          <el-form-item label="新密码">
            <el-input type="password" v-model="hdform.password">
            </el-input>
          </el-form-item>
        </el-col>
        <!-- <el-col :span="12">
           <el-form-item label="是否管理员">
             <el-switch v-model="hdform.isAdmin" active-value="1" inactive-value="0"></el-switch>
           </el-form-item>
         </el-col>-->
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
    name: 'userform',
    data() {
      return {
        hdform: {
          id:'',
          name: '',
          oldpassword:'',
          account: '',
          password: ''
        },
        visiable: false,
        loading: false,
        method: 'add'
      }
    },
    methods: {
      show(id, method) {
        this.method = method

        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true
        if (method == 'add') {
          return;
        }
        this.$http.get('/edi/user/detail/' + id).then(response => {
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
          } else if (this.method == 'password') {
            this.updatePassword();
          }
        })
      },
      add() {
        this.loading = true
        this.$http.post('/edi/user/add', this.hdform).then(response => {
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
        this.$http.post('/edi/user/update', this.hdform).then(response => {
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
      updatePassword() {
        var params = new URLSearchParams()
        params.append('id', this.hdform.id)
        params.append('oldpsw', this.hdform.oldpassword)
        params.append('newpsw', this.hdform.password)
        this.loading = true
        this.$http.post('/edi/user/pwd/update', params).then(response => {
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
      }
    }
  }
</script>
<!--<style scoped>-->
<!--.el-input {-->
<!--display: inline-block;-->
<!--height: 47px;-->
<!--width: 851%;-->
<!--}</style>-->

