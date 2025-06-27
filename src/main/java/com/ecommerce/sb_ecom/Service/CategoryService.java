package com.ecommerce.sb_ecom.Service;

import java.util.List;

import com.ecommerce.sb_ecom.Model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);   // <--- Make sure this is here

    Category updateCategory(Category category, Long categoryId);
}
