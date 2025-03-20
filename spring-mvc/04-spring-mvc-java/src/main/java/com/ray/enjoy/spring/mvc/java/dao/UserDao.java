package com.ray.enjoy.spring.mvc.java.dao;

import com.ray.enjoy.spring.mvc.java.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAll() {
        String sql = "select * from t_user order by id desc limit 10";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            user.setBirthday(rs.getDate("birthday"));
            user.setGender(User.Gender.valueOf(rs.getString("gender")));
            return user;
        });
    }

    public void save(User user) {
        String sql = "insert into t_user (name, age, birthday, gender) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getAge(), user.getBirthday(), user.getGender().name());
    }
}
