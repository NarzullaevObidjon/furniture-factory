package com.company.furniturefactory.service;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.dao.CategoryDAO;
import com.company.furniturefactory.domain.Category;
import com.company.furniturefactory.dto.category.CategoryDTO;
import com.company.furniturefactory.dto.category.CategoryWithIdDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDAO categoryDao;

    public List<Category> getAll() {
        return categoryDao.getAllCategories();
    }

    public void add(CategoryDTO categoryDTO) {
        categoryDao.save(categoryDTO);
    }

    public void update(CategoryWithIdDTO categoryDTO) {
        categoryDao.update(categoryDTO);
    }

    public void delete( Long id) {
        categoryDao.delete(id);
    }

}
