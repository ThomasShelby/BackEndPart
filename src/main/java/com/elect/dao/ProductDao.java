package com.elect.dao;

import com.elect.model.Product;

/**
 * Created by Mykola Yaremchuk on 7/14/17.
 */
public interface ProductDao extends BaseDao<Product>{

    Product findProductByUserEmail(String email);
}
