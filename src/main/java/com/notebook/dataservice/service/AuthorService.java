package com.notebook.dataservice.service;

import com.notebook.dataservice.dao.AuthorDAO;
import com.notebook.dataservice.dto.Author;
import com.notebook.dataservice.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
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
            return parser.parse(existingAuthor.get());
        } else {
            return parser.parse(repository.save(parser.parse(author)));
        }
    }

    public Author getByAlias(String alias) {
        return parser.parse(repository.findByAlias(alias).orElseThrow());
    }

    public AuthorDAO getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<String> getAll() {
        return repository.findAllAliases().stream().toList();
    }
}
