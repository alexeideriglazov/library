package com.spring.library.dao;

import com.spring.library.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BookDao extends GeneralDAO<Book> {
    List<Book> findTopBooks(int limit);

    byte[] getContent(int id);

    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, int genreId);

    void updateViewCount(int viewCount, int id);

    void updateRating(int totalRating, int totalViewCount, int avgRating, int id);
}
