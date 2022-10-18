package com.ciclo3.reto3.service;

import com.ciclo3.reto3.entities.Category;
import com.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean deleteCategory(int id) {
        Optional<Category> categoryd = categoryRepository.getCategory(id);

        if (categoryd.isEmpty()) {
            return false;
        } else {
            categoryRepository.delete(categoryd.get());
            return true;
        }
    }

    public Category updateCategory(Category category) {

        if (category.getId() != null) {
            Optional<Category> categoryU = categoryRepository.getCategory(category.getId());
            if (!categoryU.isEmpty()) {
                for (Field f : category.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(category);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(categoryU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return categoryRepository.save(categoryU.get());
        }
        return category;
    }
}