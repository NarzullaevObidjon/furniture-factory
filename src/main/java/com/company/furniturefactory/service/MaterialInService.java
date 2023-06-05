package com.company.furniturefactory.service;


import com.company.furniturefactory.dao.MaterialInDAO;
import com.company.furniturefactory.dao.MaterialWarehouseDAO;
import com.company.furniturefactory.dto.materialIncome.MaterialInCreateDTO;
import com.company.furniturefactory.dto.materialIncome.MaterialInResponse;
import com.company.furniturefactory.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialInService {
    private final MaterialInDAO materialInDAO;
    private final MaterialWarehouseDAO materialWarehouseDAO;

    public List<MaterialInResponse> getAll(String code) {
        return materialInDAO.getAll(DateUtils.resolveStart(code), DateUtils.resolveEnd(code));
    }

    public Double getSumOfIncome(String code) {
        return materialInDAO.getSumOfIncome(DateUtils.resolveStart(code), DateUtils.resolveEnd(code));
    }



    public void add(MaterialInCreateDTO dto) {
        materialInDAO.add(dto);
        materialWarehouseDAO.add(dto);
    }
}
