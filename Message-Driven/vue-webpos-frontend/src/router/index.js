

import { createRouter ,createWebHistory} from "vue-router";

import OrderVue from '@/components/Order.vue'
import ProductVue from '@/components/ProductTable.vue'



const routes=[
    {path:'/order',component:OrderVue},
    {path:'/',component:ProductVue}
]


const router=createRouter({
    history:createWebHistory(),
    routes:routes
})


export default router