package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Product;
import com.example.webpos.model.Review;

public interface PosDB {


    public List<Product> getProducts();


    public Product getProduct(String productId);


    //修改一个商品
    public boolean setProduct(Product product);


    //lab7 api
    //关于评论的API
    public List<Review> getReviews();

    public List<Review> getSomereviews(String parent_asin);
    
}