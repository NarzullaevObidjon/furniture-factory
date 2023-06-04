package com.company.furniturefactory;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public ModelAndView exception(Model model, Exception e) {
//        e.printStackTrace();
//        System.out.println(e.getMessage());
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("home");
//        return mav;
//    }
}
