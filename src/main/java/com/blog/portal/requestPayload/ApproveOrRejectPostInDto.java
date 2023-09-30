package com.blog.portal.requestPayload;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.blog.portal.enumResource.PostStatus;

/**
 * Represents a request payload for approving or rejecting a blog post.
 */
public class ApproveOrRejectPostInDto {
    /**
     * The unique identifier of the post.
     */
    @NotBlank
    private String postId;

    /**
     * The status of the post after approval or rejection.
     */
    private PostStatus postStatus;

    /**
     * Gets the ID of the post.
     *
     * @return The ID of the post.
     */
    public String getPostId() {
        return postId;
    }

    /**
     * Sets the ID of the post.
     *
     * @param postId The ID of the post.
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }

    /**
     * Gets the status of the post.
     *
     * @return The status of the post.
     */
    public PostStatus getPostStatus() {
        return postStatus;
    }

    /**
     * Sets the status of the post.
     *
     * @param postStatus The status of the post.
     */
    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    /**
     * Generates a string representation of the ApproveOrRejectPostInDto object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "ApproveOrRejectPostInDto [postId=" + postId + ", postStatus=" + postStatus + "]";
    }

    /**
     * Computes the hash code for the ApproveOrRejectPostInDto object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(postId, postStatus);
    }

    /**
     * Compares this ApproveOrRejectPostInDto object to another object to determine if they are equal.
     *
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
        ApproveOrRejectPostInDto other = (ApproveOrRejectPostInDto) obj;
        return Objects.equals(postId, other.postId) && postStatus == other.postStatus;
    }

    /**
     * Default constructor for ApproveOrRejectPostInDto.
     */
    public ApproveOrRejectPostInDto() {
        super();
    }

    /**
     * Initializes a new instance of the ApproveOrRejectPostInDto class with the specified values.
     *
     * @param postId     The ID of the post.
     * @param postStatus The status of the post.
     */
    public ApproveOrRejectPostInDto(@NotBlank String postId, PostStatus postStatus) {
        super();
        this.postId = postId;
        this.postStatus = postStatus;
    }
}
