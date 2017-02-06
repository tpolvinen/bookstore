package com.polvinen.bookstore.domain;

/**
 * Created by tatu on 06/02/17.
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
// import java.util.Currency; // see: http://www.javapractices.com/topic/TopicAction.do?Id=13

// import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private String author;
    @Getter @Setter private Integer year;
    @Getter @Setter private String isbn;
    @Getter @Setter private BigDecimal price;

}
