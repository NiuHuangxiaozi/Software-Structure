package com.example.webpos.biz;
import java.util.List;

import com.example.webpos.model.Delivery;

public interface DeliService {

    //获得某个运单
    public Delivery serviceGetDeli(String orderId);

    //添加运单
    public Boolean serviceAddDeli(Delivery deli); 

    //删除运单
    public Boolean serviceDeleteDeli(String deliId); 

    //获得所有的运单
    public List<Delivery> serviceGetAllDelis();
}
