package com.example.webpos.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.webpos.biz.PosService;
import com.example.webpos.controller.api.ApiUtil;
import com.example.webpos.controller.api.ProductsApi;
import com.example.webpos.mapper.ProductMapper;
import com.example.webpos.mapper.ReviewMapper;
import com.example.webpos.model.Product;
import com.example.webpos.model.Review;
import com.example.webpos.model.dto.ProductDto;
import com.example.webpos.model.dto.ReviewDto;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(originPatterns = "*")
public class ProductsController implements ProductsApi{

    private PosService posService;
    private ProductMapper productMapper;
    private ReviewMapper reviewMapper;

    @Autowired
    public void setPosService(PosService posService,ProductMapper productmapper,ReviewMapper reviewmapper) {
        this.posService = posService;
        this.productMapper=productmapper;
        this.reviewMapper=reviewmapper;
    }

    

    ///////////////////////////////////////////////////////

    @Override
    public ResponseEntity<List<ProductDto>> listProducts(){

        List<Product> products = posService.products(); // 调用业务逻辑层获取所有产品
        if (products == null || products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        return new ResponseEntity<>(productMapper.toProductDtoList(products), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }


    @Override
    public ResponseEntity<ProductDto> showProductById(@PathVariable("productId") String productId) {
        Product product = posService.getProductById(productId);
        System.out.println(product);
        if (product != null) {
            return new ResponseEntity<>(productMapper.toProductDto(product),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //hold之后修改的商品数量
    @Override
    public ResponseEntity<Void> assignNumberOfProduct( @PathVariable("productId") String productId, @RequestBody String body) {
        //返回内容
        ResponseEntity<Void> response = null;

        //拿到剩余的数目
        JSONObject jsonObject = JSONUtil.parseObj(body.toString());
        Integer Num = Integer.parseInt(jsonObject.getStr("quantity").toString());
        int num=Num.intValue();

        //处理逻辑
        if(posService.setStockOfProduct(num,productId)){
            response = ResponseEntity.ok().build();
        }
        else{
            response = ResponseEntity.status(400).build();
        }
        return response;
    }


    //商品增减数量
    @Override
    public ResponseEntity<Void> changeNumberofProduct(@PathVariable("productId") String productId, @RequestBody String body) {
        //返回内容
        ResponseEntity<Void> response = null;
        System.out.println(body);

        //拿到剩余的数目
        JSONObject jsonObject = JSONUtil.parseObj(body.toString());
        Integer Num = Integer.parseInt(jsonObject.getStr("number").toString());
        int num=Num.intValue();


        if(posService.changeStockOfProduct(num,productId)){
            response = ResponseEntity.ok().build();
        }
        else{
            response = ResponseEntity.status(400).build();
        }
        return response;
    }



    //lab7 begin
    @Override
    public ResponseEntity<List<ReviewDto>> listReviews() {
        
        List<Review> reviews = posService.reviews(); // 调用业务逻辑层获取所有产品

        if (reviews == null || reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        return new ResponseEntity<>(reviewMapper.toReviewDtoList(reviews), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }

    @Override
    public ResponseEntity<List<ReviewDto>> showReviewsById( @PathVariable("productId") String productId) {
        List<Review> tar_reviews = posService.getSomereviews(productId);
        if (tar_reviews == null || tar_reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 如果没有产品，返回无内容状态
        }
        return new ResponseEntity<>(reviewMapper.toReviewDtoList(tar_reviews), HttpStatus.OK); // 返回DTO列表和HTTP状态OK
    }
}
