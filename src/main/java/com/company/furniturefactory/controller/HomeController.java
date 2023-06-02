package com.company.furniturefactory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final JdbcTemplate jdbcTemplate;
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("home");
    }
}
