package com.blog.portal.responsePayload;

import java.util.Objects;
import com.blog.portal.enumResource.React;

/**
 * This class Represents Response Dto that contains information of REACTION on BLOG .
 * @author [ Ashutosh Tigga]
 */
public class ReactionBlogOutDto {
	/**
	 * ID of the This Object.
	 */
	private String id;

	/**
	 * post ID of the user.
	 */
	private String postId;

	/**
	 * user ID of the user.
	 */
	private String userId;

	/**
	 * LIKE or DISLIKE type.
	 */
	private React type;

	/**
	 * Gets ID of the post.
	 * @return postId.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets ID of the post.
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Gets ID of the user.
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Gets ID of the Object.
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the ID of Object.
	 * @param id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Sets ID of the user.
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets type of the user.
	 * @return type
	 */
	public React getType() {
		return type;
	}

	/**
	 * Sets type of the user.
	 * @param type
	 */
	public void setType(final React type) {
		this.type = type;
	}

	/**
	 * Default constructor for creating an empty LikeOrDislikePostOutDto object.
	 */
	public ReactionBlogOutDto() {
		super();
	}

	/**
	 * Parameterized constructor for creating a LikeOrDislikePostOutDto object with
	 * specific values.
	 * @param id     The unique identifier for this like/dislike.
	 * @param postId The identifier of the post being liked or disliked.
	 * @param userId The identifier of the user who performed the like or dislike
	 *               action.
	 * @param type   The type of reaction (like or dislike).
	 */
	public ReactionBlogOutDto(final String id, final String postId, final String userId, final React type) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.type = type;
	}

	/**
	 * Calculates the hash code for the LikeOrDislikePostOutDto object. This method
	 * combines the hash codes of its attributes (id, postId, type, and userId).
	 * @return The computed hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, postId, type, userId);
	}

	/**
	 * Compares this LikeOrDislikePostOutDto object to another object for equality.
	 * It first checks if the two objects are the same instance. If not, it compares
	 * the attributes (id, postId, type, and userId) of both objects for equality.
	 * @param obj The object to compare with.
	 * @return true if the objects are equal, false otherwise.
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
		ReactionBlogOutDto other = (ReactionBlogOutDto) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(postId, other.postId)
				&& type == other.type
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * Generates a human-readable string representation of the
	 * LikeOrDislikePostOutDto object. This method includes details about the
	 * object's attributes (id, postId, userId, and type).
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "ReactionBlogOutDto [id=" + id
				+ ", postId=" + postId
				+ ", userId=" + userId
				+ ", type=" + type + "]";
	}

}
