package com.ecommerce.sb_ecom.Service;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;


import com.ecommerce.sb_ecom.Model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {


    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository ;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category>categories  = categoryRepository.findAll();
        Category category = categories.stream()
                .filter(c -> categoryId != null && categoryId.equals(c.getCategoryId()))

                .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , "Resource not found"));
        
        categoryRepository.delete(category);
        return "Category with " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category>categories  = categoryRepository.findAll();
        Optional<Category> optionalCategory = categories.stream().
                filter(c -> c.getCategoryId() == (categoryId)).
        findFirst() ;

        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory = categoryRepository.save(existingCategory);
            return savedCategory ;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , "Category not found ");
            
        }
    }

    
}
