package com.example.batch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;

import org.springframework.core.io.PathResource;

import com.example.batch.model.preProduct;


public class JsonFileItemReader extends FlatFileItemReader<preProduct> {

    private String filepath;
    public JsonFileItemReader(String filepath) {
        this.filepath=filepath;
        this.setResource(new PathResource( this.filepath));
        this.setLineMapper(lineMapper());
    }

    private LineMapper<preProduct> lineMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        return (line, lineNumber) -> objectMapper.readValue(line,preProduct.class);
    }
}