package com.spring.library.spring.repository;

import com.spring.library.domain.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByNameContainingIgnoreCaseOrderByName(String name);

    Page<Author> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);
}
