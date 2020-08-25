package com.spring.library.spring.repository;

import com.spring.library.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    List<Genre> findByNameContainingIgnoreCaseOrderByName(String name);

}
