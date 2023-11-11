package com.example.newsprojekt.repository;

import com.example.newsprojekt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
