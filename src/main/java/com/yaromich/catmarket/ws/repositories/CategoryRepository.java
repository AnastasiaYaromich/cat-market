package com.yaromich.catmarket.ws.repositories;

import com.yaromich.catmarket.ws.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    @Query("select c from CategoriesEntity c where c.title = ?1")
    Optional<CategoryEntity> findByTitle(String title);
}