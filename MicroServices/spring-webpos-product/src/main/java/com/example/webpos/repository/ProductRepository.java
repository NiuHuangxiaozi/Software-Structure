package com.example.webpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webpos.model.Product;



public interface ProductRepository extends JpaRepository<Product,String> {
}
