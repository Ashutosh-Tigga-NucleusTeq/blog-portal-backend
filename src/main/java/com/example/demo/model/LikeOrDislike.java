package com.example.demo.model;

import java.util.Objects;

import com.example.demo.enumResource.React;

/**
 * This entity represents user reactions to posts, including likes and dislikes.
 * @author [ Ashutosh Tigga]
 */
public class LikeOrDislike {

	/**
	 * Id of the LikeOrDislike.
	 */
	private String id;

	/**
	 * The Post to which this like or dislike is associated.
	 */
	private Post postId;

	/**
	 * The User who performed the like or dislike.
	 */
	private User userId;

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
	public LikeOrDislike(String id, Post postId, User userId, React type) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.type = type;
	}

	/**
	 * Default constructor for the LikeOrDislike class.
	 */
	public LikeOrDislike() {
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
	public Post getPostId() {
		return postId;
	}

	/**
	 * Sets the Post to which this like or dislike is associated.
	 *
	 * @param postId The Post to set.
	 */
	public void setPostId(Post postId) {
		this.postId = postId;
	}

	/**
	 * Gets the User who performed the like or dislike.
	 *
	 * @return The User who performed the reaction.
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * Sets the User who performed the like or dislike.
	 *
	 * @param userId The User to set.
	 */
	public void setUserId(User userId) {
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
		LikeOrDislike other = (LikeOrDislike) obj;
		return Objects.equals(id, other.id) && Objects.equals(postId, other.postId) && type == other.type
				&& Objects.equals(userId, other.userId);
	}
}
