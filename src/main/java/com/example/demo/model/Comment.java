package com.example.demo.model;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotNull;

/**
 * {@code} represent entity comment entity in the application.
 *
 *   It stores information about comment id , comment.
 */
public class Comment {


	/**
	 * id of the comment.
	 */
	@Id
	private String id;

	/**
	 * message of the comment.
	 */
	@NotNull
	private String content;

	/**
	 * represent comment associated with which user.
	 */
	@NotNull
	private String userId;

	/**
	 * represent comment associated with which post.
	 */
	@NotNull
	private String postId;
	/**
	 *
	 * @param content
	 */
	public Comment(String content) {
		// TODO Auto-generated constructor stub
		this.content = content;
	}

	/**
	 * Gets the id of the comment.
	 *
	 * @return id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the comment.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the message of the comment.
	 * @return message.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the message of the comment.
	 *
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}




}
