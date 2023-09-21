package com.blog.portal.requestPayload;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.AdminAction;

public class ActionOnReportedPostInDto {
	/**
	 * postId of the {@link ReportedPostInDto} Entity.
	 */
	@NotBlank
	private String postId;
	/**
	 * Action to be done by Admin on Reported Blog post..
	 */
	private AdminAction adminAction;
	/**
	 * Gets the postId of the ReportedPost.
	 * @return postId postId of the ReportedPost.
	 */
	public String getpostId() {
		return postId;
	}
	/**
	 * Sets the postId of the ReportedPost.
	 * @param newPostId postId of the reportedPost.
	 */
	public void setpostId(String newPostId) {
		this.postId = newPostId;
	}
	/**
	 * Gets the Action of the admin to reported blog post.
	 * @return adminAction Action of the admin to reported blog post.
	 */
	public AdminAction getAdminAction() {
		return adminAction;
	}
	/**
	 * Sets the Action of Admin to Reported blog post..
	 * @param adminAction Action of Admin to reporoted blog post.
	 */
	public void setAdminAction(AdminAction adminAction) {
		this.adminAction = adminAction;
	}

}
