package com.example.webpos.biz;
import java.util.List;

import com.example.webpos.model.myOrder;


public interface OrderService {

     public List<myOrder> orders();


     public boolean removeOrder(String orderId);


     public boolean changeStateOfOrder(String orderId,String newState);

     public boolean addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state);

    
     //message
     public myOrder getmyOrder(String orderId);
}
