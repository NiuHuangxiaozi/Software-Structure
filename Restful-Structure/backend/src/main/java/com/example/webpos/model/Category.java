package com.example.webpos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;




@Data
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    int id;
    String name;
    Category(){
        
    }
}
