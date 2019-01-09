webpackJsonp([52],{"346i":function(e,s,t){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var o=t("q15z"),a=t("4JCT"),l=t("syRb"),i={name:"goodsform",components:{goodscategorysel:o.default,goodsbrandsel:a.default,mgoodsclasssel:l.default},data:function(){return{formInfo:{simpleImage:[],wheelImage:[],detailsImage:[],extensionImage:[],classes:[]},simpleImageList:[],wheelImageList:[],detailsImageList:[],extensionImageList:[],visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,s){var t=this;this.method=s,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=s&&this.$http.get("/iweb/goods/detail/"+e).then(function(e){var s=e.data.result;t.simpleImageList=new Array,t.wheelImageList=new Array,t.detailsImageList=new Array,t.extensionImageList=new Array;for(var o=0;o<s.simpleImage.length;o++)t.simpleImageList.push({name:s.simpleImage[o].orgName,url:"/iweb/file/print/"+s.simpleImage[o].name+s.simpleImage[o].suffix});for(var a=0;a<s.wheelImage.length;a++)t.wheelImageList.push({name:s.wheelImage[a].orgName,url:"/iweb/file/print/"+s.wheelImage[a].name+s.wheelImage[a].suffix});for(var l=0;l<s.detailsImage.length;l++)t.detailsImageList.push({name:s.detailsImage[l].orgName,url:"/iweb/file/print/"+s.detailsImage[l].name+s.detailsImage[l].suffix});for(var i=0;i<s.extensionImage.length;i++)t.extensionImageList.push({name:s.extensionImage[i].orgName,url:"/iweb/file/print/"+s.extensionImage[i].name+s.extensionImage[i].suffix});t.formInfo=s})},submit:function(){var e=this;this.$refs.formInfo.validate(function(s){if(!s)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goods/add",this.formInfo).then(function(s){e.loading=!1;var t=s.data;e.$message({type:t.status?"success":"error",message:t.message}),t.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goods/update",this.formInfo).then(function(s){e.loading=!1;var t=s.data;e.$message({type:t.status?"success":"error",message:t.message}),t.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},handleImageRemove:function(e,s){this.formInfo.goodsImage=null},handleImageSuccess:function(e,s,t){this.formInfo.goodsImage=s.response.result.fileId},handleSimpleImageRemove:function(e,s){this.formInfo.simpleImage.unshift(e.response.result.fileId)},handleSimpleImageSuccess:function(e,s,t){this.formInfo.simpleImage.push(s.response.result.fileId)},handleDetailsImageRemove:function(e,s){this.formInfo.detailsImage.unshift(e.response.result.fileId)},handleDetailsImageSuccess:function(e,s,t){this.formInfo.detailsImage.push(s.response.result.fileId)},handleWheelImageRemove:function(e,s){this.formInfo.wheelImage.unshift(e.response.result.fileId)},handleWheelImageSuccess:function(e,s,t){this.formInfo.wheelImage.push(s.response.result.fileId)},handleExtensionImageRemove:function(e,s){this.formInfo.extensionImage.unshift(e.response.result.fileId)},handleExtensionImageSuccess:function(e,s,t){this.formInfo.extensionImage.push(s.response.result.fileId)}}},n=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(s){e.visiable=s}}},[t("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[t("el-row",{attrs:{justify:"space-around"}},[t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品名称",prop:"goodsName",rules:e.$r(1,0,50)}},[t("el-input",{attrs:{type:"text",placeholder:"请输入商品名称"},model:{value:e.formInfo.goodsName,callback:function(s){e.$set(e.formInfo,"goodsName",s)},expression:"formInfo.goodsName"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品分类",prop:"categoryId",rules:e.$r(1,0,36)}},[t("goodscategorysel",{attrs:{impValue:e.formInfo.categoryId,placeholder:"请输入商品分类"},model:{value:e.formInfo.categoryId,callback:function(s){e.$set(e.formInfo,"categoryId",s)},expression:"formInfo.categoryId"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品品牌",prop:"brandId",rules:e.$r(1,0,36)}},[t("goodsbrandsel",{attrs:{impValue:e.formInfo.brandId,placeholder:"请输入商品品牌"},model:{value:e.formInfo.brandId,callback:function(s){e.$set(e.formInfo,"brandId",s)},expression:"formInfo.brandId"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品特征",prop:"classes"}},[t("mgoodsclasssel",{attrs:{impValue:e.formInfo.classes,placeholder:"请输入商品特征"},model:{value:e.formInfo.classes,callback:function(s){e.$set(e.formInfo,"classes",s)},expression:"formInfo.classes"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品价格",prop:"goodsPrice",rules:e.$r(1,0,999999,"number")}},[t("el-input-number",{attrs:{type:"text",placeholder:"请输入商品价格"},model:{value:e.formInfo.goodsPrice,callback:function(s){e.$set(e.formInfo,"goodsPrice",s)},expression:"formInfo.goodsPrice"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品图片",prop:"goodsImg"}},[t("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleImageRemove,"on-success":e.handleImageSuccess,"file-list":[{name:e.formInfo.brandIcon,url:"/iweb/file/print/"+e.formInfo.goodsImg}],limit:1}},[t("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品库存",prop:"inventory",rules:e.$r(1,0,999999,"number")}},[t("el-input-number",{attrs:{type:"text",placeholder:"请输入商品库存"},model:{value:e.formInfo.inventory,callback:function(s){e.$set(e.formInfo,"inventory",s)},expression:"formInfo.inventory"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:12}},[t("el-form-item",{attrs:{label:"商品其他",prop:"goodsOther",rules:e.$r(0,0,255)}},[t("el-input",{attrs:{type:"text",placeholder:"请输入商品其他"},model:{value:e.formInfo.goodsOther,callback:function(s){e.$set(e.formInfo,"goodsOther",s)},expression:"formInfo.goodsOther"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"商品描述",prop:"description",rules:e.$r(1,0,255)}},[t("el-input",{attrs:{type:"text",placeholder:"请输入商品描述"},model:{value:e.formInfo.description,callback:function(s){e.$set(e.formInfo,"description",s)},expression:"formInfo.description"}})],1)],1),e._v(" "),t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"缩略图",prop:"simpleImage"}},[t("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleSimpleImageRemove,"on-success":e.handleSimpleImageSuccess,"file-list":e.simpleImageList}},[t("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"轮播图",prop:"wheelImage"}},[t("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleWheelImageRemove,"on-success":e.handleWheelImageSuccess,"file-list":e.wheelImageList}},[t("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"展示详情图",prop:"detailsImage"}},[t("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleDetailsImageRemove,"on-success":e.handleDetailsImageSuccess,"file-list":e.detailsImageList}},[t("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),t("el-col",{attrs:{span:24}},[t("el-form-item",{attrs:{label:"推广图",prop:"extensionImage"}},[t("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleExtensionImageRemove,"on-success":e.handleExtensionImageSuccess,"file-list":e.extensionImageList}},[t("i",{staticClass:"el-icon-plus"})])],1)],1)],1)],1),e._v(" "),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(s){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),t("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},r=[],m={render:n,staticRenderFns:r},f=m,d=t("vSla"),c=d(i,f,!1,null,null,null);s.default=c.exports}});