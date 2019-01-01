<template >
  <el-select  v-model="selVal" clearable :placeholder="placeholder?placeholder:'请选择'"   v-bind="$attrs" v-on="$listeners" >
    <el-option v-for="item in option"
      :key="item.categoryId"
      :label="item.categoryName"
      :value="item.categoryId">
    </el-option>
  </el-select>
</template>

<script>
  export default {
    name: 'goodscategorysel',
    data() {
      return {
        option: [],
        value:this.impValue
      }
    },
    props: ['impValue','placeholder'],// 设置value为props属性-必须
    mounted() {
      this.doQuery()
    },
    methods: {
      doQuery() {
        this.$http.get('/iweb/goodscategory/find',{"q":this.value,"pageSize":100}).then(response => {
          const data = response.data;
          this.option = data.result.list;
          this.value = this.impValue
        })
      }
    },
    computed: {//给外层v-model赋值
      selVal: {
        // 动态计算selVal的值
        get: function () {
          if (this.value != null) return this.value;
        },
        set: function (val) {//v-model input
          this.value=val;
          // this.$emit('input',val);
        }
      }
    }

  }
</script>
