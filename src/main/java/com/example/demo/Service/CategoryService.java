package com.example.demo.Service;

import com.example.demo.Exeptions.NotFoundException;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findCategoryByName(String name){
        return categoryRepository.findCategoriesByName(name)
                .orElseThrow(() -> new NotFoundException("User by id " + name + "was not found"));
    }

    public Set<Category> getCategoriesByNames(List<String> categories){
        Set<Category> foundCategories = new HashSet<>();
        for (int i = 0; i < categories.size(); i++) {
            Category foundCategory= categoryRepository.findCategoriesByName(categories.get(i)).orElseThrow(() -> new NotFoundException("Category was not found"));
            foundCategories.add(foundCategory);
        }
        return foundCategories;
    }

    public List<Category> findAllCategories(){
        return categoryRepository.findAllCategoriesOrderedByName();
    }
}
