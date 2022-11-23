package com.greedycode.restrecoveryapproach.repository;

import com.greedycode.restrecoveryapproach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(double isbn);
}
