package com.company.furniturefactory.service;

import com.company.furniturefactory.dao.MeasurementDAO;
import com.company.furniturefactory.domain.Measurement;
import com.company.furniturefactory.dto.measurement.MeasurementDTO;
import com.company.furniturefactory.dto.measurement.MeasurementWithIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementService {
    private final MeasurementDAO measurementDao;

    public List<Measurement> getAll() {
        return measurementDao.getAll();
    }

    public void add(MeasurementDTO measurementDTO) {
        measurementDao.save(measurementDTO);
    }

    public void update(MeasurementWithIdDTO measurementDTO) {
        measurementDao.update(measurementDTO);
    }

    public void delete( Long id) {
        measurementDao.delete(id);
    }

}
