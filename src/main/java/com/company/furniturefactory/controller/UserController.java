package com.company.furniturefactory.controller;

import com.company.furniturefactory.dto.product.ProductCreateDTO;
import com.company.furniturefactory.dto.product.ProductCreateIdDTO;
import com.company.furniturefactory.dto.response.UserResponse;
import com.company.furniturefactory.dto.user.UserCreateDTO;
import com.company.furniturefactory.dto.user.UserCreateIdDTO;
import com.company.furniturefactory.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('DIRECTOR','ADMIN')")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("user");
        List<UserResponse> users = userService.getAll();
        modelAndView.addObject("users",users);
        modelAndView.addObject("userDto",new UserCreateDTO());
        modelAndView.addObject("userIdDto",new UserCreateDTO());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView add(
            @Valid @ModelAttribute(value = "userDto") UserCreateDTO dto ,
            BindingResult bindingResult
    ) {
        userService.add(dto);
        return new ModelAndView("redirect:/user/all");
    }

    @PostMapping("/update")
    public ModelAndView update(
            @Valid @ModelAttribute(value = "userIdDto") UserCreateIdDTO dto , BindingResult bindingResult) {
        userService.update(dto);
        return new ModelAndView("redirect:/user/all");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        userService.delete(id);
        return new ModelAndView("redirect:/user/all");
    }
}
