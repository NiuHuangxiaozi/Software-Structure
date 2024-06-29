






import request from '@/utils/request'
import order_request from '@/utils/orderrequest'
import deli_request from '@/utils/delirequest'

export function getAllproducts(){
    return request.get('/products')
}


export function getProduct(id){
    return request.get('/products/id/'+id.toString())
}

export function changeNumberOfProduct(id,changeNumber){
    return request.put('/products/'+id.toString(),{number: changeNumber})
}

export function getProductByName(name){
    return request.get('/products/name/'+name.toString())
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





export function getAlldelis(){
    return deli_request.get('/deliveries')
}

