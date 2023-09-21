package com.blog.portal.requestPayload;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class ReportedPostInDto {
	/**
	 * Id of the user.
	 */
	@NotBlank(message = "user id must not be blank")
	private String userId;
	/**
	 * Id of the post.
	 */
	@NotBlank(message = "post id must not be blank")
	private String postId;
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
	 * Generates hashcode of {@code ReportedPostInDto} based on postId, reoprtReason,
	 * userId.
	 * @return The generated hashcode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postId, userId);
	}
	/**
	 * Compares this {@code ReportedPostInDto} object with another object to determine if they are equal.
	 *
	 * @param obj
	 * 	 * @return {@code true} if the objects are equal; {@code false} otherwise.
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
		ReportedPostInDto other = (ReportedPostInDto) obj;
		return Objects.equals(postId, other.postId)	&& Objects.equals(userId, other.userId);
	}
	/**
	 * Generate string representation of {@code ReportedPostInDto} object.
	 * @return string representation of {@code ReportedPostInDto} object.
	 */
	@Override
	public String toString() {
		return "ReportedPostInDto [userId=" + userId + ", postId=" + postId + "]";
	}
	/**
	 * Initialize {@code ReportedPostInDto} based on userId, postId.
	 * @param userId
	 * @param postId
	 */
	public ReportedPostInDto(String userId, String postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}
	/**
	 * Default constructor of {@code ReportedPostInDto}.
	 */
	public ReportedPostInDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
