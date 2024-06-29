package com.example.webpos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.OrderService;
import com.example.webpos.controller.api.OrdersApi;
import com.example.webpos.mapper.myOrderMapper;
import com.example.webpos.model.myOrder;
import com.example.webpos.model.dto.MyOrderDto;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin(originPatterns = "*")
public class OrderController implements OrdersApi{
    
    private OrderService orderService;

    private myOrderMapper myorderMapper;
    
    @Autowired
    public void setPosService(OrderService orderSer , myOrderMapper order_mapper) {
        this.orderService = orderSer;
        this.myorderMapper=order_mapper;
    }

    @Override
    public ResponseEntity<List<MyOrderDto>> listOrders(){

        List<myOrder> orders = orderService.orders(); // 调用业务逻辑层获取所有订单
        if (orders == null || orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        System.out.println("get orders!");
        return new ResponseEntity<>(myorderMapper.tomyOrderDtoList(orders), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }

    @Override
    public ResponseEntity<Void> remomoveOrder(@PathVariable("orderId") String orderId) {
        //返回内容
        ResponseEntity<Void> response = null;

        if(orderService.removeOrder(orderId)){
            response = ResponseEntity.ok().build();
        }
        else{
            response = ResponseEntity.status(400).build();
        }

        return response;
    }

    @Override
    public ResponseEntity<Void> changeStateOfOrder( @PathVariable("orderId") String orderId, @RequestBody String body) {
        //返回内容
        ResponseEntity<Void> response = null;

        //拿到剩余的数目
        JSONObject jsonObject = JSONUtil.parseObj(body.toString());
        String newstate =jsonObject.getStr("target").toString();
        if(orderService.changeStateOfOrder(orderId, newstate))
                response = ResponseEntity.ok().build();
        else
                response = ResponseEntity.status(400).build(); 

        return response;
    }



    public ResponseEntity<Void> addOrder( @PathVariable("orderId") String orderId, @RequestBody String body) {
        ResponseEntity<Void> response = null;
        System.out.println(body);
        JSONObject jsonObject = JSONUtil.parseObj(body.toString());

        String orderid =jsonObject.getStr("orderId").toString();

        Double pay=Double.parseDouble(jsonObject.getStr("pay").toString());
        
        String goods_str=jsonObject.getStr("goods");
        String[] li=goods_str.substring(1, goods_str.length()-1).split(",");
        List<Integer> itemsSelect=new ArrayList<>();
        for(int index=0;index<li.length;index++)
            itemsSelect.add(Integer.parseInt(li[index]));


        String describe=jsonObject.getStr("describe").toString();

        String state=jsonObject.getStr("state").toString();


        if(orderService.addOrder(orderid, pay, itemsSelect, describe, state))
                response = ResponseEntity.ok().build();
        else
                response = ResponseEntity.status(400).build(); 
        return response;
    }
}
