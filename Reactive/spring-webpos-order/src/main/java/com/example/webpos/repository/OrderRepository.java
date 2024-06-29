package com.example.webpos.repository;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.webpos.model.myOrder;

@Configuration
public interface OrderRepository extends ReactiveMongoRepository<myOrder, String> {
    
}
