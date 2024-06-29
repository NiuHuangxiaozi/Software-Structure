package com.example.webpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webpos.model.Review;



public interface ReviewRepository extends JpaRepository<Review,Integer> {
 
}
