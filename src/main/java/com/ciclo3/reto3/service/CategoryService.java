package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Category;
import com.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if (!e.isEmpty()) {
                return c;
            } else {
                return categoryRepository.save(c);
            }
        }
    }
}