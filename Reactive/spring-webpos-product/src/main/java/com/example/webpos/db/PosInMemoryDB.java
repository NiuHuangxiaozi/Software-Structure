package com.example.webpos.db;
import com.example.webpos.model.Product;

import com.example.webpos.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PosInMemoryDB implements PosDB {

    private ProductRepository  product_repository;

    public  PosInMemoryDB(ProductRepository p){

        this.product_repository=p;

        List<Product> pros=new ArrayList<>();
        pros.add(new Product("PD1","熨斗", 199, "src/assets/propictures/1.jpg",1,10));
        pros.add(new Product("PD2","搅拌机", 349, "src/assets/propictures/2.jpg",1,5));
        pros.add(new Product("PD3","coach包包", 1999, "src/assets/propictures/3.jpg",1,8));
        pros.add(new Product("PD4","iPhone 13", 8999, "src/assets/propictures/4.jpg",1,5));
        pros.add(new Product("PD5","折叠沙发", 14999, "src/assets/propictures/5.jpg",1,3));
        pros.add(new Product("PD6","迷你椅子", 99, "src/assets/propictures/6.jpg",1,10));
        pros.add(new Product("PD7","华为手表", 399, "src/assets/propictures/7.jpg",1,4));
        pros.add(new Product("PD8","苹果显示器", 5999, "src/assets/propictures/comp.png",1,7));


        // pros.add(new Product("PD9","iPhone 12", 8999, "src/assets/propictures/4.jpg",1,12));

        // pros.add(new Product("PD10","iPhone 11", 8999, "src/assets/propictures/4.jpg",1,11));

        // pros.add(new Product("PD11","iPhone 10", 8999, "src/assets/propictures/4.jpg",1,10));

        Flux<Product> eight = product_repository.saveAll(pros);
        eight.subscribe(
            product -> {
                // 每个产品访问成功时的逻辑
                System.out.println("Product saved: " + product);
            },
            error -> {
                // 处理保存过程中的错误
                System.err.println("Error saving product: " + error.getMessage());
            },
            () -> {
                // 所有产品保存完成后的逻辑
                System.out.println("All products save successfully.");
            }
        );
    }


    ///////////////////////////////////////////////////////////

    @Override
    public Flux<Product> getProducts(){

        Flux<Product> all_products=product_repository.findAll();

        return all_products;
    }



    @Override
    public Mono<Product> getProduct(String productId){
        System.out.println("The product id is "+productId);

        Mono<Product> product=product_repository.findById(productId);
        return product;

    }

    @Override
    public Flux<Product> getProductByName(String name){
        System.out.println("The product search name  is "+name);

        Flux<Product> products=product_repository.findAll();
        
        return products
                .filter(product -> product.getName().contains(name))
                .collectList()  // Collect the filtered products into a List
                .flatMapMany(Flux::fromIterable);  // Convert the List back to a Flux
    }


    @Override
    public Mono<Void> setProduct(Product product) {
            String id = product.getId();
    
            return product_repository.findById(id)
                    .flatMap(existingProduct -> {
                            return product_repository.save(product).then();
            })
                    .switchIfEmpty( 
                            product_repository.save(product).then()
            );
    }


    //设置一个商品的数量
    public Mono<ResponseEntity<Void>> setNumberOfProduct(String productId, int number){
        return this.product_repository.findById(productId)
                    .doOnNext(product->System.out.println("setNumber: "+product))
                    .flatMap(product -> {
                            product.setQuantity(number); // 设置商品数量
                            return this.product_repository.save(product).then(Mono.just(ResponseEntity.ok().<Void>build()));
                    })
                    .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    //增减一个商品的数量
    public Mono<ResponseEntity<Void>> changeNumberOfProduct(String productId, int number){
        return this.product_repository.findById(productId)
                    .flatMap(product -> {
                            int origin_number=product.getQuantity();
                            product.setQuantity(origin_number+number); // 设置商品数量
                            return this.product_repository.save(product).then(Mono.just(ResponseEntity.ok().<Void>build()));
                    })
                    .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
