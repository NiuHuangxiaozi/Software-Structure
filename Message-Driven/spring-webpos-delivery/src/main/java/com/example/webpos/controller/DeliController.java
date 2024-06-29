package com.example.webpos.controller;


import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.webpos.biz.DeliService;
import com.example.webpos.controller.api.DeliveriesApi;
import com.example.webpos.mapper.DeliveryMapper;
import com.example.webpos.model.Delivery;
import com.example.webpos.model.dto.DeliveryDto;






@RestController
@CrossOrigin(originPatterns = "*")
public class DeliController implements DeliveriesApi{
    
    private DeliService deliService;

    private DeliveryMapper deliveryMapper;

    private  Integer number=0;
    
    @Autowired
    public void setPosService(DeliService deliService , DeliveryMapper deliveryMapper) {
        this.deliService = deliService;
        this.deliveryMapper = deliveryMapper;
    }


    @Override
    public ResponseEntity<DeliveryDto> showDeliveryById(@PathVariable("deliveryId") String deliveryId) {
        System.out.println("开始查询运单"+deliveryId);

        Delivery delivery=this.deliService.serviceGetDeli(deliveryId);
        if (delivery == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        return new ResponseEntity<>(deliveryMapper.toDeliveryDto(delivery), HttpStatus.OK); // 返回DTO列表和HTTP状态OK 
    }


    @Override
    public  ResponseEntity<List<DeliveryDto>> getDelis() {
        System.out.println("获取所有的运单");
        List<Delivery> delis=this.deliService.serviceGetAllDelis();
        System.err.println(delis);
        if (delis == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        return new ResponseEntity<>(deliveryMapper.toDeliveryDtoList(delis), HttpStatus.OK); // 返回DTO列表和HTTP状态OK

    }





    //rabbitmq
    @RabbitListener(queues = "delivery.queue")
    public void listen2OrderNode2CreateDeli(Map<String,Object> msg){
        //创建一个新的运单
        String road="上海--南京";
        Delivery deli=new Delivery("NJU"+String.valueOf(number), String.valueOf(msg.get("orderId")), road, String.valueOf(msg.get("describe")));
        number+=1;
        System.err.println(deli);
        deliService.serviceAddDeli(deli);
        System.out.println("创建运单成功！");
    }
}
