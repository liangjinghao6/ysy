webpackJsonp([24,42],{"91aj":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s={name:"useraddressform",data:function(){return{formInfo:{},visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,t){var a=this;this.method=t,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=t&&this.$http.get("/iweb/useraddress/detail/"+e).then(function(e){var t=e.data.result;a.formInfo=t})},submit:function(){var e=this;this.$refs.formInfo.validate(function(t){if(!t)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/useraddress/add",this.formInfo).then(function(t){e.loading=!1;var a=t.data;e.$message({type:a.status?"success":"error",message:a.message}),a.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/useraddress/update",this.formInfo).then(function(t){e.loading=!1;var a=t.data;e.$message({type:a.status?"success":"error",message:a.message}),a.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})}}},r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(t){e.visiable=t}}},[a("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[a("el-row",{attrs:{justify:"space-around"}},[a("el-col",{attrs:{span:12}}),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"用户id",prop:"userId",rules:e.$r(1,0,36)}},[a("el-input",{attrs:{type:"text",placeholder:"请输入用户id"},model:{value:e.formInfo.userId,callback:function(t){e.$set(e.formInfo,"userId",t)},expression:"formInfo.userId"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"取货人姓名",prop:"pickerName",rules:e.$r(1,0,50)}},[a("el-input",{attrs:{type:"text",placeholder:"请输入取货人姓名"},model:{value:e.formInfo.pickerName,callback:function(t){e.$set(e.formInfo,"pickerName",t)},expression:"formInfo.pickerName"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"取货人电话",prop:"pickerPhone",rules:e.$r(1,0,50)}},[a("el-input",{attrs:{type:"text",placeholder:"请输入取货人电话"},model:{value:e.formInfo.pickerPhone,callback:function(t){e.$set(e.formInfo,"pickerPhone",t)},expression:"formInfo.pickerPhone"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"取货人地址",prop:"pickerAddress",rules:e.$r(1,0,200)}},[a("el-input",{attrs:{type:"text",placeholder:"请输入取货人地址"},model:{value:e.formInfo.pickerAddress,callback:function(t){e.$set(e.formInfo,"pickerAddress",t)},expression:"formInfo.pickerAddress"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-form-item",{attrs:{label:"是否默认地址",prop:"isDefault",rules:e.$r(1)}},[a("el-switch",{attrs:{"active-value":"true","inactive-value":"false"},model:{value:e.formInfo.isDefault,callback:function(t){e.$set(e.formInfo,"isDefault",t)},expression:"formInfo.isDefault"}})],1)],1),e._v(" "),a("el-col",{attrs:{span:12}}),e._v(" "),a("el-col",{attrs:{span:12}}),e._v(" "),a("el-col",{attrs:{span:12}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),a("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},n=[],o={render:r,staticRenderFns:n},l=o,i=a("vSla"),u=i(s,l,!1,null,null,null);t.default=u.exports},cWOm:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("91aj"),r=a("69yh"),n={components:{useraddressform:s.default},data:function(){return{pageBean:{},listLoading:!0,visiable:!1,queryInfo:new r.a(this)}},mounted:function(){this.queryInfo.query.q="",this.doQuery()},methods:{doEdit:function(e,t){this.$refs.useraddressform.show(e,t)},doRemove:function(e){var t=this;this.$confirm("确定删除本数据?","提示",{}).then(function(){t.listLoading=!0,t.$http.get("/iweb/useraddress/delete?id="+e).then(function(e){var a=e.data;t.listLoading=!1,t.$message({type:a.status,message:a.description}),a.status&&t.doQuery()})})},doQuery:function(){var e=this;this.listLoading=!0,this.$http.get("/iweb/useraddress/find?q="+this.queryInfo.query.q+"&pageNum="+this.queryInfo.pageNum+"&pageSize="+this.queryInfo.pageSize).then(function(t){console.log(t.data.result);var a=t.data.result;e.pageBean=a,e.listLoading=!1})}}},o=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"app-container calendar-list-container"},[a("div",{staticClass:"filter-container"},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"请输入姓名或账号"},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.doQuery(t)}},model:{value:e.queryInfo.query.q,callback:function(t){e.$set(e.queryInfo.query,"q",t)},expression:"queryInfo.query.q"}}),e._v(" "),a("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"search"},on:{click:e.doQuery}},[e._v("搜索")]),e._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{icon:"edit",type:"primary"},on:{click:function(t){e.doEdit("","add")}}},[e._v("添加\n      ")])],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%",height:"100%"},attrs:{data:e.pageBean.list,border:"",fit:"","highlight-current-row":"","default-sort":{prop:"updTimestamp",order:"descending"},sortable:"custom"},on:{"sort-change":e.queryInfo.doSort}},[a("el-col",{attrs:{span:12}}),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"150px",align:"center",label:"用户id",prop:"userId"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.userId))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"150px",align:"center",label:"取货人姓名",prop:"pickerName"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.pickerName))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"150px",align:"center",label:"取货人电话",prop:"pickerPhone"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.pickerPhone))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"150px",align:"center",label:"取货人地址",prop:"pickerAddress"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.pickerAddress))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"100px",align:"center",label:"是否默认地址",prop:"isDefault"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s("0"==t.row.isDefault?"×":"√"))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"250px",align:"center",label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.createTime))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}},[a("el-table-column",{attrs:{width:"250px",align:"center",label:"修改时间",prop:"updateTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("span",[e._v(e._s(t.row.updateTime))])]}}])})],1),e._v(" "),a("el-col",{attrs:{span:12}}),e._v(" "),a("el-table-column",{attrs:{width:"150px",align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small",type:"success"},on:{click:function(a){e.doEdit(t.row.addressId,"update")}}},[e._v("编辑\n          ")]),e._v(" "),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){e.doRemove(t.row.addressId)}}},[e._v("删除\n          ")])]}}])})],1),e._v(" "),a("div",{staticClass:"pagination-container"},[a("el-pagination",{attrs:{"current-page":e.pageBean.pageNum,"page-size":e.queryInfo.pageSize,"page-sizes":[10,20,30,50],layout:"total, sizes, prev, pager, next, jumper",total:e.pageBean.totalRecords},on:{"update:currentPage":function(t){e.$set(e.pageBean,"pageNum",t)},"size-change":e.queryInfo.doSizeChg,"current-change":e.queryInfo.doCurPageChange}})],1),e._v(" "),a("useraddressform",{ref:"useraddressform",on:{"save-ok":e.doQuery}})],1)},l=[],i={render:o,staticRenderFns:l},u=i,d=a("vSla"),c=d(n,u,!1,null,null,null);t.default=c.exports}});