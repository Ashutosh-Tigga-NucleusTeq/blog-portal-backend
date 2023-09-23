package com.blog.portal.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blog.portal.enumResource.ReportAction;

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
     * Action taken by an admin on the Reported Post.
     */
    private ReportAction adminAction;

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
     * @param adminAction  The action taken by an admin on the Reported Post.
     */
    public ReportedPost(String id, String postId, String userId, String reportReason, ReportAction adminAction) {
        super();
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.reportReason = reportReason;
        this.adminAction = adminAction;
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
     * Gets the action taken by an admin on the Reported Post.
     *
     * @return The admin action.
     */
    public ReportAction getAdminAction() {
        return adminAction;
    }

    /**
     * Sets the action taken by an admin on the Reported Post.
     *
     * @param adminAction The admin action to set.
     */
    public void setAdminAction(ReportAction adminAction) {
        this.adminAction = adminAction;
    }

    /**
     * Generates a hash code for this {@code ReportedPost} object based on its id, postId, userId,
     * reportReason, and adminAction.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(adminAction, id, postId, reportReason, userId);
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
        return adminAction == other.adminAction && Objects.equals(id, other.id) && Objects.equals(postId, other.postId)
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
                + ", reportReason=" + reportReason + ", adminAction=" + adminAction + "]";
    }
}
