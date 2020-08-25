package com.spring.library.spring.repository;

import com.spring.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCaseOrAuthorNameContainingIgnoreCaseOrderByName(String bookName, String authorName);
}
