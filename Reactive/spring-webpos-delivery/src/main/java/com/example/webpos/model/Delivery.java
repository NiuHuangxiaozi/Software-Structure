package com.example.webpos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;




@Document(value="deliveries")
@Data
@AllArgsConstructor
public class Delivery {

    @Id
    private String deliveryId;

    private String OrderId;

    private String logistics; 

    private String describe;
    public Delivery() {
    }

    Delivery(Delivery otherDelivery){
        deliveryId=otherDelivery.deliveryId;
        logistics=otherDelivery.logistics;
        describe=otherDelivery.describe;
    }

    @Override
    public String toString() {
        return getDeliveryId() + "\t" + getLogistics() + "\t" + getDescribe();
    }
    
}
