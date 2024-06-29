package com.example.batch.config;

import com.example.batch.model.Product;
import com.example.batch.model.Review;
import com.example.batch.model.preProduct;
import com.example.batch.service.JsonFileItemReader;
import com.example.batch.service.ProductProcessor;
import com.example.batch.service.ProductWriter;
import com.fasterxml.jackson.databind.JsonNode;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


// @Configuration
// @EnableBatchProcessing
public class BatchConfig {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;


    @Bean
    public JsonFileItemReader reader() {
        return new JsonFileItemReader("src/main/resources/data/Products.jsonl");
    }

    @Bean
    public ItemProcessor<preProduct, Product> itemProcessor() {
        return new ProductProcessor();  
    }




    ///////////////////////////////////////////////
    @Bean
    public ItemWriter<Product> itemWriter() {
        return new ProductWriter();
    }

    @Bean
    public JdbcBatchItemWriter<Product> h2Writer() {
        String sqlcmd="(id, name, price, image, stock, quantity, maincategory, averagerating, ratingnumber, features, store)";
        String inputs="(:id, :name, :price, :image, :stock, :quantity, :maincategory, :averagerating, :ratingnumber, :features, :store)";
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO Pipproduct " + sqlcmd + " VALUES "+ inputs)
                .dataSource(dataSource)
                .build();
    }
    ///////////////////////////////////////////////


    @Bean
    protected Step processProducts() {
        return stepBuilderFactory.get("task41")
                .<preProduct, Product>chunk(1)
                .reader(reader())
                .processor(itemProcessor())
                .writer(h2Writer())
                // .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job chunksJob() {
        return jobBuilderFactory
                .get("chunksJob")
                .incrementer(new RunIdIncrementer())
                .flow(processProducts())
                .end()
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(10);
        return executor;
    }

}
