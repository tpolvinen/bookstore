package com.polvinen.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tatu on 08/02/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
