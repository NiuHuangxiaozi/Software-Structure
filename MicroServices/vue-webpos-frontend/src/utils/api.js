






import request from '@/utils/request'
import order_request from '@/utils/orderrequest'

export function getAllproducts(){
    return request.get('/products')
}


export function getProduct(id){
    return request.get('/product',{ params: id})
}

export function changeNumberOfProduct(id,changeNumber){
    return request.put('/products/'+id.toString(),{number: changeNumber})
}





export function getAllorders(){
    return order_request.get('/orders')
}


export function deleteorder(orderId){
    return order_request.delete('/orders/'+orderId)
}


export function changeOrderState(row,newstate){
    return order_request.put('/orders/'+row.orderId,{target : newstate })    
}

export function addOrder(OrderId,information){
    return order_request.post('/orders/'+OrderId,  information)    
}