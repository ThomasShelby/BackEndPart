package com.elect.service.impl;

import com.elect.dao.UserDAO;
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
    UserDAO userDAO;

    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void updateUser(User user) {
        User userEntity = userDAO.findById(user.getId());
        if (userEntity != null) {
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setPhone(user.getPhone());
            userEntity.setEmail(user.getEmail());
            userEntity.setSkype(user.getSkype());
            userEntity.setAddressId(user.getAddressId());
            userEntity.setUserPassword(user.getUserPassword());
            userEntity.setGender(user.getGender());
            userEntity.setDateOfBirth(user.getDateOfBirth());
            userEntity.setAvatar(user.getAvatar());
        }
    }

    @Override
    public void deleteUserById(String id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }
}
