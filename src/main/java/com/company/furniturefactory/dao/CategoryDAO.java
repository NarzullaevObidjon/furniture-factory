package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.dto.category.CategoryDTO;
import com.company.furniturefactory.dto.category.CategoryWithIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDAO {

    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM main_user.category where deleted=0";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            Category category = new Category();
            category.setId(resultSet.getLong("id"));
            category.setNameUz(resultSet.getString("name_uz"));
            category.setNameRu(resultSet.getString("name_ru"));
            return category;
        });
    }

    public void save(CategoryDTO dto) {
        String sql = "INSERT INTO main_user.category (name_uz, name_ru,created_by) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, dto.getNameUz(), dto.getNameRu(), sessionUser.getId());
    }

    public void update(CategoryWithIdDTO dto) {
        String sql = "UPDATE main_user.category SET name_uz=?, name_ru=?, updated_by=?, updated_at=? WHERE id=?";
        jdbcTemplate.update(sql, dto.getNameUz(), dto.getNameRu(),sessionUser.getId(), LocalDateTime.now(), dto.getId());
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.category SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql,sessionUser.getId(), LocalDateTime.now(), id);
    }
}