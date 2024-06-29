package com.example.webpos.controller;


import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.db.DeliDB;
import com.example.webpos.model.Delivery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;






@RestController
@CrossOrigin(originPatterns = "*")
public class DeliController{
    
    private DeliDB deli_db;


    private  Integer number=0;
    
    @Autowired
    public void setPosService(DeliDB db) {
        this.deli_db = db;
    }

    @GetMapping("/deliveries/{deliveryId}")
    public Mono<Delivery> showDeliveryById(@PathVariable("deliveryId") String deliveryId) {
        return this.deli_db.getDeli(deliveryId);
    }


    @GetMapping("/deliveries")
    public  Flux<Delivery> getDelis() {
            return this.deli_db.getAllDelis()
                    .doOnComplete(()->System.out.println("获取所有的运单完毕"));
    }


    //rabbitmq
    @RabbitListener(queues = "delivery.queue")
    public void listen2OrderNode2CreateDeli(Map<String,Object> msg){
        //创建一个新的运单
        String road="上海--南京";
        Delivery deli=new Delivery("NJU"+String.valueOf(number), String.valueOf(msg.get("orderId")), road, String.valueOf(msg.get("describe")));
        number+=1;
        System.err.println(deli);
        Mono<Void> one=this.deli_db.addDeli(deli);
        one.doOnSuccess(aVoid -> System.out.println("订单保存成功"))
            .subscribe();
    }

}
