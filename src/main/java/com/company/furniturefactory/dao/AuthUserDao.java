package com.company.furniturefactory.dao;


import com.company.furniturefactory.domain.AuthUser;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthUserDao {

    private final JdbcTemplate jdbcTemplate;

    public AuthUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<AuthUser> findByUsername(String username) {
        var sql = "select * from MAIN_USER.AUTHUSER where username = ?";
        return Optional.of(jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(AuthUser.class), username));
    }
}
