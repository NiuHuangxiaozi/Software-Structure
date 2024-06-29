package com.example.poshell.biz;

import com.example.poshell.db.PosDB;
import com.example.poshell.model.Cart;
import com.example.poshell.model.Item;
import com.example.poshell.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public Cart newCart() {
        return posDB.saveCart(new Cart());
    }

    @Override
    public void checkout(Cart cart) 
    {

        this.getCart().empty();

    }

    @Override
    public void total(Cart cart) {

    }

    @Override
    public boolean add(Product product, int amount) {
        return false;
    }
//加入购物车
    @Override
    public boolean add(String productId, int amount) {

        Item item = posDB.getItem(productId);
        if (item == null) return false;
        //修改库存
        if(posDB.removeItem(productId, amount)){
            System.err.println(amount);
            this.getCart().addItem(new Item(item.getProduct(), amount));
            return true;
        }
        else
            return false;
    }
    @Override
    public List<Item> items() {
        return posDB.getItems();
    }

    //all my code
    //从购物车删除
    @Override
    public boolean remove(String productId,int amount)
    {
        //判断有没有这个商品
         if(this.getCart().removeItem(productId,amount))
         {
            if(posDB.addItem(productId, amount)){
                return true;
            }
            else
                return false;
         }
         return false;
    }

    @Override
    public boolean empty_cart()
    {
        for(Item i:this.getCart().getItems())
        {
            if(posDB.addItem(i.getProduct().getId(), i.getAmount()))
                continue;
            else
                return false; 
        }
        this.getCart().empty();
        return true;
    }

}
