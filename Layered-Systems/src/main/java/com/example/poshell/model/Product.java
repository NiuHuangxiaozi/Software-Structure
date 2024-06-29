package com.example.poshell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private double price;

    @Override
    public String toString() {
        return getId() + "\t" + getName() + "\t" + getPrice();
    }
}
