package com.epam.dao;

import com.epam.model.User;

import java.util.List;

/**
 * Created by Konstantin Yalovik on 06.02.2017.
 */
public interface UserDao {

    public User getUser(String username);

    public List<User> list();
}
