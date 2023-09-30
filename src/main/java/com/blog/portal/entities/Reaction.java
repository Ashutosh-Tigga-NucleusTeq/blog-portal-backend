package com.blog.portal.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blog.portal.enumResource.React;

/**
 * This entity represents user reactions to posts, including likes and dislikes.
 * @author [ Ashutosh Tigga]
 */
@Document
public class Reaction {

	/**
	 * Id of the LikeOrDislike.
	 */
	@Id
	private String id;

	/**
	 * The Post to which this like or dislike is associated.
	 */
	private String postId;

	/**
	 * The User who performed the like or dislike.
	 */
	private String userId;

	/**
	 * Type of the React, which can be either a like or a dislike.
	 */
	private React type;

	/**
	 * Constructs a new LikeOrDislike object with the provided parameters.
	 *
	 * @param id     The unique identifier for this LikeOrDislike.
	 * @param postId The Post to which this like or dislike is associated.
	 * @param userId The User who performed the like or dislike.
	 * @param type   The type of reaction, which can be either a like or a dislike.
	 */
	public Reaction(String id, String postId, String userId, React type) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.type = type;
	}

	/**
	 * Default constructor for the LikeOrDislike class.
	 */
	public Reaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the unique identifier for this LikeOrDislike.
	 *
	 * @return The id of the LikeOrDislike.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier for this LikeOrDislike.
	 *
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the Post to which this like or dislike is associated.
	 *
	 * @return The Post to which this reaction is associated.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the Post to which this like or dislike is associated.
	 *
	 * @param postId The Post to set.
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}

	/**
	 * Gets the User who performed the like or dislike.
	 *
	 * @return The User who performed the reaction.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the User who performed the like or dislike.
	 *
	 * @param userId The User to set.
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the type of reaction, which can be either a like or a dislike.
	 *
	 * @return The type of reaction.
	 */
	public React getType() {
		return type;
	}

	/**
	 * Sets the type of reaction, which can be either a like or a dislike.
	 *
	 * @param type The type of reaction to set.
	 */
	public void setType(React type) {
		this.type = type;
	}

	/**
	 * Generates a hash code for this LikeOrDislike object based on its id, postId,
	 * type, and userId.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, postId, type, userId);
	}

	/**
	 * Compares this LikeOrDislike object with another object to determine if they
	 * are equal. Two LikeOrDislike objects are considered equal if their id, postId,
	 * type, and userId are the same.
	 *
	 * @param obj The object to compare with.
	 * @return true if the objects are equal; false otherwise.
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
		Reaction other = (Reaction) obj;
		return Objects.equals(id, other.id) && Objects.equals(postId, other.postId) && type == other.type
				&& Objects.equals(userId, other.userId);
	}
	/**
	 * Overriden toString method.
	 */
	@Override
	public String toString() {
		return "LikeOrDislike [id=" + id + ", postId=" + postId + ", userId=" + userId + ", type=" + type + "]";
	}
}
