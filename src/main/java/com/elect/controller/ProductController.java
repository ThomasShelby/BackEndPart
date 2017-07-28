package com.elect.controller;

import com.elect.model.Product;
import com.elect.service.ProductService;
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
 * Created by Mykola Yaremchuk on 7/8/17.
 */
@RequestMapping("/products")
@RestController
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> listProducts() {
        LOG.debug("listProducts() method is being executed inside ProductController..");
        return productService.findAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getProductById(@PathVariable(value = "id") int id) {
        LOG.debug("getProductById(id = {}) method is being executed inside ProductController..", id);

        Product product = productService.findById(id);
        if (product == null) {
            LOG.error("No Product found for ID = {}", id);
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }
        LOG.debug("Product by ID was found.");
        return new ResponseEntity(product, HttpStatus.OK);
    }

}
