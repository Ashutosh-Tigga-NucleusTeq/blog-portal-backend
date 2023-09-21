package com.blog.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.Comment;

/**
 * This interface interact with comment collection of db.
 * it contains query by which we can perform data related operation.
 */
@Repository
public interface CommentPostRepo extends MongoRepository<Comment, String> {

	/**
	 * Fetches comment by post id.
	 * @param postId
	 * @return List<Comment>
	 */
	List<Comment> findByPostId(String postId);
	/**
	 * This is for perform delete comment by post id.
	 * @param postId
	 */
	void deleteByPostId(String postId);
}
