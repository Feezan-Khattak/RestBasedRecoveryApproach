/**
 * COPYRIGHT. Vialogic Private Ltd 2022. ALL RIGHTS RESERVED.
 * This software is only to be used for the purpose of which it has been provided. No part of it is to be reproudced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer language in any way or for any other purposes whatsoever without the prior
 * written consent of Vialogic Private Ltd.
 */


package com.greedycode.restrecoveryapproach.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class AuthorClient {

    @Value("${authors.get.all.author}")
    private String authors;

    @Value("${authors.get.author.by.id}")
    private String authorById;

    @Value("${authors.get.author.by.name}")
    private String authorName;

    private final RestTemplate restTemplate;

    public AuthorClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Object> getAllAuthors(){
        HttpEntity<Object> httpEntity = new HttpEntity<>(getHeader());
        log.info("uri: " + authors + "");
        Object data = null;
        try {
            ResponseEntity<Object> restResponse = restTemplate.exchange(
                    authors,
                    HttpMethod.GET,
                    httpEntity,
                    Object.class
            );

            log.info("Rest response: " + restResponse);
            if(restResponse.getBody() != null) {
                data = restResponse.getBody();
            }

        }catch (Exception err){
            log.info("Can't fetch all authors: " + err.getLocalizedMessage());
        }
            return List.of(data);
    }

    public Object getAuthorById(Long id){
        HttpEntity<Object> httpEntity = new HttpEntity<>(getHeader());
        log.info("uri: " + authors + "" + id);
        Object data = null;
        try {
            ResponseEntity<Object> restResponse = restTemplate.exchange(
                    authorById + "" + id,
                    HttpMethod.GET,
                    httpEntity,
                    Object.class
            );

            log.info("Rest response: " + restResponse);
            if(restResponse.getBody() != null) {
                data = restResponse.getBody();
            }

        }catch (Exception err){
            log.info("Can't fetch author by Id: " + err.getLocalizedMessage());
        }
        return data;
    }

    public Object getAuthorByName(String name){
        HttpEntity<Object> httpEntity = new HttpEntity<>(getHeader());
        log.info("uri: " + authors + "" + name);
        Object data = null;
        try {
            ResponseEntity<Object> restResponse = restTemplate.exchange(
                    authorName + "" + name,
                    HttpMethod.GET,
                    httpEntity,
                    Object.class
            );

            log.info("Rest response: " + restResponse);
            if(restResponse.getBody() != null) {
                data = restResponse.getBody();
            }

        }catch (Exception err){
            log.info("Can't fetch author by name: " + err.getLocalizedMessage());
        }
        return data;
    }

    private HttpHeaders getHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
