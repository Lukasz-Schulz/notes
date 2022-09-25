package com.notebook.dataservice.repository;

import com.notebook.dataservice.dao.NoteDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteDAO, Long> {

}
