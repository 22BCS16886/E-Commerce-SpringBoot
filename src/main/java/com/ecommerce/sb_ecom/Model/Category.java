package com.ecommerce.sb_ecom.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId ;
    private String categoryName ;

    public Category() {

    }

    public Category(Long categoryId, String categoryName) {
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
