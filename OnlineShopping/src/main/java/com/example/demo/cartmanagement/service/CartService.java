package com.example.demo.cartmanagement.service;

import com.example.demo.cartmanagement.entity.CartEntity;

public interface CartService {

    CartEntity addItemToCart(Long cartId, Long itemId, double price);

    CartEntity viewCart(Long cartId);

    CartEntity updateItem(Long cartId, Long itemId, int quantity, double price);

    CartEntity removeItem(Long cartId, Long itemId);

    CartEntity clearCart(Long cartId);
}
