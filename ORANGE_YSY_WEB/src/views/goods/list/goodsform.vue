<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">


        <el-col :span="12">
          <el-form-item label="商品名称" prop="goodsName" :rules="$r(1,0,50)">
            <el-input type="text" v-model="formInfo.goodsName" placeholder="请输入商品名称">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品分类" prop="categoryId" :rules="$r(1,0,36)">
            <goodscategorysel v-model="formInfo.categoryId" :impValue="formInfo.categoryId" placeholder="请输入商品分类"></goodscategorysel>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品品牌" prop="brandId" :rules="$r(1,0,36)">
            <goodsbrandsel v-model="formInfo.brandId" :impValue="formInfo.brandId" placeholder="请输入商品品牌"></goodsbrandsel>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品特征" prop="classIds" >
            <mgoodsclasssel v-model="formInfo.classIds" :impValue="formInfo.classIds" placeholder="请输入商品特征"></mgoodsclasssel>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品价格" prop="goodsPrice" :rules="$r(1,0,999999,'number')">
            <el-input-number type="text" v-model="formInfo.goodsPrice" placeholder="请输入商品价格">
            </el-input-number>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品图片" prop="goodsImg">
            <el-upload

              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleImageRemove"
              :on-success="handleImageSuccess"
              :file-list=" [{name: formInfo.brandIcon, url: '/iweb/file/print/' + formInfo.goodsImg}]"
              :limit="1">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品库存" prop="inventory" :rules="$r(1,0,999999,'number')">
            <el-input-number type="text" v-model="formInfo.inventory" placeholder="请输入商品库存">
            </el-input-number>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品其他" prop="goodsOther" :rules="$r(0,0,255)">
            <el-input type="text" v-model="formInfo.goodsOther" placeholder="请输入商品其他">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="商品描述" prop="description" :rules="$r(1,0,255)">
            <el-input type="text" v-model="formInfo.description" placeholder="请输入商品描述">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="缩略图" prop="simpleImage">
            <el-upload
              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleSimpleImageRemove"
              :on-success="handleSimpleImageSuccess"
              :file-list="simpleImageList">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="轮播图" prop="wheelImage">
            <el-upload
              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleWheelImageRemove"
              :on-success="handleWheelImageSuccess"
              :file-list="wheelImageList">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="展示详情图" prop="detailsImage">
            <el-upload
              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleDetailsImageRemove"
              :on-success="handleDetailsImageSuccess"
              :file-list="detailsImageList">
              <i class="el-icon-plus"></i>
            </el-upload>
          </el-form-item>
        </el-col>

        <el-col :span="24">
          <el-form-item label="推广图" prop="extensionImage">
            <el-upload
              action="/iweb/file/upload"
              list-type="picture-card"
              :on-remove="handleExtensionImageRemove"
              :on-success="handleExtensionImageSuccess"
              :file-list="extensionImageList">
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

    <!--<el-dialog :visible.sync="dialogVisible">-->
      <!--<img width="100%" :src="dialogImageUrl" alt="">-->
    <!--</el-dialog>-->
  </el-dialog>

</template>

<script>
  import goodscategorysel from '@/views/comsel/goodscategorysel'
  import goodsbrandsel from '@/views/comsel/goodsbrandsel'
  import mgoodsclasssel from '@/views/comsel/mgoodsclasssel'
  export default {
    name: 'goodsform',
    components: {
      goodscategorysel,goodsbrandsel,mgoodsclasssel
    },
    data() {
      return {
        formInfo: {
          simpleImage: [],
          wheelImage: [],
          detailsImage: [],
          extensionImage: [],
          classIds: [],
        },
        simpleImageList: [],
        wheelImageList: [],
        detailsImageList: [],
        extensionImageList: [],
        visiable: false,
        loading: false,
        method: 'add',
        //dialogImageUrl: '',
        //dialogVisible: false
      }
    },
    mounted() {
      Array.prototype.indexOf = function(val) {
        for (var i = 0; i < this.length; i++) {
          if (this[i] == val) return i;
        }
        return -1;
      };
      Array.prototype.remove = function(val) {
        var index = this.indexOf(val);
        if (index > -1) {
          this.splice(index, 1);
        }
      };
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
        this.$http.get('/iweb/goods/detail/' + id).then(response => {
          const data = response.data.result
          this.simpleImageList = new Array();
          this.wheelImageList = new Array();
          this.detailsImageList = new Array();
          this.extensionImageList = new Array();
          for (let i=0; i<data.simpleImage.length; i++) {
            this.simpleImageList.push({name: data.simpleImage[i].orgName, url: '/iweb/file/print/' + data.simpleImage[i].name + data.simpleImage[i].suffix})
          }
          for (let i=0; i<data.wheelImage.length; i++) {
            this.wheelImageList.push({name: data.wheelImage[i].orgName, url: '/iweb/file/print/' + data.wheelImage[i].name + data.wheelImage[i].suffix})
          }
          for (let i=0; i<data.detailsImage.length; i++) {
            this.detailsImageList.push({name: data.detailsImage[i].orgName, url: '/iweb/file/print/' + data.detailsImage[i].name + data.detailsImage[i].suffix})
          }
          for (let i=0; i<data.extensionImage.length; i++) {
            this.extensionImageList.push({name: data.extensionImage[i].orgName, url: '/iweb/file/print/' + data.extensionImage[i].name + data.extensionImage[i].suffix})
          }

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
        this.$http.post('/iweb/goods/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/goods/update', this.formInfo).then(response => {
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
        this.formInfo.goodsImage=null;
      },
      // handlePictureCardPreview(file) {
      //   const filename = file.response.result.name + file.response.result.suffix;
      //
      //   this.dialogImageUrl = `/iweb/file/print/${filename}`;
      //   this.dialogVisible = true;
      // },
      handleImageSuccess(respones,file,fileList){
        this.formInfo.goodsImage = file.response.result;
      },
      handleSimpleImageRemove(file, fileList) {
        this.formInfo.simpleImage.removeObject(file.response.result);
      },
      handleSimpleImageSuccess(respones,file,fileList){
        this.formInfo.simpleImage.push(file.response.result);
      },
      handleDetailsImageRemove(file, fileList) {
        this.formInfo.detailsImage.removeObject(file.response.result);
      },
      handleDetailsImageSuccess(respones,file,fileList){
        this.formInfo.detailsImage.push(file.response.result);
      },
      handleWheelImageRemove(file, fileList) {
        this.formInfo.wheelImage.removeObject(file.response.result);
      },
      handleWheelImageSuccess(respones,file,fileList){
        this.formInfo.wheelImage.push(file.response.result);
      },
      handleExtensionImageRemove(file, fileList) {
        this.formInfo.extensionImage.removeObject(file.response.result);
      },
      handleExtensionImageSuccess(respones,file,fileList){
        this.formInfo.extensionImage.push(file.response.result);
      },
    }
  }
</script>
