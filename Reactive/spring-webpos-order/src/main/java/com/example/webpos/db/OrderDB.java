package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.myOrder;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface OrderDB {

    //获得所有订单
    public Flux<myOrder> getOrders();

    //获得某个订单
    public Mono<myOrder> getOrder(String orderId);

    //移除一个订单
    public Mono<Void> removeOrder(String orderId);


    //修改一个订单
    public Mono<Void> changeStateOfOrder(String orderId,String new_msg);

    //增加一个订单
    public Mono<Void> addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state);

    
    
    
    
}