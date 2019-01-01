<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">

        
        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="用户id" prop="userId" :rules="$r(1,0,36)">
            <el-input type="text" v-model="formInfo.userId" placeholder="请输入用户id">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="取货人姓名" prop="pickerName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.pickerName" placeholder="请输入取货人姓名">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="取货人电话" prop="pickerPhone" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.pickerPhone" placeholder="请输入取货人电话">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="取货人地址" prop="pickerAddress" :rules="$r(1,0,200)">
            <el-input type="text" v-model="formInfo.pickerAddress" placeholder="请输入取货人地址">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="是否默认地址" prop="isDefault"
                        :rules="$r(1)">
            <el-switch
              v-model="formInfo.isDefault"
              active-value="true"
              inactive-value="false">
            </el-switch>
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
    name: 'useraddressform',
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
        this.$http.get('/iweb/useraddress/detail/' + id).then(response => {
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
        this.$http.post('/iweb/useraddress/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/useraddress/update', this.formInfo).then(response => {
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
