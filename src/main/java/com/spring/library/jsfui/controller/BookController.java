package com.spring.library.jsfui.controller;

import com.spring.library.dao.BookDao;
import com.spring.library.domain.Book;
import com.spring.library.jsfui.enums.SearchType;
import com.spring.library.jsfui.model.LazyDataTable;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
@Component
@Getter
@Setter
@Log
public class BookController extends AbstractController {
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static final int TOP_BOOKS_LIMIT = 5;

    private int rowsCount = DEFAULT_PAGE_SIZE;

    private SearchType searchType;

    @Autowired
    private BookDao bookDao;

    private LazyDataTable<Book> lazyModel;

    private Page<Book> bookPages;


    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable(this);
    }

    @Override
    public Page search(int first, int count, String sortField, Sort.Direction sortDirection) {
        if (sortField == null) {
            sortField = "name";
        }
        if (searchType == null) {
            bookPages = bookDao.getAll(first, count, sortField, sortDirection);
        } else {
            switch (searchType) {
                case SEARCH_GENRE:
                    break;
                case SEARCH_TEXT:
                    break;
                case ALL:
                    bookPages = bookDao.getAll(first, count, sortField, sortDirection);
                    break;
            }
        }
        return bookPages;
    }

    public List<Book> getTopBooks(){
        return bookDao.findTopBooks(TOP_BOOKS_LIMIT);
    }
}
