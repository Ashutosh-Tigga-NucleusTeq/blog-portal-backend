package com.blog.portal.responsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.blog.portal.entities.Blog;

/**
 * This is class Represents Response Dto that contains informartion about Reported Blog.
 * @author [ Ashutosh Tigga]
 */
public class ReportedBlogsOutDto {

	/**
	 * Id of the RepotedPost.
	 */
	private String id;

	/**
	 * Id of the user.
	 */
	private String userId;

	/**
	 * Id of the blog.
	 */
	private String postId;

	/**
	 * reported blog.
	 */
	private Blog blog;

	/**
	 * Reason of reporting blog.
	 */
	private List<String> reportReason = new ArrayList<String>();

	/**
	 * Gets Reported Blog.
	 * @return blog.
	 */
	public Blog getPost() {
		return blog;
	}

	/**
	 * Sets ReportedBlog.
	 * @param newBlog
	 */
	public void setPost(final Blog newBlog) {
		this.blog = newBlog;
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
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the id of the ReportedBlog.
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the ReportedBlog.
	 * @param id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the blog.
	 * @return postId
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the id of the blog.
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Gets the reason for reporting.
	 * @return reportReason.
	 */
	public List<String> getReportReason() {
		return reportReason;
	}

	/**
	 * Sets the reason of reporting.
	 * @param reportReason
	 */
	public void setReportReason(final List<String> reportReason) {
		this.reportReason = reportReason;
	}

	/**
	 * Generates hashcode of ReportBlogInDto based on postId,
	 * reoprtReason, userId, id.
	 * @return The generated hashcode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, postId, reportReason, userId);
	}

	/**
	 * Compares this ReportBlogInDto object with another object to
	 * determine if they are equal.
	 * @param obj
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ReportedBlogsOutDto other = (ReportedBlogsOutDto) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(postId, other.postId)
				&& Objects.equals(reportReason, other.reportReason)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * This method Represents String representation of ReportedBlogsOutDto.
	 * @return String representation of ReportedBlogsOutDto.
	 */
	@Override
	public String toString() {
		return "ReportBlogInDto [id=" + id
				+ ", +userId=" + userId
				+ ", postId=" + postId
				+ ", reportReason=" + reportReason + "]";
	}

	/**
	 * Initialize ReportBlogInDto based on userId, postId, reportedReason.
	 * @param id
	 * @param userId
	 * @param postId
	 * @param reportReason
	 */
	public ReportedBlogsOutDto(final String id, final String userId,
			final String postId, final List<String> reportReason) {
		super();
		this.id = id;
		this.userId = userId;
		this.postId = postId;
		this.reportReason = reportReason;
	}

	/**
	 * Default constructor of ReportBlogInDto.
	 */
	public ReportedBlogsOutDto() {
		super();
	}

}
