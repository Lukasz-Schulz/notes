package com.notebook.dataservice.service;

import com.notebook.dataservice.dao.NoteDAO;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteServiceTest {

    private static Logger LOG = LoggerFactory
            .getLogger(NoteServiceTest.class);
    @Autowired
    private static NoteService service;

    void add() {
        service.getAll().forEach(note -> LOG.info(note.getMessage()));

        NoteDAO n1 = new NoteDAO();
        n1.setMessage("estrdhfdz");
        n1.setTitle("title1");
        NoteDAO n2 = new NoteDAO();
        n2.setMessage("estrdhfdz");
        n2.setTitle("title1");
        NoteDAO n3 = new NoteDAO();
        n3.setMessage("estrdhfdz");
        n3.setTitle("title1");

//        service.add(n1);
//        service.add(n2);
//        service.add(n3);

        service.getAll().forEach(note -> LOG.info(note.getMessage()));
    }

    @Test
    void delete() {
    }
}