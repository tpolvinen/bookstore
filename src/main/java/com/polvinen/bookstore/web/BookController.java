package com.polvinen.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;

/**
 * Created by tatu on 06/02/17.
 */

@Controller
public class BookController {
    @Autowired
    private BookRepository repository;

//    @RequestMapping(value="/index", method=RequestMethod.GET)
//    public String indexForm() {
//        return "index";
//    }

    @RequestMapping(value="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value="/booklist", method=RequestMethod.GET)
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        repository.delete(bookId);
        return "redirect:../booklist";
    }
}
