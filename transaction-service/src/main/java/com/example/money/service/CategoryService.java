package com.example.money.service;

import com.example.money.dto.CategoryDto;
import com.example.money.enums.CategoryGroup;
import com.example.money.model.Category;
import com.example.money.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CategoryDto categoryDto) {
        if (categoryRepository.findByName(categoryDto.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Category already exists");
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setGroup(CategoryGroup.fromValue(categoryDto.getCategory()).getValue());
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
