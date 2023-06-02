package com.company.furniturefactory;

import com.company.furniturefactory.domain.AuthUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
@EnableWebSecurity
@ComponentScan("com.company")
public class FurnitureFactoryApplication implements CommandLineRunner {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FurnitureFactoryApplication(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(FurnitureFactoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        jdbcTemplate.
    }
}
