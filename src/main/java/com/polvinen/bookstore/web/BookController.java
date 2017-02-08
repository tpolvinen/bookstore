package com.polvinen.bookstore.web;

/**
 * Created by tatu on 06/02/17.
 */

import com.polvinen.bookstore.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

//    @RequestMapping(value="/index", method=RequestMethod.GET)
//    public String indexForm() {
//        return "index";
//    }

    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}
