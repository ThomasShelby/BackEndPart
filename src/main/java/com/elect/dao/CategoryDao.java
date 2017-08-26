package com.elect.dao;

import com.elect.model.Category;

/**
 * Created by Mykola Yaremchuk on 8/15/17.
 */
public interface CategoryDao extends BaseDao<Category> {

    Category findCategoryByProductName(String productName);
}
