package com.blog.portal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.User;

/**
 * The UserRepository interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for User objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * method that fetch Entity by email.
	 * @param email
	 * @return Optional<User>
	 */
	Optional<User> findByEmail(String email);

	/**
	 * Fetches the user entity by contactNumber.
	 * @return Optiona<User>
	 */
	Optional<User> findByContactNumber();

}
