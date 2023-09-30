package com.blog.portal.requestPayload;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.AdminAction;

/**
 * Represents a request payload for taking action on a reported blog post.
 */
public class ActionOnReportedPostInDto {

    /**
     * The unique identifier of the reported post.
     */
    @NotBlank
    private String postId;

    /**
     * The action to be taken by an admin on the reported blog post.
     */
    private AdminAction adminAction;

    /**
     * Gets the postId of the ReportedPost.
     * @return The postId of the reported post.
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Sets the postId of the ReportedPost.
     * @param newPostId The postId of the reported post.
     */
    public void setPostId(String newPostId) {
        this.postId = newPostId;
    }

    /**
     * Gets the action to be taken by an admin on the reported blog post.
     * @return The action to be taken by an admin.
     */
    public AdminAction getAdminAction() {
        return adminAction;
    }

    /**
     * Sets the action to be taken by an admin on the reported blog post.
     * @param adminAction The action to be taken by an admin.
     */
    public void setAdminAction(AdminAction adminAction) {
        this.adminAction = adminAction;
    }

    /**
     * Constructor to initialize the ActionOnReportedPostInDto.
     * @param postId The postId of the reported post.
     * @param adminAction The action to be taken by an admin.
     */
    public ActionOnReportedPostInDto(@NotBlank String postId, AdminAction adminAction) {
        super();
        this.postId = postId;
        this.adminAction = adminAction;
    }

    /**
     * Returns a string representation of the ActionOnReportedPostInDto.
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "ActionOnReportedPostInDto [postId=" + postId + ", adminAction=" + adminAction + "]";
    }

    /**
     * Computes the hash code for the ActionOnReportedPostInDto object.
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(adminAction, postId);
    }

    /**
     * Checks if this ActionOnReportedPostInDto object is equal to another object.
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
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
        ActionOnReportedPostInDto other = (ActionOnReportedPostInDto) obj;
        return adminAction == other.adminAction && Objects.equals(postId, other.postId);
    }

    /**
     * Default constructor for ActionOnReportedPostInDto.
     */
    public ActionOnReportedPostInDto() {
        super();
    }
}
