package com.blog.portal.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blog.portal.entities.ReportedBlog;

/**
 * The ReportRepository interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for ReportedBlog objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
@Repository
public interface ReportRepository extends MongoRepository<ReportedBlog, String> {

	/**
	 * This query fetch Reported post by user id and post id.
	 *
	 * @param userId
	 * @param postId
	 * @return Object of ReportedBlog.
	 */
	ReportedBlog findByUserIdAndPostId(String userId, String postId);

	/**
	 * Delete all reporeted post by its post id.
	 *
	 * @param postId
	 */
	void deleteByPostId(String postId);

	/**
	 * Fetches reported post by post id.
	 *
	 * @param postId
	 * @return Collection of Entity ReportedBlog that contains some data.
	 */
	List<ReportedBlog> findByPostId(String postId);


}
