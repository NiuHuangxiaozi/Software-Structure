package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Delivery;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DeliDB {

    //获得某个运单
    public Mono<Delivery> getDeli(String deliId);

    //添加运单
    public Mono<Void> addDeli(Delivery deli); 

    //删除运单
    public Mono<Void> deleteDeli(String deliId); 

    //获得所有的运单
    public Flux<Delivery> getAllDelis();

}