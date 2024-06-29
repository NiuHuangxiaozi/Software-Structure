package com.example.webpos.biz;
import java.util.List;

import com.example.webpos.model.Cart;
import com.example.webpos.model.Product;


public interface PosService {
    public Cart getCart();
    public List<Product> products();

    public void checkout(Cart cart);

    public double total();
    public double realPrice();
    public double discount();

    public boolean add(Product product, int amount);

    public boolean add(String productId, int amount);
    

    //add my interface
    public boolean remove(String productId,int amount);
    public boolean empty_cart();

    public boolean removeCartItem(String productId);

    
}
