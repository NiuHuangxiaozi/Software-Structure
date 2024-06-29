package com.example.webpos.biz;
import java.util.List;
import com.example.webpos.model.Product;


public interface PosService {

    public List<Product> products();
    //add in lab4


    //获得产品的具体信息
    public Product getProductById(String id);

    //将商品的库存设置多少
    public Boolean setStockOfProduct(int num,String productId);


    //对商品的数量增加修改
    public Boolean changeStockOfProduct(int num,String productId);
}
