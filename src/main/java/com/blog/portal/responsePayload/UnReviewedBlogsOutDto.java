package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.Objects;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class Represents Response DTO for UNREVIEWED BLOG posts. This class
 * encapsulates information about a BLOG post including the user name, post
 * title, content, creation date, and post ID.
 * @author [ Ashutosh Tigga]
 */
public class UnReviewedBlogsOutDto {

	/**
	 * The user name of the author of the BLOG post.
	 */
	private String userName;

	/**
	 * The title of the BLOG post.
	 */
	private String title;

	/**
	 * The content of the BLOG post.
	 */
	private String content;

	/**
	 * The date and time when the BLOG post was created.
	 */
	private Date createdAt;

	/**
	 * The unique identifier of the BLOG post.
	 */
	private String id;

	/**
	 * Designation of USER.
	 */
	private Designation userDesignation;
	/**
	 * Technology category of POST.
	 */
	private TechnologyCategory techCategory;

	/**
	 * Gets the Designation of the USER.
	 * @return userDesignation Designation of the USER.
	 */
	public Designation getUserDesignation() {
		return userDesignation;
	}

	/**
	 * Sets the Designation of the USER.
	 * @param userDesignation Designation of the USER.
	 */
	public void setUserDesignation(final Designation userDesignation) {
		this.userDesignation = userDesignation;
	}

	/**
	 * Gets the Technology Category of the BLOG Blog.
	 * @return techCategory Technology Category of the BLOG post.
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * Sets the Technology Category of the BLOG Blog.
	 * @param techCategory Techonology Category of the BLOG Blog.
	 */
	public void setTechCategory(final TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * Gets the user name of the author.
	 * @return The user name.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name of the author.
	 * @param userName The user name to set.
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the title of the blog post.
	 * @return The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the blog post.
	 * @param title The title to set.
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the content of the blog post.
	 * @return The content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the blog post.
	 * @param content The content to set.
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Gets the creation date and time of the blog post.
	 * @return The creation date.
	 */
	public Date getCreatedAt() {
		return new Date(createdAt.getTime());
	}

	/**
	 * Sets the creation date and time of the blog post.
	 * @param createdAt The creation date to set.
	 */
	public void setCreatedAt(final Date createdAt) {
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * Gets the unique identifier of the blog post.
	 * @return The post ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of the blog post.
	 * @param id The post ID to set.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Generates a string representation of the UnReviewedBlogsOutDto object.
	 * @return A string containing user name, title, content, creation date, and ID.
	 */
	@Override
	public String toString() {
		return "UnReviewedBlogsOutDto [userName=" + userName
				+ ", title=" + title
				+ ", content=" + content
				+ ", createdAt=" + createdAt
				+ ", id=" + id + "]";
	}

	/**
	 * Constructs an UnReviewedBlogsOutDto object with the specified values.
	 * @param userName  The user name of the author.
	 * @param title     The title of the blog post.
	 * @param content   The content of the blog post.
	 * @param createdAt The creation date and time of the blog post.
	 * @param id        The unique identifier of the blog post.
	 */
	public UnReviewedBlogsOutDto(final String userName, final String title, final String content,
			final Date createdAt, final String id) {
		super();
		this.userName = userName;
		this.title = title;
		this.content = content;
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
		this.id = id;
	}

	/**
	 * Default constructor for UnReviewedBlogsOutDto.
	 */
	public UnReviewedBlogsOutDto() {
		super();
	}

	/**
	 * Computes a hash code for this object based on its content, creation date, ID,
	 * title, and user name.
	 * @return The computed hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, createdAt, id, title, userName);
	}

	/**
	 * Checks if this object is equal to another object. Two UnReviewedBlogsOutDto
	 * objects are considered equal if they have the same content, creation date,
	 * ID, title, and user name.
	 * @param obj The object to compare with.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UnReviewedBlogsOutDto other = (UnReviewedBlogsOutDto) obj;
		return Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(id, other.id)
				&& Objects.equals(title, other.title)
				&& Objects.equals(userName, other.userName);
	}

}
