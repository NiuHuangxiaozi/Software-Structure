package com.example.webpos.controller;



import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Product;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;





@RestController
@CrossOrigin(originPatterns = "*")
public class ProductsController{

    private PosDB posDb;

    @Autowired
    public void setPosService(PosDB posDb) {
        this.posDb = posDb;
    }
    ////////////////////////////////////////////////////////////////////////////////





    @RequestMapping(value = "/products",method = RequestMethod.GET)
    public Flux<Product> listProducts(){
        //      return this.posDb.getProducts();
        return Mono.delay(Duration.ofMillis(50))
               .thenMany(this.posDb.getProducts());
    }


    @GetMapping("/products/name/{productName}")
    public Flux<Product> showProductsByName(@PathVariable("productName") String productName) {
        Flux<Product> tar_products=this.posDb.getProductByName(productName);
        return tar_products
                .doOnNext(product -> System.out.println("Found product: " + product));
    }

    
    @GetMapping("/products/id/{productId}")
    public Mono<Product> showProductById(@PathVariable("productId") String productId) {
            Mono<Product> product=this.posDb.getProduct(productId);
            return product
                       . doOnNext(pro -> System.out.println("Found product: " + pro));
    }




    //hold之后修改的商品数量
    ///products/{productId}:
    @PatchMapping(value = "/products/{productId}")
    public Mono<ResponseEntity<Void>> assignNumberOfProduct(@PathVariable("productId") String productId, @RequestBody String body) {
            JSONObject jsonObject = JSONUtil.parseObj(body);
            Integer num = jsonObject.getInt("quantity");

            return this.posDb.setNumberOfProduct(productId, num);
    }


    //商品增减数量
    @PutMapping(value = "/products/{productId}")
    public Mono<ResponseEntity<Void>> changeNumberofProduct(@PathVariable("productId") String productId, @RequestBody String body) {
            JSONObject jsonObject = JSONUtil.parseObj(body);
            Integer num = jsonObject.getInt("number");

            return this.posDb.changeNumberOfProduct(productId, num);
    }
}
