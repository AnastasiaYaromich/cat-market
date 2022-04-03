package com.yaromich.catmarket.services;

import com.yaromich.catmarket.entities.Cart;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;

    public void addProductToCart(Long id) {
        Product product = productService.findProductById(id);
        Cart cart = new Cart();
        cart.setProduct(product);
        cartRepository.save(cart);
    }

    public List<Product> findAllProductsInCart() {
        List<Cart> carts = cartRepository.findAll();
        List<Product> products = new ArrayList<>();
        for (Cart cart: carts) {
            products.add(cart.getProduct());
        }
        return products;
    }
}
