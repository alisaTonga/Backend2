package org.example.app.service;

import org.example.app.entity.Book;

import java.util.List;

public interface BookServiceInterface {

    List<Book> findAll();
    List<Book> findByAuthor(String author);
    Book findBookById(Long id);
}
