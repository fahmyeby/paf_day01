package com.example.paf_day01kindle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paf_day01kindle.model.Book;
import com.example.paf_day01kindle.repo.BookRepo;

@Service
public class BookService {
    @Autowired private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.getBooks();
    }

    public List<Book> getBooks(int limit){
        return bookRepo.getBooks(limit);
    }

    public List<Book> getByAuthor(String author, int limit){
        return bookRepo.getByAuthor(author, limit);
    }

    public Book getByAsin(String asin){
        return bookRepo.getByAsin(asin);
    }
}
