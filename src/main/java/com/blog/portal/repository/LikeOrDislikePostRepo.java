package com.blog.portal.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.Reaction;

/**
 * This interface contains the query from which we can perform operation on collection.
 */
@Repository
public interface LikeOrDislikePostRepo extends MongoRepository<Reaction, String> {

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
