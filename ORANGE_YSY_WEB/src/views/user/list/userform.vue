<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">


        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="账号" prop="userName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.userName" placeholder="请输入账号">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="昵称" prop="nickName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.nickName" placeholder="请输入昵称">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否为会员" prop="isVip"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isVip"
              active-value="true"
              inactive-value="false">
            </el-switch>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="微信号" prop="wx" :rules="$r(0,0,50)">
            <el-input type="text" v-model="formInfo.wx" placeholder="请输入微信号">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="手机号" prop="phone" :rules="$r(0,0,20)">
            <el-input type="text" v-model="formInfo.phone" placeholder="请输入手机号">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="用户级别" prop="userLevel" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.userLevel" placeholder="请输入用户级别">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="邀请码" prop="inviteNo" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.inviteNo" placeholder="请输入邀请码">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="介绍人" prop="inviteId" :rules="$r(0,0,36)">
            <el-input type="text" v-model="formInfo.inviteId" placeholder="请输入介绍人">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="关联时间" prop="inviteTime" :rules="$r(0)">
            <el-date-picker
              v-model="formInfo.inviteTime"
              type="datetime"
              placeholder="请输入关联时间"
              value-format="yyyy-MM-dd HH:mm:ss">
            </el-date-picker>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="成会员时间" prop="vipTime" :rules="$r(0)">
            <el-date-picker
              v-model="formInfo.vipTime"
              type="datetime"
              placeholder="请输入成会员时间"
              value-format="yyyy-MM-dd HH:mm:ss">
            </el-date-picker>
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
        this.$http.get('/iweb/user/detail/' + id).then(response => {
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
        this.$http.post('/iweb/user/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/user/update', this.formInfo).then(response => {
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
