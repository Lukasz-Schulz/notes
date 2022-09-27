package com.notebook.dataservice.controller;

import com.notebook.dataservice.dto.Author;
import com.notebook.dataservice.dto.Note;
import com.notebook.dataservice.service.AuthorService;
import com.notebook.dataservice.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.net.HttpRetryException;
import java.util.List;

@RestController
public class NoteController {

    private static Logger LOG = LoggerFactory
            .getLogger(NoteController.class);
    private final NoteService service;
    private final AuthorService authorService;

    public NoteController(NoteService noteService, AuthorService authorService) {
        service = noteService;
        this.authorService = authorService;
    }

    @GetMapping("/notes/get")
    public List<Note> getAllNotes() {
        LOG.info("Receive get request on /notes/get.");
        return service.getAll();
    }

    @GetMapping("/author/get/{alias}")
    public Author getAuthor(@PathVariable String alias) {
        LOG.info("Receive get request on /author/get.");
        return authorService.getByAlias(alias);
    }

    @PostMapping("/notes/add")
    public Note postNewNote(@RequestBody Note note) {
        LOG.info("Receive post request.");
         return service.add(note);
    }

    @PostMapping("/author/add")
    public Author postNewAuthor(@RequestBody Author author) {
        LOG.info("Receive post request.");
         return authorService.add(author);
    }

    @PutMapping("notes/update")
    public Note update(@RequestBody Note note) throws HttpRetryException {
        return service.update(note);

    }
}
