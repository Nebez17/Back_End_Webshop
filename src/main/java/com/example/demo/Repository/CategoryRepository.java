package com.example.demo.Repository;

import com.example.demo.Model.Category;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoriesByName(String name);


}
