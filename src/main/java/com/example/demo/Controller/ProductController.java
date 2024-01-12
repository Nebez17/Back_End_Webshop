package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.Security.AdminSecurity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @AdminSecurity
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDto productDto) {

       Product createdProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

//    @AdminSecurity
//    @GetMapping()
//    public ResponseEntity<List<Product>> getAllProducts(){
//        List<Product> products = productService.findAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProductsByCategoryId(@RequestParam(name = "categoryId", required = false) UUID categoryId) {
        if (categoryId != null) {
            List<Product> products = productService.findProductsByCategoryId(categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            List<Product> allProducts = productService.findAllProducts();
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable("id") UUID id){
        Product product= productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @AdminSecurity
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") UUID id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @AdminSecurity
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDto updatedProduct) {
        Product updated = productService.updateProduct(id, updatedProduct);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
