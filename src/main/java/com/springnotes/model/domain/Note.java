package com.springnotes.model.domain;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    public Note(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Note() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
