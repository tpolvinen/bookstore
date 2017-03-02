package com.polvinen.bookstore.domain;

/**
 * Created by tatu on 06/02/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

// import java.math.BigDecimal;
// import java.util.Currency; // see: http://www.javapractices.com/topic/TopicAction.do?Id=13

// import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private String author;
    @Getter @Setter private Integer year;
    @Getter @Setter private String isbn;
    @Getter @Setter private Double price;

    //@ManyToOne
    // @JsonIgnore

    public Book() {}

    public Book(String title, String author, Integer year, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
}
