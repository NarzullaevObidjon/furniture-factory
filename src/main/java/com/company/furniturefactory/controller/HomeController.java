package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {


    @GetMapping("/")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("home");
        view.addObject("user", sessionUser.getUser());
        return view;
    }
}
