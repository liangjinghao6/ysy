<template>
  <keep-alive>
    <el-row>
      <el-form label-width="100px" style="margin: 20px" :model="hdform" ref="hdform">

        <el-col :span="8">
          <el-form-item label="模板:" prop="genType" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select v-model="hdform.genType" placeholder="请选择" style="width: 100%">
              <el-option
                v-for="item in genTypeDrop"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="数据源:">
            <el-select placeholder="请选择" style="width: 100%" v-model="hdform.srcDb" @change="selDb">
              <el-option
                v-for="item in genSrcDrop"
                :key="item.srcId"
                :label="item.srcName"
                :value="item.srcId">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="包名">
            <el-input placeholder="包名" v-model="hdform.packageName">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="jdbcurl:" prop="jdbcurl">
            <el-input placeholder="jdbc:" v-model="hdform.jdbcurl"
                      :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="账号:">
            <el-input placeholder="账号" v-model="hdform.dbUser">
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="密码:">
            <el-input placeholder="密码" v-model="hdform.dbPassword" type='password'>
            </el-input>
          </el-form-item>
        </el-col>
        <el-col :span="8">

          <el-form-item label="表名:" prop="tabNameLs" :rules="[{ required: true, message: '此处不能为空',  trigger: 'blur' }]">
            <el-select style="width:100%"
                       v-model="hdform.tabNameLs"
                       multiple
                       filterable
                       remote
                       reserve-keyword
                       placeholder="请输入表名"
                       :remote-method="querySearch"
                       @focus="querySearch('')">
              <el-option
                v-for="item in genTabDrop"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>


            <!--<el-autocomplete v-model="hdform.tabName" :fetch-suggestions="querySearch"-->
            <!--placeholder="表名:" -->
            <!--&gt;</el-autocomplete>-->
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item>
            <el-button type="primary" @click="onSubmit" :loading="loading">立即生成</el-button>
          </el-form-item>
        </el-col>
      </el-form>
      <el-form style="margin: 20px">
        <el-col :span="24" v-for="myshow in showLs" :key="myshow.title">
          <el-form-item :label="myshow.title">
            <el-input type="textarea" :rows="12" placeholder="生成内容"
                      v-model="myshow.content">
            </el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>

  </keep-alive>
</template>

<script>
  var FileSaver = require('file-saver');
  export default {
    name: 'articleDetail',
    created() {
      this.doQuery()
    },
    data() {
      return {
        hdform: {
          jdbcurl: 'jdbc:mysql://xxxx:3306/tos?useUnicode=true&amp;characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull',
          dbUser: '',
          dbPassword: '',
          genType: '',
          entityName: '',
          tabNameLs: [],
          entity: '',
          packageName: 'net.huadong.idev'
        },
        loading: false,
        genTypeDrop: [],//模板
        genSrcDrop: [],//数据源
        genTabDrop: [],//表名
        showLs: [],
      }
    },

    methods: {
      onSubmit() {
        this.$refs['hdform'].validate((valid) => {
          if (!valid) {
            return false;
          }
          this.loading = true
          this.$http.post('/webresources/coder/genCoder', this.hdform).then(response => {
            this.loading = false
            const data = response.data
            if (data.code == '-1') {
              this.$alert(data.message, '错误');
              return;
            }
            this.showLs = data
          })
          this.$http.post('/webresources/coder/genCoderZip', this.hdform, {responseType: 'arraybuffer'}).then(response => {
            var blob = new Blob([response.data], {type: "text/plain;charset=utf-8"});
            FileSaver.saveAs(blob, "genCoder" + this.hdform.tabNameLs + ".zip");
          }).catch(error => {
            reject(error.toString())
          })
        })
      },
      doQuery() {
        this.$http.get('/webresources/coder/genFileDrop').then(response => {
          this.genTypeDrop = response.data;
        })
        this.$http.get('/webresources/coder/genSrcDrop').then(response => {
          this.genSrcDrop = response.data;
        })
      },
      selDb(srcId) {
        this.genSrcDrop.filter((item) => {
          if (item.srcId == srcId) {
            this.hdform.jdbcurl = item.dbUrl
            this.hdform.dbUser = item.dbAccount
            this.hdform.dbPassword = item.dbPassword

          }
        })
      },
      querySearch(queryString) {
        this.hdform.tabQuery = queryString
        this.$http.post('/webresources/coder/findTableName', this.hdform).then(response => {
          const data = response.data
          if (data.code == '-1') {
            return;//这里的错误不处理
          }
          this.genTabDrop = data
        })
      },

    }

  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  @import "src/styles/mixin.scss";

</style>

