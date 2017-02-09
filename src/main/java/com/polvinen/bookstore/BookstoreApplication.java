package com.polvinen.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;
import com.polvinen.bookstore.domain.User;
import com.polvinen.bookstore.domain.UserRepository;

/**
 * Created by tatu on 06/02/17.
 */

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreRunner(BookRepository brepository, UserRepository urepository) {
		return (args) -> {
			log.info("Save a couple of BOOKS!");
			brepository.save(new Book("asdf", "ökuhpiuh", 2000, "1234567890123", 123.12));
			brepository.save(new Book("liuyft", "puiyoiuy", 2001, "1234567890124", 22.0));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("Fetch all BOOKS!");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
