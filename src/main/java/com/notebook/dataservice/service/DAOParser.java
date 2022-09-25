package com.notebook.dataservice.service;

import com.notebook.dataservice.dao.AuthorDAO;
import com.notebook.dataservice.dao.NoteDAO;
import com.notebook.dataservice.dto.Author;
import com.notebook.dataservice.dto.Note;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DAOParser {
    private Note note;

    public Note parse(NoteDAO dao) {
        Note dto = new Note(dao.getId(),
                dao.getTitle(),
                dao.getMessage(),
                new Author(dao.getAuthor().getId(), dao.getAuthor().getAlias()));
        dto.setId(dto.getId());
        return dto;
    }

    public NoteDAO parse(Note dto) {
        NoteDAO dao = new NoteDAO(dto.getId(),
                dto.getTitle(),
                dto.getMessage(),
                new AuthorDAO(dto.getAuthor().getId(), dto.getAuthor().getAlias()));
        return dao;
    }

    public Author parse(AuthorDAO dao) {
        Author dto = new Author(dao.getId(),
                dao.getAlias(),
                dao.getName(),
                dao.getSurname(),
                dao.getEmail(),
                dao.getNotes() == null ? List.of() : dao.getNotes()
                        .stream()
                        .map(this::parse)
                        .collect(Collectors.toList()));
        return dto;
    }

    public AuthorDAO parse(Author dto) {
        AuthorDAO dao = new AuthorDAO(
                dto.getId(),
                dto.getAlias(),
                dto.getName(),
                dto.getSurname(),
                dto.getEmail(),
                dto.getNotes() == null ? List.of() : dto.getNotes()
                        .stream()
                        .map(this::parse)
                        .collect(Collectors.toList())
        );
        return dao;
    }
}
