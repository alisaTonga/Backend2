package org.example;

import org.example.app.controller.BookController;
import org.example.app.entity.Book;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example.app");
        BookController controller = context.getBean(BookController.class);
        List<Book> books = controller.findAll();
        for (Book book: books){
            System.out.println(book);
        }
    }
}