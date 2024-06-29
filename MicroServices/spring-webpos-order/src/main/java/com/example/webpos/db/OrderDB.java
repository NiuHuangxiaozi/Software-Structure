package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.myOrder;



public interface OrderDB {

    //获得所有订单
    public List<myOrder> getOrders();

    //获得某个订单
    public myOrder getOrder(String orderId);


    //移除一个商品
    public boolean removeOrder(String orderId);


    //修改一个订单
    public boolean assignOrder(myOrder newOrder);

    //增加一个订单
    public boolean addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state);
    
    
}