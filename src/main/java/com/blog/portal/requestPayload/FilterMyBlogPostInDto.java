package com.blog.portal.requestPayload;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class FilterMyBlogPostInDto {

	/**
	 * id of the user.
	 */
	@NotBlank
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

	/**
	 * Generates a hash code for this {@code FilterMyBlogPostInDto} object based on its
	 * status, techCategory, title, and userId.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
	    return Objects.hash(status, techCategory, title, userId);
	}

	/**
	 * Compares this {@code FilterMyBlogPostInDto} object with another object to determine
	 * if they are equal. Two {@code FilterMyBlogPostInDto} objects are considered equal if
	 * their status, techCategory, title, and userId are the same.
	 *
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    FilterMyBlogPostInDto other = (FilterMyBlogPostInDto) obj;
	    return status == other.status
	    		&& techCategory == other.techCategory
	    		&& Objects.equals(title, other.title)
	    		&& Objects.equals(userId, other.userId);
	}

	/**
	 * Generates a string representation of this {@code FilterMyBlogPostInDto} object.
	 *
	 * @return The string representation of the {@code FilterMyBlogPostInDto} object.
	 */
	@Override
	public String toString() {
	    return "FilterMyBlogPostInDto [userId=" + userId + ", title=" + title
	    		+  ", techCategory=" + techCategory + ", status=" + status + "]";
	}


}
