package com.elect.controller;

import com.elect.model.Category;
import com.elect.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Created by Mykola Yaremchuk on 8/26/17.
 */
@RequestMapping("/categories")
@RestController
public class CategoryController {


    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> listCategories() {
        LOG.debug("listCategories() method is being executed inside CategoryController..");
        return categoryService.findAllCategories();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCategoryById(@PathVariable(value = "id") int id) {
        LOG.debug("getCategoryById(id = {}) method is being executed inside CategoryController..", id);

        Category category = categoryService.findById(id);
        if (category == null) {
            LOG.error("No Category found for ID = {}", id);
            return new ResponseEntity("No Category found for ID " + id, HttpStatus.NOT_FOUND);
        }
        LOG.debug("Product by ID was found.");
        return new ResponseEntity(category, HttpStatus.OK);
    }

}
