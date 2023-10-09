package com.blog.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * The PostRepo interface extends the MongoRepository interface for User
 * entities. It provides basic CRUD (Create, Read, Update, Delete) operations
 * for Blog objects stored in a MongoDB database.
 *
 * @author [ Ashutosh Tigga]
 */
public interface BlogRepository extends MongoRepository<Blog, String> {

	/**
	 * Query for fetching post by title , status , technology category.
	 * @param title
	 * @param status
	 * @param techCategory
	 * @return List<Blog> list of post.
	 */
	List<Blog> findByTitleContainingIgnoreCaseAndStatusAndTechCategory(
          String title, BlogStatus status, TechnologyCategory techCategory);

  /**
   * Query for fetching posts by title.
   * @param title
   * @param status
   * @return List<Blog>
   */
  List<Blog>  findByTitleContainingIgnoreCaseAndStatus(String title, BlogStatus status);

  /**
   * Query for Fetching Blog by Technology category.
   * @param techCategory
   * @param status
   * @return List<Blog>
   */
  List<Blog> findByTechCategoryAndStatus(TechnologyCategory techCategory, BlogStatus status);

  /**
   * Query for fetching all the post based on status Approved.
   *@param status
   *@return List<Blog>
   */
  List<Blog> findByStatus(BlogStatus status);

	/**
	 * Query for fetching all post of user by userId.
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByUserId(String userId);

	/**
	 * Query for fetching all post by user id and title.
	 * @param title
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByTitleContainingIgnoreCaseAndUserId(
			String title,
			String userId);

	/**
	 * Query for fetching post by technology category and user id.
	 * @param techCategory
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByTechCategoryAndUserId(
			TechnologyCategory techCategory,
			String userId);

	/**
	 * Query for fetching Blog by status and userid.
	 * @param status
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByStatusAndUserId(
			BlogStatus status,
			String userId);

	/**
	 * Query for fetching post by status and techCategory and userId.
	 * @param status
	 * @param techCategory
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByStatusAndTechCategoryAndUserId(
			BlogStatus status,
			TechnologyCategory techCategory,
			String userId);

	/**
	 * Query for fetching post by status title userid.
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			TechnologyCategory techCategory,
			String title,
			String userId);

	/**
	 * Query for fetching post by status , title and userid.
	 * @param status
	 * @param title
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByStatusAndTitleContainingIgnoreCaseAndUserId(
			BlogStatus status,
			String title,
			String userId);

	/**
	 * Query for fetching post by status techcategory title and userid.
	 * @param status
	 * @param techCategory
	 * @param title
	 * @param userId
	 * @return List<Blog>
	 */
  List<Blog> findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
			BlogStatus status,
			TechnologyCategory techCategory,
			String title,
			String userId);

	/**
	 * Query for finding post by userid and postid.
	 * @param userId
	 * @param postId
	 * @return List
	 */
	List<Blog> findByUserIdAndId(String userId, String postId);
}
