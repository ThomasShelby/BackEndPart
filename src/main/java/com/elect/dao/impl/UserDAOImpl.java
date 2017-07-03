package com.elect.dao.impl;

import com.elect.dao.AbstractDao;
import com.elect.dao.UserDAO;
import com.elect.model.User;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Repository("userDAO")
public class UserDAOImpl extends AbstractDao<Integer, User> implements UserDAO {

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }
}
