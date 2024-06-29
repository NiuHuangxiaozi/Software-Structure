package com.example.batch.service;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.PathResource;

import com.example.batch.model.preReview;
import com.fasterxml.jackson.databind.ObjectMapper;

public class reviewItemReader extends FlatFileItemReader<preReview>{
    private String filepath;
    
    
    public reviewItemReader(String filepath) {
        this.filepath=filepath;

        this.setResource(new PathResource( this.filepath));

        this.setLineMapper(lineMapper());
    }


    private LineMapper<preReview> lineMapper() {

        final ObjectMapper objectMapper = new ObjectMapper();

        return (line, lineNumber) -> objectMapper.readValue(line,preReview.class);
    }
}
