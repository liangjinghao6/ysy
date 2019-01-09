<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">


        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="类别名称" prop="categoryName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.categoryName" placeholder="请输入类别名称">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="类别描述" prop="description" :rules="$r(1,0,255)">
            <el-input type="text" v-model="formInfo.description" placeholder="请输入类别描述">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="类别链接" prop="categoryUrl" :rules="$r(0,0,50)">
            <el-input type="text" v-model="formInfo.categoryUrl" placeholder="请输入类别链接">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="类别图标" prop="categoryIcon">
            <el-upload

              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleIconRemove"
              :on-success="handleIconSuccess"
              :file-list=" [{name: formInfo.categoryIcon, url: '/iweb/file/print/' + formInfo.categoryIcon}]"
              :limit="1">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="类别背景" prop="categoryImg">
            <el-upload

              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleImageRemove"
              :on-success="handleImageSuccess"
              :file-list=" [{name: formInfo.categoryImg, url: '/iweb/file/print/' + formInfo.categoryImg}]"
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
    name: 'goodscategoryform',
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
        this.$http.get('/iweb/goodscategory/detail/' + id).then(response => {
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
        this.$http.post('/iweb/goodscategory/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/goodscategory/update', this.formInfo).then(response => {
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
      },handleImageRemove(file, fileList) {
        this.formInfo.categoryImg=null;
      },
      handleImageSuccess(respones,file,fileList){
        this.formInfo.categoryImg = file.response.result.fileName;
      },
      handleIconRemove(file, fileList) {
        this.formInfo.categoryIcon=null;
      },
      handleIconSuccess(respones,file,fileList){
        this.formInfo.categoryIcon = file.response.result.fileName;
      },
    }
  }
</script>
