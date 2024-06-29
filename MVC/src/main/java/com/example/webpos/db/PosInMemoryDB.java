package com.example.webpos.db;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;
import com.example.webpos.repository.CartItemRepository;
import com.example.webpos.repository.ProductRepository;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class PosInMemoryDB implements PosDB {
    
    private double tax;
    private CartItemRepository cartitem_repository; 
    private ProductRepository  product_repository;

    public  PosInMemoryDB(CartItemRepository c,ProductRepository p){
        this.tax=0.99;
        this.cartitem_repository=c;
        this.product_repository=p;
        product_repository.save(new Product("PD1","熨斗", 199, "1.jpg"));
        product_repository.save(new Product("PD2","搅拌机", 349, "2.jpg"));
        product_repository.save(new Product("PD3","coach包包", 1999, "3.jpg"));
        product_repository.save(new Product("PD4","iPhone 13", 8999, "4.jpg"));
        product_repository.save(new Product("PD5","折叠沙发", 14999, "5.jpg"));
        product_repository.save(new Product("PD6","迷你椅子", 99, "6.jpg"));
        product_repository.save(new Product("PD7","华为手表", 399, "7.jpg"));
        product_repository.save(new Product("PD8","苹果显示器", 5999, "comp.png"));
    }
    @Override 
    public double getTax(){
        return tax;
    }
    @Override
    public Cart getCart() 
    {
        List<Item> all_items=cartitem_repository.findAll();
        return  new Cart(all_items);
    }
    @Override
    public List<Product> getProducts(){
        List<Product> all_products=product_repository.findAll();
        return all_products;
    }
    @Override
    public boolean subItem(String productId,int amount){
        Optional<Item> item=cartitem_repository.findById(productId);
        if(item.isPresent()){
            if(item.get().getQuantity()>amount){
                cartitem_repository.save(new Item(item.get().getProduct(),item.get().getQuantity()-amount));
                return true;
            }
            else if(item.get().getQuantity()==amount){
                cartitem_repository.deleteById(productId);
                return true;
            }
            else{       
                return false;
            }
        }
        else
            return false;
    }
    @Override
    public boolean addItem(String productId,int amount){
        Optional<Product> product=product_repository.findById(productId);
        if(product.isPresent()){
            Optional<Item> item=cartitem_repository.findById(productId);
            if(item.isPresent()){
                cartitem_repository.save(new Item(product.get(),item.get().getQuantity()+amount));
            }
            else{
                cartitem_repository.save(new Item(product.get(),amount));
            }
            
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Product getProduct(String productId){
        Optional<Product> product=product_repository.findById(productId);
        return product.get();
    }

    @Override
    public void emptyCart(){
        cartitem_repository.deleteAll();
    }

    @Override
    public boolean deleteItem(String productId){
        Optional<Item> item=cartitem_repository.findById(productId);
        if(item.isPresent()){
            cartitem_repository.deleteById(productId);
        }
        return true;
    }
}
