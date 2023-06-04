package com.company.furniturefactory.controller;


import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Material;
import com.company.furniturefactory.domain.Measurement;
import com.company.furniturefactory.dto.material.MaterialCreateDTO;
import com.company.furniturefactory.dto.material.MaterialCreateIdDTO;
import com.company.furniturefactory.dto.material.MaterialResponse;
import com.company.furniturefactory.service.MaterialService;
import com.company.furniturefactory.service.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/material")
@RequiredArgsConstructor
@PreAuthorize("hasRole('DIRECTOR') or hasRole('ADMIN')")
public class MaterialController {
    private final MaterialService materialService;
    private final MeasurementService measurementService;
    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("material");
        view.addObject("user", sessionUser.getUser());
        List<MaterialResponse> materials = materialService.getAll();
        List<Measurement> measurements = measurementService.getAll();
        view.addObject("materialDto", new MaterialCreateDTO());
        view.addObject("materials", materials);
        view.addObject("measurements", measurements);
        view.addObject("materialIdDto", new MaterialCreateIdDTO());
        return view;
    }

    @PostMapping
    public ModelAndView addMeasurement(
            @Valid @ModelAttribute(value = "materialDto") MaterialCreateDTO dto ,BindingResult bindingResult) {
        materialService.add(dto);
        return new ModelAndView("redirect:/material/all");
    }
}
