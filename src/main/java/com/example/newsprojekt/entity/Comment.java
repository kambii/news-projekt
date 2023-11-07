package com.example.newsprojekt.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    // Author (linked to a User entity)

    private Date date;
    private String parentComment; // for replies to comments
    @ManyToOne
    @JoinColumn(name="article_id", nullable=false)
    private Article article;

    public Comment() {
    }

    public Comment(String content, Date date, String parentComment, Article article) {
        this.content = content;
        this.date = date;
        this.parentComment = parentComment;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getParentComment() {
        return parentComment;
    }

    public void setParentComment(String parentComment) {
        this.parentComment = parentComment;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
