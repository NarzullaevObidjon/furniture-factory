package com.company.furniturefactory.controller;


import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.domain.Measurement;
import com.company.furniturefactory.dto.material.MaterialCreateDTO;
import com.company.furniturefactory.dto.material.MaterialCreateIdDTO;
import com.company.furniturefactory.dto.material.MaterialResponse;
import com.company.furniturefactory.dto.product.ProductCreateDTO;
import com.company.furniturefactory.dto.product.ProductCreateIdDTO;
import com.company.furniturefactory.dto.product.ProductResponse;
import com.company.furniturefactory.service.CategoryService;
import com.company.furniturefactory.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
@PreAuthorize("hasRole('DIRECTOR') or hasRole('ADMIN')")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("product");
        view.addObject("user", sessionUser.getUser());
        List<ProductResponse> products = productService.getAll();
        List<Category> categories = categoryService.getAll();
        view.addObject("productDto", new ProductCreateDTO());
        view.addObject("products", products);
        view.addObject("categories", categories);
        view.addObject("productIdDto", new ProductCreateIdDTO());
        return view;
    }

    @PostMapping
    public ModelAndView add(
            @Valid @ModelAttribute(value = "productDto") ProductCreateDTO dto ,
            BindingResult bindingResult
    ) {
        productService.add(dto);
        return new ModelAndView("redirect:/product/all");
    }

    @PostMapping("/update")
    public ModelAndView update(
            @Valid @ModelAttribute(value = "productIdDto") ProductCreateIdDTO dto , BindingResult bindingResult) {
        productService.update(dto);
        return new ModelAndView("redirect:/product/all");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        productService.delete(id);
        return new ModelAndView("redirect:/product/all");
    }
}
