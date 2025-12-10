package com.example.demo.shopmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.shopmanagement.entity.ShopEntity;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
}
