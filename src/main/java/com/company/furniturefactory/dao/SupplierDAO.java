package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Client;
import com.company.furniturefactory.domain.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SupplierDAO {

    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<Supplier> getAll() {
        String sql = "SELECT * FROM main_user.supplier where deleted=0";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Supplier supplier = new Supplier();
            supplier.setId(resultSet.getLong("id"));
            supplier.setName(resultSet.getString("name"));
            supplier.setPhone(resultSet.getString("phone"));
            return supplier;
        });
    }

    public void add(String name, String phone) {
        jdbcTemplate.update("insert into main_user.supplier(name, phone) values(?,?)", name, phone);
    }

    public void update(String name, String phone, Long id) {
        String sql = "UPDATE main_user.supplier SET name=?, phone=?, updated_by=?, updated_at=? WHERE id=?";
        jdbcTemplate.update(sql, name, phone, sessionUser.getId(), LocalDateTime.now(), id);
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.supplier SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql, sessionUser.getId(), LocalDateTime.now(), id);
    }
}
