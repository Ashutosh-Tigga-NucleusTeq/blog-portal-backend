package com.blog.portal.responsePayload;

import java.util.Objects;

import com.blog.portal.entities.Post;

public class ReportedPostOutDto {

		/**
		 * Id of the RepotedPost.
		 */
		private String id;
		/**
		 * Id of the user.
		 */
		private String userId;
		/**
		 * Id of the post.
		 */
		private String postId;
		/**
		 * reported post.
		 */
		private Post post;
		/**
		 * Reason of reporting post.
		 */
		private String reportReason;
		/**
		 * Gets Reported Post.
		 * @return post.
		 */
		public Post getPost() {
			return post;
		}
		/**
		 * Sets ReportedPost.
		 * @param post
		 */
		public void setPost(Post post) {
			this.post = post;
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
		 * Gets the id of the ReportedPost.
		 * @return id
		 */
		public String getId() {
			return id;
		}
		/**
		 * Sets the id of the ReportedPost.
		 * @param id
		 */
		public void setId(String id) {
			this.id = id;
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
		 * Gets the reason for reporting.
		 * @return reportReason.
		 */
		public String getReportReason() {
			return reportReason;
		}
		/**
		 * Sets the reason of reporting.
		 * @param reportReason
		 */
		public void setReportReason(String reportReason) {
			this.reportReason = reportReason;
		}
		/**
		 * Generates hashcode of {@code ReportedPostInDto} based on postId, reoprtReason,
		 * userId, id.
		 * @return The generated hashcode.
		 */
		@Override
		public int hashCode() {
			return Objects.hash(id, postId, reportReason, userId);
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
			ReportedPostOutDto other = (ReportedPostOutDto) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(postId, other.postId)
					&& Objects.equals(reportReason, other.reportReason)
					&& Objects.equals(userId, other.userId);
		}
		/**
		 * Generate string representation of {@code ReportedPostInDto} object.
		 * @return string representation of {@code ReportedPostInDto} object.
		 */
		@Override
		public String toString() {
			return "ReportedPostInDto [id=" + id + ", +userId=" + userId
					+ ", postId=" + postId + ", reportReason=" + reportReason + "]";
		}
		/**
		 * Initialize {@code ReportedPostInDto} based on userId, postId, reportedReason.
		 * @param id
		 * @param userId
		 * @param postId
		 * @param reportReason
		 */
		public ReportedPostOutDto(String id, String userId, String postId, String reportReason) {
			super();
			this.id = id;
			this.userId = userId;
			this.postId = postId;
			this.reportReason = reportReason;
		}
		/**
		 * Default constructor of {@code ReportedPostInDto}.
		 */
		public ReportedPostOutDto() {
			super();
			// TODO Auto-generated constructor stub
		}



}
