package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.Objects;

import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * Represents a Data Transfer Object (DTO) for unreviewed blog posts. This class
 * encapsulates information about a blog post including the user name, post
 * title, content, creation date, and post ID.
 */
public class UnReviewedPostOutDto {

	/**
	 * The user name of the author of the blog post.
	 */
	private String userName;

	/**
	 * The title of the blog post.
	 */
	private String title;

	/**
	 * The content of the blog post.
	 */
	private String content;

	/**
	 * The date and time when the blog post was created.
	 */
	private Date createdAt;

	/**
	 * The unique identifier of the blog post.
	 */
	private String id;

	/**
	 * Designation of user.
	 */
	private Designation userDesignation;
	/**
	 * Technology category of post.
	 */
	private TechnologyCategory techCategory;
	/**
	 * Gets the Designation of the user.
	 * @return userDesignation Designation of the user.
	 */
	public Designation getUserDesignation() {
		return userDesignation;
	}
	/**
	 * Sets the Designation of the user.
	 * @param userDesignation Designation of the user.
	 */
	public void setUserDesignation(Designation userDesignation) {
		this.userDesignation = userDesignation;
	}
	/**
	 * Gets the Technology Category of the Post.
	 * @return techCategory Technology Category of the post.
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * Sets the Technology Category of the post.
	 * @param techCategory Techonology Category of the post.
	 */
	public void setTechCategory(TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * Gets the user name of the author.
	 *
	 * @return The user name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name of the author.
	 *
	 * @param userName The user name to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the title of the blog post.
	 *
	 * @return The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the blog post.
	 *
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the content of the blog post.
	 *
	 * @return The content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the blog post.
	 *
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the creation date and time of the blog post.
	 *
	 * @return The creation date.
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Sets the creation date and time of the blog post.
	 *
	 * @param createdAt The creation date to set.
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Gets the unique identifier of the blog post.
	 *
	 * @return The post ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the blog post.
	 *
	 * @param id The post ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Generates a string representation of the UnReviewedPostOutDto object.
	 *
	 * @return A string containing user name, title, content, creation date, and ID.
	 */
	@Override
	public String toString() {
		return "UnReviewedPostOutDto [userName=" + userName + ", title=" + title + ", content=" + content + ", createdAt="
				+ createdAt + ", id=" + id + "]";
	}

	/**
	 * Constructs an UnReviewedPostOutDto object with the specified values.
	 *
	 * @param userName  The user name of the author.
	 * @param title     The title of the blog post.
	 * @param content   The content of the blog post.
	 * @param createdAt The creation date and time of the blog post.
	 * @param id        The unique identifier of the blog post.
	 */
	public UnReviewedPostOutDto(String userName, String title, String content, Date createdAt, String id) {
		super();
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.id = id;
	}

	/**
	 * Default constructor for UnReviewedPostOutDto.
	 */
	public UnReviewedPostOutDto() {
		super();
	}

	/**
	 * Computes a hash code for this object based on its content, creation date, ID,
	 * title, and user name.
	 *
	 * @return The computed hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, createdAt, id, title, userName);
	}

	/**
	 * Checks if this object is equal to another object. Two UnReviewedPostOutDto
	 * objects are considered equal if they have the same content, creation date,
	 * ID, title, and user name.
	 *
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UnReviewedPostOutDto other = (UnReviewedPostOutDto) obj;
		return Objects.equals(content, other.content) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title)
				&& Objects.equals(userName, other.userName);
	}

}
