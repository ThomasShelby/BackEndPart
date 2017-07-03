package com.elect.dao;

import com.elect.model.User;

import java.util.List;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
public interface UserDAO {

    List<User> findAllUsers();
}
