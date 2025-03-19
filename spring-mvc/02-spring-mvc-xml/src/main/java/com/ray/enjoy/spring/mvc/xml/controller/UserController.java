package com.ray.enjoy.spring.mvc.xml.controller;

import com.ray.enjoy.spring.mvc.xml.entity.User;
import com.ray.enjoy.spring.mvc.xml.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@ResponseBody
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("test")
    public String test() {
        return "hello 张三";
    }

    @GetMapping("list")
    public List<User> list() {
        return userService.getAll();
    }

    @GetMapping("add")
    public void add(@RequestParam(required = false, name = "rollback") Boolean rollback) {
        userService.add(new User("张三", 18, new Date(), User.Gender.MALE), rollback);
    }
}