package com.example.demo.shopmanagement.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.shopmanagement.entity.ShopEntity;
import com.example.demo.shopmanagement.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ShopEntity addShop(@RequestBody ShopEntity shop) {
        return service.addShop(shop);
    }

    @PutMapping("/update")
    public ShopEntity updateShop(@RequestBody ShopEntity shop) {
        return service.updateShop(shop);
    }

    @GetMapping("/get/{id}")
    public ShopEntity getShop(@PathVariable("id") Long id) {
        return service.searchShopById(id);
    }

    @GetMapping("/all")
    public List<ShopEntity> getAllShops() {
        return service.getAllShops();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteShop(@PathVariable("id") Long id) {
        return service.deleteShop(id) ? "Deleted" : "Not Found";
    }

    @PutMapping("/{shopId}/add-employee/{employeeId}")
    public String addEmployee(@PathVariable("shopId") Long shopId,
                              @PathVariable("employeeId") Long employeeId) {
        return service.addEmployee(shopId, employeeId) ? "Employee Added" : "Shop Not Found";
    }

    @PutMapping("/{shopId}/add-item/{itemId}")
    public String addItem(@PathVariable("shopId") Long shopId,
                          @PathVariable("itemId") Long itemId) {
        return service.addItem(shopId, itemId) ? "Item Added" : "Shop Not Found";
    }
}
