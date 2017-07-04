package com.elect.dao.impl;

import com.elect.dao.AbstractDao;
import com.elect.dao.UserDAO;
import com.elect.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
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

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public void deleteUserById(String id) {
        Query query = getSession().createSQLQuery("delete from user_card where id = :id");
        query.setString("id", id);
        query.executeUpdate();
    }

    @Override
    public User findUserByEmail(String email) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (User) criteria.uniqueResult();
    }
}
