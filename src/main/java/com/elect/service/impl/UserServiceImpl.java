package com.elect.service.impl;

import com.elect.dao.UserDao;
import com.elect.model.User;
import com.elect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.getAll();
    }

    @Override
    public User findById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void updateUser(User user) {
//        userDao.update(user);
        User userEntity = userDao.getById(user.getId());
        if (userEntity != null) {
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setPhone(user.getPhone());
            userEntity.setEmail(user.getEmail());
            userEntity.setSkype(user.getSkype());
            userEntity.setAddress(user.getAddress());
            userEntity.setAddress(user.getAddress());
            userEntity.setPassword(user.getPassword());
            userEntity.setGender(user.getGender());
            userEntity.setDateOfBirth(user.getDateOfBirth());
            userEntity.setAvatarUrl(user.getAvatarUrl());
        }
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public boolean isUserEmailUnique(Integer userId, String email) {
        User user = findUserByEmail(email);
        return ( user == null || ((userId != null) && (user.getId() == userId)));
    }
}
