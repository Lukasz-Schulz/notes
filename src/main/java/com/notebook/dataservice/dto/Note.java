package com.notebook.dataservice.dto;

public class Note {

    private Long id;
    private String title;
    private String message;
    private Author author;

    public Note(Long id, String title, String message, Author author) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
