package com.greedycode.restrecoveryapproach;

import com.greedycode.restrecoveryapproach.model.Book;
import com.greedycode.restrecoveryapproach.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class RestRecoveryApproachApplication{

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(RestRecoveryApproachApplication.class, args);
	}

	@PostConstruct
	public void setup(){
		log.info("Setting up default Data for Database");
		Book book1 = new Book(100L, "The Five Stars", 1200, 46124, "Haider Khan");
		Book book2 = new Book(101L, "Suno Tum sitari ho", 800, 26257, "Asad Rehman");
		Book book3 = new Book(102L, "Pillars Of Islam", 2000, 48414, "Asif Ali");
		Book book4 = new Book(103L, "Data Structure & Algorithm", 1000, 26909, "Michal John");

		bookService.saveBook(book1);
		log.info("Book-1 stored successfully");
		bookService.saveBook(book2);
		log.info("Book-2 stored successfully");
		bookService.saveBook(book3);
		log.info("Book-3 stored successfully");
		bookService.saveBook(book4);
		log.info("Book-4 stored successfully");

	}
}
