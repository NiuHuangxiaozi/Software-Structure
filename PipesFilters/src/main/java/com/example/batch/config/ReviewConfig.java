package com.example.batch.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.example.batch.model.Product;
import com.example.batch.model.Review;
import com.example.batch.model.preProduct;
import com.example.batch.model.preReview;
import com.example.batch.service.JsonFileItemReader;
import com.example.batch.service.ProductProcessor;
import com.example.batch.service.reviewItemProcessor;
import com.example.batch.service.reviewItemReader;





@Configuration
@EnableBatchProcessing
public class ReviewConfig {
    

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;


    @Bean
    public reviewItemReader reader() {
        return new reviewItemReader("src/main/resources/data/Reviews.jsonl");
    }

    @Bean
    public ItemProcessor<preReview, Review> itemProcessor() {
        return new reviewItemProcessor();  
    }


    @Bean
    public JdbcBatchItemWriter<Review> reviewh2Writer() {
        String sqlcmd="(rating, title, text, image, asin, parentasin, userid)";
        String inputs="(:rating, :title, :text, :image, :asin, :parentasin, :userid)";
        return new JdbcBatchItemWriterBuilder<Review>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO Review " + sqlcmd + " VALUES "+ inputs)
                .dataSource(dataSource)
                .build();
    }

    @Bean
    protected Step processReviews() {
        return stepBuilderFactory.get("reviewTask1")
                .<preReview, Review>chunk(20)
                .reader(reader())
                .processor(itemProcessor())
                .writer(reviewh2Writer())
                // .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job chunksJob() {
        return jobBuilderFactory
                .get("ReviewJob")
                .incrementer(new RunIdIncrementer())
                .flow(processReviews())
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
