package com.greedycode.authorservice;

import com.greedycode.authorservice.model.Author;
import com.greedycode.authorservice.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class AuthorServiceApplication {

	@Autowired
	private AuthorService authorService;


	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}

	@PostConstruct
	public void loadDatabase(){
		Author author1 = new Author(200L, "Haider Khan", 2L, "Islamabad");
		Author author2 = new Author(201L, "Asad Rehman", 1L, "Nowshera");
		Author author3 = new Author(202L, "Asif Ali", 5L, "Akora Khattak");
		Author author4 = new Author(203L, "Michal John", 20L, "Nizampur");
		Author author5 = new Author(204L, "Kashif Mansori", 9L, "Punjab");
		Author author6 = new Author(205L, "Amir Saleem", 8L, "Sindh");
		Author author7 = new Author(206L, "Asif Ali", 2L, "Gilgit");
		Author author8 = new Author(207L, "Feezan Khattak", 27L, "Shaidu");

		log.info("Feeding database with some random authors");

		authorService.saveAuthor(author1);
		authorService.saveAuthor(author2);
		authorService.saveAuthor(author3);
		authorService.saveAuthor(author4);
		authorService.saveAuthor(author5);
		authorService.saveAuthor(author6);
		authorService.saveAuthor(author7);
		authorService.saveAuthor(author8);

		log.info("Random authors saved successfully");

	}
}
