package com.elect.controller;

import com.elect.model.Product;
import com.elect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/8/17.
 */
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productService.findAllProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getProductById(@PathVariable(value = "id") int id) {

        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity("No Product found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(product, HttpStatus.OK);
    }

}
