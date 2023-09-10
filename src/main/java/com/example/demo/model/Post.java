package com.example.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;

/**
 * The {@code Post} class represents a Post entity in the application. It
 * stores information about a blog post, including its title, content, status,
 * technology category, creation date, editing date, and author data.
 *
 * @author [ Ashutosh Tigga]
 */
public class Post {

    /**
     * The unique identifier (id) of the blog post.
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
     * By default set to pending.
     */
    private PostStatus status = PostStatus.Pending;

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
    private User authorId;

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
     * @param authorId      The id of the user.
     */
    public Post(String title, String content, Date createdAt,
            TechnologyCategory techCategory,
            User authorId) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.techCategory = techCategory;
        this.authorId = authorId;
    }

    /**
     * Default constructor for the {@code Post} class.
     */
    public Post() {
        super();
    }

    /**
     * Gets the unique identifier (id) of the blog post.
     *
     * @return The unique identifier of the blog post.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier (id) of the blog post.
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
    public PostStatus getStatus() {
        return status;
    }

    /**
     * Sets the status of the blog post.
     *
     * @param status The status to set.
     */
    public void setStatus(PostStatus status) {
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
    public User getAuthorId() {
        return authorId;
    }

    /**
     * Sets the author's unique identifier associated with the blog post.
     *
     * @param authorId The author's unique identifier to set.
     */
    public void setAuthorId(User authorId) {
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

    /**
     * Generates a hash code for this {@code Post} object based on its authorId,
     * comments, content, createdAt, editedAt, id, status, techCategory, and title.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(authorId, comments, content, createdAt, editedAt, id, status, techCategory, title);
    }

    /**
     * Compares this {@code Post} object with another object to determine if they are equal.
     * Two {@code Post} objects are considered equal if their authorId, comments, content,
     * createdAt, editedAt, id, status, techCategory, and title are the same.
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
        Post other = (Post) obj;
        return Objects.equals(authorId, other.authorId) && Objects.equals(comments, other.comments)
                && Objects.equals(content, other.content) && Objects.equals(createdAt, other.createdAt)
                && Objects.equals(editedAt, other.editedAt) && Objects.equals(id, other.id)
                && status == other.status
                && techCategory == other.techCategory && Objects.equals(title, other.title);
    }

    /**
     * Generates a string representation of this {@code Post} object.
     *
     * @return The string representation of the {@code Post} object.
     */
    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", status=" + status
                + ", techCategory=" + techCategory + ", createdAt=" + createdAt + ", editedAt=" + editedAt
                + ", authorId=" + authorId + ", comments=" + comments + "]";
    }
}
