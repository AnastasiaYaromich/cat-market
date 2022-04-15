package com.yaromich.catmarket.ws.repositories;

import com.yaromich.catmarket.ws.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query("select p from ProductEntity p where p.name = ?1")
    Optional<ProductEntity> findByName(String name);
}