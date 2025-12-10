package com.example.demo.cartmanagement.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private Long customerId;

    @ElementCollection
    private List<Long> itemIds;

    private double totalAmount;

    public CartEntity() {}

    public CartEntity(Long customerId, List<Long> itemIds, double totalAmount) {
        this.customerId = customerId;
        this.itemIds = itemIds;
        this.totalAmount = totalAmount;
    }

    public Long getCartId() {
        return cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
