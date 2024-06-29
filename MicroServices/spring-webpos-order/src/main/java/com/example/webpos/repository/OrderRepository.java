package com.example.webpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webpos.model.myOrder;

public interface OrderRepository extends JpaRepository<myOrder,String> {
    
}
