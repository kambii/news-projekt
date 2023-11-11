package com.example.newsprojekt.service;

import com.example.newsprojekt.entity.Article;
import com.example.newsprojekt.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticle(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("article not found with id: " + id));
    }

    public Article createArticle(Article article) {
        article.setPublicationDate(LocalDateTime.now());
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article article) {
        Article currentArticle = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("article not found with id: " + id));

        article.setPublicationDate(LocalDateTime.now());

        currentArticle.setTitle(article.getTitle());
        currentArticle.setContent(article.getContent());
        currentArticle.setPublicationDate(article.getPublicationDate());
        currentArticle.setCategories(article.getCategories());
        currentArticle.setMedia(article.getMedia());
        currentArticle.setComments(article.getComments());
        currentArticle.setTags(article.getTags());

        return articleRepository.save(currentArticle);
    }

    public void deleteArticle(Long id) {
        Article currentArticle = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("article not found with id: " + id));

        articleRepository.delete(currentArticle);
    }
}
