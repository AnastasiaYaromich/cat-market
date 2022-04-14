package com.yaromich.catmarket.converters;
import com.yaromich.catmarket.dtos.ProductDto;
import com.yaromich.catmarket.entities.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {

    public ProductDto entityToDto(Product p) {
        ProductDto productDto = new ProductDto();
        productDto.setId(p.getId());
        productDto.setTitle(p.getTitle());
        productDto.setPrice(p.getPrice());
        productDto.setCategoryTitle(p.getCategory().getTitle());
        return productDto;
    }

    public List<ProductDto> entityListToDtoList(List<Product> products) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : products) {
            productDtoList.add(new ProductDto(p.getId(), p.getTitle(), p.getPrice(), p.getCategory().getTitle()));
        }
        return productDtoList;
    }
}
