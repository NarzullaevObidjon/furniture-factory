package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Client;
import com.company.furniturefactory.domain.Supplier;
import com.company.furniturefactory.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/supplier")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('DIRECTOR','ADMIN')")
public class SupplierController {
    private final SupplierService supplierService;

    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("supplier");
        view.addObject("user", sessionUser.getUser());
        List<Supplier> suppliers = supplierService.getAll();
        view.addObject("suppliers", suppliers);
        return view;
    }
    @PostMapping
    public ModelAndView addCategory(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone
    ) {
        supplierService.add(name, phone);
        return new ModelAndView("redirect:/supplier/all");
    }
    @PostMapping("/update")
    public ModelAndView updateCategory(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("id") Long id
    ) {
        supplierService.update(name,phone,id);
        return new ModelAndView("redirect:/supplier/all");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        supplierService.delete(id);
        return new ModelAndView("redirect:/supplier/all");
    }
}
