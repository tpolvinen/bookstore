package com.polvinen.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tatu on 09/02/17.
 */

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}