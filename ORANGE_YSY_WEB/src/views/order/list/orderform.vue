<template>

  <el-dialog title="编辑" :visible.sync="visiable" width='60%'>
    <el-form class="small-space" label-width="120px" :model="formInfo" ref="formInfo" :inline="true">
      <el-row justify="space-around">

        
        <el-col :span="12">
        </el-col>

        <el-col :span="12">
          <el-form-item label="订单编号" prop="orderNo" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.orderNo" placeholder="请输入订单编号">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="用户id" prop="userId" :rules="$r(1,0,36)">
            <el-input type="text" v-model="formInfo.userId" placeholder="请输入用户id">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="地址id" prop="addressId" :rules="$r(1,0,36)">
            <el-input type="text" v-model="formInfo.addressId" placeholder="请输入地址id">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="物流号" prop="logisticsNo" :rules="$r(0,0,50)">
            <el-input type="text" v-model="formInfo.logisticsNo" placeholder="请输入物流号">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="物流公司" prop="logisticsName" :rules="$r(0,0,50)">
            <el-input type="text" v-model="formInfo.logisticsName" placeholder="请输入物流公司">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="发票类型" prop="billType" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.billType" placeholder="请输入发票类型">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="商品总额" prop="totalPrice" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.totalPrice" placeholder="请输入商品总额">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="优惠金额" prop="cutPrice" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.cutPrice" placeholder="请输入优惠金额">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="运费金额" prop="transPrice" :rules="$r(0,0,1)">
            <el-input type="text" v-model="formInfo.transPrice" placeholder="请输入运费金额">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="订单状态" prop="orderStatus" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.orderStatus" placeholder="请输入订单状态">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="订单类型" prop="orderType" :rules="$r(1,0,1)">
            <el-input type="text" v-model="formInfo.orderType" placeholder="请输入订单类型">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="订单备注" prop="orderDesc" :rules="$r(0,0,255)">
            <el-input type="text" v-model="formInfo.orderDesc" placeholder="请输入订单备注">
            </el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
             <el-form-item label="完成时间" prop="finishTime" :rules="$r(0)">
            <el-date-picker
		      v-model="formInfo.finishTime"
		      type="datetime"
		      placeholder="请输入完成时间"
		      value-format="yyyy-MM-dd HH:mm:ss">
		    </el-date-picker>
		</el-form-item>
        </el-col>

        <el-col :span="12">
             <el-form-item label="支付时间" prop="payTime" :rules="$r(0)">
            <el-date-picker
		      v-model="formInfo.payTime"
		      type="datetime"
		      placeholder="请输入支付时间"
		      value-format="yyyy-MM-dd HH:mm:ss">
		    </el-date-picker>
		</el-form-item>
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
        </el-col>

        <el-col :span="12">
        </el-col>

      </el-row>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="visiable = false">取 消</el-button>
      <el-button type="primary" @click="submit" :loading="loading"> 确 定</el-button>
    </div>
  </el-dialog>

</template>

<script>
  export default {
    name: 'orderform',
    data() {
      return {
        formInfo: {},
        visiable: false,
        loading: false,
        method: 'add'
      }
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
        this.$http.get('/iweb/order/detail/' + id).then(response => {
          const data = response.data.result
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
        this.$http.post('/iweb/order/add', this.formInfo).then(response => {
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
        this.$http.post('/iweb/order/update', this.formInfo).then(response => {
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
    }
  }
</script>
