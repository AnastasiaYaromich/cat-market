package com.yaromich.catmarket.controllers;

import com.yaromich.catmarket.converters.ProductConverter;
import com.yaromich.catmarket.dtos.ProductDto;
import com.yaromich.catmarket.entities.Product;
import com.yaromich.catmarket.exceptions.AppError;
import com.yaromich.catmarket.exceptions.ResourceNotFoundException;
import com.yaromich.catmarket.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductConverter productConverter;

    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<Product> products = productService.findAll();
        return productConverter.entityListToDtoList(products);
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productConverter.entityToDto(productService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт с id: " + id + " не найден")));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProducts(@RequestBody ProductDto productDto) {
        productService.createNewProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
