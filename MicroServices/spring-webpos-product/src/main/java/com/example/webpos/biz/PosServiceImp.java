package com.example.webpos.biz;

import com.example.webpos.db.PosDB;
import com.example.webpos.model.Product;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;





@Service
@Component
public class PosServiceImp implements PosService {

    private PosDB posDB;

    //设置断路器
    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;




    @Autowired
    public void setPosDB(PosDB posDB) {
        this.posDB = posDB;
    }
    
    @Override
    public List<Product> products(){
        CircuitBreaker circuitbreaker=circuitBreakerFactory.create("circuitbreaker");

        return circuitbreaker.run(()->posDB.getProducts(),throwable->getDefaultProduct());
    }


    private List<Product> getDefaultProduct(){
            List<Product> temp=new ArrayList<>();
            temp.add(new Product("PD0","出错", 199, "src/assets/propictures/1.jpg",1,100));
            return temp;
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


    //在lab6中使用
    public Boolean changeStockOfProduct(int changenumber,String productId){
        Product item=posDB.getProduct(productId);
        if(item!=null){
            //修改数量
            item.changeQuantity(changenumber);

            //修改商品数据库
            this.posDB.setProduct(item);
            return true;
        }
        else{
            return false;
        }
    }
}