package com.poly.plantManagement.service;

import java.util.List;

import com.poly.plantManagement.entities.Category;


public interface IServiceCategory {
    void saveCategory(Category category);
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Category>  getCategoryByName(String mc);
    void deleteCategory(int id);
}
