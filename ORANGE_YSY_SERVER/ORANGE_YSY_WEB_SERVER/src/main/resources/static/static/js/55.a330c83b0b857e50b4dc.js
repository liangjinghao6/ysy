webpackJsonp([55],{Picw:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={name:"goodscategoryform",data:function(){return{formInfo:{},visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,t){var o=this;this.method=t,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=t&&this.$http.get("/iweb/goodscategory/detail/"+e).then(function(e){var t=e.data.result;o.formInfo=t})},submit:function(){var e=this;this.$refs.formInfo.validate(function(t){if(!t)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goodscategory/add",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goodscategory/update",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},handleImageRemove:function(e,t){this.formInfo.categoryImg=null},handleImageSuccess:function(e,t,o){this.formInfo.categoryImg=t.response.result.fileName},handleIconRemove:function(e,t){this.formInfo.categoryIcon=null},handleIconSuccess:function(e,t,o){this.formInfo.categoryIcon=t.response.result.fileName}}},s=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(t){e.visiable=t}}},[o("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[o("el-row",{attrs:{justify:"space-around"}},[o("el-col",{attrs:{span:12}}),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"类别名称",prop:"categoryName",rules:e.$r(1,0,50)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入类别名称"},model:{value:e.formInfo.categoryName,callback:function(t){e.$set(e.formInfo,"categoryName",t)},expression:"formInfo.categoryName"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"类别描述",prop:"description",rules:e.$r(1,0,255)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入类别描述"},model:{value:e.formInfo.description,callback:function(t){e.$set(e.formInfo,"description",t)},expression:"formInfo.description"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"类别链接",prop:"categoryUrl",rules:e.$r(0,0,50)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入类别链接"},model:{value:e.formInfo.categoryUrl,callback:function(t){e.$set(e.formInfo,"categoryUrl",t)},expression:"formInfo.categoryUrl"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"类别图标",prop:"categoryIcon"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleIconRemove,"on-success":e.handleIconSuccess,"file-list":[{name:e.formInfo.categoryIcon,url:"/iweb/file/print/"+e.formInfo.categoryIcon}],limit:1}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"类别背景",prop:"categoryImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleImageRemove,"on-success":e.handleImageSuccess,"file-list":[{name:e.formInfo.categoryImg,url:"/iweb/file/print/"+e.formInfo.categoryImg}],limit:1}},[o("i",{staticClass:"el-icon-plus"})])],1)],1)],1)],1),e._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(t){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),o("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},r=[],n={render:s,staticRenderFns:r},l=n,i=o("vSla"),c=i(a,l,!1,null,null,null);t.default=c.exports}});