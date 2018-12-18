<template>
  <div>
    <el-dialog title="编辑" :visible.sync="visiable" :modal="false">
      <el-form :model="hdform" ref="hdform" label-width="80px">
        <el-row>
          <el-col :span="11">
            <el-form-item label="展示名:" prop="detailName"
                          :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
              <el-input placeholder="展示名(前缀自动拼实体名)" v-model="hdform.detailName">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="排序号:">
              <el-input placeholder="排序号:" v-model.number="hdform.sorter">
              </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="23">
            <el-form-item label="内容:">
              <el-input type="textarea" :rows="10" placeholder="freemarker内容:"
                        v-model="hdform.detailContent">
              </el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="visiable = false">取 消</el-button>
          <el-button type="primary" @click="doTest">测试</el-button>
          <el-button type="primary" @click="submit" v-if="canEdit">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog :modal="false"
               title="校验结果"
               :visible.sync="tsVisible"
               width="80%">
      <el-input type="textarea" :rows="16" placeholder="备注:"
                v-model="tsResult">
      </el-input>
    </el-dialog>
  </div>
</template>

<script>

  export default {
    name: 'coderdetailform',
    data() {
      return {
        hdform: {},
        visiable: false,
        tsVisible: false,
        tsResult: '',
        canEdit: true
      }
    },
    methods: {
      show(detailId, fileId, canEdit) {
        this.canEdit = canEdit
        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.visiable = true;
        this.$http.get('/webresources/coderfiledetail/findOne?detailId=' + detailId + "&fileId=" + fileId).then(response => {
          const data = response.data
          this.hdform = data;
        })
      },
      submit() {
        this.$http.post('/webresources/coderfiledetail/saveOne', this.hdform).then(response => {
          const data = response.data
          this.$message({
            type: data.code == '-1' ? 'error' : 'success',
            message: data.message
          })
          if (data.code == '-1') {
            return
          }
          this.$emit('save-ok');
          this.visiable = false;

        })
      },
      doTest() {
        this.tsVisible = true
        this.$http.post('/webresources/coderfiledetail/doTest', this.hdform).then(response => {
          const data = response.data
          if (data.code == '-1') {
            this.$alert(data.message, '错误');
            return;
          }
          this.tsResult = data
        })
      }

    }

  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";

</style>

