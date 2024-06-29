package com.example.webpos.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



import com.example.webpos.db.OrderDB;
import com.example.webpos.model.myOrder;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
@CrossOrigin(originPatterns = "*")
public class OrderController{
    
    private OrderDB orderDb;

    @Autowired
    public void setPosService(OrderDB o) {
        this.orderDb = o;
    }

    //message
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void createDelivery(String orderId,String describe){
        String queueName="delivery.queue";
        Map<String,Object> msg=new HashMap<>(3);
        msg.put("orderId", orderId);
        msg.put("describe", describe);
        rabbitTemplate.convertAndSend(queueName, msg);
        System.out.println("发送成功"+String.valueOf(msg));
    }

    //////////////message

    //返回所有的订单
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public Flux<myOrder> listOrders(){
            return this.orderDb.getOrders()
            .doOnNext(result -> System.out.println("Orders Get Successfully"));
    }



    //删除某个订单
    @DeleteMapping("/orders/{orderId}")
    public Mono<ResponseEntity<Void>> removeOrder(@PathVariable("orderId") String orderId) {
        return this.orderDb.removeOrder(orderId)
                .doOnNext(result -> System.out.println("Order removed successfully"))
                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(400).build()));
    }




    @PutMapping("/orders/{orderId}")
    public Mono<ResponseEntity<Void>> changeStateOfOrder( @PathVariable("orderId") String orderId, @RequestBody String body) {
        JSONObject jsonObject = JSONUtil.parseObj(body);
        String newstate = jsonObject.getStr("target");

        return this.orderDb.changeStateOfOrder(orderId, newstate)
                    .doOnNext(result -> System.out.println("Order State Changed Successfully"))
                    .then(Mono.just(ResponseEntity.ok().<Void>build()))
                    .onErrorResume(e -> Mono.just(ResponseEntity.status(400).build()));

    }


    @PostMapping("/orders/{orderId}")
    public Mono<ResponseEntity<Void>> addOrder( @PathVariable("orderId") String orderId, @RequestBody String body) {


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

        createDelivery(orderId,describe);
        return this.orderDb.addOrder(orderid, pay, itemsSelect, describe, state)
                .then(Mono.just(ResponseEntity.ok().<Void>build()))
                .onErrorResume(e -> Mono.just(ResponseEntity.status(400).build()));
        
    }
}
