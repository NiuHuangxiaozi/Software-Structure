package com.example.batch.service;

import com.example.batch.model.Product;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

public class ProductWriter implements ItemWriter<Product>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        // System.err.println("处理完毕");
        return null;
    }

    @Override
    public void write(List<? extends Product> list) throws Exception {
        // System.err.println("==========================");
        //             for (Product product : list) {
        //                 System.out.println(product);
        //             }
        // //    list.stream().forEach(System.out::println);
        //    System.out.println("chunk written");
           
        // System.err.println("==========================");


        String outputfile = "src/output.txt";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputfile,true)));
        for (Product product : list) {
            
            out.write(product+"\n");          
        }
        out.close();
    }
}
