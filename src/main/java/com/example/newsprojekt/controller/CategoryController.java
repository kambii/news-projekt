package com.example.newsprojekt.controller;

import com.example.newsprojekt.entity.Article;
import com.example.newsprojekt.entity.Category;
import com.example.newsprojekt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/get-category{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @PostMapping("/add-category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category createCategory = categoryService.createCategory(category);
        return ResponseEntity.ok(createCategory);
    }

    @PutMapping("/update-category{id}")
    public ResponseEntity updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updatedCategory = categoryService.updateCategory(id,category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/delete-category{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
