package com.polvinen.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.polvinen.bookstore.domain.Book;
import com.polvinen.bookstore.domain.BookRepository;
import com.polvinen.bookstore.domain.User;
import com.polvinen.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreReactApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreReactApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner bookDemo(BookRepository brepository,  UserRepository urepository) {
		return (args) -> {
			
			brepository.save(new Book("asdf", "ökuhpiuh", 2000, "1234567890123", 123.12));
			brepository.save(new Book("liuyft", "puiyoiuy", 2001, "1234567890124", 22.0));

			// Create users: admin/admin user/user
			// Hibernate: insert into user (id, email, password, role, username) values (null, ?, ?, ?, ?)
						User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com", "USER");
						User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@bookstore.com", "ADMIN");
						urepository.save(user1);
						urepository.save(user2);
					};
				}
			}