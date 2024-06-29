package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Setting;

public interface PosDB {


    public List<Product> getProducts();


    public Product getProduct(String productId);


    public double getTax();

    //add in lab4
    public List<Setting> getSettings();

    public List<Category> getCategories();

    //修改一个商品
    public boolean setProduct(Product product);
    
}