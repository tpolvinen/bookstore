package com.polvinen.bookstore.web;

/**
 * Created by tatu on 06/02/17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexForm() {
        return "index";
    }
}
