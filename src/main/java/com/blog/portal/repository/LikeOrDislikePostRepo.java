package com.blog.portal.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.LikeOrDislike;

/**
 * This interface contains the query from which we can perform operation on collection.
 */
@Repository
public interface LikeOrDislikePostRepo extends MongoRepository<LikeOrDislike, String> {

	/**
	 * Query for fetching react of user.
	 * @param userId
	 * @param postId
	 * @return LikeOrDislike
	 */
	LikeOrDislike findByUserIdAndPostId(String userId, String postId);
	/**
	 * This is for deleting all post like and dislike reaction by post id.
	 * @param postId
	 */
	void deleteByPostId(String postId);
}
