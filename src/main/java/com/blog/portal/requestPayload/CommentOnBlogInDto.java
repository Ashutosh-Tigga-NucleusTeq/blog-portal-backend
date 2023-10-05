package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * This class Represents a Request DTO for creating a comment on a post.
 * This class contains information about the comment content, user ID, and post
 * ID.
 * @author [ Ashutosh Tigga]
 */
public class CommentOnBlogInDto {

	/**
	 * Minimum length of comment.
	 */
	private static final int MIN_CONTENT = 10;

	/**
	 * Maximum length of comment.
	 */
	private static final int MAX_CONTENT = 100;

	/**
	 * The content of the comment.
	 */
	@NotBlank(message = "Content is Required")
	@Size(min = MIN_CONTENT, max = MAX_CONTENT, message = "length should be between ["
	+ MIN_CONTENT + "-" + MAX_CONTENT + "]")
	private String content;

	/**
	 * The ID of the user who is making the comment.
	 */
	@NotBlank(message = "User ID is Required")
	private String userId;

	/**
	 * The ID of the post on which the comment is being made.
	 */
	@NotBlank(message = "Blog ID is Required")
	private String postId;

	/**
	 * Gets the content of the comment.
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the comment.
	 * @param content
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Gets the id of the user.
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the id of the user.
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets id of the post.
	 * @return postId.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the id of the post.
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Constructs a new instance of the CommentOnBlogInDto class with the
	 * specified parameters.
	 * @param content The content of the comment.
	 * @param userId  The ID of the user making the comment.
	 * @param postId  The ID of the post on which the comment is being made.
	 */
	public CommentOnBlogInDto(final String content, final String userId, final String postId) {
		super();
		this.content = content;
		this.userId = userId;
		this.postId = postId;
	}

	/**
	 * Default constructor for the CommentOnBlogInDto class.
	 */
	public CommentOnBlogInDto() {
		super();
	}

	/**
	 * Computes the hash code of this object based on its attributes.
	 * @return The hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, postId, userId);
	}

	/**
	 * Compares this object to another object to check for equality.
	 * @param obj The object to compare to.
	 * @return {@code true} if the objects are equal, {@code false} otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		CommentOnBlogInDto other = (CommentOnBlogInDto) obj;
		return Objects.equals(content, other.content)
				&& Objects.equals(postId, other.postId)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * Returns a string representation of this object.
	 * @return The string representation.
	 */
	@Override
	public String toString() {
		return "CommentOnBlogInDto [content=" + content
				+ ", userId=" + userId
				+ ", postId=" + postId + "]";
	}
}
