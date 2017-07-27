package com.elect.dao.impl;

import com.elect.dao.ProductDao;
import com.elect.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Mykola Yaremchuk on 7/14/17.
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

    @Override
    public Product findProductByUserEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (Product) criteria.uniqueResult();
    }
}
