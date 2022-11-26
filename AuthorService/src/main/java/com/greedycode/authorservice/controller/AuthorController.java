/**
 * COPYRIGHT. Vialogic Private Ltd 2022. ALL RIGHTS RESERVED.
 * This software is only to be used for the purpose of which it has been provided. No part of it is to be reproudced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer language in any way or for any other purposes whatsoever without the prior
 * written consent of Vialogic Private Ltd.
 */


package com.greedycode.authorservice.controller;

import com.greedycode.authorservice.model.Author;
import com.greedycode.authorservice.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    ResponseEntity<Author> savinAuthor(@RequestBody Author author){
        log.info("Post request for saving author details");
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @GetMapping
    ResponseEntity<List<Author>> getAllAuthors(){
        log.info("Get request for all authors");
        return ResponseEntity.ok(authorService.findAllAuthor());
    }

    @GetMapping("/author/id/{id}")
    ResponseEntity<Author> getAuthorById(@PathVariable Long id){
        log.info("Get request for author using its ID");
        return ResponseEntity.ok(authorService.findAuthorByAuthorId(id));
    }

    @GetMapping("/author/name/{name}")
    ResponseEntity<Author> getAuthorByName(@PathVariable String name){
        log.info("Get request for author using its name");
        return ResponseEntity.ok(authorService.findAuthorByAuthorName(name));
    }
}
