package com.example.webpos.db;
import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Setting;
import com.example.webpos.repository.CategoryRepository;
import com.example.webpos.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


public class PosInMemoryDB implements PosDB {
    

    private ProductRepository  product_repository;

    private CategoryRepository category_repository;

    @Autowired
    private List<Setting> Settings;

    public  PosInMemoryDB(ProductRepository p, CategoryRepository cate){
        this.product_repository=p;
        this.category_repository=cate;

        //初始化数据库
        product_repository.save(new Product("PD1","熨斗", 199, "iron.jpg",1,2,10));
        product_repository.save(new Product("PD2","搅拌机", 349, "mixer.jpg",1,2,5));
        product_repository.save(new Product("PD3","coach包包", 1999, "bag.jpg",1,3,8));
        product_repository.save(new Product("PD4","iPhone 13", 8999, "iphone.jpg",1,0,5));
        product_repository.save(new Product("PD5","折叠沙发", 14999, "sofa.jpg",1,1,3));
        product_repository.save(new Product("PD6","迷你椅子", 99, "deckchair.jpg",1,1,10));
        product_repository.save(new Product("PD7","华为手表", 399, "watch.jpg",1,0,4));
        product_repository.save(new Product("PD8","苹果显示器", 5999, "computer.png",1,0,7));
    }

    @PostConstruct
    public void init(){
         //添加shop信息
         this.Settings.set(0,new Setting("$", true, 30,"settings.jpg", "教育超市", "上海市静安区教育大厦", "美国弗吉尼亚","15190785634","版权所有"));
    }

    //////////////////////////////////////////////////////////

    @Override
    public List<Product> getProducts(){
        List<Product> all_products=product_repository.findAll();
        return all_products;
    }
    @Override
    public Product getProduct(String productId){
        System.out.println("asass"+productId);
        Optional<Product> product=product_repository.findById(productId);
        return product.get();

    }

    //add in lab4 
    public List<Setting> getSettings(){
        return this.Settings;
    }

    public List<Category> getCategories(){
        List<Category> all_categories=this.category_repository.findAll();
        return all_categories;
    }

    public boolean setProduct(Product product){
        String Id=product.getId();
        Optional<Product> pro=product_repository.findById(Id);
        if(pro.isPresent()){
            product_repository.save(product);
            return true;
        }
        else{
            return false;
        }
    }
}
