package com.greedycode.restrecoveryapproach.service;

import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book){
        log.info("Save the book in the database");
        return bookRepository.save(book);
    }

    public Book bookById(Long id){
        log.info("fetch the book from database using the ID");
        return bookRepository.findById(id).get();
    }

    public List<Book> allBooks(){
        log.info("fetch all books from database");
        return bookRepository.findAll();
    }

    public Book bookByIsbn(double isbn){
        log.info("fetch the books from database by specific ISBN");
        return bookRepository.findByIsbn(isbn);
    }
}
