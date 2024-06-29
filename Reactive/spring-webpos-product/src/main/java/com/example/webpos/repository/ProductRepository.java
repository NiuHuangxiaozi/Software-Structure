package com.example.webpos.repository;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.webpos.model.Product;

@Configuration
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {
    
}
