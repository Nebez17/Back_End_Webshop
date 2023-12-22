package com.example.demo.Repository;

import com.example.demo.Model.Product;
import com.example.demo.Model.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    void deleteProductById(UUID id);
    @Query("SELECT e FROM Product e ORDER BY e.productName")
    List<Product> findAllProductsOrderedByProductName();

    Optional<Product> findProductById(UUID id);
}
