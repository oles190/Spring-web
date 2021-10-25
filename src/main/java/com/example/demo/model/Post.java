package com.example.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Data
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "anons")
    private String anons;
    @Column(name = "full_text")
    private String fullText;

    public Post(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Column(name = "views")
    private int views;

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Post(int id, String title, String anons, String fullText, int views) {
        this.id = id;
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
        this.views = views;
    }
}

