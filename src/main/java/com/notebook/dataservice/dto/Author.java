package com.notebook.dataservice.dto;

import java.util.List;

public class Author {

    private Long id;
    private String alias;
    private String name;
    private String surname;
    private String email;
    private List<Note> notes;

    public Author(Long id, String alias, String name, String surname, String email, List<Note> notes) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.notes = notes;
    }

    public Author() {
    }

    public Author(Long id, String alias) {
        this.id = id;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", alias='" + alias + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", notes=" + notes +
                '}';
    }
}
