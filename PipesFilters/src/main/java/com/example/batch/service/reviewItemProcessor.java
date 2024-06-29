package com.example.batch.service;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;


import com.example.batch.model.Review;
import com.example.batch.model.preReview;
import com.fasterxml.jackson.databind.ObjectMapper;

public class reviewItemProcessor  implements ItemProcessor<preReview, Review>, StepExecutionListener{

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
    public Review process(preReview pro) throws Exception {
        // System.out.println("开始处理！");

        

        String title="默认名称";
        if(pro.getTitle()!=null)
            title=pro.getTitle().substring(0,Math.min(150,pro.getTitle().length()));

        String text="用户没有任何评价！";
        if(pro.getText()!=null)
            text=pro.getText().substring(0,Math.min(150,pro.getText().length()));


        String image="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg";
        if(pro.getImages().size()>0 && pro.getImages().get(0).get("small")!=null)
                image=pro.getImages().get(0).get("small");
        
        String asin="123";
        if(pro.getAsin()!=null)
                asin=pro.getAsin();
        String user_id="xiaohuangniu";
        if(pro.getUser_id()!=null)
            user_id=pro.getUser_id();

        Review review=new Review(pro.getRating(),title,text,image,asin,pro.getParent_asin(),user_id);

        index++;
        System.out.println("@"+String.valueOf(index)+"@");
        System.out.println(review);
        return review;
    }
}
