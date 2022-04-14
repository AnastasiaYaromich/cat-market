package com.yaromich.catmarket.converters;

import com.yaromich.catmarket.dtos.CartDto;
import com.yaromich.catmarket.dtos.CartItemDto;
import com.yaromich.catmarket.dtos.ProductDto;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.utils.Cart;
import com.yaromich.catmarket.utils.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartConverter {

    public CartDto entityToDto(Cart cart, List<CartItem> cartItems) {
        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        for (CartItem cartItem: cartItems) {
            cartItemDtoList.add(new CartItemDto(cartItem.getProductId(), cartItem.getProductTitle(), cartItem.getQuantity(),
                    cartItem.getPricePerProduct(), cartItem.getPrice()));
        }
        CartDto cartDto = new CartDto();
        cartDto.setItems(cartItemDtoList);
        cartDto.setTotalPrice(cart.getTotalPrice());
        return cartDto;
    }

    public List<CartItemDto> cartItemToDtoList(List<CartItem> cartItems) {
        List<CartItemDto> cartItemDtoList = new ArrayList<>();
        for (CartItem cartItem: cartItems) {
            cartItemDtoList.add(new CartItemDto(cartItem.getProductId(), cartItem.getProductTitle(), cartItem.getQuantity(),
                    cartItem.getPricePerProduct(), cartItem.getPrice()));
        }
        return cartItemDtoList;
    }
}
