package com.example.demo.dto;

import java.util.Date;
import java.util.Objects;

import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a Data Transfer Object (DTO) for a blog post.
 * @author [ Ashutosh Tigga]
 */
public class PostInDto {
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
    @Size(min = minTitle, max = maxTitle, message = "Post title size must be between 5-100 characters")
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
    @Size(min = minContent, max = maxContent, message = "Post content size must be between 25 - 500 characters")
    private String content;

    /**
     * The creation date of the blog post.
     */
    @NotNull
    private Date createdAt;

    /**
     * The id of the author who posted the post.
     */
    private User authorId;

    /**
     * Technology category of the post.
     */
    private TechnologyCategory techCategory;

    /**
     * Constructor for creating a `PostInDto` object.
     *
     * @param title        The title of the blog post.
     * @param content      The content of the blog post.
     * @param createdAt    The creation date of the blog post.
     * @param authorId     The id of the author who posted the post.
     * @param techCategory The technology category of the post.
     */
    public PostInDto(String title, String content, Date createdAt, User authorId, TechnologyCategory techCategory) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.authorId = authorId;
        this.techCategory = techCategory;
    }

    /**
     * Default constructor for the `PostInDto` class.
     */
    public PostInDto() {
        super();
    }

    /**
     * Gets the id of the author who posted the post.
     *
     * @return The author's id.
     */
    public User getAuthorId() {
        return authorId;
    }

    /**
     * Sets the id of the author who posted the post.
     *
     * @param authorId The author's id to set.
     */
    public void setAuthorId(User authorId) {
        this.authorId = authorId;
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
     * Computes the hash code of this object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(authorId, content, createdAt, techCategory, title);
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PostInDto other = (PostInDto) obj;
        return Objects.equals(authorId, other.authorId) && Objects.equals(content, other.content)
                && Objects.equals(createdAt, other.createdAt) && techCategory == other.techCategory
                && Objects.equals(title, other.title);
    }

    /**
     * Converts this object into a string representation for debugging and logging purposes.
     *
     * @return The string representation of this object.
     */
    @Override
    public String toString() {
        return "PostInDto [title=" + title + ", content=" + content + ", createdAt=" + createdAt + ", authorId=" + authorId
                + ", techCategory=" + techCategory + "]";
    }
}
