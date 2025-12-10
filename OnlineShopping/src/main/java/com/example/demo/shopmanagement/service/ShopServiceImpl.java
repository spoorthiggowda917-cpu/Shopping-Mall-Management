package com.example.demo.shopmanagement.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.shopmanagement.entity.ShopEntity;
import com.example.demo.shopmanagement.repo.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository repo;

    public ShopServiceImpl(ShopRepository repo) {
        this.repo = repo;
    }

    @Override
    public ShopEntity addShop(ShopEntity shop) {
        return repo.save(shop);
    }

    @Override
    public ShopEntity updateShop(ShopEntity shop) {
        return repo.save(shop);
    }

    @Override
    public ShopEntity searchShopById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ShopEntity> getAllShops() {
        return repo.findAll();
    }

    @Override
    public boolean deleteShop(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addEmployee(Long shopId, Long employeeId) {
        ShopEntity shop = repo.findById(shopId).orElse(null);
        if (shop == null) return false;

        shop.setShopEmployeeId(employeeId);
        repo.save(shop);
        return true;
    }

    @Override
    public boolean addItem(Long shopId, Long itemId) {
        // No item field in entity but kept for PDF requirement
        return repo.existsById(shopId);
    }
}
