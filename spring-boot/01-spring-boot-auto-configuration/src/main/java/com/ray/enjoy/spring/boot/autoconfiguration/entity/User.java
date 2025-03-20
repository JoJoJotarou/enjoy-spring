package com.ray.enjoy.spring.boot.autoconfiguration.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    private Gender gender;

    public User(String name, Integer age, Date birthday, Gender gender) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public enum Gender {
        MALE,
        FEMALE;
    }
}
