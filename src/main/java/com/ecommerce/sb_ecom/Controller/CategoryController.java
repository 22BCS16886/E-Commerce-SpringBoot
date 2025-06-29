package com.ecommerce.sb_ecom.Controller;


import java.util.List;

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
    public ResponseEntity <String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully" ,HttpStatus.CREATED );
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity <String> deleteCategory(@PathVariable Long categoryId){
        try {
            String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status , HttpStatus.OK) ;
        }catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode()) ;
        }
    }

    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity <String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId){
        try{
            Category savedCategory = categoryService.updateCategory(category , categoryId);
            return new ResponseEntity<>("Category with category id" + categoryId , HttpStatus.OK);
        }
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason() , e.getStatusCode()) ;
        }
    }
}

