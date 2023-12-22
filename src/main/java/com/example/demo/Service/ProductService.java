package com.example.demo.Service;

import com.example.demo.Exeptions.NotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }



    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> findAllProducts(){
        return productRepository.findAllProductsOrderedByProductName();
    }
    public Product findProductById(UUID id){
        return productRepository.findProductById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + "was not found"));
    }
    public void deleteProduct(UUID id){
        productRepository.deleteProductById(id);
    }

    public Product createProduct(ProductDto productDto){

        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setImageURL(productDto.getImageURL());
        Set<Category> catogires = categoryService.getCategoriesByNames(productDto.getCategory());
        product.setCategory(catogires);
        return productRepository.save(product);
    }


    public Product updateProduct(UUID id, Product updatedProduct) {
        // Retrieve the existing product from the database
        Product existingProduct = productRepository.findProductById(id)
                .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));

        // Update the fields of the existing product with the values from the updated product
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setImageURL(updatedProduct.getImageURL());
        existingProduct.setCategory(updatedProduct.getCategory());

        // Save the updated product
        return productRepository.save(existingProduct);
    }
}
