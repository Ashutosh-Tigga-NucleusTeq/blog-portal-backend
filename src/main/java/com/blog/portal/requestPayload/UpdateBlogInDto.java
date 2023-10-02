package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This class Represent Request DTO that takes post information like it's id,
 * title, content and perform update operation on selected post's id BLOG.
 *
 * @author Ashutosh Tigga
 */
public class UpdateBlogInDto {
	/**
	 * ID of the BLOG post.
	 */
	@NotBlank(message = "Blog ID is Required")
	private String id;

	/**
	 * Minimum size of title.
	 */
	private static final int MIN_TITLE_SIZE = 10;

	/**
	 * Title of the BLOG post.
	 */
	@NotBlank(message = "Title must is Required")
	@Size(min = MIN_TITLE_SIZE, message = "Title Minmum size must be " + MIN_TITLE_SIZE + "")
	private String title;

	/**
	 * Content of the BLOG post.
	 */
	@NotBlank(message = "Blog content is Required")
	private String content;

	/**
	 * Gets the id of the String.
	 *
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the Blog.
	 *
	 * @param id
	 */
	public void setId(final String id) {
		this.id = id;
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
	 * Sets the tile of the post.
	 *
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the content of the post.
	 *
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the Content of the post.
	 *
	 * @param content
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Parameterized Constructor.
	 *
	 * @param id
	 * @param title
	 * @param content
	 */
	public UpdateBlogInDto(final String id, final String title, final String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	/**
	 * Default contructor.
	 */
	public UpdateBlogInDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Generates a string representation of the UpdateBlogInDto object.
	 *
	 * @return A string containing information about the post ID, title, and
	 *         content.
	 */
	@Override
	public String toString() {
		return "UpdateBlogInDto [id=" + id
				+ ", title=" + title
				+ ", content=" + content + "]";
	}

	/**
	 * Calculates the hash code for the UpdateBlogInDto object based on its
	 * properties.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, id, title);
	}

	/**
	 * Compares this UpdateBlogInDto object with another object to determine if they
	 * are equal.
	 *
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
		UpdateBlogInDto other = (UpdateBlogInDto) obj;
		return Objects.equals(content, other.content)
				&& Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}

}
