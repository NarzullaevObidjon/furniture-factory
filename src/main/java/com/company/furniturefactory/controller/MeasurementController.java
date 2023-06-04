package com.company.furniturefactory.controller;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Measurement;
import com.company.furniturefactory.dto.measurement.MeasurementDTO;
import com.company.furniturefactory.dto.measurement.MeasurementWithIdDTO;
import com.company.furniturefactory.service.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/measurement")
@RequiredArgsConstructor
@PreAuthorize("hasRole('DIRECTOR') or hasRole('ADMIN')")
public class MeasurementController {
    private final MeasurementService measurementService;

    @GetMapping("/all")
    public ModelAndView home(SessionUser sessionUser){
        ModelAndView view = new ModelAndView("measurement");
        view.addObject("user", sessionUser.getUser());
        List<Measurement> measurements = measurementService.getAll();
        view.addObject("measurementDto", new MeasurementDTO());
        view.addObject("measurements", measurements);
        view.addObject("measurementWithIdDto", new MeasurementWithIdDTO());
        return view;
    }
    @PostMapping
    public ModelAndView addMeasurement(@Valid @ModelAttribute MeasurementDTO measurementDTO , BindingResult bindingResult) {
        measurementService.add(measurementDTO);
        return new ModelAndView("redirect:/measurement/all");
    }
    @PostMapping("/update")
    public ModelAndView updateMeasurement(@Valid @ModelAttribute MeasurementWithIdDTO dto, BindingResult bindingResult) {
        measurementService.update(dto);
        return new ModelAndView("redirect:/measurement/all");
    }
    @GetMapping("/delete/{id}")
    public ModelAndView deleteMeasurement(@PathVariable Long id) {
        measurementService.delete(id);
        return new ModelAndView("redirect:/measurement/all");
    }
}
