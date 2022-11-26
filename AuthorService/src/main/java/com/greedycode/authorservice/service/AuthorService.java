/**
 * COPYRIGHT. Vialogic Private Ltd 2022. ALL RIGHTS RESERVED.
 * This software is only to be used for the purpose of which it has been provided. No part of it is to be reproudced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer language in any way or for any other purposes whatsoever without the prior
 * written consent of Vialogic Private Ltd.
 */


package com.greedycode.authorservice.service;

import com.greedycode.authorservice.model.Author;
import com.greedycode.authorservice.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(Author author){
        log.info("Saving Author record into database");
        return authorRepository.save(author);
    }

    public List<Author> findAllAuthor(){
        log.info("Fetching all Author From Database");
        return authorRepository.findAll();
    }

    public Author findAuthorByAuthorName(String name){
        log.info("Searching for Author whose name is " + name);
        return authorRepository.findByAuthorName(name);
    }

    public Author findAuthorByAuthorId(Long id){
        log.info("Searching For Author whose Id is " + id);
        return authorRepository.findById(id).get();
    }

}
