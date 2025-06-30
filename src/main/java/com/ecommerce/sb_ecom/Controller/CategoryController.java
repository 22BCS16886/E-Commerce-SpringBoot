package com.ecommerce.sb_ecom.Controller;


import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.sb_ecom.Model.Category;
import com.ecommerce.sb_ecom.Service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api")
public class CategoryController {

    CategoryService categoryService ;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/public/categories")
    public ResponseEntity <List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories , HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity <String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully" ,HttpStatus.CREATED );
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity <String> deleteCategory(@PathVariable Long categoryId){
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity <String> updateCategory(@Valid @RequestBody Category category,@PathVariable Long categoryId){

            Category savedCategory = categoryService.updateCategory(category , categoryId);
            return new ResponseEntity<>("CATEGORY updated successfully",HttpStatus.OK);

    }
}

