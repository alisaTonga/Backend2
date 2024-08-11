package org.example.app.repository;

import org.example.app.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class BookRepository implements BookRepositoryInterface{
    List<Book> library = List.of(
          new Book(1L,"Five Feet Apart","Rachael Lippincott", 2018, "9781471184505"),
          new Book(2L,"Fahrenheit 451","Ray Bradbury", 1996, "9780345410016"),
          new Book(3L,"Dubrovskiy","Pushkin Aleksandr Sergeevich", 2018, "9785389026742"),
          new Book(4L,"Tenet","Christopher Nolan", 2020, "9780571362738"),
          new Book(5L,"Amphibian man","Alexander Belyaev", 1986, "9785050006592"),
          new Book(6L,"Professor Dowell's Head","Alexander Belyaev", 1980, "9780025083707"),
          new Book(7L,"Around the World in 80 Days","Jules Verne", 1978, "9782010047299"),
          new Book(8L,"20 000 Leagues Under the Sea","Jules Verne", 2017, "9781979954129")
    );
    @Override
    public List<Book> findAll() {
        return library;
    }

    @Override
    public List<Book> findByAuthor(String author) {
        List<Book> foundedBooks = new ArrayList<>();
        for (Book book:  library){
            if (book.getAuthor().equals(author)){
                foundedBooks.add(book);
            }
        }
        return foundedBooks;
    }

    @Override
    public Book findBookById(Long id) {
        Book foundedBook = null;
        for (Book book:  library){
            if (book.getId().equals(id)){
                foundedBook = book;
            }
        }
        return foundedBook;
    }
}
