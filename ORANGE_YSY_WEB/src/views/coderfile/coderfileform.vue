<template>

  <el-dialog title="编辑" :visible.sync="visiable">
    <!--<div style="height: 300px;overflow:auto">-->

    <el-form :model="hdform" ref="hdform" label-width="80px">
      <el-row>
        <el-col :span="23">
          <el-form-item label="模板名:" prop="fileName" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-input placeholder="模板名" v-model="hdform.fileName">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="23">
          <el-form-item label="排序号:" prop="sorter" :rules="[{ type: 'number', message: '必须为数字'}]">
            <el-input placeholder="排序号:" v-model.number="hdform.sorter">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="23">
          <el-form-item label="是否共享:" v-if="$store.getters.isAdmin">
            <el-switch v-model="hdform.isShare" active-value="1" inactive-value="0"></el-switch>
          </el-form-item>
        </el-col>
        <el-col :span="23">

          <el-form-item label="备注:">
            <el-input type="textarea" :rows="6" placeholder="备注:"
                      v-model="hdform.remarkTxt">
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>
    <!--</div>-->
    <span slot="footer" class="dialog-footer">
          <el-button @click="visiable = false">取 消</el-button>
          <el-button type="primary" @click="submit" :loading='loading'>确 定</el-button>
      </span>
  </el-dialog>

</template>

<script>

  export default {
    name: 'coderfileform',
    data() {
      return {
        isAdmin: false,
        loading: false,
        hdform: {},
        visiable: false,
        showLs: [],
        dbType: [{
          value: '1',
          label: 'mysql'
        }, {
          value: '2',
          label: 'oracle'
        }],
      }
    },
    methods: {
      show(fileId) {
        this.visiable = true
        //弹窗重复使用时,清除校验项目
        if (this.$refs['hdform'])
          this.$refs['hdform'].resetFields()
        this.$http.get('/webresources/coderfile/findOne?fileId=' + fileId).then(response => {

          const data = response.data
          this.hdform = data;
        })
      },
      submit() {
        this.$refs['hdform'].validate((valid) => {
          if (!valid) {
            return false;
          }
          this.loading = true
          this.$http.post('/webresources/coderfile/saveOne', this.hdform).then(response => {
            this.loading = false
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
        });

      }

    }

  }
</script>


