package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.dto.category.CategoryDTO;
import com.company.furniturefactory.dto.category.CategoryWithIdDTO;
import com.company.furniturefactory.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
@PreAuthorize("hasRole('DIRECTOR') or hasRole('ADMIN')")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("category");
        view.addObject("user", sessionUser.getUser());
        List<Category> categories = categoryService.getAll();
        view.addObject("categoryDto", new CategoryDTO());
        view.addObject("categories", categories);
        view.addObject("categoryWithIdDto", new CategoryWithIdDTO());
        return view;
    }
    @PostMapping
    public ModelAndView addCategory(@Valid @ModelAttribute CategoryDTO categoryDTO , BindingResult bindingResult) {
        categoryService.add(categoryDTO);
        return new ModelAndView("redirect:/category/all");
    }
    @PostMapping("/update")
    public ModelAndView updateCategory(@Valid @ModelAttribute CategoryWithIdDTO dto, BindingResult bindingResult) {
        categoryService.update(dto);
        return new ModelAndView("redirect:/category/all");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return new ModelAndView("redirect:/category/all");
    }
}
