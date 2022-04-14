package com.yaromich.catmarket.repositories;

import com.yaromich.catmarket.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findOneById(Long id);
}
