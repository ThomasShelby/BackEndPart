package com.elect.service.impl;

import com.elect.dao.CategoryDao;
import com.elect.model.Category;
import com.elect.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 8/26/17.
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.getAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.getById(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void updateCategory(Category category) {
//        categoryDao.update(category);
        Category categoryEntity = categoryDao.getById(category.getId());
        if (categoryEntity != null) {
            categoryEntity.setId(category.getId());
            categoryEntity.setName(category.getName());
            categoryEntity.setProducts(category.getProducts());
            categoryEntity.setImageName(category.getImageName());
            categoryEntity.setImageUrl(category.getImageUrl());
            categoryEntity.setDescription(category.getDescription());
        }
    }

    @Override
    public void deleteCategoryById(String id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Category findCategoryByProductName(String productName) {
        return categoryDao.findCategoryByProductName(productName);
    }

    @Override
    public int getAmountOfProducts() {
        return categoryDao.getAll().size();
    }
}