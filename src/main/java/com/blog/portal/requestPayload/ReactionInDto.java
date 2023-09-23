package com.blog.portal.requestPayload;

import java.util.Objects;

import com.blog.portal.enumResource.React;

public class ReactionInDto {
	/**
	 * post id of the user.
	 */
	private String postId;
	/**
	 * user id of the user.
	 */
	private String userId;
	/**
	 * like or dislike type.
	 */
	private React type;
	/**
	 * Gets id of the post.
	 * @return postId.
	 */
	public String getPostId() {
		return postId;
	}
	/**
	 * Sets id of the post.
	 * @param postId
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	/**
	 * Gets id of the user.
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * Sets id of the user.
	 * @param userId
	 */
	public void setUserId(String userId) {
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
	public void setType(React type) {
		this.type = type;
	}
	 /**
   * Generates a string representation of the LikeOrDislikePostInDto object.
   *
   * @return A string containing information about the post ID, user ID, and action type.
   */
  @Override
  public String toString() {
      return "LikeOrDislikePostInDto [postId=" + postId + ", userId=" + userId + ", type=" + type + "]";
  }

  /**
   * Calculates the hash code for the LikeOrDislikePostInDto object based on its properties.
   *
   * @return The generated hash code.
   */
  @Override
  public int hashCode() {
      return Objects.hash(postId, type, userId);
  }

  /**
   * Compares this LikeOrDislikePostInDto object with another object to determine if they are equal.
   * Two LikeOrDislikePostInDto objects are considered equal if their post ID, user ID, and action type are the same.
   *
   * @param obj The object to compare with.
   * @return true if the objects are equal; false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
          return false;
      }
      ReactionInDto other = (ReactionInDto) obj;
      return Objects.equals(postId, other.postId) && type == other.type && Objects.equals(userId, other.userId);
  }

}
