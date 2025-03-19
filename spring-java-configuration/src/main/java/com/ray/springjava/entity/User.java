package com.ray.springjava.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String name;

    private Integer age;

    private Date birthday;

    private Gender gender;

    public User() {
    }

    public User(String name, Integer age, Date birthday, Gender gender) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public enum Gender {
        MALE,
        FEMALE
    }

}
