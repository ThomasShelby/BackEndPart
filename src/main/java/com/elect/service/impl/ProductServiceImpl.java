package com.elect.service.impl;

import com.elect.dao.ProductDao;
import com.elect.model.Product;
import com.elect.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/27/17.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAllProducts() {
        return productDao.getAll();
    }

    @Override
    public Product findById(int id) {
        return productDao.getById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productDao.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }

    @Override
    public void deleteProductById(String id) {
        productDao.deleteById(id);
    }

    @Override
    public Product findProductByUserEmail(String email) {
        return findProductByUserEmail(email);
    }
}
