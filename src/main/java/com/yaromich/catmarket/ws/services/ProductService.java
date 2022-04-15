package com.yaromich.catmarket.ws.services;

import com.yaromich.catmarket.ws.entities.ProductEntity;
import com.yaromich.catmarket.ws.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public static final Function<ProductEntity, Product> functionEntityToSoap = se -> {
        Product p = new Product();
        p.setId(se.getId());
        p.setTitle(se.getTitle());
        p.setPrice(se.getPrice());
        p.setCategoryTitle(se.getCategory().getTitle());
        return p;
    };

    public List<Product> getAllProducts() {
        return productRepository.findAll().stream().map(functionEntityToSoap).collect(Collectors.toList());
    }

    public Product getByName(String name) {
        return productRepository.findByName(name).map(functionEntityToSoap).get();
    }

    public Product getById(Long id) {
        return   productRepository.findById(id).map(functionEntityToSoap).get();
    }
}