package com.example.webpos.db;
import org.springframework.stereotype.Component;

import com.example.webpos.model.myOrder;
import com.example.webpos.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Component
public class OrderMemoryDB implements OrderDB {
    

    private OrderRepository  order_repository;


    public  OrderMemoryDB(OrderRepository o){

        this.order_repository=o;
        // //初始化数据库
        // product_repository.save(new Product("PD2","搅拌机", 349, "src/assets/propictures/2.jpg",1,2,5));
        // product_repository.save(new Product("PD3","coach包包", 1999, "src/assets/propictures/3.jpg",1,3,8));
        // product_repository.save(new Product("PD4","iPhone 13", 8999, "src/assets/propictures/4.jpg",1,0,5));
        // product_repository.save(new Product("PD5","折叠沙发", 14999, "src/assets/propictures/5.jpg",1,1,3));
        // product_repository.save(new Product("PD6","迷你椅子", 99, "src/assets/propictures/6.jpg",1,1,10));
        // product_repository.save(new Product("PD7","华为手表", 399, "src/assets/propictures/7.jpg",1,0,4));
        // product_repository.save(new Product("PD8","苹果显示器", 5999, "src/assets/propictures/comp.png",1,0,7));
    }



    ///////////////////////////////////////////////////////////

    public List<myOrder> getOrders(){
        List<myOrder> all_products=order_repository.findAll();
        return all_products;
    }

    public myOrder getOrder(String orderId){

        Optional<myOrder> order=order_repository.findById(orderId);
        if(order.isPresent())
            return order.get();
        else
            return null;
    }

    public boolean removeOrder(String orderId){
        Optional<myOrder> order=order_repository.findById(orderId);
        if(order.isPresent()){
            order_repository.deleteById(orderId);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean assignOrder(myOrder newOrder){
        String OrderId=newOrder.getOrderId();
        Optional<myOrder> pro=order_repository.findById(OrderId);
        if(pro.isPresent()){

            order_repository.save(newOrder);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state){
        order_repository.save(new myOrder(orderid,pay,itemsSelect,describe,state));
        return true;
    }
}
