package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class Represents Request DTO contains fields title technology category and
 * status of post and based on this it will filter the user's post.
 * @author [ Ashutosh Tigga]
 */
public class UserBlogsInDto {

	/**
	 * id of the user.
	 */
	@NotBlank(message = "userId is Required")
	private String userId;
	/**
	 * Title of the Blog.
	 * No need of validation bcz we can fetch BLOG based on empty value too.
	 */
	private String title;

	/**
	 * Technology category of the post.
	 */
	private TechnologyCategory techCategory;

	/**
	 * status of post.
	 */
	private BlogStatus status;

	/**
	 * Gets the id of the user.
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Gets the id of the user.
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the title of the post.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the post.
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets technology.
	 * @return techCategory
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * set Technology.
	 * @param techCategory
	 */
	public void setTechCategory(final TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * Gets status of the post.
	 * @return status
	 */
	public BlogStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status of post.
	 * @param status
	 */
	public void setStatus(final BlogStatus status) {
		this.status = status;
	}

	/**
	 * Generates a hash code for this UserBlogsInDto object based on
	 * its status, techCategory, title, and userId.
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(status, techCategory, title, userId);
	}

	/**
	 * Compares this UserBlogsInDto object with another object to
	 * determine if they are equal. Two UserBlogsInDto objects are
	 * considered equal if their status, techCategory, title, and userId are the
	 * same.
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		UserBlogsInDto other = (UserBlogsInDto) obj;
		return status == other.status && techCategory == other.techCategory && Objects.equals(title, other.title)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * Generates a string representation of this UserBlogsInDto
	 * object.
	 * @return The string representation of the UserBlogsInDto
	 * object.
	 */
	@Override
	public String toString() {
		return "UserBlogsInDto [userId=" + userId
				+ ", title=" + title
				+ ", techCategory=" + techCategory
				+ ", status=" + status + "]";
	}

}
