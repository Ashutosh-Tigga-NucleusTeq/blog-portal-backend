package com.example.demo.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;

/**
 * The {@code Comment} class represents an entity for comments in the application.
 * and associated post (postId).
 *
 * @author [ Ashutosh Tigga]
 */
public class Comment {

	/**
	 * The unique identifier (id) of the comment.
	 */
	@Id
	private String id;

	/**
	 * The content or message of the comment.
	 */
	@NotNull
	private String content;

	/**
	 * The id of the user associated with this comment.
	 */
	@NotNull
	private String userId;

	/**
	 * The id of the post associated with this comment.
	 */
	@NotNull
	private String postId;

	/**
	 * Constructs a new Comment object with the given content.
	 *
	 * @param content The content of the comment.
	 */
	public Comment(String content) {
		this.content = content;
	}

	/**
	 * Constructs a new Comment object with the provided parameters.
	 *
	 * @param id      The unique identifier (id) of the comment.
	 * @param content The content of the comment.
	 * @param userId  The id of the user associated with this comment.
	 * @param postId  The id of the post associated with this comment.
	 */
	public Comment(String id, @NotNull String content, @NotNull String userId, @NotNull String postId) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
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
	public void setId(String id) {
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
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Generates a hash code for this Comment object based on its content, id, postId,
	 * and userId.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(content, id, postId, userId);
	}

	/**
	 * Compares this Comment object with another object to determine if they are
	 * equal. Two Comment objects are considered equal if their content, id, postId,
	 * and userId are the same.
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
		Comment other = (Comment) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(postId, other.postId) && Objects.equals(userId, other.userId);
	}

	/**
	 * Generates a string representation of this Comment object.
	 *
	 * @return The string representation of the Comment object.
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", userId=" + userId + ", postId=" + postId + "]";
	}
}
