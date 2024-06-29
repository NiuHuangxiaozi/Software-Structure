
<script lang="ts" setup>

  import { getAllproducts,getProduct,changeNumberOfProduct,addOrder } from '@/utils/api';
  import {ref} from 'vue'

  import { useRouter } from 'vue-router';
  const router=useRouter()




  //有关物品表格
  const products =ref([])
  const getProdcuts=async function()
  {
    let result= await getAllproducts();
    console.log(result)
    products.value=result
    console.log(products.value)
  }
  getProdcuts();

  //购物车的表格
  const cartItems =ref([])




  //商品选项的按钮
  import {
    ArrowLeft,
    ArrowRight,
  } from '@element-plus/icons-vue'
  import { Delete } from '@element-plus/icons-vue'
import { throttleByRaf } from 'element-plus/es/utils';


  //版面
  const headwords=ref([
    "1",
    "2",
    "3",
    "4"
  ])


  //交易按钮
  const buttons = ref([
    { type: 'primary', text: '清空购物车' },
    { type: 'success', text: '购买' },
    ])



  //订单开始的数字
  const orderIndex=ref(0)

  //////////////////////////////////////////////////////////////////////////////////////////////
  //下面是数据类型和一些触发的事件

  //点击购买，向购物车加东西
  const addToCart=(row) => {
    if(row.quantity!=0){
        //
        row.quantity-=1
        let inCart=cartItems.value.some(item=>{return item.id==row.id})
        if(inCart ==true){
          for(var i = 0; i < cartItems.value.length; i++){
                if(cartItems.value[i].id==row.id){
                    cartItems.value[i].numberSelect+=1
                    cartItems.value[i].price+=row.price
                    console.log("add to cart successful!")
                    break;
                }
          }
        }
        else{
              cartItems.value.push({
              id:row.id,
              name:row.name,
              price:row.price,
              numberSelect:1
            })
        }
        TotalPrice.value+=row.price
    } 
  }

  //购物车增加一个东西
  const increCartitem=(row)=>{
    for(var i = 0; i < products.value.length; i++){

          if(products.value[i].id==row.id){
               if(products.value[i].quantity!=0){
                  products.value[i].quantity-=1
                  row.numberSelect+=1
                  row.price+=products.value[i].price

                  TotalPrice.value+=products.value[i].price

                  console.log("增加成功！")
               }
               else{
                  console.log("没有货物了！")
               }
               break;
          }
    }

  }

  //购物车减少一个东西
  const decreCartitem=(row)=>{
    for(var i = 0; i < products.value.length; i++){

          if(products.value[i].id==row.id){
                  products.value[i].quantity+=1
                  row.numberSelect-=1
                  row.price-=products.value[i].price

                  TotalPrice.value-=products.value[i].price

                  console.log("减少成功！")
                  break;  
          }
      }
    if(row.numberSelect==0)
        clearCartitem(row)
      
  }

  //清空购物车的一项
  const clearCartitem=(row)=>{
    for(var i = 0; i < products.value.length; i++){

      if(products.value[i].id==row.id){
        
          products.value[i].quantity+=row.numberSelect

          TotalPrice.value-=products.value[i].price*row.numberSelect
      }
    }
    cartItems.value=cartItems.value.filter( function(item){  return row.id !== item.id; })

  }

  //显示更新总价格
  const TotalPrice=ref(0)


  //清空所有的购物车项
  const clearAllCartItem=()=>{
    for(var i = 0; i < cartItems.value.length; i++){
        for(var j = 0; j < products.value.length; j++){
          if(products.value[j].id==cartItems.value[i].id){
            products.value[j].quantity+=cartItems.value[i].numberSelect
            break;
          }
        }
    }
    cartItems.value=[]
    TotalPrice.value=0
    
  }

  //完成了支付
  const charge=async ()=>{

    let Pay=0.0
    let Discribe=''
    let cart_item_list=[]
    //生成订单
    for(var index=0;index<cartItems.value.length;index++){

          //收集订单信息
          let tempId=cartItems.value[index].id
          let Id=Number(tempId.substr(2))
          cart_item_list.push(Id)
          cart_item_list.push(cartItems.value[index].numberSelect)
          Pay+=cartItems.value[index].price

          Discribe+=cartItems.value[index].name+"*"+cartItems.value[index].numberSelect.toString()+' '

          //减少库存
          let result = await changeNumberOfProduct(tempId,0-cartItems.value[index].numberSelect)


    }
    //准备OrderId
    let OrderId="JD"+orderIndex.value.toString()
    orderIndex.value+=1

    let state='待支付'

    let tempOrder={
        'orderId' : OrderId,
        'pay' : Pay,
        'goods' : cart_item_list,
        'describe' : Discribe,
        'state' : state
    }
    
    //将当前订单加入订单库
    let result2=await addOrder(OrderId , tempOrder)

    //清空订单
    cartItems.value=[]

    router.push('/order')
  }
  //查看订单
  const checkOrder=()=>{
    router.push('/order')
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
      <el-col :span="12">
          <div class="grid-content ep-bg-purple" >

            <el-scrollbar height="1000px">
                <el-table :data="products" border style="width: 100%">
                  <el-table-column prop="id" label="Id" width="180" />
                  <el-table-column prop="name" label="Name" width="180" />
                  <el-table-column prop="price" label="Price" />
                  <el-table-column prop="image" label="Image">
                      <template #default="scope">
                          <el-image :src="scope.row.image"></el-image>
                      </template>
                  </el-table-column>
                  <el-table-column prop="quantity" label="Quantity" />
                  <el-table-column  label="opeation" style="width: 70%">
                      <template #default="{ row }">
                          <el-button @click="addToCart(row)"   type="success" plain>购买</el-button>
                      </template>
                  </el-table-column>
                </el-table> 
            </el-scrollbar>
      
          </div>
      </el-col>
    <el-col :span="12">

      <div class="grid-content ep-bg-purple">
          <el-scrollbar height="900px">
            <el-table :data="cartItems" border style="width: 100%">
              <el-table-column prop="id" label="Id" width="100" />
              <el-table-column prop="name" label="Name" width="150" />
              <el-table-column prop="price" label="Price" />

              <el-table-column prop="numberSelect" label="NumberSelect" />
              <el-table-column  label="opeation" style="width: 70%">
                <template #default="{ row }">
                    <el-button-group>
                      <el-button  @click="decreCartitem(row)" type="danger" :icon="ArrowLeft"></el-button>
                      <el-button  @click="increCartitem(row)" type="warning" :icon="ArrowRight"></el-button>
                      <el-button  @click="clearCartitem(row)" type="danger" :icon="Delete" circle />
                    </el-button-group>
                </template>
              </el-table-column>
            </el-table> 
        </el-scrollbar>
      </div>

      <el-row >

        <el-col  :span="6">
          <el-statistic style=" margin-top: 20px;"  title="总价格"  prefix='$' :value="TotalPrice"/>
        </el-col>

        <el-col :span="6">
          <el-button  @click="clearAllCartItem" style=" margin-top: 40px;" type="warning" round>清空购物车</el-button>
        </el-col>

        <el-col :span="6">
          <el-button @click="checkOrder" style=" margin-top: 40px;" type="info" round>查看订单</el-button>
        </el-col>

        <el-col :span="6">
          <el-button @click="charge" style=" margin-top: 40px;" type="success" round>立即购买</el-button>
        </el-col>

      </el-row>

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
