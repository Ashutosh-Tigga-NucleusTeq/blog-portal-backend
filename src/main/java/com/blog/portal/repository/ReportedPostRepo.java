package com.blog.portal.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.blog.portal.entities.ReportedPost;

@Repository
public interface ReportedPostRepo extends MongoRepository<ReportedPost, String> {

	/**
	 * This query fetch Reported post by user id and post id.
	 *
	 * @param userId
	 * @param postId
	 * @return Object of ReportedPost.
	 */
	ReportedPost findByUserIdAndPostId(String userId, String postId);

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
	 * @return Collection of Entity ReportedPost that contains some data.
	 */
	List<ReportedPost> findByPostId(String postId);


}
