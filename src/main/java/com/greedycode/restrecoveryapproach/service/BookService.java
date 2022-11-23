package com.greedycode.restrecoveryapproach.service;

import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book bookById(Long id){
        return bookRepository.findById(id).get();
    }

    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public Book bookByIsbn(double isbn){
        return bookRepository.findByIsbn(isbn);
    }
}
