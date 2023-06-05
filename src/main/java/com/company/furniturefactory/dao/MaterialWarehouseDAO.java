package com.company.furniturefactory.dao;

import com.company.furniturefactory.dto.materialIncome.MaterialInCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MaterialWarehouseDAO {
    private final JdbcTemplate jdbcTemplate;

    public void add(MaterialInCreateDTO dto) {
        jdbcTemplate.update("insert into MaterialWarehouse(material_id,amount,price) values(?,?,?)",
                dto.getMaterialId(),
                dto.getAmount(),
                dto.getPrice());
    }
}
