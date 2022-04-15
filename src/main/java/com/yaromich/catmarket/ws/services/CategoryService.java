package com.yaromich.catmarket.ws.services;

import com.yaromich.catmarket.ws.entities.CategoryEntity;
import com.yaromich.catmarket.ws.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoriesRepository;

    public static final Function<CategoryEntity, Category> functionEntityToSoap = ge -> {
        Category c = new Category();
        c.setTitle(ge.getTitle());
        ge.getProducts().stream().map(ProductService.functionEntityToSoap).forEach(p -> c.getProducts().add(p));
        return c;
    };

    public Category getByTitle(String title) {
        return categoriesRepository.findByTitle(title).map(functionEntityToSoap).get();
    }
}