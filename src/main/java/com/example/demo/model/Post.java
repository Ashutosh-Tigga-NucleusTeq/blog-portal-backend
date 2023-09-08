package com.example.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.demo.enumResource.TechnologyCategory;

/**
 * The {@code Post} class represents a Post entity in the application. It
 * stores information about a blog post, including its title, content, status,
 * technology category, creation date, editing date, and author data.
 *
 * @author Ashutosh Tigga
 */
public class Post {

    /**
     * The unique identifier of the blog post.
     */
    @Id
    private String id;

    /**
     * The title of the blog post.
     */
    private String title;

    /**
     * The content of the blog post.
     */
    private String content;

    /**
     * The status of the blog post.
     */
    private boolean status;

    /**
     * The technology category of the blog post.
     */
    private TechnologyCategory techCategory;

    /**
     * The creation date of the blog post.
     */
    private Date createdAt;

    /**
     * The date when the blog post was last edited.
     */
    private Date editedAt;

    /**
     * The author data associated with the blog post.
     */
    private String authorId;

    /**
     * List of comments associated with the blog post.
     */
    private List<Comment> comments;

    /**
     * Creates a new instance of the {@code Post} class with specified parameters.
     *
     * @param title         The title of the blog post.
     * @param content       The content of the blog post.
     * @param createdAt     The creation date of the blog post.
     * @param techCategory  The technology category of the blog post.
     */
    public Post(String title, String content, Date createdAt, TechnologyCategory techCategory) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.techCategory = techCategory;
    }

    /**
     * Gets the unique identifier of the blog post.
     *
     * @return The unique identifier of the blog post.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the blog post.
     *
     * @param id The unique identifier to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the blog post.
     *
     * @return The title of the blog post.
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
     * @return The content of the blog post.
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
     * Checks the status of the blog post.
     *
     * @return {@code true} if the blog post is active, {@code false} otherwise.
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the status of the blog post.
     *
     * @param status The status to set.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Gets the technology category of the blog post.
     *
     * @return The technology category of the blog post.
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
     * Gets the creation date of the blog post.
     *
     * @return The creation date of the blog post.
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
     * Gets the date when the blog post was last edited.
     *
     * @return The date when the blog post was last edited.
     */
    public Date getEditedAt() {
        return editedAt;
    }

    /**
     * Sets the date when the blog post was last edited.
     *
     * @param editedAt The date when the blog post was last edited to set.
     */
    public void setEditedAt(Date editedAt) {
        this.editedAt = editedAt;
    }

    /**
     * Gets the author's unique identifier associated with the blog post.
     *
     * @return The author's unique identifier associated with the blog post.
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * Sets the author's unique identifier associated with the blog post.
     *
     * @param authorId The author's unique identifier to set.
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * Gets the list of comments associated with the blog post.
     *
     * @return The list of comments associated with the blog post.
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the list of comments associated with the blog post.
     *
     * @param comments The list of comments to set.
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
