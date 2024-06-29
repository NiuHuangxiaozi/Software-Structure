package com.example.webpos.model;




import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name = "PIPPRODUCT")
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


    Product(Product otherproduct){
        this.id=otherproduct.id;
        this.name=otherproduct.name;
        this.price=otherproduct.price;
        this.image=otherproduct.image;
        this.stock=1;
        this.quantity=otherproduct.quantity;
        this.maincategory=otherproduct.maincategory;
        this.averagerating=otherproduct.averagerating;
        this.ratingnumber=otherproduct.ratingnumber;
        this.features=otherproduct.features;
        this.store=otherproduct.store;
    }
    public Product() {
    }


    public void changeQuantity(int changenumber){
        quantity=quantity+changenumber;
    }
    
    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getPrice();
    }

}
