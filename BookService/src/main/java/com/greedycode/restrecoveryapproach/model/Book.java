package com.greedycode.restrecoveryapproach.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Book {
    @Id
    private Long bookId;
    private String bookName;
    private double price;
    private double isbn;
    private String author;
}
