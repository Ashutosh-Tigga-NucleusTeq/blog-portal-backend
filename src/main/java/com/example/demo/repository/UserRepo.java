package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepo interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for User objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
@Repository
public interface UserRepo extends MongoRepository<User, String> {

	/**
	 * method that fetch Entity by email.
	 * @param email
	 * @return Optional<User>
	 */
	Optional<User> findByEmail(String email);

}
