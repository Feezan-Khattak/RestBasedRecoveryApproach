package com.greedycode.restrecoveryapproach.service;

import com.greedycode.restrecoveryapproach.client.AuthorClient;
import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorClient authorClient;

    public BookService(BookRepository bookRepository, AuthorClient authorClient) {
        this.bookRepository = bookRepository;
        this.authorClient = authorClient;
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

    public List<Object> fetchAllAuthors(){
        log.info("fetching all authors details...");
        return authorClient.getAllAuthors();
    }

    public Object fetchAuthorById(Long id){
        log.info("fetching author by id");
        return authorClient.getAuthorById(id);
    }

    public Object fetchAuthorByName(String name){
        log.info("fetching author by id");
        return authorClient.getAuthorByName(name);
    }
}
