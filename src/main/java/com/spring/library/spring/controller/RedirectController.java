package com.spring.library.spring.controller;

import com.spring.library.dao.impl.BookService;
import com.spring.library.domain.Book;
import com.spring.library.spring.repository.AuthorRepository;
import com.spring.library.spring.repository.BookRepository;
import com.spring.library.spring.repository.GenreRepository;
import com.spring.library.spring.repository.PublisherRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log
public class RedirectController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {
       return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }
}


