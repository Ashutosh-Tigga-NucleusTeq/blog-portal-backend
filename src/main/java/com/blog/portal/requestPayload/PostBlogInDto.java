package com.blog.portal.requestPayload;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class Represents a Request DTO that contains fields id, title, content,
 * createdAt, userId, Technology category posting blog post.
 *
 * @author [ Ashutosh Tigga]
 */
public class PostBlogInDto {

	/**
	 * Minimum size of title.
	 */
	private static final int MIN_TITLE_SIZE = 10;

	/**
	 * Maximum size of title.
	 */
	private static final int MAX_TITLE_SIZE = 100;

	/**
	 * The Title of the BLOG post.
	 */
	@NotBlank(message = "Title is Required")
	@Size(min = MIN_TITLE_SIZE, max = MAX_TITLE_SIZE, message = "length of title must be between [" + MIN_TITLE_SIZE + "-"
			+ MAX_TITLE_SIZE + "]")
	private String title;

	/**
	 * Minimum size of title.
	 */
	private static final int MIN_CONTENT_SIZE = 50;


	/**
	 * The Content of the BLOG post.
	 */
	@NotBlank(message = "Content is Required")
	@Size(min = MIN_CONTENT_SIZE,
			message = "length of Content must be between [" + MIN_CONTENT_SIZE + "]")
	private String content;

	/**
	 * The Creation date of the BLOG post.
	 */
	@NotNull(message = "Created Date must not be null")
	private Date createdAt;

	/**
	 * The ID of the author who posted the post.
	 */
	@NotBlank(message = "User ID is Required")
	private String userId;

	/**
	 * Technology category of the post.
	 */
	private TechnologyCategory techCategory;

	/**
	 * Constructor for creating a `PostInDto` object.
	 *
	 * @param title        The title of the blog post.
	 * @param content      The content of the blog post.
	 * @param createdAt    The creation date of the blog post.
	 * @param user         id of the author who posted the post.
	 * @param techCategory The technology category of the post.
	 */
	public PostBlogInDto(final String title, final String content, final Date createdAt,
			final String user, final TechnologyCategory techCategory) {
		this.title = title;
		this.content = content;
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
		this.userId = user;
		this.techCategory = techCategory;
	}

	/**
	 * Default constructor for the `PostInDto` class.
	 */
	public PostBlogInDto() {
		super();
	}

	/**
	 * Gets the id of the author who posted the post.
	 *
	 * @return userId The author's data.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the id of the author who posted the post.
	 *
	 * @param user The author's data to set.
	 */
	public void setUserID(final String user) {
		this.userId = user;
	}

	/**
	 * Gets the title of the blog post.
	 *
	 * @return The blog post title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the blog post.
	 *
	 * @param title The title to set.
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the content of the blog post.
	 *
	 * @return The blog post content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the blog post.
	 *
	 * @param content The content to set.
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Gets the creation date of the blog post.
	 *
	 * @return The creation date.
	 */
	public Date getCreatedAt() {
		return new Date(createdAt.getTime());
	}

	/**
	 * Sets the creation date of the blog post.
	 *
	 * @param createdAt The creation date to set.
	 */
	public void setCreatedAt(final Date createdAt) {
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * Gets the technology category of the blog post.
	 *
	 * @return The technology category.
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * Sets the technology category of the blog post.
	 *
	 * @param techCategory The technology category to set.
	 */
	public void setTechCategory(final TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * This method calculates the hash code for the PostBlogInDto object. The hash
	 * code is based on the values of the object's properties.
	 *
	 * @return The calculated hash code.
	 */
	@Override
	public int hashCode() {
		// Calculate the hash code based on the object's properties
		return Objects.hash(content, createdAt, techCategory, title, userId);
	}

	/**
	 * This method compares the PostBlogInDto object with another object to
	 * determine equality. Two PostBlogInDto objects are considered equal if all
	 * their properties are equal.
	 *
	 * @param obj The object to compare with.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		PostBlogInDto other = (PostBlogInDto) obj;

		return Objects.equals(content, other.content) && Objects.equals(createdAt, other.createdAt)
				&& techCategory == other.techCategory && Objects.equals(title, other.title)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * This method generates a string representation of the PostBlogInDto object.
	 * The string includes the values of all the object's properties.
	 *
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "PostBlogInDto [title=" + title
				+ ", content=" + content
				+ ", createdAt=" + createdAt
				+ ", userId=" + userId
				+ ", techCategory=" + techCategory + "]";
	}
}
