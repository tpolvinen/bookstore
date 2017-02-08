package com.polvinen.bookstore;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreRunner(BookRepository repository) {
		return (args) -> {
			log.info("Save a couple of BOOKS!");
			repository.save(new Book("asdf", "ökuhpiuh", 2000, "1234567890123", 123.12));
			repository.save(new Book("liuyft", "puiyoiuy", 2001, "1234567890124", 22.0));
			log.info("Fetch all BOOKS!");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
