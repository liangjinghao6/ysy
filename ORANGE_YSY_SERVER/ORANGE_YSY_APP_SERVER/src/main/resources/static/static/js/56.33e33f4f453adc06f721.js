webpackJsonp([56],{Aqmz:function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a={name:"goodsbrandform",data:function(){return{formInfo:{},visiable:!1,loading:!1,method:"add"}},methods:{show:function(t,e){var s=this;this.method=e,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=e&&this.$http.get("/iweb/goodsbrand/detail/"+t).then(function(t){var e=t.data.result;s.formInfo=e})},submit:function(){var t=this;this.$refs.formInfo.validate(function(e){if(!e)return!1;"add"==t.method?t.add():"update"==t.method&&t.update()})},add:function(){var t=this;this.loading=!0,this.$http.post("/iweb/goodsbrand/add",this.formInfo).then(function(e){t.loading=!1;var s=e.data;t.$message({type:s.status?"success":"error",message:s.message}),s.status&&(t.$emit("save-ok"),t.visiable=!1)},function(){t.loading=!1,t.$message({type:"error",message:"操作失败"})})},update:function(){var t=this;this.loading=!0,this.$http.post("/iweb/goodsbrand/update",this.formInfo).then(function(e){t.loading=!1;var s=e.data;t.$message({type:s.status?"success":"error",message:s.message}),s.status&&(t.$emit("save-ok"),t.visiable=!1)},function(){t.loading=!1,t.$message({type:"error",message:"操作失败"})})}}},o=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("el-dialog",{attrs:{title:"编辑",visible:t.visiable,width:"60%"},on:{"update:visible":function(e){t.visiable=e}}},[s("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:t.formInfo,inline:!0}},[s("el-row",{attrs:{justify:"space-around"}},[s("el-col",{attrs:{span:12}}),t._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"品牌名称",prop:"brandName",rules:t.$r(1,0,50)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入品牌名称"},model:{value:t.formInfo.brandName,callback:function(e){t.$set(t.formInfo,"brandName",e)},expression:"formInfo.brandName"}})],1)],1),t._v(" "),s("el-col",{attrs:{span:12}},[s("el-form-item",{attrs:{label:"品牌描述",prop:"description",rules:t.$r(1,0,255)}},[s("el-input",{attrs:{type:"text",placeholder:"请输入品牌描述"},model:{value:t.formInfo.description,callback:function(e){t.$set(t.formInfo,"description",e)},expression:"formInfo.description"}})],1)],1),t._v(" "),s("el-col",{attrs:{span:12}}),t._v(" "),s("el-col",{attrs:{span:12}}),t._v(" "),s("el-col",{attrs:{span:12}})],1)],1),t._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:function(e){t.visiable=!1}}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary",loading:t.loading},on:{click:t.submit}},[t._v(" 确 定")])],1)],1)},n=[],r={render:o,staticRenderFns:n},i=r,l=s("vSla"),d=l(a,i,!1,null,null,null);e.default=d.exports}});