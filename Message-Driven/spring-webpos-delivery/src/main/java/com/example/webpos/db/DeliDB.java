package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Delivery;

public interface DeliDB {

    //获得某个运单
    public Delivery getDeli(String deliId);

    //添加运单
    public Boolean addDeli(Delivery deli); 

    //删除运单
    public Boolean deleteDeli(String deliId); 

    //获得所有的运单
    public List<Delivery> getAllDelis();

}