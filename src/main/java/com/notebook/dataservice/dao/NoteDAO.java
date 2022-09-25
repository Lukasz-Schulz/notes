package com.notebook.dataservice.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@Entity
public class NoteDAO {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    @Cascade(CascadeType.MERGE)
    private AuthorDAO author;

    public NoteDAO() {}
    public NoteDAO(Long id, String title, String message, AuthorDAO author) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthorDAO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDAO author) {
        this.author = author;
    }
}
