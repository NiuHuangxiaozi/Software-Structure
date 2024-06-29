package com.example.webpos.model;


import org.hibernate.annotations.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
@AllArgsConstructor
public class Product {
    
    @Id
    private String id;

    private String name;
    private double price;
    private String image;

    Product(Product otherproduct){
        this.id=otherproduct.id;
        this.name=otherproduct.name;
        this.price=otherproduct.price;
        this.image=otherproduct.image;
    }
    public Product() {
    }
    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getPrice();
    }

}
