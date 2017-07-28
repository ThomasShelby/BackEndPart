package com.elect.dao.impl;

import com.elect.dao.UserDao;
import com.elect.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.lang.invoke.MethodHandles;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public User findUserByEmail(String email) {
        LOG.info("Executing findUserByEmail() method. ");
        LOG.debug("Executing findUserByEmail() method with email: {} ", email);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }
}
