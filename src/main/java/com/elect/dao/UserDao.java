package com.elect.dao;

import com.elect.model.User;

/**
 * Created by Mykola Yaremchuk on 7/2/17.
 */
public interface UserDao extends BaseDao<User>{

    User findUserByEmail(String email);
}
