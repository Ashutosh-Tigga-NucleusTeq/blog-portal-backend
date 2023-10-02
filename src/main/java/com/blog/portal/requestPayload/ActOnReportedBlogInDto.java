package com.blog.portal.requestPayload;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.ReportedBlogAction;

/**
 * This class Represents a Request DTO that contains postId and reportedBlogAction
 * for taking action on a reported BLOG post.
 *
 * @author [ Ashutosh Tigga]
 */
public class ActOnReportedBlogInDto {

    /**
     * The unique Identifier  of the BLOG post.
     */
    @NotBlank(message = "Blog ID is Required")
    private String postId;

    /**
     * The action to be taken by an ADMIN on the reported BLOG post.
     */
    private ReportedBlogAction reportedBlogAction;

    /**
     * Gets the postId of the ReportedBlog.
     *
     * @return The postId of the reported post.
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Sets the postId of the ReportedBlog.
     *
     * @param newPostId The postId of the reported post.
     */
    public void setPostId(final String newPostId) {
        this.postId = newPostId;
    }

    /**
     * Gets the action to be taken by an admin on the reported blog post.
     *
     * @return The action to be taken by an admin.
     */
    public ReportedBlogAction getAdminAction() {
        return reportedBlogAction;
    }

    /**
     * Sets the action to be taken by an admin on the reported blog post.
     *
     * @param newReportedBlogAction The action to be taken by an admin.
     */
    public void setAdminAction(final ReportedBlogAction newReportedBlogAction) {
        this.reportedBlogAction = newReportedBlogAction;
    }

    /**
     * Constructor to initialize the ActOnReportedBlogInDto.
     *
     * @param postId The postId of the reported post.
     * @param reportedBlogAction The action to be taken by an admin.
     */
    public ActOnReportedBlogInDto(final String postId, final ReportedBlogAction reportedBlogAction) {
        super();
        this.postId = postId;
        this.reportedBlogAction = reportedBlogAction;
    }

    /**
     * Returns a string representation of the ActOnReportedBlogInDto.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "ActOnReportedBlogInDto [postId=" + postId
        		+ ", reportedBlogAction=" + reportedBlogAction + "]";
    }

    /**
     * Computes the hash code for the ActOnReportedBlogInDto object.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(reportedBlogAction, postId);
    }

    /**
     * Checks if this ActOnReportedBlogInDto object is equal to another object.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
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
        ActOnReportedBlogInDto other = (ActOnReportedBlogInDto) obj;
        return reportedBlogAction == other.reportedBlogAction
        		&& Objects.equals(postId, other.postId);
    }

    /**
     * Default constructor for ActOnReportedBlogInDto.
     */
    public ActOnReportedBlogInDto() {
        super();
    }
}
