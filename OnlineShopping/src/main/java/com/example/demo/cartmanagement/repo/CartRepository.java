package com.example.demo.cartmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cartmanagement.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
