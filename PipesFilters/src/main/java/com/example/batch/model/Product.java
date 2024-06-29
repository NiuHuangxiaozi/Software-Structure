package com.example.batch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
// @Table(name = "temp")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Product {

    @Id
    private String id; //唯一的ID，对应parent_asin

    private String name;  //商品的名称,对应title

    private double price; //对应price
    
    private String image; //对应images里面的thumb

    private int stock; //自己设置为1

    private int quantity; //商品的数量，自己设置为10



    //下面是商品额外的属性
    private String maincategory;

    private Double averagerating;

    private int ratingnumber;

    private String features;

    private String store;
}
