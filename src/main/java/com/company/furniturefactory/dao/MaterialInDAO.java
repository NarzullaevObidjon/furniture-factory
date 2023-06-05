package com.company.furniturefactory.dao;

import com.company.furniturefactory.dto.materialIncome.MaterialInCreateDTO;
import com.company.furniturefactory.dto.materialIncome.MaterialInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MaterialInDAO {

    private String GET_ALL_SQL = """
            select
                MI.id,
                MI.income_date,
                M.name_uz material_name,
                MI.amount,
                MI.price,
                ME.name_uz measurement_name,
                S.name supplier_name
            from materialincome MI
                left join material M on MI.material_id = M.id
                left join measurement ME on M.measurement_id = ME.id
                left join supplier S on MI.supplier_id = S.id
            where MI.income_date >=? and MI.income_date < ?
            """;
    private String SUM_OF_INCOME_SQL = """
            SELECT (
                SELECT SUM(PRICE * AMOUNT)
                FROM MAIN_USER.MATERIALINCOME
                WHERE INCOME_DATE >=? and INCOME_DATE < ?
                ) AS sum
            FROM DUAL
            """;
    private final JdbcTemplate jdbcTemplate;

    public List<MaterialInResponse> getAll(LocalDateTime start, LocalDateTime end) {
        try {
            return jdbcTemplate.query(GET_ALL_SQL, (rs, rowNum) -> {
                MaterialInResponse response = new MaterialInResponse();
                response.setMaterialName(rs.getString("material_name"));
                response.setId(rs.getLong("id"));
                response.setAmount(rs.getDouble("amount"));
                response.setPrice(rs.getDouble("price"));
                response.setIncomeDate(LocalDateTime.parse(rs.getString("income_date"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                response.setMeasurementName(rs.getString("measurement_name"));
                response.setSupplierName(rs.getString("supplier_name"));
                return response;
            }, start, end);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyList();
        }
    }

    public Double getSumOfIncome(LocalDateTime start, LocalDateTime end) {
        try {
            return jdbcTemplate.queryForObject(SUM_OF_INCOME_SQL, Double.class, start, end);
        } catch (EmptyResultDataAccessException e) {
            return 0.0;
        }
    }

    public void add(MaterialInCreateDTO dto) {
        jdbcTemplate.update("insert into MaterialIncome(material_id,supplier_id,price,amount, income_date) values(?,?,?,?,?)",
                dto.getMaterialId(),
                dto.getSupplierId(),
                dto.getPrice(),
                dto.getAmount(),
                dto.getIncomeDate()
        );
    }
}
