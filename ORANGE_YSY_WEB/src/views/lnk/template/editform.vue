<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="hdform" ref="hdform" :inline="true">
      <el-row justify="space-around">
        <el-col :span="12" >
          <el-form-item label="名称" prop="name" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input type="text" v-model="hdform.name" maxlength="20" placeholder="请输入姓名">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="所属单位" prop="path">
            <el-input type="text" v-model="hdform.company" maxlength="20" placeholder="请输入所属单位">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row justify="space-around">
        <el-col :span="12" >
          <el-form-item label="文件来源路径" prop="inPath">
            <el-input type="text" v-model="hdform.inPath" maxlength="200" placeholder="请输入文件路径">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="文件导出路径" prop="outPath">
            <el-input type="text" v-model="hdform.outPath" maxlength="200" placeholder="请输入文件路径">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row justify="space-around">
        <el-col :span="12">
          <el-form-item label="导入类型" prop="typeInId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.typeInId" placeholder="请选择类型" @change="changeInType(hdform.typeInId)">
              <el-option  v-for="type in hdtype" :value="type.id" :key="type.id" :label="type.name">
                {{type.name}}|{{type.description}}
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="导入模板" prop="tmpInId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.tmpInId" placeholder="请选择类型">
              <el-option  v-for="template in hdtemplatein" :value="template.id" :key="template.id" :label="template.name">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row justify="space-around">
        <el-col :span="12">
          <el-form-item label="导出类型" prop="typeOutId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.typeOutId" placeholder="请选择类型" @change="changeOutType(hdform.typeOutId)">
              <el-option  v-for="type in hdtype" :value="type.id" :key="type.id" :label="type.name"  >
                {{type.name}}|{{type.description}}
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="导入模板" prop="tmpOutId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.tmpOutId" placeholder="请选择类型">
              <el-option  v-for="template in hdtemplateout" :value="template.id" :key="template.id" :label="template.name">
              </el-option>
            </el-select>
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
    name: 'editform',
    data() {
      return {
        hdform: {},
        visiable: false,
        loading: false,
        method: 'add',
        hdtype:'',
      }
    },
    mounted() {
      this.init()
    },
    methods: {
      init() {
        this.$http.get('/edi/edi/type/list').then(response => {
          const data = response.data.result;
          this.hdtype = data;
        })
      },
      handleFile(response, file, fileList) {
        this.fileMessage = "文件" + file.name + "上传成功";
        this.hdform.fileId = response.result;
      },
      changeInType(id) {
        this.$http.get('/edi/edi/tmp/list/' + id).then(response => {
          const data = response.data.result;
          this.hdtemplatein = data;
        })
      },
      changeOutType(id) {
        this.$http.get('/edi/edi/tmp/list/' + id).then(response => {
          const data = response.data.result;
          this.hdtemplateout = data;
        })
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
        this.$http.get('/edi/lnk/tmp/detail/' + id).then(response => {
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
          }
        })
      },
      add() {
        this.loading = true
        this.$http.post('/edi/lnk/tmp/add', this.hdform).then(response => {
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
        this.$http.post('/edi/lnk/tmp/update', this.hdform).then(response => {
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

    }
  }
</script>
<!--<style scoped>-->
<!--.el-input {-->
<!--display: inline-block;-->
<!--height: 47px;-->
<!--width: 851%;-->
<!--}</style>-->

