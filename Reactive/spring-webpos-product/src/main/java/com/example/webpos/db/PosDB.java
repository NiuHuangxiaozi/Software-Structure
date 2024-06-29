package com.example.webpos.db;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.webpos.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PosDB {


    public Flux<Product> getProducts();


    public Mono<Product> getProduct(String productId);

    public Flux<Product> getProductByName(String name);


    //修改一个商品
    public Mono<Void> setProduct(Product product);


    //设置一个商品的数量
    public Mono<ResponseEntity<Void>> setNumberOfProduct(String productId, int number);

    //增减一个商品的数量
    public Mono<ResponseEntity<Void>> changeNumberOfProduct(String productId, int number);


    
}