package com.elect.service;

import com.elect.model.Category;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 8/26/17.
 */
public interface CategoryService {

    List<Category> findAllCategories();

    Category findById(int id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(String id);

    Category findCategoryByProductName(String productName);

    int getAmountOfProducts();
}
