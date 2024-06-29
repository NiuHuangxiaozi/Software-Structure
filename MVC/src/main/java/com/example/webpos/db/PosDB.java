package com.example.webpos.db;

import java.util.List;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;

public interface PosDB {


    public List<Product> getProducts();

    public Cart getCart();

    public Product getProduct(String productId);

    public boolean subItem(String productId,int amount);

    public boolean addItem(String productId,int amount);

    public void emptyCart();

    public boolean deleteItem(String productId);

    public double getTax();

}