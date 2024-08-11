package org.example.app.service;

import org.example.app.entity.Book;
import org.example.app.repository.BookRepository;
import org.example.app.repository.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookService implements BookServiceInterface{
    private final BookRepositoryInterface repository;
    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    @Override
    public Book findBookById(Long id) {
        return repository.findBookById(id);
    }
}
