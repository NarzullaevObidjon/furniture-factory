package com.company.furniturefactory.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MaterialOutDAO {
    private final JdbcTemplate jdbcTemplate;
}
