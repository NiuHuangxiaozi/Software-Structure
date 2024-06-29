
<script lang="ts" setup>
  import {ref, getCurrentInstance} from 'vue'
  import { useRouter } from 'vue-router';
  import { getreview } from '@/utils/api';

  const router=useRouter()

   //订单开始的数字
  const app = getCurrentInstance()
  
  const reviews=ref([])

  const getReviews=async function()
  {
    let reviewId = app.appContext.config.globalProperties.$reviewId
    let result= await getreview(reviewId);
    console.log(result)
    reviews.value=result
    console.log(reviews.value)
  }
  getReviews();
  
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
                <el-table :data="reviews" border style="width: 100%">
                  <el-table-column prop="id" label="reviewId" width="180" />
                  <el-table-column prop="rating" label="rating" />
                  <el-table-column prop="title" label="title" />
                  <el-table-column prop="text" label="text" />
                  <el-table-column prop="image" label="image" >
                    <template #default="scope">
                      <el-image :src="scope.row.image"></el-image>
                    </template>
                  </el-table-column>
                  <el-table-column prop="asin" label="asin" />
                  <el-table-column prop="parentasin" label="parentasin" />
                  <el-table-column prop="userid" label="userid" />
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
