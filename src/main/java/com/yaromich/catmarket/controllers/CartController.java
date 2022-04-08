package com.yaromich.catmarket.controllers;

import com.yaromich.catmarket.converters.CartConverter;
import com.yaromich.catmarket.dtos.CartDto;
import com.yaromich.catmarket.dtos.CartItemDto;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.services.CartService;
import com.yaromich.catmarket.utils.Cart;
import com.yaromich.catmarket.utils.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @GetMapping
    public CartDto getCurrentCartItems() {
        System.out.println("Hello World!");
        Cart cart = cartService.getCurrentCart();
        List<CartItem> cartItems = cartService.getCurrentCart().getItems();
        return cartConverter.entityToDto(cart, cartItems);
    }

    @GetMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id) {
        System.out.println(id);
        cartService.addToCart(id);
    }


    @DeleteMapping("/deleteAll")
    public void deleteAllItemsInCart() {
         cartService.getCurrentCart().clear();
    }

    @DeleteMapping("delete/{id}")
    public void deleteProductInCartById(@PathVariable Long id) {
        cartService.deleteFromCart(id);

    }
    }

