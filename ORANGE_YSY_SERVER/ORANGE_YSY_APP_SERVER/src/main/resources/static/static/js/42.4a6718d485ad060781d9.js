webpackJsonp([42],{"91aj":function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={name:"useraddressform",data:function(){return{formInfo:{},visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,t){var s=this;this.method=t,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=t&&this.$http.get("/iweb/useraddress/detail/"+e).then(function(e){var t=e.data.result;s.formInfo=t})},submit:function(){var e=this;this.$refs.formInfo.validate(function(t){if(!t)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/useraddress/add",this.formInfo).then(function(t){e.loading=!1;var s=t.data;e.$message({type:s.status?"success":"error",message:s.message}),s.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/useraddress/update",this.formInfo).then(function(t){e.loading=!1;var s=t.data;e.$message({type:s.status?"success":"error",message:s.message}),s.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})}}},r=function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(t){e.visiable=t}}},[s("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[s("el-row",{attrs:{justify:"space-around"}},[s("el-col",{attrs:{span:12}}),e._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"用户id",prop:"userId",rules:e.$r(1,0,36)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入用户id"},model:{value:e.formInfo.userId,callback:function(t){e.$set(e.formInfo,"userId",t)},expression:"formInfo.userId"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"取货人姓名",prop:"pickerName",rules:e.$r(1,0,50)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入取货人姓名"},model:{value:e.formInfo.pickerName,callback:function(t){e.$set(e.formInfo,"pickerName",t)},expression:"formInfo.pickerName"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"取货人电话",prop:"pickerPhone",rules:e.$r(1,0,50)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入取货人电话"},model:{value:e.formInfo.pickerPhone,callback:function(t){e.$set(e.formInfo,"pickerPhone",t)},expression:"formInfo.pickerPhone"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"取货人地址",prop:"pickerAddress",rules:e.$r(1,0,200)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入取货人地址"},model:{value:e.formInfo.pickerAddress,callback:function(t){e.$set(e.formInfo,"pickerAddress",t)},expression:"formInfo.pickerAddress"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"是否默认地址",prop:"isDefault",rules:e.$r(1)}},[s("el-switch",{attrs:{"active-value":"true","inactive-value":"false"},model:{value:e.formInfo.isDefault,callback:function(t){e.$set(e.formInfo,"isDefault",t)},expression:"formInfo.isDefault"}})],1)],1),e._v(" "),s("el-col",{attrs:{span:12}}),e._v(" "),s("el-col",{attrs:{span:12}}),e._v(" "),s("el-col",{attrs:{span:12}})],1)],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(t){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),s("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},o=[],l={render:r,staticRenderFns:o},i=l,n=s("vSla"),f=n(a,i,!1,null,null,null);t.default=f.exports}});