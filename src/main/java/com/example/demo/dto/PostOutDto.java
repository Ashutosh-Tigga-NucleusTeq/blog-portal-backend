package com.example.demo.dto;

import java.util.Date;
import java.util.Objects;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a Data Transfer Object (DTO) for a blog post.
 * @author [ Ashutosh Tigga]
 */
public class PostOutDto {
    /**
     * Id of the post.
     */
    private String id;

    /**
     * The minimum size of the title.
     */
    private final int minTitle = 5;

    /**
     * The maximum size of the title.
     */
    private final int maxTitle = 100;

    /**
     * The title of the blog post.
     */
    @Size(min = minTitle, max = maxTitle,
            message = "Post title size must be between 5-100 characters")
    private String title;

    /**
     * The minimum size of the blog content.
     */
    private final int minContent = 25;

    /**
     * The maximum size of the blog content.
     */
    private final int maxContent = 500;

    /**
     * The content of the blog post.
     */
    @Size(min = minContent, max = maxContent,
            message = "Post content size must be between 25 - 500 characters")
    private String content;

    /**
     * The creation date of the blog post.
     */
    @NotNull
    private Date createdAt;

    /**
     * The technology category of the blog post.
     */
    private TechnologyCategory techCategory;

    /**
     * The author's ID associated with the blog post.
     */
    private User authorId;

    /**
     * Status of the post.
     */
    private PostStatus status;

    /**
     * Constructor for creating a `PostOutDto` object.
     *
     * @param id           The id of the post.
     * @param title        The title of the blog post.
     * @param content      The content of the blog post.
     * @param status       The status of the post.
     * @param createdAt    The creation date of the blog post.
     * @param techCategory The technology category of the blog post.
     * @param authorId     The author's ID associated with the blog post.
     */
    public PostOutDto(String id, String title, String content, PostStatus status,
                      TechnologyCategory techCategory, Date createdAt, User authorId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.techCategory = techCategory;
        this.authorId = authorId;
        this.status = status;
    }

    /**
     * Default constructor for the `PostOutDto` class.
     */
    public PostOutDto() {
        super();
    }

    /**
     * Gets status of the post.
     *
     * @return The status of the post.
     */
    public PostStatus getStatus() {
        return status;
    }

    /**
     * Sets status of the post.
     *
     * @param status The status to set.
     */
    public void setStatus(PostStatus status) {
        this.status = status;
    }

    /**
     * Gets the id of the post.
     *
     * @return The id of the post.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the post.
     *
     * @param id The id of the post to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the blog post.
     *
     * @return The blog post title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the blog post.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the content of the blog post.
     *
     * @return The blog post content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the blog post.
     *
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the creation date of the blog post.
     *
     * @return The creation date.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation date of the blog post.
     *
     * @param createdAt The creation date to set.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets the technology category of the blog post.
     *
     * @return The technology category.
     */
    public TechnologyCategory getTechCategory() {
        return techCategory;
    }

    /**
     * Sets the technology category of the blog post.
     *
     * @param techCategory The technology category to set.
     */
    public void setTechCategory(TechnologyCategory techCategory) {
        this.techCategory = techCategory;
    }

    /**
     * Gets the author's ID associated with the blog post.
     *
     * @return The author's ID.
     */
    public User getAuthorId() {
        return authorId;
    }

    /**
     * Sets the author's ID associated with the blog post.
     *
     * @param authorId The author's ID to set.
     */
    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }

    /**
     * Computes the hash code of this object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(authorId, content, createdAt, id, status, techCategory, title);
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
        PostOutDto other = (PostOutDto) obj;
        return Objects.equals(authorId, other.authorId) && Objects.equals(content, other.content)
                && Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
                && status == other.status && techCategory == other.techCategory
                && Objects.equals(title, other.title);
    }

    /**
     * Converts this object into a string representation for debugging and logging purposes.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return "PostOutDto [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
                + ", techCategory=" + techCategory + ", authorId=" + authorId + ", status=" + status + "]";
    }
}
