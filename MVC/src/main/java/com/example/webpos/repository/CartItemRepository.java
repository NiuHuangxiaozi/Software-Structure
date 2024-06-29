package com.example.webpos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webpos.model.Item;



public interface CartItemRepository extends JpaRepository<Item,String> 
{
}
