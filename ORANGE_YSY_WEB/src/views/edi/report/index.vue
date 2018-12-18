<template>
  <div class="app-container calendar-list-container">
    <el-form class="small-space" label-width="120px" :model="hdform" ref="hdform" :inline="true">
      <el-row justify="space-around">
            <el-form-item label="转换模板" prop="lnkTemplateId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
              <el-select v-model="hdform.lnkTemplateId" placeholder="请选择类型" >
                <el-option  v-for="tempate in hdlnktemplate" :value="tempate.id" :key="tempate.id" :label="tempate.name">
                  {{tempate.name}}
                </el-option>
              </el-select>
            </el-form-item>
      </el-row>

      <el-row justify="space-around">
        <el-form-item label="文件" prop="description">
          <el-upload
            class="upload-demo"
            action="/edi/file/upload"
            :on-success="handleFile"
            :show-file-list="false"
            :multiple = "false">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">{{fileMessage}}</div>
          </el-upload>
        </el-form-item>
      </el-row>
    </el-form>

    <el-button class="filter-item" type="primary" @click="reverse">重置</el-button>
    <el-button class="filter-item" type="primary" @click="submit">确定</el-button>
    <el-button class="filter-item" type="primary" @click="download">下载</el-button>
  </div>
</template>

<script>


  export default {
    data() {
      return {
        file: {},
        hdlnktemplate: {},
        hdform: {},
        visiable: false,
        loading: false,
        hdtemplatein: {},
        hdtemplateout: {},
        fileMessage: "只能上传jpg/png文件，且不超过500kb",
        doResult : "",
      };
    },
    mounted() {
      this.init()
    },
    methods: {
      init() {
        this.$http.get('/edi/lnk/tmp/list').then(response => {
          const data = response.data.result;
          this.hdlnktemplate = data;
        })
      },
      handleFile(response, file, fileList) {
        this.fileMessage = "文件" + file.name + "上传成功";
        this.hdform.fileId = response.result;
      },
      reverse() {
        this.hdform = {};
      },
      show(id, method) {
        this.method = method

        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true
        if (method == 'add') {
          return;
        }
      },
      submit() {
        this.$refs['hdform'].validate((valid) => {
          if (!valid) {
            return false;
          }
          this.loading = true
          var param = new URLSearchParams();
          param.set("lnkTemplateId", this.hdform.lnkTemplateId);
          param.set("fileId", this.hdform.fileId);
          this.$http.post('/edi/edi/service/do', param).then(response => {
            this.loading = false
            const data = response.data
            this.$message({
              type: data.status ? 'success' : 'error',
              message: data.description
            })
            if (!data.status) {
              return
            }
            this.$emit('save-ok');
            this.doResult = data.result;
            this.visiable = false;
          }, () => {
            this.loading = false;
            this.$message({
              type: 'error',
              message: "操作失败",
            })
          })
        })
      },
      download(){
          location.href = "/edi/edi/service/download/"+this.doResult;
      }
    }

  }
</script>
