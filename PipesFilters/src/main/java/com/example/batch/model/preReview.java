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
public class preReview {


    private Double rating;
    
    private String title;

    private String text;

    private List<Map<String, String>> images;

    private String asin;

    private String parent_asin;

    private String user_id;

    @JsonIgnore
    private int timestamp;

    @JsonIgnore
    private boolean verified_purchase;

    @JsonIgnore
    private int helpful_vote;
}
