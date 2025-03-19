package com.ray.springjava.service;

import com.ray.springjava.dao.UserDao;
import com.ray.springjava.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }


    public void add(User user) {
        add1(user);
        System.out.println("failed" + 1 / 0);
    }

    @Transactional
    public void add1(User user) {
        userDao.save(new User("张三", 18, new Date(), User.Gender.MALE));
    }
}
