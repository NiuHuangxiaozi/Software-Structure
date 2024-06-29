package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Setting;

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
    public List<Product> products(){
        return posDB.getProducts();
    }

    //add in lab4
    public List<Setting> getSettings(){
        return this.posDB.getSettings();
    }

    //获取种类
    public List<Category> categories(){
        return this.posDB.getCategories();
    }

    //获得某个产品的信息
    public Product getProductById(String id){
        return posDB.getProduct(id);
    } 

    public Boolean setStockOfProduct(int num,String productId){
        Product item=posDB.getProduct(productId);
        if(item!=null){
            item.setQuantity(num);
            this.posDB.setProduct(item);
            return true;
        }
        else{
            return false;
        }
    }
}