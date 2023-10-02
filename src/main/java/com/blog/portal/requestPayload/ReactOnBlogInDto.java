package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import com.blog.portal.enumResource.React;

/**
 * This class Represents Request DTO contains postId, userId and reaction type
 * of post for performing like or dislike operation on specific post.
 *
 * @author [ Ashutosh Tigga]
 */
public class ReactOnBlogInDto {
	/**
	 * BLOG Blog ID of the user.
	 */
	@NotBlank(message = "Blog ID is Required")
	private String postId;

	/**
	 * User ID of the user.
	 */
	@NotBlank(message = "User ID is required")
	private String userId;

	/**
	 * LIKE or DISLIKE type.
	 */
	private React type;

	/**
	 * Parameterized constructor.
	 *
	 * @param newUserId
	 * @param newPostId
	 * @param newReaction
	 */
	public ReactOnBlogInDto(final String newUserId, final String newPostId, final React newReaction) {
		this.userId = newUserId;
		this.postId = newPostId;
		this.type = newReaction;
	}

	/**
	 * Default Constructor.
	 */
	public ReactOnBlogInDto() {
	}

	/**
	 * Gets id of the post.
	 *
	 * @return postId.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets id of the post.
	 *
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Gets id of the user.
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets id of the user.
	 *
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets type of the user.
	 *
	 * @return type
	 */
	public React getType() {
		return type;
	}

	/**
	 * Sets type of the user.
	 *
	 * @param type
	 */
	public void setType(final React type) {
		this.type = type;
	}

	/**
	 * Generates a string representation of the LikeOrDislikePostInDto object.
	 *
	 * @return A string containing information about the post ID, user ID, and
	 *         action type.
	 */
	@Override
	public String toString() {
		return "LikeOrDislikePostInDto [postId=" + postId + ", userId=" + userId + ", type=" + type + "]";
	}

	/**
	 * Calculates the hash code for the LikeOrDislikePostInDto object based on its
	 * properties.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postId, type, userId);
	}

	/**
	 * Compares this LikeOrDislikePostInDto object with another object to determine
	 * if they are equal. Two LikeOrDislikePostInDto objects are considered equal if
	 * their post ID, user ID, and action type are the same.
	 *
	 * @param obj The object to compare with.
	 * @return true if the objects are equal; false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ReactOnBlogInDto other = (ReactOnBlogInDto) obj;
		return Objects.equals(postId, other.postId) && type == other.type && Objects.equals(userId, other.userId);
	}

}
