package com.notebook.dataservice.repository;

import com.notebook.dataservice.dao.AuthorDAO;
import com.notebook.dataservice.dto.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDAO, Long> {
    Optional<AuthorDAO> findByAlias(String alias);

    @Query("SELECT alias FROM AuthorDAO")
    Collection<String> findAllAliases();
}
