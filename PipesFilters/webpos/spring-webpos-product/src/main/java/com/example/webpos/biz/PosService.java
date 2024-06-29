package com.example.webpos.biz;
import java.util.List;
import com.example.webpos.model.Product;
import com.example.webpos.model.Review;


public interface PosService {

    public List<Product> products();
    //add in lab4


    //获得产品的具体信息
    public Product getProductById(String id);

    //将商品的库存设置多少
    public Boolean setStockOfProduct(int num,String productId);


    //对商品的数量增加修改
    public Boolean changeStockOfProduct(int num,String productId);



    //关于评论的API
    public List<Review> reviews();

    public List<Review> getSomereviews(String parent_asin);
}
