
<script lang="ts" setup>
  import {ref} from 'vue'
  import { useRouter } from 'vue-router';
  import { getAllorders,changeNumberOfProduct ,deleteorder,changeOrderState} from '@/utils/api';



  const router=useRouter()

  //header标语
  const headwords=ref([
    "1",
    "2",
    "3",
    "4"
  ])
  
  const orders=ref([])
  const getOrders=async function()
  {
    let result= await getAllorders();
    orders.value=result
    console.log(orders.value)
  }
  getOrders();



  //撤回订单
  const withdrawOrder=async (row)=>{
     if(row.state=="已支付"){
        console.log("已经支付的订单不能撤回")
     }
     else{
        for(var i = 0; i < orders.value.length; i++){
            //找到指定的订单
            if(orders.value[i].orderId==row.orderId){
                    //index为商品编号
                    let productList=orders.value[i].goods
                    //index+1为相应的数量
                    for(var index=0;index<productList.length-1;index=index+2){
                      changeNumberOfProduct("PD"+productList[index].toString(),productList[index+1])
                    }

                    //删除订单
                    let result= await deleteorder(row.orderId)

                    //重新加载订单
                    orders.value=[]
                    getOrders()
                    console.log("reload orders!")
                break;
            }
        }

     }
  }

  //支付订单
  import {ElMessage,ElMessageBox} from 'element-plus'
  
  const payOrder=(row)=>{
    if(row.state=="已支付"){
        console.log("已经支付的订单不能再次支付")
     }
     else if(row.state=="待支付"){
              ElMessageBox.confirm(
              '确认支付吗？',
              'Warning',
              {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
                type: 'warning',
              }
            )
              .then(async () => {
                let result = await changeOrderState(row,"已支付")
                getOrders();

                ElMessage({
                  type: 'success',
                  message: '支付成功',
                })
              })
              .catch(() => {
                ElMessage({
                  type: 'info',
                  message: '取消支付',
                })
              })
        }
  }

  const removeCompleteOrder=async (row)=>{
    if(row.state=="待支付"){
        console.log("待支付的订单不能删除")
    }
    else if(row.state=="已支付"){
      //删除订单
      let result= await deleteorder(row.orderId)
      //重新加载订单
      getOrders()
      console.log("reload orders in removeCompleteOrder!")
    }
  }
</script>










<template>
  <div class="block text-center">
    <el-carousel height="100px">
      <el-carousel-item v-for="item in headwords" :key="item">
        <h3 class="small justify-center" text="2xl">{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
  </div>


  <el-row :gutter="40">
      <el-col :span="24">
          <div class="grid-content ep-bg-purple" >

            <el-scrollbar height="800px">
                <el-table :data="orders" border style="width: 100%">
                  <el-table-column prop="orderId" label="OrderId" width="180" />
                  <el-table-column prop="pay" label="Pay" />
                  <el-table-column prop="describe" label="Describe" />
                  <el-table-column prop="state" label="State" />
                  <el-table-column  label="opeation" style="width: 70%">
                      <template #default="{ row }">
                        <el-button  @click="withdrawOrder(row)"  type="success" plain>撤销订单</el-button>
                        <el-button  @click="payOrder(row)"  type="success" plain>支付订单</el-button>
                        <el-button  @click="removeCompleteOrder(row)"  type="success" plain>删除已支付订单</el-button>
                      </template>
                  </el-table-column>
                </el-table> 
            </el-scrollbar>
      
          </div>
      </el-col>
  </el-row>
</template>



<style>
  .el-row {
    margin-bottom: 20px;
  }
  .el-row:last-child {
    margin-bottom: 0;
  }
  .el-col {
    border-radius: 4px;
  }

  .grid-content {
    border-radius: 4px;
    min-height: 36px;
    color: brown;
  }
  .scrollbar-demo-item {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100px;
    margin: 10px;
    text-align: center;
    border-radius: 4px;
    background: var(--el-color-primary-light-9);
    color: var(--el-color-primary);
  }

  .demonstration {
    color: var(--el-text-color-secondary);
  }
  
  .el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 100px;
    margin: 0;
    text-align: center;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }

  .el-col {
    text-align: center;
  }
</style>
