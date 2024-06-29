package com.example.webpos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Item {


    @Id
    private String id;

    @OneToOne
    private Product product;
    private int quantity;
    public Item(){
        
    }
    public Item(Product product,int quantity){
        this.product=new Product(product);
        this.quantity=quantity;
        this.id=this.product.getId();
    }
    @Override
    public String toString() {
        return product.toString() + "\t" + quantity;
    }
}
