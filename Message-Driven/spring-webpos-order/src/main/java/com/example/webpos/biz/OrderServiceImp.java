package com.example.webpos.biz;

import com.example.webpos.db.OrderDB;
import com.example.webpos.model.myOrder;
import com.example.webpos.model.dto.SettingDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;





@Service
@Component
public class OrderServiceImp implements OrderService {

    private OrderDB orderDB;

    @Autowired
    public void setPosDB(OrderDB posDB) {
        this.orderDB = posDB;
    }

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private  String settingURL="http://setting-service/";

    public List<myOrder> orders(){
        //拿一下配置

        List<SettingDto> settings = restTemplate.getForObject(settingURL+"settings", List.class);
        System.out.println("=============");
        System.out.println(settings);
        System.out.println("=============");

        return orderDB.getOrders();
    }

    public boolean removeOrder(String orderId){
        myOrder myorder=this.orderDB.getOrder(orderId);
        if(myorder==null){
                return false;
        }
        else{
             return this.orderDB.removeOrder(orderId);
        }
    }

    
    public boolean changeStateOfOrder(String orderId,String newState){
        myOrder myorder=this.orderDB.getOrder(orderId);
        if(myorder==null)
            return false;
        else{
            myorder.setState(newState);
            this.orderDB.assignOrder(myorder);
            return true;
        }
    }
    

    public boolean addOrder(String orderid,Double pay,List<Integer> itemsSelect, String describe, String state){
        myOrder myorder=this.orderDB.getOrder(orderid);
        if(myorder==null){
            this.orderDB.addOrder(orderid, pay, itemsSelect, describe, state);
            return true;
        }
        else{
            return false;
        }
    }

    public myOrder getmyOrder(String orderId){
            return this.orderDB.getOrder(orderId);
    }

}