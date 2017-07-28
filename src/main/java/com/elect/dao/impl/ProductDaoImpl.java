package com.elect.dao.impl;

import com.elect.dao.ProductDao;
import com.elect.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;

/**
 * Created by Mykola Yaremchuk on 7/14/17.
 */
@Repository("productDao")
public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public Product findProductByUserEmail(String email) {
        LOG.info("Executing findProductByUserEmail() method. ");
        LOG.debug("Executing findProductByUserEmail() method with email: {} ", email);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (Product) criteria.uniqueResult();
    }
}
