package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * Represents a Data Transfer Object (DTO) for a blog post.
 * @author [ Ashutosh Tigga]
 */
public class PostBlogOutDto {
    /**
     * Id of the post.
     */
    private String id;

    /**
     * The minimum size of the title.
     */
    private static final int MINTITLE = 1;

    /**
     * The title of the blog post.
     */
    @Size(min = MINTITLE,
            message = "Post title size must be empty")
    private String title;

    /**
     * The minimum size of the blog content.
     */
    private static final int MINCONTENT = 1;

    /**
     * The content of the blog post.
     */
    @Size(min = MINCONTENT,
            message = "Post content size must be empty")
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
     * The author's  associated with the blog post.
     */
    private User user;

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
     * @param user     The author's ID associated with the blog post.
     */
    public PostBlogOutDto(String id, String title, String content, PostStatus status,
                      TechnologyCategory techCategory, Date createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
        this.techCategory = techCategory;
        this.user = user;
        this.status = status;
    }

    /**
     * Default constructor for the `PostOutDto` class.
     */
    public PostBlogOutDto() {
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
    	 return new Date(createdAt.getTime());
    }

    /**
     * Sets the creation date of the blog post.
     *
     * @param createdAt The creation date to set.
     */
    public void setCreatedAt(Date createdAt) {
    	 this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
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
    public User getUser() {
        return user;
    }

    /**
     * Sets the author's ID associated with the blog post.
     *
     * @param user The author's ID to set.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Computes the hash code of this object based on its attributes.
     *
     * @return The hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(user, content, createdAt, id, status, techCategory, title);
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
        PostBlogOutDto other = (PostBlogOutDto) obj;
        return Objects.equals(user, other.user) && Objects.equals(content, other.content)
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
                + ", techCategory=" + techCategory + ", author=" + user + ", status=" + status + "]";
    }
}
