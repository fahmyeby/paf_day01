package com.example.paf_day01kindle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.paf_day01kindle.model.Book;
import com.example.paf_day01kindle.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // landing
    @GetMapping("/")
    public ModelAndView landingPage() {
        ModelAndView mav = new ModelAndView("landing");
        return mav;
    }

    // results
    @GetMapping("/search")
    public ModelAndView searchBooks(
            @RequestParam String author,
            @RequestParam(defaultValue = "10") int results) {
        List<Book> books = bookService.getByAuthor(author, results);
        ModelAndView mav = new ModelAndView("results");
        mav.addObject("books", books);
        return mav;
    }

    // details
    @GetMapping("/details/{asin}")
    public ModelAndView bookDetails(@PathVariable String asin) {
        Book book = bookService.getByAsin(asin);
        ModelAndView mav = new ModelAndView("details");
        mav.addObject("book", book);
        return mav;
    }
}
