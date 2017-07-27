package com.elect.service;

import com.elect.model.Product;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/27/17.
 */
public interface ProductService {

    List<Product> findAllProducts();

    Product findById(int id);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(String id);

    Product findProductByUserEmail(String email);
}
