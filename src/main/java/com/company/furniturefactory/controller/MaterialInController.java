package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.dto.materialIncome.MaterialInCreateDTO;
import com.company.furniturefactory.dto.materialIncome.MaterialInResponse;
import com.company.furniturefactory.service.MaterialInService;
import com.company.furniturefactory.service.MaterialService;
import com.company.furniturefactory.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/material-in")
@RequiredArgsConstructor
@PreAuthorize("hasRole('DIRECTOR') or hasRole('ADMIN')")
public class MaterialInController {
    private final MaterialInService materialInService;
    private final MaterialService materialService;
    private final SupplierService supplierService;

    @GetMapping("/all")
    public ModelAndView all(
            SessionUser sessionUser,
            @RequestParam(value = "code", required = false, defaultValue = "monthly") String code
    ) {
        ModelAndView mav = new ModelAndView("materialIn");
        mav.addObject("code",code);
        mav.addObject("user",sessionUser.getUser());
        List<MaterialInResponse> incomes = materialInService.getAll(code);
        mav.addObject("incomes", incomes);
        Double sum = materialInService.getSumOfIncome(code);
        mav.addObject("sum", sum);
        mav.addObject("dto",new MaterialInCreateDTO());
        mav.addObject("materials", materialService.getAll());
        mav.addObject("suppliers", supplierService.getAll());
        return mav;
    }
    @PostMapping("/add")
    public String add(
            @Valid @ModelAttribute(name = "dto") MaterialInCreateDTO dto
    ){
        materialInService.add(dto);
        return "redirect:/material-in/all";
    }
}
