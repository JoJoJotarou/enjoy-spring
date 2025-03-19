package com.ray.enjoy.spring.mvc.xmlandcomponentscan.service;

import com.ray.enjoy.spring.mvc.xmlandcomponentscan.dao.UserDao;
import com.ray.enjoy.spring.mvc.xmlandcomponentscan.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(User user, Boolean rollback) {
        userDao.save(user);

        if (rollback)
            throw new RuntimeException("rollback");
    }
}
