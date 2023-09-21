package com.blog.portal.repository;

import java.util.List;

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
	 * @return List<Post> list of post.
	 */
	List<Post> findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
          String title, PostStatus status, TechnologyCategory techCategory);

  /**
   * Query for fetching posts by title.
   * @param title
   * @param status
   * @return List<Post>
   */
  List<Post>  findByTitleContainingIgnoreCaseAndStatus(String title, PostStatus status);

  /**
   * Query for Fetching Post by Technology category.
   * @param techCategory
   * @param status
   * @return List<Post>
   */
  List<Post> findByTechCategoryAndStatus(TechnologyCategory techCategory, PostStatus status);

  /**
   * Query for fetching all the post based on status Approved.
   *@param status
   *@return List<Post>
   */
  List<Post> findByStatus(PostStatus status);

	/**
	 * Query for fetching all post of user by userId.
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByUserId(String userId);

	/**
	 * Query for fetching all post by user id and title.
	 * @param title
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByTitleContainingIgnoreCaseAndUserId(
			String title,
			String userId);

	/**
	 * Query for fetching post by technology category and user id.
	 * @param techCategory
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByTechCategoryAndUserId(
			TechnologyCategory techCategory,
			String userId);

	/**
	 * Query for fetching Post by status and userid.
	 * @param status
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByStatusAndUserId(
			PostStatus status,
			String userId);

	/**
	 * Query for fetching post by status and techCategory and userId.
	 * @param status
	 * @param techCategory
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByStatusAndTechCategoryAndUserId(
			PostStatus status,
			TechnologyCategory techCategory,
			String userId);

	/**
	 * Query for fetching post by status title userid.
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			TechnologyCategory techCategory,
			String title,
			String userId);

	/**
	 * Query for fetching post by status , title and userid.
	 * @param status
	 * @param title
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByStatusAndTitleContainingIgnoreCaseAndUserId(
			PostStatus status,
			String title,
			String userId);

	/**
	 * Query for fetching post by status techcategory title and userid.
	 * @param status
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @return List<Post>
	 */
  List<Post> findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			PostStatus status,
			TechnologyCategory techCategory,
			String title,
			String userId);

	/**
	 * Query for finding post by userid and postid.
	 * @param userId
	 * @param postId
	 * @return List
	 */
	List<Post> findByUserIdAndId(String userId, String postId);
}
