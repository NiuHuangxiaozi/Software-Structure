package com.example.webpos.biz;
import java.util.List;

import com.example.webpos.model.Category;
import com.example.webpos.model.Product;
import com.example.webpos.model.Setting;


public interface PosService {

    public List<Product> products();
    //add in lab4
    //获得商店的基本信息
    public List<Setting> getSettings();

    //获得所有的种类
    public List<Category> categories();

    //获得产品的具体信息
    public Product getProductById(String id);

    //将商品的库存减少多少
    public Boolean setStockOfProduct(int num,String productId);
}
