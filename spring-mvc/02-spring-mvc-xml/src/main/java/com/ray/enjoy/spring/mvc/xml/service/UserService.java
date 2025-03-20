package com.ray.enjoy.spring.mvc.xml.service;

import com.ray.enjoy.spring.mvc.xml.dao.UserDao;
import com.ray.enjoy.spring.mvc.xml.entity.User;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public void add(User user, boolean rollback) {
        userDao.save(user);

        if (rollback)
            throw new RuntimeException("rollback");
    }
}
