package com.yaromich.catmarket.controllers;


import com.yaromich.catmarket.entities.Cart;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{id}")
    public void addProductToCartById(@PathVariable Long id) {
        cartService.addProductToCart(id);
    }

    @GetMapping
    public List<Product> getAllCartProducts() {
        return cartService.findAllProductsInCart();
    }
}
