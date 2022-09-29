package com.notebook.dataservice.service;

import com.notebook.dataservice.dao.AuthorDAO;
import com.notebook.dataservice.dto.Author;
import com.notebook.dataservice.dto.Note;
import com.notebook.dataservice.exception.EntityAlreadyExistsException;
import com.notebook.dataservice.exception.EntityNotFoundException;
import com.notebook.dataservice.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private DAOParser parser;

    public AuthorService(AuthorRepository repository, DAOParser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    public Author add(Author author) {
        Optional<AuthorDAO> existingAuthor = repository.findByAlias(author.getAlias());
        if(existingAuthor.isEmpty()) {
            return parser.parse(repository.save(parser.parse(author)));
        } else if (author.getAlias().equals(existingAuthor.get().getAlias())) {
            throw new EntityAlreadyExistsException("Author already exists.", parser.parse(existingAuthor.get()));
        } else {
            return parser.parse(repository.save(parser.parse(author)));
        }
    }

    public Author mergeNotes(Note note, String alias) {
        Optional<AuthorDAO> potentialAuthor = repository.findByAlias(alias);
        if(potentialAuthor.isEmpty()) {
            throw new EntityNotFoundException("Author not found.");
        } else {
            AuthorDAO existingAuthor = potentialAuthor.get();
            existingAuthor.getNotes()
                    .add(parser.parse(note));
            return parser.parse(repository.save(existingAuthor));
        }
    }

    public Author getByAlias(String alias) {
        try {
            return parser.parse(repository.findByAlias(alias).orElseThrow());
        } catch (NoSuchElementException ex) {
            throw new EntityNotFoundException("Author not found.");
        }
    }

    public AuthorDAO getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<String> getAll() {
        return repository.findAllAliases().stream().toList();
    }
}
