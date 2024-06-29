package com.example.batch.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class preProduct {

    private String main_category;

    private String title;

    private Double average_rating;

    private int rating_number;

    private List<String> features;

    private List<String> description;

    private Double price;

    private List<Map<String, String>> images;

    private List<Map<String, String>> videos;

    private String store;

    private List<String> categories;

    @JsonIgnore
    private Map<String,String> details;

    private String parent_asin;

    private List<String> bought_together;
}
