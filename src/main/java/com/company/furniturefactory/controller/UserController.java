package com.company.furniturefactory.controller;

import com.company.furniturefactory.dto.response.UserResponse;
import com.company.furniturefactory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("/user")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('DIRECTOR','ADMIN')")
public class UserController {

//    @GetMapping("/all")
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("users");
////        List<UserResponse> users = userService.getAll();
////        modelAndView.addObject("users", users);
//        return modelAndView;
//    }
}
