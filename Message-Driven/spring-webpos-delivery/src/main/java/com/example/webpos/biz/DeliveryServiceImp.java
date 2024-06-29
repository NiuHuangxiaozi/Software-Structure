package com.example.webpos.biz;
import com.example.webpos.db.DeliDB;
import com.example.webpos.model.Delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;





@Service
@Component
public class DeliveryServiceImp implements DeliService {

    private DeliDB deliDB;

    @Autowired
    public void setPosDB(DeliDB posDB) {
        this.deliDB = posDB;
    }

    //获得某个运单
    public Delivery serviceGetDeli(String orderId){
            return this.deliDB.getDeli(orderId);
    }

    //添加运单
    public Boolean serviceAddDeli(Delivery deli){
            return deliDB.addDeli(deli);
    }

    //删除运单
    public Boolean serviceDeleteDeli(String deliId){
        return deliDB.deleteDeli(deliId);
    }

    //获得所有的运单
    public List<Delivery> serviceGetAllDelis(){
        return this.deliDB.getAllDelis();
    }

}