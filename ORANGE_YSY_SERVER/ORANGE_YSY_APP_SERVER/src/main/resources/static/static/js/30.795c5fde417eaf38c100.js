webpackJsonp([30,48],{ZD7J:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={name:"lnkbackgoodsform",data:function(){return{formInfo:{},visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,t){var o=this;this.method=t,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=t&&this.$http.get("/iweb/lnkbackgoods/detail/"+e).then(function(e){var t=e.data.result;o.formInfo=t})},submit:function(){var e=this;this.$refs.formInfo.validate(function(t){if(!t)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/lnkbackgoods/add",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/lnkbackgoods/update",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})}}},n=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(t){e.visiable=t}}},[o("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[o("el-row",{attrs:{justify:"space-around"}},[o("el-col",{attrs:{span:12}}),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品id",prop:"goodsId",rules:e.$r(1,0,36)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入商品id"},model:{value:e.formInfo.goodsId,callback:function(t){e.$set(e.formInfo,"goodsId",t)},expression:"formInfo.goodsId"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品数量",prop:"goodsNum",rules:e.$r(1,0,1)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入商品数量"},model:{value:e.formInfo.goodsNum,callback:function(t){e.$set(e.formInfo,"goodsNum",t)},expression:"formInfo.goodsNum"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"退货单id",prop:"backId",rules:e.$r(1,0,36)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入退货单id"},model:{value:e.formInfo.backId,callback:function(t){e.$set(e.formInfo,"backId",t)},expression:"formInfo.backId"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}})],1)],1),e._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(t){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),o("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},s=[],i={render:n,staticRenderFns:s},r=i,l=o("vSla"),d=l(a,r,!1,null,null,null);t.default=d.exports},bMo7:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a=o("ZD7J"),n=o("69yh"),s={components:{lnkbackgoodsform:a.default},data:function(){return{pageBean:{},listLoading:!0,visiable:!1,queryInfo:new n.a(this)}},mounted:function(){this.queryInfo.query.q="",this.doQuery()},methods:{doEdit:function(e,t){this.$refs.lnkbackgoodsform.show(e,t)},doRemove:function(e){var t=this;this.$confirm("确定删除本数据?","提示",{}).then(function(){t.listLoading=!0,t.$http.get("/iweb/lnkbackgoods/delete?id="+e).then(function(e){var o=e.data;t.listLoading=!1,t.$message({type:o.status,message:o.description}),o.status&&t.doQuery()})})},doQuery:function(){var e=this;this.listLoading=!0,this.$http.get("/iweb/lnkbackgoods/find?q="+this.queryInfo.query.q+"&pageNum="+this.queryInfo.pageNum+"&pageSize="+this.queryInfo.pageSize).then(function(t){console.log(t.data.result);var o=t.data.result;e.pageBean=o,e.listLoading=!1})}}},i=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"app-container calendar-list-container"},[o("div",{staticClass:"filter-container"},[o("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"请输入姓名或账号"},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.doQuery(t)}},model:{value:e.queryInfo.query.q,callback:function(t){e.$set(e.queryInfo.query,"q",t)},expression:"queryInfo.query.q"}}),e._v(" "),o("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"search"},on:{click:e.doQuery}},[e._v("搜索")]),e._v(" "),o("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{icon:"edit",type:"primary"},on:{click:function(t){e.doEdit("","add")}}},[e._v("添加\n      ")])],1),e._v(" "),o("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%",height:"100%"},attrs:{data:e.pageBean.list,border:"",fit:"","highlight-current-row":"","default-sort":{prop:"updTimestamp",order:"descending"},sortable:"custom"},on:{"sort-change":e.queryInfo.doSort}},[o("el-col",{attrs:{span:12}}),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品id",prop:"goodsId"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.goodsId))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品数量",prop:"goodsNum"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.goodsNum))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"退货单id",prop:"backId"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.backId))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"250px",align:"center",label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.createTime))])]}}])})],1),e._v(" "),o("el-table-column",{attrs:{width:"150px",align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{size:"small",type:"success"},on:{click:function(o){e.doEdit(t.row.bgId,"update")}}},[e._v("编辑\n          ")]),e._v(" "),o("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(o){e.doRemove(t.row.bgId)}}},[e._v("删除\n          ")])]}}])})],1),e._v(" "),o("div",{staticClass:"pagination-container"},[o("el-pagination",{attrs:{"current-page":e.pageBean.pageNum,"page-size":e.queryInfo.pageSize,"page-sizes":[10,20,30,50],layout:"total, sizes, prev, pager, next, jumper",total:e.pageBean.totalRecords},on:{"update:currentPage":function(t){e.$set(e.pageBean,"pageNum",t)},"size-change":e.queryInfo.doSizeChg,"current-change":e.queryInfo.doCurPageChange}})],1),e._v(" "),o("lnkbackgoodsform",{ref:"lnkbackgoodsform",on:{"save-ok":e.doQuery}})],1)},r=[],l={render:i,staticRenderFns:r},d=l,u=o("vSla"),c=u(s,d,!1,null,null,null);t.default=c.exports}});