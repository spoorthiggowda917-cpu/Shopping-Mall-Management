package com.example.demo.shopmanagement.service;

import java.util.List;
import com.example.demo.shopmanagement.entity.ShopEntity;

public interface ShopService {

    ShopEntity addShop(ShopEntity shop);

    ShopEntity updateShop(ShopEntity shop);

    ShopEntity searchShopById(Long id);

    List<ShopEntity> getAllShops();

    boolean deleteShop(Long id);

    boolean addEmployee(Long shopId, Long employeeId);

    boolean addItem(Long shopId, Long itemId);
}
