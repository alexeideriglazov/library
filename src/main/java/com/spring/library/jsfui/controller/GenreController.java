package com.spring.library.jsfui.controller;

import com.spring.library.dao.GenreDao;
import com.spring.library.domain.Genre;
import com.spring.library.jsfui.model.LazyDataTable;
import lombok.Getter;
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
public class GenreController extends  AbstractController<Genre>{
    private int rowsCount = 20;
    private int first;

    @Autowired
    private GenreDao genreDao;

    private Genre selectedGenre;

    private LazyDataTable<Genre> lazyModel;

    private Page<Genre> genrePages;

    @PostConstruct
    public void init(){
        lazyModel = new LazyDataTable(this);
    }

    @Override
    public Page<Genre> search(int first, int count, String sortField, Sort.Direction sortDirection) {
        return genrePages;
    }

    public List<Genre> getAll() {
        return genreDao.getAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
