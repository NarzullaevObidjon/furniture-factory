package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.domain.Client;
import com.company.furniturefactory.dto.category.CategoryWithIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientDAO {

    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<Client> getAll() {
        String sql = "SELECT * FROM main_user.client where deleted=0";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Client client = new Client();
            client.setId(resultSet.getLong("id"));
            client.setName(resultSet.getString("name"));
            client.setPhone(resultSet.getString("phone"));
            return client;
        });
    }

    public void add(String name, String phone) {
        jdbcTemplate.update("insert into main_user.client(name, phone) values(?,?)", name, phone);
    }

    public void update(String name, String phone, Long id) {
        String sql = "UPDATE main_user.client SET name=?, phone=?, updated_by=?, updated_at=? WHERE id=?";
        jdbcTemplate.update(sql, name, phone, sessionUser.getId(), LocalDateTime.now(), id);
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.client SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql, sessionUser.getId(), LocalDateTime.now(), id);
    }
}
