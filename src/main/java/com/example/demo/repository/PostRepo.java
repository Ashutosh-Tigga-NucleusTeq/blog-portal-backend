package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Post;

/**
 * The PostRepo interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for Post objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
public interface PostRepo extends MongoRepository<Post, String> {

}
