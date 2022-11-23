package com.greedycode.restrecoveryapproach.controller;


import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    ResponseEntity<List<Book>> books(){
        return ResponseEntity.ok(bookService.allBooks());
    }

    @GetMapping("/book/{id}")
    ResponseEntity<Book> bookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.bookById(id));
    }

    @GetMapping("/book/{isbn}")
    ResponseEntity<Book> bookByIsbn(@PathVariable double isbn){
        return ResponseEntity.ok(bookService.bookByIsbn(isbn));
    }

    @PostMapping("/")
    ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.saveBook(book));
    }



}
