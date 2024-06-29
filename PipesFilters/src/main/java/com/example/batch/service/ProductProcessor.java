package com.example.batch.service;

import com.example.batch.model.Product;
import com.example.batch.model.preProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<preProduct, Product>, StepExecutionListener {

    private ObjectMapper objectMapper;
    private int index=0;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public Product process(preProduct pro) throws Exception {
        // System.out.println("开始处理！");

        

        String name="默认名字";
        if(pro.getTitle()!=null)
            name=pro.getTitle().substring(0,Math.min(150,pro.getTitle().length()));

        Double tar_price=20.0;
        if(pro.getPrice()!=null)
            tar_price=pro.getPrice();


        String imageUrl="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg";
        if(pro.getImages().size()>0 && pro.getImages().get(0).get("thumb")!=null)
            imageUrl=pro.getImages().get(0).get("thumb");

        int stock=1;
        int quantity=10;

        String main_category="暂无类别";
        if(pro.getMain_category()!=null)
            main_category=pro.getMain_category();

        String tar_feaures="【没有任何特征！】";

        if(pro.getFeatures()!=null && pro.getFeatures().size()!=0)
            tar_feaures=pro.getFeatures().get(0).substring(0,Math.min(150,pro.getFeatures().get(0).length()));

        String tar_store="教育超市";
        
        if(pro.getStore()!=null)
            tar_store=pro.getStore();

        Product product=new Product(pro.getParent_asin(), 
                                    name, 
                                    tar_price,
                                    imageUrl, 
                                    stock,
                                    quantity, 
                                    main_category,
                                    pro.getAverage_rating(), 
                                    pro.getRating_number(),
                                    tar_feaures,
                                    tar_store);



        index++;
        // System.out.println("@"+String.valueOf(index)+"@");
        // System.out.println(product);
        
        return product;
    }
}
