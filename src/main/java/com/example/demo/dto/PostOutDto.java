package com.example.demo.dto;

import java.util.Date;

import com.example.demo.enumResource.TechnologyCategory;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a Data Transfer Object (DTO) for a blog post.
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
    private String authorId;

    /**
     * Constructor for creating a `PostOutDto` object.
     *
     * @param id						 The if of the post.
     * @param title          The title of the blog post.
     * @param content        The content of the blog post.
     * @param createdAt      The creation date of the blog post.
     * @param techCategory   The technology category of the blog post.
     * @param authorId       The author's ID associated with the blog post.
     */
    public PostOutDto(String id, String title, String content, Date createdAt,
                      TechnologyCategory techCategory, String authorId) {
        this.title = title;
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.techCategory = techCategory;
        this.authorId = authorId;
    }
    /**
     * non parameterized constuctor of PostOutDto.
     */
    public PostOutDto() {
			// TODO Auto-generated constructor stub
		}

    /**
     * Gets the id of the post.
     * @return id id of the post.
     */
		public String getId() {
			return id;
		}

		/**
		 * Sets the if of the post.
		 * @param id id of the post.
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
    public String getAuthorId() {
        return authorId;
    }

    /**
     * Sets the author's ID associated with the blog post.
     *
     * @param authorId The author's ID to set.
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return A string describing the object.
     */
    @Override
    public String toString() {
        return "PostOutDto [minTitle=" + minTitle + ", maxTitle=" + maxTitle + ", title=" + title + ", minContent="
                + minContent + ", maxContent=" + maxContent + ", content=" + content + ", createdAt=" + createdAt
                + ", techCategory=" + techCategory + "]";
    }
}
