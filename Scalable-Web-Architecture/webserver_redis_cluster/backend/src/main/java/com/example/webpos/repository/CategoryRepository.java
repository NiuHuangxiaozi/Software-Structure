package com.example.webpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webpos.model.Category;






public interface CategoryRepository extends JpaRepository<Category,Integer> {
    
}
