package com.example.webpos.db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.webpos.model.Delivery;
import com.netflix.discovery.converters.Auto;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeliMemoryDB implements DeliDB {
    

    // private OrderRepository  order_repository;
    List<Delivery>  deliveries;


    public  DeliMemoryDB(){
        deliveries=new ArrayList<>();
    }
   ///////////////////////////////////////////////////////////

    public Delivery getDeli(String deliId){
        for (int index = 0; index < deliveries.size(); index++) {
                if(deliveries.get(index).getDeliveryId().equals(deliId))
                        return  deliveries.get(index);
        }
        return null;
    }

    //添加运单
    public Boolean addDeli(Delivery deli){
        deliveries.add(deli);
        System.out.println(deliveries);
        return true;
    }

    //删除运单
    public Boolean deleteDeli(String deliId){
        for (int index = 0; index < deliveries.size(); index++) {
            if(deliveries.get(index).getDeliveryId()==deliId)
                    deliveries.remove(index);
                    System.out.println(deliveries);
                    return true;
        }  
        return false;
    }

    //获得所有的运单
    public List<Delivery> getAllDelis(){    
        return  deliveries;
    }
}
