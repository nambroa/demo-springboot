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
}
