package com.notebook.dataservice.repository;

import com.notebook.dataservice.dao.AuthorDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorDAO, Long> {
    Optional<AuthorDAO> findByAlias(String alias);
}
