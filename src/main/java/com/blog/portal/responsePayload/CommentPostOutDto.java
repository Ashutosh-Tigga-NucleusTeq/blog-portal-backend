package com.blog.portal.responsePayload;

import java.util.Objects;

public class CommentPostOutDto {

	/**
	 * id of the comment outDto.
	 */
	private String id;
	/**
	 * content of comment.
	 */
	private String content;
	/**
	 * id of the user.
	 */
	private String userId;
	/**
	 * id of the post.
	 */
	private String postId;
	/**
	 * Gets the id of the comment.
	 * @return id
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
	 * Gets the content of the post.
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * Sets the content of the post.
	 * @param content
	 */
	public void setContent(String content) {
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
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * Gets the id of the post.
	 * @return postId
	 */
	public String getPostId() {
		return postId;
	}
	/**
	 * Sets the id of the post.
	 * @param postId
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	/**
	 * Generates a string representation of the CommentPostOutDto object.
	 * This method returns a formatted string containing information about the comment,
	 * including its unique identifier, content, user ID, and associated post ID.
	 *
	 * @return A string representation of the object, including comment details.
	 */
	@Override
	public String toString() {
		return "CommentPostOutDto [id=" + id + ", content=" + content
				+ ", userId=" + userId + ", postId=" + postId + "]";
	}
  /**
   * Initializes a new instance of the {@code CommentPostOutDto} class.
   * This constructor takes parameters to set the initial values of the comment properties.
   *
   * @param id      The unique identifier of the comment.
   * @param content The content of the comment.
   * @param userId  The user ID of the commenter.
   * @param postId  The ID of the post to which this comment belongs.
   */
	public CommentPostOutDto(String id, String content, String userId, String postId) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.postId = postId;
	}
	/**
   * Initializes a new instance of the {@code CommentPostOutDto} class with default values.
   * This is a default constructor that doesn't initialize the comment properties.
   */
	public CommentPostOutDto() {
		super();
	}
	 /**
   * Calculates the hash code for this comment object based on its properties.
   *
   * @return The hash code value.
   */
  @Override
  public int hashCode() {
      return Objects.hash(content, id, postId, userId);
  }

  /**
   * Compares this comment object to another object to determine if they are equal.
   *
   * @param obj The object to compare to.
   * @return {@code true} if the objects are equal; {@code false} otherwise.
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

      CommentPostOutDto other = (CommentPostOutDto) obj;

      return Objects.equals(content, other.content) && Objects.equals(id, other.id)
              && Objects.equals(postId, other.postId) && Objects.equals(userId, other.userId);
  }

}
