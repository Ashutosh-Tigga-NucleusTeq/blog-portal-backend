package com.blog.portal.entities;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The {@code ReportedBlog} class represents a ReportedBlog entity in the application. It stores
 * information about Reported Blogs.
 *
 * @author [ Ashutosh Tigga]
 */
@Document("reported-blog")
public class ReportedBlog {

	/**
	 * Id of the ReportedBlog document.
	 */
	@Id
	private String id;

	/**
	 * Id of the blog being reported.
	 */
	private String postId;

	/**
	 * Id of the User who reported the blog.
	 */
	private String userId;

	/**
	 * Message that contains the reason for reporting the blog.
	 */
	private String reportReason;

	/**
	 * Reference of Reported Blog.
	 */
	@DBRef
	private Blog blog;

	/**
	 * Default constructor for the {@code ReportedBlog} class.
	 */
	public ReportedBlog() {
		super();
	}

	/**
	 * Creates a new instance of the {@code ReportedBlog} class with specified
	 * parameters.
	 *
	 * @param id           The id of the ReportedBlog document.
	 * @param postId       The id of the blog being reported.
	 * @param userId       The id of the User who reported the blog.
	 * @param reportReason The message containing the reason for reporting the blog.
	 */
	public ReportedBlog(final String id,
			final String postId,
			final String userId,
			final String reportReason) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
		this.reportReason = reportReason;
	}

	/**
	 * Gets the id of the ReportedBlog.
	 *
	 * @return The id of the ReportedBlog.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the ReportedBlog.
	 *
	 * @param id The id to set.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the id of the blog being reported.
	 *
	 * @return The id of the blog being reported.
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Gets reference of ReportedBlog.
	 *
	 * @return reportedPost
	 */
	public Blog getPost() {
		return blog;
	}

	/**
	 * Sets the reference of RepotedPost.
	 *
	 * @param reportedPost
	 */
	public void setPost(final Blog reportedPost) {
		this.blog = reportedPost;
	}

	/**
	 * Sets the id of the blog being reported.
	 *
	 * @param postId The id of the blog to set.
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Gets the id of the User who reported the blog.
	 *
	 * @return The id of the User who reported the blog.
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the id of the User who reported the blog.
	 *
	 * @param userId The id of the User to set.
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the reason for reporting the blog.
	 *
	 * @return The reason message for reporting the blog.
	 */
	public String getReportReason() {
		return reportReason;
	}

	/**
	 * Sets the reason for reporting the blog.
	 *
	 * @param reportReason The reason message to set.
	 */
	public void setReportReason(final String reportReason) {
		this.reportReason = reportReason;
	}

	/**
	 * Generates a hash code for this {@code ReportedBlog} object based on its id,
	 * postId, userId, reportReason.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id, postId, reportReason, userId);
	}

	/**
	 * Compares this {@code ReportedBlog} object with another object to determine if
	 * they are equal. Two {@code ReportedBlog} objects are considered equal if
	 * their id, postId, userId, reportReason, and adminAction are the same.
	 *
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
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
		ReportedBlog other = (ReportedBlog) obj;
		return Objects.equals(id, other.id) && Objects.equals(postId, other.postId)
				&& Objects.equals(reportReason, other.reportReason) && Objects.equals(userId, other.userId);
	}

	/**
	 * Generates a string representation of this {@code ReportedBlog} object.
	 *
	 * @return The string representation of the {@code ReportedBlog} object.
	 */
	@Override
	public String toString() {
		return "ReportedBlog [id=" + id
				+ ", postId=" + postId
				+ ", userId=" + userId
				+ ", reportReason=" + reportReason
				+ "]";
	}
}
