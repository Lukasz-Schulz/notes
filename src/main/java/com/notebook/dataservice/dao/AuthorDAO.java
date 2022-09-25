package com.notebook.dataservice.dao;

import javax.persistence.*;
import java.util.List;

@Entity
public class AuthorDAO {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 20)
    private String alias;
    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String surname;
    @Column(length = 40)
    private String email;
    @Column
    @OneToMany(fetch = FetchType.EAGER)
    private List<NoteDAO> notes;

    public AuthorDAO() {

    }
    public AuthorDAO(Long id, String alias) {

        this.alias = alias;
        this.id = id;
    }

    public AuthorDAO(Long id, String alias, String name, String surname, String email, List<NoteDAO> notes) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.notes = notes;
    }

    public Long getId() {
        return id;
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

    public List<NoteDAO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDAO> notes) {
        this.notes = notes;
    }
}
