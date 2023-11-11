package com.example.newsprojekt.repository;

import com.example.newsprojekt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
