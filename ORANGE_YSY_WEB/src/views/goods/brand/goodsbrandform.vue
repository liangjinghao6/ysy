<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">


        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="品牌名称" prop="brandName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.brandName" placeholder="请输入品牌名称">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="品牌描述" prop="description" :rules="$r(1,0,255)">
            <el-input type="text" v-model="formInfo.description" placeholder="请输入品牌描述">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="品牌链接" prop="brandUrl" :rules="$r(0,0,50)">
            <el-input type="text" v-model="formInfo.brandUrl" placeholder="请输入品牌链接">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="品牌图标" prop="brandIcon">
            <el-upload

              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleIconRemove"
              :on-success="handleIconSuccess"
              :file-list=" [{name: formInfo.brandIcon, url: '/iweb/file/print/' + formInfo.brandIcon}]"
              :limit="1">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="品牌背景" prop="brandImg">
            <el-upload

              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleImageRemove"
              :on-success="handleImageSuccess"
              :file-list=" [{name: formInfo.brandImg, url: '/iweb/file/print/' + formInfo.brandImg}]"
              :limit="1">
              <i class="el-icon-plus"></i>
            </el-upload>
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
    name: 'goodsbrandform',
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
        this.$http.get('/iweb/goodsbrand/detail/' + id).then(response => {
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
        this.$http.post('/iweb/goodsbrand/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/goodsbrand/update', this.formInfo).then(response => {
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
      handleImageRemove(file, fileList) {
        this.formInfo.brandImg=null;
      },
      handleImageSuccess(respones,file,fileList){
        this.formInfo.brandImg = file.response.result.fileName;
      },
      handleIconRemove(file, fileList) {
        this.formInfo.brandIcon=null;
      },
      handleIconSuccess(respones,file,fileList){
        this.formInfo.brandIcon = file.response.result.fileName;
      },
    }
  }
</script>
