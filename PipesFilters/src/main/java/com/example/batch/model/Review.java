package com.example.batch.model;

import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
// @Table(name = "temp")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Review {
    
    private Double rating;
    
    private String title;

    private String text;

    private String image;

    @Id
    private String asin;

    private String parentasin;
    
    private String userid;  
}
