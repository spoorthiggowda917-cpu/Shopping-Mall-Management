package com.example.demo.cartmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cartmanagement.entity.CartEntity;
import com.example.demo.cartmanagement.repo.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartEntity addItemToCart(Long cartId, Long itemId, double price) {
        CartEntity cart = cartRepository.findById(cartId).orElse(new CartEntity());
        if (cart.getItemIds() == null) cart.setItemIds(new ArrayList<>());

        cart.getItemIds().add(itemId);
        cart.setTotalAmount(cart.getTotalAmount() + price);

        return cartRepository.save(cart);
    }

    @Override
    public CartEntity viewCart(Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public CartEntity updateItem(Long cartId, Long itemId, int quantity, double price) {
        CartEntity cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) return null;

        List<Long> items = cart.getItemIds();
        items.removeIf(id -> id.equals(itemId));

        for (int i = 0; i < quantity; i++) items.add(itemId);

        cart.setItemIds(items);
        cart.setTotalAmount(quantity * price);

        return cartRepository.save(cart);
    }

    @Override
    public CartEntity removeItem(Long cartId, Long itemId) {
        CartEntity cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) return null;

        cart.getItemIds().removeIf(id -> id.equals(itemId));

        return cartRepository.save(cart);
    }

    @Override
    public CartEntity clearCart(Long cartId) {
        CartEntity cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) return null;

        cart.setItemIds(new ArrayList<>());
        cart.setTotalAmount(0);

        return cartRepository.save(cart);
    }
}
