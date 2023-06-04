package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Measurement;
import com.company.furniturefactory.dto.measurement.MeasurementDTO;
import com.company.furniturefactory.dto.measurement.MeasurementWithIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MeasurementDAO {

    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<Measurement> getAll() {
        String sql = "SELECT * FROM main_user.measurement where deleted=0";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Measurement measurement = new Measurement();
            measurement.setId(resultSet.getLong("id"));
            measurement.setNameUz(resultSet.getString("name_uz"));
            measurement.setNameRu(resultSet.getString("name_ru"));
            return measurement;
        });
    }

    public void save(MeasurementDTO dto) {
        String sql = "INSERT INTO main_user.measurement (name_uz, name_ru, created_by) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, dto.getNameUz(), dto.getNameRu(), sessionUser.getId());
    }

    public void update(MeasurementWithIdDTO dto) {
        String sql = "UPDATE main_user.measurement SET name_uz=?, name_ru=?, updated_by=?, updated_at=? WHERE id=?";
        jdbcTemplate.update(sql, dto.getNameUz(), dto.getNameRu(),sessionUser.getId(), LocalDateTime.now(), dto.getId());
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.measurement SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql,sessionUser.getId(), LocalDateTime.now(), id);
    }
}