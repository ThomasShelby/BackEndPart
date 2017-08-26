package com.elect.dao.impl;

import com.elect.dao.CategoryDao;
import com.elect.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;

/**
 * Created by Mykola Yaremchuk on 8/15/17.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Category findCategoryByProductName(String productName) {
        LOG.info("Executing findCategoryByProductName() method. ");
        LOG.debug("Executing findCategoryByProductName() method with productName: {} ", productName);
        //TODO to implement
        return null;
    }
}
