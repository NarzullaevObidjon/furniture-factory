package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.domain.Client;
import com.company.furniturefactory.dto.category.CategoryDTO;
import com.company.furniturefactory.dto.category.CategoryWithIdDTO;
import com.company.furniturefactory.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('DIRECTOR','ADMIN')")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("client");
        view.addObject("user", sessionUser.getUser());
        List<Client> clients = clientService.getAll();
        view.addObject("clients", clients);
        return view;
    }
    @PostMapping
    public ModelAndView addCategory(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone
    ) {
        clientService.add(name, phone);
        return new ModelAndView("redirect:/client/all");
    }
    @PostMapping("/update")
    public ModelAndView updateCategory(
            @RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("id") Long id
    ) {
        clientService.update(name,phone,id);
        return new ModelAndView("redirect:/client/all");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id) {
        clientService.delete(id);
        return new ModelAndView("redirect:/client/all");
    }
}
