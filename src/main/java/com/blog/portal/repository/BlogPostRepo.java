package com.blog.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * The PostRepo interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for Post objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
public interface BlogPostRepo extends MongoRepository<Post, String> {

	/**
	 * Query for fetching post by title , status , technology category.
	 * @param title
	 * @param status
	 * @param techCategory
	 * @param page
	 * @return List<Post> list of post.
	 */
  Page<Post> findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
          String title, PostStatus status, TechnologyCategory techCategory, Pageable page);

  /**
   * Query for fetching posts by title.
   * @param title
   * @param status
   * @param page
   * @return List<Post>
   */
  Page<Post>  findByTitleContainingIgnoreCaseAndStatus(String title, PostStatus status, Pageable page);

  /**
   * Query for Fetching Post by Technology category.
   * @param techCategory
   * @param status
   * @param page
   * @return List<Post>
   */
  Page<Post> findByTechCategoryAndStatus(TechnologyCategory techCategory, PostStatus status,
      Pageable page);

  /**
   * Query for fetching all the post based on status Approved.
   *@param status
   *@param page
   *@return List<Post>
   */
  Page<Post> findByStatus(PostStatus status,
      Pageable page);

	/**
	 * Query for fetching all post of user by userId.
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByUserId(String userId,
      Pageable page);

	/**
	 * Query for fetching all post by user id and title.
	 * @param title
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByTitleContainingIgnoreCaseAndUserId(
			String title,
			String userId,
      Pageable page);

	/**
	 * Query for fetching post by technology category and user id.
	 * @param techCategory
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByTechCategoryAndUserId(
			TechnologyCategory techCategory,
			String userId,
      Pageable page);

	/**
	 * Query for fetching Post by status and userid.
	 * @param status
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByStatusAndUserId(
			PostStatus status,
			String userId,
      Pageable page);

	/**
	 * Query for fetching post by status and techCategory and userId.
	 * @param status
	 * @param techCategory
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByStatusAndTechCategoryAndUserId(
			PostStatus status,
			TechnologyCategory techCategory,
			String userId,
      Pageable page);

	/**
	 * Query for fetching post by status title userid.
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			TechnologyCategory techCategory,
			String title,
			String userId,
      Pageable page);

	/**
	 * Query for fetching post by status , title and userid.
	 * @param status
	 * @param title
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByStatusAndTitleContainingIgnoreCaseAndUserId(
			PostStatus status,
			String title,
			String userId,
      Pageable page);

	/**
	 * Query for fetching post by status techcategory title and userid.
	 * @param status
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @param page
	 * @return List<Post>
	 */
  Page<Post> findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			PostStatus status,
			TechnologyCategory techCategory,
			String title,
			String userId,
      Pageable page);

	/**
	 * Query for finding post by userid and postid.
	 * @param userId
	 * @param postId
	 * @return List
	 */
	List<Post> findByUserIdAndId(String userId, String postId);
}
