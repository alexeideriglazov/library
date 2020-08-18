package com.spring.library.dao;

import com.spring.library.domain.Book;

import java.util.List;

public interface BookDao extends GeneralDAO<Book> {
    List<Book> findTopBooks(int limit);
}
