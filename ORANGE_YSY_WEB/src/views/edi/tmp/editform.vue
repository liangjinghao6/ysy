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
          <el-form-item label="类型" prop="typeId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.typeId" placeholder="请选择格式类型" >
              <el-option  v-for="type in hdtype" :value="type.id" :key="type.id" :label="type.name">
                {{type.name}}|{{type.description}}
              </el-option>
            </el-select>
            <!--<el-input type="text" v-model="hdform.type" placeholder="请输入账号">
            </el-input>-->
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="类型" prop="sourceId" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.sourceId" placeholder="请选择来源类型" clearable>
              <el-option  v-for="source in hdsource" :value="source.id" :key="source.id" :label="source.name">
                {{source.name}}|{{source.description}}
              </el-option>
            </el-select>
            <!--<el-input type="text" v-model="hdform.type" placeholder="请输入账号">
            </el-input>-->
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="所属单位" prop="path">
            <el-input type="text" v-model="hdform.company" maxlength="20" placeholder="请输入所属单位">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="分隔符" prop="path">
            <el-input type="text" v-model="hdform.delimit" maxlength="1" placeholder="请输入分隔符">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="换行符" prop="path">
            <el-input type="text" v-model="hdform.newline" maxlength="5" placeholder="请输入换行符">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="释义符" prop="path">
            <el-input type="text" v-model="hdform.transfer" maxlength="1" placeholder="请输入释义符">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" >
          <el-form-item label="备注" prop="path">
            <el-input type="text" maxlength="255" v-model="hdform.note" placeholder="请输入备注">
            </el-input>
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
        hdtype:{},
        hdsource:{},
      }
    },
    methods: {
      show(id, method) {
        this.method = method
        this.$http.get('/edi/edi/type/list').then(response => {
          const data = response.data.result;
          this.hdtype = data;
        })
        this.$http.get('/edi/edi/source/list').then(response => {
          const data = response.data.result;
          this.hdsource = data;
        })
        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true
        if (method == 'add') {
          return;
        }
        this.$http.get('/edi/edi/tmp/detail/' + id).then(response => {
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
        this.$http.post('/edi/edi/tmp/add', this.hdform).then(response => {
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
        this.$http.post('/edi/edi/tmp/update', this.hdform).then(response => {
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

