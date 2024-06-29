package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Product;

public interface PosDB {


    public List<Product> getProducts();


    public Product getProduct(String productId);


    public double getTax();


    //修改一个商品
    public boolean setProduct(Product product);
    
}