package com.example.webpos.db;
import org.springframework.stereotype.Component;

import com.example.webpos.model.myOrder;
import com.example.webpos.repository.OrderRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class OrderMemoryDB implements OrderDB {
    

    private OrderRepository  order_repository;


    public  OrderMemoryDB(OrderRepository o){
        this.order_repository=o;
    }



    ///////////////////////////////////////////////////////////
    //获得所有的节点
    @Override
    public Flux<myOrder> getOrders(){
        Flux<myOrder> all_orders=order_repository.findAll();
        return all_orders;
    }

    @Override
    public Mono<myOrder> getOrder(String orderId){
        System.out.println("The order id is "+orderId);

        Mono<myOrder> product=order_repository.findById(orderId);
        return product;
    }

    @Override
    public Mono<Void> removeOrder(String orderId){

        return order_repository.findById(orderId)
                .flatMap(t_order -> order_repository.delete(t_order))
                .then();
    }

    @Override
    public Mono<Void> changeStateOfOrder(String orderId,String new_msg){
                return order_repository.findById(orderId)
                        .flatMap(order -> {
                            order.setState(new_msg);
                            return order_repository.save(order);
                        })
                        .then();
    }

    @Override
    public Mono<Void> addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state){
            myOrder newOrder = new myOrder(orderid, pay, itemsSelect, describe, state);
            return order_repository.save(newOrder)
                .then();
    }
}
