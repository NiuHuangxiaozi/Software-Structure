package com.example.poshell.db;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;

import java.util.List;

public interface PosDB {

    public List<Item> getItems();

    public Cart saveCart(Cart cart);

    public Cart getCart();

    public Item getItem(String productId);

    public boolean removeItem(String productId,int amount);

    public boolean addItem(String productId,int amount);
}
