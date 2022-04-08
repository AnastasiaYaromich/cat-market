package com.yaromich.catmarket.utils;

import com.yaromich.catmarket.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;
    
    public void add(Product p) {
        for (CartItem item: items) {
            if(item.getProductId().equals(p.getId())) {
                item.incrementQuantity();
                recalculate();
                return;
       }
        }
        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();
    }

    public void  clear() {
        items.clear();
        totalPrice = BigDecimal.ZERO;
    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
    }

    public void delete(Product p) {
        for (CartItem item: items) {
            if(item.getProductId().equals(p.getId())) {
                if(item.getQuantity() == 1) {
                    items.remove(item);
                } else {
                    item.decrementQuantity();
                }
                recalculate();
                return;
            }
        }
    }
}
