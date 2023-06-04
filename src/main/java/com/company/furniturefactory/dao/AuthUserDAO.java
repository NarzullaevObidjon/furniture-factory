package com.company.furniturefactory.dao;

import com.company.furniturefactory.domain.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthUserDAO {

    private final JdbcTemplate jdbcTemplate;

    public Optional<AuthUser> findByUsername(String username) {
        AuthUser authUser = jdbcTemplate.queryForObject("select * from main_user.authuser where username=? and deleted=0",
                new BeanPropertyRowMapper<>(AuthUser.class), username);
        return Optional.of(authUser);
    }
}
