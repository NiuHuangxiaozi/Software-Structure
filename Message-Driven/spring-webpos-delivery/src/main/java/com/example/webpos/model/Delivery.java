package com.example.webpos.model;

import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
public class Delivery {

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
