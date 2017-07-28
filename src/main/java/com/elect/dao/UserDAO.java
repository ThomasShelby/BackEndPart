package com.elect.dao;

import com.elect.model.User;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
public interface UserDAO {

    List<User> findAllUsers();

    User findById(int id);

    void saveUser(User user);

    void deleteUserById(String id);

    User findUserByEmail(String email);
}