package org.example.app.controller;

import org.example.app.entity.Book;
import org.example.app.service.BookService;
import org.example.app.service.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookController {
    BookServiceInterface service;
    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    public List<Book> findAll() {
        return service.findAll();
    }


    public List<Book> findByAuthor(String author) {
        return service.findByAuthor(author);
    }


    public Book findBookById(Long id) {
        return service.findBookById(id);
    }
}
