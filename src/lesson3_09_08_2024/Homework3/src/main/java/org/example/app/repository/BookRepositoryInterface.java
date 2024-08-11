package org.example.app.repository;

import org.example.app.entity.Book;

import java.util.List;

public interface BookRepositoryInterface {
    List<Book> findAll();
    List<Book> findByAuthor(String author);
    Book findBookById(Long id);

}
