package com.blog.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blog.portal.entities.Comment;

/**
 * The CommentRepository interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for Comment objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

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
