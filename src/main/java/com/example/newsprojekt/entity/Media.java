package com.example.newsprojekt.entity;

import com.example.newsprojekt.enums.MediaType;
import jakarta.persistence.*;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;  // The URL or path to the media file
    private MediaType type;  // Enum for media type (e.g., IMAGE, VIDEO)
    @OneToOne(mappedBy = "media")
    private Article article;

    private int width;
    private int height;


    public Media() {
    }

    public Media(String name, String url, MediaType type, Article article, int width, int height) {
        this.name = name;
        this.url = url;
        this.type = type;
        this.article = article;
        this.width = width;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
