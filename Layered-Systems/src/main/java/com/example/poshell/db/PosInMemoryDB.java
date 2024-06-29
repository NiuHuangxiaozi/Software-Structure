package com.example.poshell.db;

import com.example.poshell.model.Cart;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PosInMemoryDB implements PosDB {
    private List<Item> inventory = new ArrayList<>();
    private List<Product> products=new ArrayList<>();
    private Cart cart;

    @Override
    public List<Item> getItems() {
        return inventory;
    }

    @Override
    public Cart saveCart(Cart cart) {
        this.cart = cart;
        return this.cart;
    }

    @Override
    public Cart getCart() {
        return this.cart;
    }

    @Override
    public Item getItem(String productId) {
        for (Item p : getItems()) {
            if (p.getProduct().getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }
    @Override
    public boolean removeItem(String productId,int amount)
    {
        for (Item p : getItems()) {
            if (p.getProduct().getId().equals(productId)) 
            {
                if(p.getAmount()>amount){
                    p.setAmount(p.getAmount()-amount);
                    return true;
                }
                else if(p.getAmount()==amount){
                    this.getItems().remove(p);
                    return true;
                }
                else 
                    return false;
            }
        }
        return false;
    }
    @Override
    public boolean addItem(String productId,int amount)
    {
        for (Item p : getItems()) 
        {
            if (p.getProduct().getId().equals(productId))
            {
                p.setAmount(p.getAmount()+amount);
                return true;
            } 
        }
        for (Product product:products)
        {
            if (product.getId().equals(productId)){
                this.getItems().add(new Item(new Product(productId, product.getName(), product.getPrice()), amount));
                return true;
            }
        }
        return false;
}
    private PosInMemoryDB() {
        this.inventory.add(new Item(new Product("PD1", "iPhone 15", 8999),10));
        this.inventory.add(new Item(new Product("PD2", "MacBook Pro", 29499),5));

        this.products.add(new Product("PD1","iPhone 15" , 8999));
        this.products.add(new Product("PD2","MacBook Pro" , 29499));

    }


    //add my function 


}
