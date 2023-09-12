package com.example.demo.dto;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;

public class UserPostInDto {

	/**
	 * id of the user.
	 */
	private String userId;
	/**
	 * Title of the Post.
	 */
	private String title;

	/**
	 * Technology category of the post.
	 */
	private TechnologyCategory techCategory;

	/**
	 * status of post.
	 */
	private PostStatus status;

	/**
	 * Gets the id of the user.
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Gets the id of the user.
	 *
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the title of the post.
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the post.
	 *
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets technology.
	 *
	 * @return techCategory
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * set Technology.
	 *
	 * @param techCategory
	 */
	public void setTechCategory(TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * Gets status of the post.
	 *
	 * @return status
	 */
	public PostStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status of post.
	 *
	 * @param status
	 */
	public void setStatus(PostStatus status) {
		this.status = status;
	}

}
