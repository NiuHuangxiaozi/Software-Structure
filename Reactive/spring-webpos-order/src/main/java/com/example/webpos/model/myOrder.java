package com.example.webpos.model;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;




@Document(value="myOrders")
@Data
@AllArgsConstructor
public class myOrder {

    @Id
    private String orderId;

    private double pay;

    private List<Integer>goods;

    private String describe;

    private String state;

    public myOrder() {
    }

    myOrder(myOrder otherorder){
        this.orderId=otherorder.orderId;
        this.pay=otherorder.pay;
        this.goods=otherorder.goods;
        this.describe=otherorder.describe;
        this.state=otherorder.state;
    }

    @Override
    public String toString() {
        return getOrderId() + "\t" + getPay() + "\t" + getGoods()+ "\t"+getState();
    }
    
}
