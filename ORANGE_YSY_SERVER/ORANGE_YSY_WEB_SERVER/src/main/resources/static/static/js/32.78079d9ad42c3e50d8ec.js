webpackJsonp([32,52],{"+vt4":function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=o("346i"),a=o("69yh"),n={components:{goodsform:s.default},data:function(){return{pageBean:{},listLoading:!0,visiable:!1,queryInfo:new a.a(this)}},mounted:function(){this.queryInfo.query.q="",this.doQuery()},methods:{doEdit:function(e,t){this.$refs.goodsform.show(e,t)},doRemove:function(e){var t=this;this.$confirm("确定删除本数据?","提示",{}).then(function(){t.listLoading=!0,t.$http.get("/iweb/goods/delete?id="+e).then(function(e){var o=e.data;t.listLoading=!1,t.$message({type:o.status,message:o.description}),o.status&&t.doQuery()})})},doQuery:function(){var e=this;this.listLoading=!0,this.$http.get("/iweb/goods/find?q="+this.queryInfo.query.q+"&pageNum="+this.queryInfo.pageNum+"&pageSize="+this.queryInfo.pageSize).then(function(t){console.log(t.data.result);var o=t.data.result;e.pageBean=o,e.listLoading=!1})}}},l=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("div",{staticClass:"app-container calendar-list-container"},[o("div",{staticClass:"filter-container"},[o("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"请输入姓名或账号"},nativeOn:{keyup:function(t){if(!("button"in t)&&e._k(t.keyCode,"enter",13,t.key))return null;e.doQuery(t)}},model:{value:e.queryInfo.query.q,callback:function(t){e.$set(e.queryInfo.query,"q",t)},expression:"queryInfo.query.q"}}),e._v(" "),o("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"search"},on:{click:e.doQuery}},[e._v("搜索")]),e._v(" "),o("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{icon:"edit",type:"primary"},on:{click:function(t){e.doEdit("","add")}}},[e._v("添加\n      ")])],1),e._v(" "),o("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%",height:"100%"},attrs:{data:e.pageBean.list,border:"",fit:"","highlight-current-row":"","default-sort":{prop:"updTimestamp",order:"descending"},sortable:"custom"},on:{"sort-change":e.queryInfo.doSort}},[o("el-col",{attrs:{span:12}}),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品编号",prop:"goodsNo"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.goodsNo))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品名称",prop:"goodsName"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.goodsName))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品描述",prop:"description"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.description))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品分类",prop:"categoryId"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.categoryId))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品品牌",prop:"brandId"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.brandId))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品价格",prop:"goodsPrice"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.goodsPrice))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品图片",prop:"goodsImg"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",{staticStyle:{color:"red"}},[e._v(e._s(t.row.goodsImg))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品库存",prop:"inventory"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.inventory))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"150px",align:"center",label:"商品其他",prop:"goodsOther"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",{staticStyle:{color:"red"}},[e._v(e._s(t.row.goodsOther))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"250px",align:"center",label:"创建时间",prop:"createTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.createTime))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-table-column",{attrs:{width:"250px",align:"center",label:"修改时间",prop:"updateTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("span",[e._v(e._s(t.row.updateTime))])]}}])})],1),e._v(" "),o("el-col",{attrs:{span:12}}),e._v(" "),o("el-table-column",{attrs:{width:"150px",align:"center",label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[o("el-button",{attrs:{size:"small",type:"success"},on:{click:function(o){e.doEdit(t.row.goodsId,"update")}}},[e._v("编辑\n          ")]),e._v(" "),o("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(o){e.doRemove(t.row.goodsId)}}},[e._v("删除\n          ")])]}}])})],1),e._v(" "),o("div",{staticClass:"pagination-container"},[o("el-pagination",{attrs:{"current-page":e.pageBean.pageNum,"page-size":e.queryInfo.pageSize,"page-sizes":[10,20,30,50],layout:"total, sizes, prev, pager, next, jumper",total:e.pageBean.totalRecords},on:{"update:currentPage":function(t){e.$set(e.pageBean,"pageNum",t)},"size-change":e.queryInfo.doSizeChg,"current-change":e.queryInfo.doCurPageChange}})],1),e._v(" "),o("goodsform",{ref:"goodsform",on:{"save-ok":e.doQuery}})],1)},r=[],i={render:l,staticRenderFns:r},c=i,d=o("vSla"),u=d(n,c,!1,null,null,null);t.default=u.exports},"346i":function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=o("q15z"),a=o("4JCT"),n=o("syRb"),l={name:"goodsform",components:{goodscategorysel:s.default,goodsbrandsel:a.default,mgoodsclasssel:n.default},data:function(){return{formInfo:{simpleImage:[],wheelImage:[],detailsImage:[],extensionImage:[],classes:[]},visiable:!1,loading:!1,method:"add"}},methods:{show:function(e,t){var o=this;this.method=t,this.$refs.formInfo&&this.$refs.formInfo.resetFields(),this.visiable=!0,"add"!=t&&this.$http.get("/iweb/goods/detail/"+e).then(function(e){var t=e.data.result;o.formInfo=t})},submit:function(){var e=this;this.$refs.formInfo.validate(function(t){if(!t)return!1;"add"==e.method?e.add():"update"==e.method&&e.update()})},add:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goods/add",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},update:function(){var e=this;this.loading=!0,this.$http.post("/iweb/goods/update",this.formInfo).then(function(t){e.loading=!1;var o=t.data;e.$message({type:o.status?"success":"error",message:o.message}),o.status&&(e.$emit("save-ok"),e.visiable=!1)},function(){e.loading=!1,e.$message({type:"error",message:"操作失败"})})},handleImageRemove:function(e,t){this.formInfo.goodsImage=null},handleImageSuccess:function(e,t,o){this.formInfo.goodsImage=t.response.result.fileId},handleSimpleImageRemove:function(e,t){this.formInfo.simpleImage.unshift(e.response.result.fileId)},handleSimpleImageSuccess:function(e,t,o){this.formInfo.simpleImage.push(t.response.result.fileId)},handleDetailsImageRemove:function(e,t){this.formInfo.detailsImage.unshift(e.response.result.fileId)},handleDetailsImageSuccess:function(e,t,o){this.formInfo.detailsImage.push(t.response.result.fileId)},handleWheelImageRemove:function(e,t){this.formInfo.wheelImage.unshift(e.response.result.fileId)},handleWheelImageSuccess:function(e,t,o){this.formInfo.wheelImage.push(t.response.result.fileId)},handleExtensionImageRemove:function(e,t){this.formInfo.extensionImage.unshift(e.response.result.fileId)},handleExtensionImageSuccess:function(e,t,o){this.formInfo.extensionImage.push(t.response.result.fileId)}}},r=function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-dialog",{attrs:{title:"编辑",visible:e.visiable,width:"60%"},on:{"update:visible":function(t){e.visiable=t}}},[o("el-form",{ref:"formInfo",staticClass:"small-space",attrs:{"label-width":"120px",model:e.formInfo,inline:!0}},[o("el-row",{attrs:{justify:"space-around"}},[o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品名称",prop:"goodsName",rules:e.$r(1,0,50)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入商品名称"},model:{value:e.formInfo.goodsName,callback:function(t){e.$set(e.formInfo,"goodsName",t)},expression:"formInfo.goodsName"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品分类",prop:"categoryId",rules:e.$r(1,0,36)}},[o("goodscategorysel",{attrs:{impValue:e.formInfo.categoryId,placeholder:"请输入商品分类"},model:{value:e.formInfo.categoryId,callback:function(t){e.$set(e.formInfo,"categoryId",t)},expression:"formInfo.categoryId"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品品牌",prop:"brandId",rules:e.$r(1,0,36)}},[o("goodsbrandsel",{attrs:{impValue:e.formInfo.brandId,placeholder:"请输入商品品牌"},model:{value:e.formInfo.brandId,callback:function(t){e.$set(e.formInfo,"brandId",t)},expression:"formInfo.brandId"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品特征",prop:"classes"}},[o("mgoodsclasssel",{attrs:{impValue:e.formInfo.classes,placeholder:"请输入商品特征"},model:{value:e.formInfo.classes,callback:function(t){e.$set(e.formInfo,"classes",t)},expression:"formInfo.classes"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品价格",prop:"goodsPrice",rules:e.$r(1,0,999999,"number")}},[o("el-input-number",{attrs:{type:"text",placeholder:"请输入商品价格"},model:{value:e.formInfo.goodsPrice,callback:function(t){e.$set(e.formInfo,"goodsPrice",t)},expression:"formInfo.goodsPrice"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品图片",prop:"goodsImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleImageRemove,"on-success":e.handleImageSuccess,limit:1}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品库存",prop:"inventory",rules:e.$r(1,0,999999,"number")}},[o("el-input-number",{attrs:{type:"text",placeholder:"请输入商品库存"},model:{value:e.formInfo.inventory,callback:function(t){e.$set(e.formInfo,"inventory",t)},expression:"formInfo.inventory"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:12}},[o("el-form-item",{attrs:{label:"商品其他",prop:"goodsOther",rules:e.$r(0,0,255)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入商品其他"},model:{value:e.formInfo.goodsOther,callback:function(t){e.$set(e.formInfo,"goodsOther",t)},expression:"formInfo.goodsOther"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"商品描述",prop:"description",rules:e.$r(1,0,255)}},[o("el-input",{attrs:{type:"text",placeholder:"请输入商品描述"},model:{value:e.formInfo.description,callback:function(t){e.$set(e.formInfo,"description",t)},expression:"formInfo.description"}})],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"缩略图",prop:"goodsImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleSimpleImageRemove,"on-success":e.handleSimpleImageSuccess}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"轮播图",prop:"goodsImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleWheelImageRemove,"on-success":e.handleWheelImageSuccess}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"展示详情图",prop:"goodsImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleDetailsImageRemove,"on-success":e.handleDetailsImageSuccess}},[o("i",{staticClass:"el-icon-plus"})])],1)],1),e._v(" "),o("el-col",{attrs:{span:24}},[o("el-form-item",{attrs:{label:"推广图",prop:"goodsImg"}},[o("el-upload",{attrs:{action:"/iweb/file/upload","list-type":"picture-card","on-remove":e.handleExtensionImageRemove,"on-success":e.handleExtensionImageSuccess}},[o("i",{staticClass:"el-icon-plus"})])],1)],1)],1)],1),e._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:function(t){e.visiable=!1}}},[e._v("取 消")]),e._v(" "),o("el-button",{attrs:{type:"primary",loading:e.loading},on:{click:e.submit}},[e._v(" 确 定")])],1)],1)},i=[],c={render:r,staticRenderFns:i},d=c,u=o("vSla"),p=u(l,d,!1,null,null,null);t.default=p.exports}});