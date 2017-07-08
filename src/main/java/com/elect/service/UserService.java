package com.elect.service;

import com.elect.model.User;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
public interface UserService {

    List<User> findAllUsers();

    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(String id);

    User findUserByEmail(String email);

    boolean isUserEmailUnique(Integer userId, String email);
}
