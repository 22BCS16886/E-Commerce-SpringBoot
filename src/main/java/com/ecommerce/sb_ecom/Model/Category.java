package com.ecommerce.sb_ecom.Model;


import jakarta.persistence.Entity;


public class Category {
    private long categoryId ;
    private String categoryName ;

    public Category() {
    // default constructor
    }

    public Category(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    // Getter for categoryId
    public long getCategoryId() {
        return categoryId;
    }

    // Setter for categoryId
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    // Getter for categoryName
    public String getCategoryName() {
        return categoryName;
    }

    // Setter for categoryName
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
