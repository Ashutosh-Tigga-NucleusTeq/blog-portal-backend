package com.blog.portal.entities;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The {@code Comment} class represents an entity for COMMENTS in the
 * application. and associated post (postId).
 *
 * @author [ Ashutosh Tigga]
 */
@Document("comment")
public class Comment {

	/**
	 * The unique identifier (id) of the comment.
	 */
	@Id
	private String id;

	/**
	 * The content or message of the comment.
	 */
	private String content;

	/**
	 * The id of the user associated with this comment.
	 */
	private String userId;

	/**
	 * The id of the post associated with this comment.
	 */
	private String postId;

	/**
	 * user's data.
	 */
	@DBRef
	private User user;

	/**
	 * Constructs a new Comment object with the given content.
	 *
	 * @param content The content of the comment.
	 */
	public Comment(final String content) {
		this.content = content;
	}

	/**
	 * Gets the data of user.
	 *
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the data of the user.
	 *
	 * @param user
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * Constructs a new Comment object with the provided parameters.
	 *
	 * @param id      The unique identifier (id) of the comment.
	 * @param content The content of the comment.
	 * @param userId  The id of the user associated with this comment.
	 * @param postId  The id of the post associated with this comment.
	 */
	public Comment(final String id,
			final String content,
			final String userId,
			final String postId) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.postId = postId;
	}

	/**
	 * Gets the information of user.
	 *
	 * @return userId.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the information of user.
	 *
	 * @param userID
	 */
	public void setUserID(final String userID) {
		this.userId = userID;
	}

	/**
	 * Gets the information of post.
	 *
	 * @return postId.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the information of post.
	 *
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Default constructor for the Comment class.
	 */
	public Comment() {
		super();
	}

	/**
	 * Gets the unique identifier (id) of the comment.
	 *
	 * @return The id of the comment.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the unique identifier (id) of the comment.
	 *
	 * @param id The id to set.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the content or message of the comment.
	 *
	 * @return The content of the comment.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content or message of the comment.
	 *
	 * @param content The content to set.
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Calculates the hash code for this Comment object based on its content, id,
	 * userId, and postId.
	 *
	 * @return The calculated hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, id, userId, postId);
	}

	/**
	 * Checks if this Comment object is equal to another object by comparing their
	 * content, id, userId, and postId.
	 *
	 * @param obj The object to compare with this Comment.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Comment other = (Comment) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(userId, other.userId) && Objects.equals(postId, other.postId);
	}

	/**
	 * Generates a string representation of this Comment object.
	 *
	 * @return A string containing the Comment's id, content, userId, and postId.
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", userId=" + userId + ", postId=" + postId + "]";
	}

}
