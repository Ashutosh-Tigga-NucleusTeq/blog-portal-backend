package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import com.blog.portal.enumResource.BlogStatus;

/**
 * This class Represents a Request DTO contains postId, blogStatus for approving
 * or rejecting a BLOG post by ADMIN.
 *
 * @author [ Ashutosh Tigga]
 */
public class ActOnUnReviewedBlogInDto {
	/**
	 * The unique identifier of the post.
	 */
	@NotBlank(message = "Blog ID is required")
	private String postId;

	/**
	 * The status of the post after approval or rejection.
	 */
	private BlogStatus blogStatus;

	/**
	 * Gets the ID of the post.
	 *
	 * @return The ID of the post.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the ID of the post.
	 *
	 * @param postId The ID of the post.
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Gets the status of the post.
	 *
	 * @return The status of the post.
	 */
	public BlogStatus getPostStatus() {
		return blogStatus;
	}

	/**
	 * Sets the status of the post.
	 *
	 * @param newBlogStatus The status of the post.
	 */
	public void setPostStatus(final BlogStatus newBlogStatus) {
		this.blogStatus = newBlogStatus;
	}

	/**
	 * Generates a string representation of the ActOnUnReviewedBlogInDto object.
	 *
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "ActOnUnReviewedBlogInDto [postId=" + postId
				+ ", blogStatus=" + blogStatus + "]";
	}

	/**
	 * Computes the hash code for the ActOnUnReviewedBlogInDto object based on its
	 * attributes.
	 *
	 * @return The hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postId, blogStatus);
	}

	/**
	 * Compares this ActOnUnReviewedBlogInDto object to another object to determine if
	 * they are equal.
	 *
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
		ActOnUnReviewedBlogInDto other = (ActOnUnReviewedBlogInDto) obj;
		return Objects.equals(postId, other.postId)
				&& blogStatus == other.blogStatus;
	}

	/**
	 * Default constructor for ActOnUnReviewedBlogInDto.
	 */
	public ActOnUnReviewedBlogInDto() {
		super();
	}

	/**
	 * Initializes a new instance of the ActOnUnReviewedBlogInDto class with the
	 * specified values.
	 *
	 * @param postId     The ID of the post.
	 * @param blogStatus The status of the post.
	 */
	public ActOnUnReviewedBlogInDto(final String postId, final BlogStatus blogStatus) {
		super();
		this.postId = postId;
		this.blogStatus = blogStatus;
	}
}
