package com.notebook.dataservice.service;

import com.notebook.dataservice.dao.NoteDAO;
import com.notebook.dataservice.dto.Author;
import com.notebook.dataservice.dto.Note;
import com.notebook.dataservice.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.net.HttpRetryException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    public NoteService(NoteRepository noteRepository, AuthorService authorService, DAOParser parser) {
        this.noteRepository = noteRepository;
        this.authorService = authorService;
        this.parser = parser;
    }

    private final NoteRepository noteRepository;
    private final AuthorService authorService;
    private DAOParser parser;

    public List<Note> getAll() {
        return noteRepository.findAll().stream()
                .map(n -> parser.parse(n))
                .collect(Collectors.toList());
    }

    public Note add(Note note) {
        Author author = (authorService.getByAlias(note.getAuthor().getAlias()));
        note.getAuthor().setId(author.getId());
        NoteDAO savedNote = noteRepository.save(parser.parse(note));
        author.getNotes().add(parser.parse(savedNote));
        authorService.add(author);
        return parser.parse(savedNote);
    }

    public Note update(Note newNote) throws HttpRetryException {
        if(newNote.getId() != null) {
            NoteDAO oldNote = noteRepository.findById(newNote.getId()).orElseThrow();
            oldNote.setTitle(newNote.getTitle());
            oldNote.setMessage(newNote.getMessage());
            return parser.parse(noteRepository.save(oldNote));
        } else {
            throw new HttpRetryException("Please provide note id", 404);
        }
    }

    public void delete(Note note) {
        List<NoteDAO> notes = noteRepository.findAll();
        notes.remove(parser.parse(note));
        noteRepository.saveAll(notes);
    }
}
