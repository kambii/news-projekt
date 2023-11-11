package com.example.newsprojekt.controller;

import com.example.newsprojekt.entity.Article;
import com.example.newsprojekt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/getArticles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/get-article{id}")
    public Article getArticle(@PathVariable Long id) {
        return articleService.getArticle(id);
    }

    @PostMapping("/add-article")
    public ResponseEntity<Article> createArticle(@RequestBody Article article){
        Article createArticle = articleService.createArticle(article);
        return ResponseEntity.ok(createArticle);
    }

    @PutMapping("/update-article{id}")
    public ResponseEntity updateArticle(@PathVariable Long id, @RequestBody Article article){
        Article updatedArticle = articleService.updateArticle(id,article);
        return ResponseEntity.ok(updatedArticle);
    }

    @DeleteMapping("/delete-article{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id){
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }
}
