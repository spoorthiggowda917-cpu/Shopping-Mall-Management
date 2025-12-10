package com.example.demo.cartmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cartmanagement.entity.CartEntity;
import com.example.demo.cartmanagement.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // Add item to cart
    @PostMapping("/add/{cartId}/{itemId}/{price}")
    public CartEntity addItem(@PathVariable("cartId") Long cartId,
                              @PathVariable("itemId") Long itemId,
                              @PathVariable("price") double price) {
        return cartService.addItemToCart(cartId, itemId, price);
    }

    // View cart
    @GetMapping("/{cartId}")
    public CartEntity viewCart(@PathVariable("cartId") Long cartId) {
        return cartService.viewCart(cartId);
    }

    // Update item quantity or price
    @PutMapping("/update/{cartId}/{itemId}/{quantity}/{price}")
    public CartEntity updateItem(@PathVariable("cartId") Long cartId,
                                 @PathVariable("itemId") Long itemId,
                                 @PathVariable("quantity") int quantity,
                                 @PathVariable("price") double price) {
        return cartService.updateItem(cartId, itemId, quantity, price);
    }

    // Remove a specific item from cart
    @DeleteMapping("/remove/{cartId}/{itemId}")
    public CartEntity removeItem(@PathVariable("cartId") Long cartId,
                                 @PathVariable("itemId") Long itemId) {
        return cartService.removeItem(cartId, itemId);
    }

    // Clear entire cart
    @DeleteMapping("/clear/{cartId}")
    public CartEntity clearCart(@PathVariable("cartId") Long cartId) {
        return cartService.clearCart(cartId);
    }
}
