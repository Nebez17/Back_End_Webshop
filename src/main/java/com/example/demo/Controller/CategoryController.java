package com.example.demo.Controller;

import com.example.demo.Model.Category;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import com.example.demo.Model.dto.CategoryDto;
import com.example.demo.Model.dto.ProductDto;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.Security.AdminSecurity;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequestMapping("/category")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Category> getCategoryByName (@PathVariable("name") String name){
        Category category= categoryService.findCategoryByName(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @AdminSecurity
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") UUID id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @AdminSecurity
    @PostMapping
    public ResponseEntity<Category> addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        Category createdCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    @AdminSecurity
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") UUID id, @RequestBody CategoryDto categoryDto) {
        Category updated = categoryService.updateCategory(id, categoryDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

}
