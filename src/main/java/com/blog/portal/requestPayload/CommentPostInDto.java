package com.blog.portal.requestPayload;

import java.util.Objects;

/**
 * Represents a Data Transfer Object (DTO) for creating a comment on a post.
 * This class contains information about the comment content, user ID, and post ID.
 */
public class CommentPostInDto {
    /**
     * The content of the comment.
     */
    private String content;

    /**
     * The ID of the user who is making the comment.
     */
    private String userId;

    /**
     * The ID of the post on which the comment is being made.
     */
    private String postId;

    /**
     * Gets the content of the comment.
     * @return content
     */
    public String getContent() {
			return content;
		}
    /**
     * Sets the content of the comment.
     * @param content
     */
		public void setContent(String content) {
			this.content = content;
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
		 * Gets id of the post.
		 * @return postId.
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
     * Constructs a new instance of the {@code CommentPostInDto} class with the specified parameters.
     *
     * @param content The content of the comment.
     * @param userId  The ID of the user making the comment.
     * @param postId  The ID of the post on which the comment is being made.
     */
    public CommentPostInDto(String content, String userId, String postId) {
        super();
        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }

    /**
     * Default constructor for the {@code CommentPostInDto} class.
     */
    public CommentPostInDto() {
        super();
    }

    /**
     * Computes the hash code of this object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(content, postId, userId);
    }

    /**
     * Compares this object to another object to check for equality.
     *
     * @param obj The object to compare to.
     * @return {@code true} if the objects are equal, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentPostInDto other = (CommentPostInDto) obj;
        return Objects.equals(content, other.content) && Objects.equals(postId, other.postId)
                && Objects.equals(userId, other.userId);
    }

    /**
     * Returns a string representation of this object.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return "CommentPostInDto [content=" + content + ", userId=" + userId + ", postId=" + postId + "]";
    }
}
