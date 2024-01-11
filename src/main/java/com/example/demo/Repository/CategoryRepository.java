package com.example.demo.Repository;

import com.example.demo.Model.Category;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesByName(String name);
    @Transactional
    void deleteProductById(UUID id);

    @Query("SELECT e FROM Category e ORDER BY e.name")
    List<Category> findAllCategoriesOrderedByName();


}
