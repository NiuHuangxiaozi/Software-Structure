package com.example.batch.config;

import com.example.batch.model.Product;
import com.example.batch.model.preProduct;
import com.example.batch.service.JsonFileItemReader;
import com.example.batch.service.ProductProcessor;
import com.example.batch.service.ProductWriter;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.partition.PartitionHandler;
import org.springframework.batch.core.partition.support.MultiResourcePartitioner;
import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.core.partition.support.TaskExecutorPartitionHandler;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


// @Configuration
// @EnableBatchProcessing
public class PartitionConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;


    @Bean
    public Job partitioningJob() throws Exception {
        return jobBuilderFactory
                .get("partitioningJob")
                .incrementer(new RunIdIncrementer())
                .flow(masterStep())
                .end()
                .build();
    }

    @Bean
    public Step masterStep() throws Exception {
        return stepBuilderFactory
                .get("masterStep1")
                // .partitioner(slaveStep())
                .partitioner("partition", partitioner())
                .partitionHandler(partitionHandler())
                // .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Partitioner partitioner() {
        return gridSize -> {
            Map<String, ExecutionContext> partitionMap = new HashMap<>();
            for (int i = 1; i <= gridSize; i++) {
                ExecutionContext context = new ExecutionContext();
                context.putString("fileName","src/main/resources/meta_All_Beauties/meta_All_Beauty (" + i + ").txt");
                partitionMap.put("partition" + i, context);
            }
            return partitionMap;
        };
    }
    
    @Bean
    public PartitionHandler partitionHandler() throws Exception {
        TaskExecutorPartitionHandler handler = new TaskExecutorPartitionHandler();
        handler.setTaskExecutor(taskExecutor());
        handler.setStep(slaveStep());
        handler.setGridSize(113); // Adjust this to the number of files you have
        return handler;
    }

    @Bean
    public Step slaveStep() throws Exception {
        return stepBuilderFactory.get("task23")
                .<preProduct, Product>chunk(20)
                .reader(itemReader(null))
                .processor(itemProcessor())
                .writer(h2Writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    @StepScope
    public JsonFileItemReader itemReader(@Value("#{stepExecutionContext['fileName']}") String fileName) {
        // System.err.println(fileName);
        return new JsonFileItemReader(fileName);
    }


    @Bean
    public ItemProcessor<preProduct, Product> itemProcessor() {
        return new ProductProcessor();
    }
    


    /////////////////////////////////////////////////////////
    @Bean
    public ItemWriter<Product> itemWriter() {
        return new ProductWriter();
    }
    @Bean
    public JdbcBatchItemWriter<Product> h2Writer() {
        String sqlcmd="(id, name, price, image, stock, quantity, main_category, average_rating, rating_number, features, store)";
        String inputs="(:id, :name, :price, :image, :stock, :quantity, :main_category, :average_rating, :rating_number, :features, :store)";
        return new JdbcBatchItemWriterBuilder<Product>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO Pipproduct " + sqlcmd + " VALUES "+ inputs)
                .dataSource(dataSource)
                .build();
    }
    ////////////////////////////////////////////////////////


    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(300);
        executor.setQueueCapacity(200);
        return executor;
    }

}
