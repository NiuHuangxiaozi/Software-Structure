package com.example.webpos.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "REVIEW")
@AllArgsConstructor
public class Review {
    
    @Id
    private int id;

    private Double rating;
    
    private String title;

    private String text;

    private String image;

    private String asin;

    private String parentasin;
    
    private String userid;
    
    public Review() {
    }
}
