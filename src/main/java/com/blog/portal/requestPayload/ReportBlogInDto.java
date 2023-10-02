package com.blog.portal.requestPayload;

import java.util.Objects;
import javax.validation.constraints.NotBlank;

/**
 * This class Represents Request DTO that contains fields like userId, postId
 * and reportReson for performing report functionality on selected postId by
 * selected userId with proper reporting reason.
 *
 * @author Ashutosh Tigga
 */
public class ReportBlogInDto {
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
	 * Reason of reporting post.
	 */
	@NotBlank(message = "report reason must not be blank")
	private String reportReason;

	/**
	 * Gets the Reason of reporting.
	 *
	 * @return reasonReport proper message for repoting.
	 */
	public String getReportReason() {
		return reportReason;
	}

	/**
	 * Sets the reason of reporting.
	 *
	 * @param reportReason
	 */
	public void setReportReason(final String reportReason) {
		this.reportReason = reportReason;
	}

	/**
	 * Gets the id of the user.
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the id of the user.
	 *
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the id of the post.
	 *
	 * @return postId
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * Sets the id of the post.
	 *
	 * @param postId
	 */
	public void setPostId(final String postId) {
		this.postId = postId;
	}

	/**
	 * Generates hashcode of {@code ReportBlogInDto} based on postId, reoprtReason,
	 * userId.
	 *
	 * @return The generated hashcode.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(postId, userId);
	}

	/**
	 * Compares this {@code ReportBlogInDto} object with another object to determine
	 * if they are equal.
	 *
	 * @param obj * @return {@code true} if the objects are equal; {@code false}
	 *            otherwise.
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
		ReportBlogInDto other = (ReportBlogInDto) obj;
		return Objects.equals(postId, other.postId)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * Generate string representation of {@code ReportBlogInDto} object.
	 *
	 * @return string representation of {@code ReportBlogInDto} object.
	 */
	@Override
	public String toString() {
		return "ReportBlogInDto [userId=" + userId
				+ ", postId=" + postId + "]";
	}

	/**
	 * Initialize {@code ReportBlogInDto} based on userId, postId.
	 *
	 * @param userId
	 * @param postId
	 */
	public ReportBlogInDto(final String userId, final String postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}

	/**
	 * Default constructor of {@code ReportBlogInDto}.
	 */
	public ReportBlogInDto() {
		super();
	}

}
