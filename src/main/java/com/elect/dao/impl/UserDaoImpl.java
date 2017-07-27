package com.elect.dao.impl;

import com.elect.dao.UserDao;
import com.elect.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }
}
