package com.epam.service;

import com.epam.dao.UserDao;
import com.epam.exception.LoginException;
import com.epam.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Konstantin Yalovik on 30.01.2017.
 */
@Component
public class LoginService {

    @Autowired
    private UserDao userDao;

    public void processLogin(String username, String password) throws LoginException {
        User user = userDao.getUser(username);
        if (user == null || user.getPassword() == null || !user.getPassword().equals(password)){
            throw new LoginException("Wrong password or login");
        }
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
