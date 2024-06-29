package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Cart;
import com.example.webpos.model.Item;
import com.example.webpos.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;





@Service
@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }
    @Override
    public Cart getCart() {
        return posDB.getCart();
    }
    @Override
    public List<Product> products(){
        return posDB.getProducts();
    }

    @Override
    public void checkout(Cart cart) 
    {
       posDB.emptyCart();
    }

    @Override
    public double total() {
        double totalPrice=0.0;
        Cart c=this.getCart();
        for(Item item:c.getItems()){
            totalPrice+=item.getProduct().getPrice()*item.getQuantity();
        }
        return totalPrice;
    }
    @Override
    public double realPrice(){
        double current_count=discount();
        double totalCost=total();
        double tax=posDB.getTax();
        return  totalCost*tax+totalCost*current_count;
    }
    @Override
    public double discount(){
        int item_number=0;
        Cart c=this.getCart();
        for(Item item:c.getItems()){
            item_number+=item.getQuantity();
        }
        if(item_number<2){
            return 1.0;
        }
        else if(item_number<5)
            return 0.9;
        else if(item_number<7)
            return 0.7;
        else if(item_number<10)
            return 0.5;
        else{
            return 0.4;
        }
    }

    @Override
    public boolean add(Product product, int amount) {
        return false;
    }
    //加入购物车
    @Override
    public boolean add(String productId, int amount) {
        if(posDB.addItem(productId, amount))
            return true;
        else{
            return false;
        }
    }
    //all my code
    //从购物车删除
    @Override
    public boolean remove(String productId,int amount){
        if(posDB.subItem(productId, amount)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean empty_cart()
    {
        posDB.emptyCart();
        return true;
    }
    @Override
    public boolean removeCartItem(String productId){
        posDB.deleteItem(productId);
        return true;
    }
}