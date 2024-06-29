package com.example.webpos.db;
import org.springframework.stereotype.Component;

import com.example.webpos.model.Delivery;
import com.example.webpos.repository.DeliveryRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class DeliMemoryDB implements DeliDB {
    
    private DeliveryRepository  delivery_repository;

    public  DeliMemoryDB(DeliveryRepository d){

        this.delivery_repository=d;
    }

   ///////////////////////////////////////////////////////////

    public Mono<Delivery> getDeli(String deliId){
        return delivery_repository.findAll()
            .filter(deli -> deli.getDeliveryId().equals(deliId))
            .next(); // next() retrieves the first element that matches the filter condition
    }

    //添加运单
    public Mono<Void> addDeli(Delivery deli){
        return delivery_repository.save(deli).then();
    }

    //删除运单
    public Mono<Void> deleteDeli(String deliId){
        return delivery_repository.findById(deliId)
                .flatMap(deli->delivery_repository.delete(deli))
                .then();
    }

    //获得所有的运单
    public Flux<Delivery> getAllDelis(){
        return delivery_repository.findAll()
            .doOnComplete(() -> System.out.println("get all orders"));
    }
}
