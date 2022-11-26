package com.greedycode.restrecoveryapproach.controller;


import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    ResponseEntity<List<Book>> books(){
        log.info("A rest response with all books");
        return ResponseEntity.ok(bookService.allBooks());
    }

    @GetMapping("/book/id/{id}")
    ResponseEntity<Book> bookById(@PathVariable Long id){
        log.info("A rest response with a single book by ID");
        return ResponseEntity.ok(bookService.bookById(id));
    }

    @GetMapping("/book/isbn/{isbn}")
    ResponseEntity<Book> bookByIsbn(@PathVariable double isbn){
        log.info("A rest response with a single book by ISBN");
        return ResponseEntity.ok(bookService.bookByIsbn(isbn));
    }

    @PostMapping
    ResponseEntity<Book> saveBook(@RequestBody Book book){
        log.info("A rest response to add new book");
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @GetMapping("/authors")
    ResponseEntity<List<Object>> authors(){
        log.info("A rest response to fetch all authors");
        return ResponseEntity.ok(bookService.fetchAllAuthors());
    }

    @GetMapping("/authors/author/id/{id}")
    ResponseEntity<Object> authorById(@PathVariable Long id){
        log.info("A rest response to fetch author by id");
        return ResponseEntity.ok(bookService.fetchAuthorById(id));
    }

    @GetMapping("/authors/author/name/{name}")
    ResponseEntity<Object> authorByName(@PathVariable String name){
        log.info("A rest response to fetch author by id");
        return ResponseEntity.ok(bookService.fetchAuthorByName(name));
    }



}
