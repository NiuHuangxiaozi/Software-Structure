package com.example.webpos.model;




import jakarta.persistence.Entity;
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

    private int stock; //判断是否启用内存
    private int category; //产品的类别

    private int quantity; //商品的数量


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
