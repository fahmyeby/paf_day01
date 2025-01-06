package com.example.paf_day01kindle.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.example.paf_day01kindle.model.Book;

@Repository
public class BookRepo {
    @Autowired private JdbcTemplate template;

    // default method with limit of 10
    public List<Book> getBooks(){
        return getBooks(10);
    }
    
    // get with specified limit
    public List<Book> getBooks(int limit){
        SqlRowSet rs = template.queryForRowSet(Queries.SEARCH_LIMIT, limit);
        List<Book> books = new LinkedList<>();
        while (rs.next()){
            books.add(Book.toBook(rs));
        } return books;
    }

    // get by author with specified limit
    public List<Book> getByAuthor(String author, int limit){
        SqlRowSet rs = template.queryForRowSet(Queries.SEARCH_BY_AUTHOR, "%" + author + "%", limit);
        List<Book> books = new LinkedList<>();
        while(rs.next()){
            books.add(Book.toBook(rs));
        } return books;
    }

    public Book getByAsin(String asin) {
        SqlRowSet rs = template.queryForRowSet(Queries.SEARCH_BY_ASIN, asin);
        if (rs.next()) {
            return Book.toBook(rs);
        }
        return null;
    }
}