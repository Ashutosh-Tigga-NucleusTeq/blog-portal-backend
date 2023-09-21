package com.blog.portal.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This Entity is for handling the reported Post.
 * @author [ Ashutosh Tigga]
 */
@Document
public class ReportedPost {

    /**
     * Id of the ReportedPost document.
     */
		@Id
    private String id;

    /**
     * Id of the post being reported.
     */
    private String postId;

    /**
     * Id of the User who reported the post.
     */
    private String userId;

    /**
     * Message that contains the reason for reporting the post.
     */
    private String reportReason;

    /**
     * Reference of Reported Post.
     */
    @DBRef
    private Post post;

    /**
     * Default constructor for the {@code ReportedPost} class.
     */
    public ReportedPost() {
        super();
    }

    /**
     * Creates a new instance of the {@code ReportedPost} class with specified parameters.
     *
     * @param id           The id of the ReportedPost document.
     * @param postId       The id of the post being reported.
     * @param userId       The id of the User who reported the post.
     * @param reportReason The message containing the reason for reporting the post.
     */
    public ReportedPost(String id, String postId, String userId, String reportReason) {
        super();
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.reportReason = reportReason;
    }

    /**
     * Gets the id of the ReportedPost.
     *
     * @return The id of the ReportedPost.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the ReportedPost.
     *
     * @param id The id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the id of the post being reported.
     *
     * @return The id of the post being reported.
     */
    public String getPostId() {
        return postId;
    }
    /**
     * Gets reference of ReportedPost.
     * @return reportedPost
     */
    public Post getPost() {
			return post;
		}

    /**
     * Sets the reference of RepotedPost.
     * @param reportedPost
     */
		public void setPost(Post reportedPost) {
			this.post = reportedPost;
		}

		/**
     * Sets the id of the post being reported.
     *
     * @param postId The id of the post to set.
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Gets the id of the User who reported the post.
     *
     * @return The id of the User who reported the post.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the id of the User who reported the post.
     *
     * @param userId The id of the User to set.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the reason for reporting the post.
     *
     * @return The reason message for reporting the post.
     */
    public String getReportReason() {
        return reportReason;
    }

    /**
     * Sets the reason for reporting the post.
     *
     * @param reportReason The reason message to set.
     */
    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    /**
     * Generates a hash code for this {@code ReportedPost} object based on its id, postId, userId,
     * reportReason.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, postId, reportReason, userId);
    }

    /**
     * Compares this {@code ReportedPost} object with another object to determine if they are equal.
     * Two {@code ReportedPost} objects are considered equal if their id, postId, userId, reportReason,
     * and adminAction are the same.
     *
     * @param obj The object to compare with.
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
        ReportedPost other = (ReportedPost) obj;
        return  Objects.equals(id, other.id) && Objects.equals(postId, other.postId)
                && Objects.equals(reportReason, other.reportReason) && Objects.equals(userId, other.userId);
    }

    /**
     * Generates a string representation of this {@code ReportedPost} object.
     *
     * @return The string representation of the {@code ReportedPost} object.
     */
    @Override
    public String toString() {
        return "ReportedPost [id=" + id + ", postId=" + postId + ", userId=" + userId
                + ", reportReason=" + reportReason + "]";
    }
}
