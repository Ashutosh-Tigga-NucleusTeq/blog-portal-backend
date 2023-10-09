package com.blog.portal.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.Reaction;

/**
 * The ReactionRepository interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for Reaction objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
@Repository
public interface ReactionRepository extends MongoRepository<Reaction, String> {

	/**
	 * Query for fetching react of user.
	 * @param userId
	 * @param postId
	 * @return LikeOrDislike
	 */
	Reaction findByUserIdAndPostId(String userId, String postId);
	/**
	 * This is for deleting all post like and dislike reaction by post id.
	 * @param postId
	 */
	void deleteByPostId(String postId);
}
