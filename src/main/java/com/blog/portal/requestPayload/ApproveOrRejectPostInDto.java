package com.blog.portal.requestPayload;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.PostStatus;

public class ApproveOrRejectPostInDto {
	/**
	 * Id of the post.
	 */
	@NotBlank
	private String postId;
	/**
	 * Status of the code.
	 */
	private PostStatus postStatus;
	/**
	 * Gets the id of the post.
	 * @return postId id of the post.
	 */
	public String getPostId() {
		return postId;
	}
	/**
	 * Sets the id of the post.
	 * @param postId id of the post.
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}
	/**
	 * Gets the status of the post.
	 * @return postStatus status of the post.
	 */
	public PostStatus getPostStatus() {
		return postStatus;
	}
	/**
	 * Sets the status of the post.
	 * @param postStatus status of the post.
	 */
	public void setPostStatus(PostStatus postStatus) {
		this.postStatus = postStatus;
	}

}
