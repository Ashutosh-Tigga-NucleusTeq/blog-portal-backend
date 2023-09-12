package com.example.demo.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * The {@code Post} class represents a Post entity in the application. It
 * stores information about a blog post, including its title, content, status,
 * technology category, creation date, editing date, and author data.
 *
 * @author [ Ashutosh Tigga]
 */
@Document(collection = "post")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
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
     * Id of the user.
     */
    private String userId;
    /**
     * The author data associated with the blog post.
     */
    @DBRef
    private User user;

    /**
     * Creates a new instance of the {@code Post} class with specified parameters.
     *
     * @param title         The title of the blog post.
     * @param content       The content of the blog post.
     * @param createdAt     The creation date of the blog post.
     * @param techCategory  The technology category of the blog post.
     */
    public Post(String title, String content, Date createdAt,
            TechnologyCategory techCategory
            ) {
        this.title = title;
        this.content = content;
        this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
        this.techCategory = techCategory;
				/* this.user = userId; */
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
    	 return new Date(createdAt.getTime());
    }

    /**
     * Sets the creation date of the blog post.
     *
     * @param createdAt The creation date to set.
     */
    public void setCreatedAt(Date createdAt) {
    		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;    }

    /**
     * Gets the date when the blog post was last edited.
     *
     * @return The date when the blog post was last edited.
     */
    public Date getEditedAt() {
    	 if (editedAt != null) {
         return new Date(editedAt.getTime());
     } else {
         return null; // Return null if 'editedAt' is null
     }
    }

    /**
     * Sets the date when the blog post was last edited.
     *
     * @param editedAt The date when the blog post was last edited to set.
     */
    public void setEditedAt(Date editedAt) {
    		this.editedAt = (editedAt != null) ? new Date(editedAt.getTime()) : null;
    }

    /**
     * Gets the author's unique identifier associated with the blog post.
     *
     * @return The author's unique identifier associated with the blog post.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the author's unique identifier associated with the blog post.
     *
     * @param author The author's unique identifier to set.
     */
    public void setUser(User author) {
        this.user = author;
    }
    /**
     * Gets user id.
     * @return userId
     */
    public String getUserId() {
			return userId;
		}
    /**
     * Sets user id.
     * @param userId
     */
		public void setUserId(String userId) {
			this.userId = userId;
		}

		/**
     * Generates a hash code for this {@code Post} object based on its authorId,
     * comments, content, createdAt, editedAt, id, status, techCategory, and title.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(user, content, createdAt, editedAt, id, status, techCategory, title);
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
        return Objects.equals(user, other.user)
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
                + ", author=" + user + "]";
    }
}
