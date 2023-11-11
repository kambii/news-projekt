package com.example.newsprojekt.service;

import com.example.newsprojekt.entity.Article;
import com.example.newsprojekt.entity.Category;
import com.example.newsprojekt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategory(Long id) {

        return categoryRepository.findById(id).
                orElseThrow(() -> new RuntimeException("category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        category.setCreatedDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {

        Category currentCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found with id: " + id));
        category.setCreatedDate(LocalDateTime.now());

        currentCategory.setName(category.getName());
        currentCategory.setDescription(category.getDescription());
        currentCategory.setArticles(category.getArticles());
        currentCategory.setCreatedDate(category.getCreatedDate());

        return categoryRepository.save(currentCategory);
    }

    public void deleteCategory(Long id) {
        Category currentCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("category not found with id: " + id));

        categoryRepository.delete(currentCategory);
    }
}
