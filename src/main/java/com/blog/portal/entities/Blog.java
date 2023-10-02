package com.blog.portal.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * The {@code Blog} class represents a Blog entity in the application. It stores
 * information about a BLOG post, including its title, content, status,
 * technology category, creation date, editing date, and author data.
 *
 * @author [ Ashutosh Tigga]
 */
@Document(collection = "blog")
public class Blog {

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
	 * The status of the blog post. By default set to pending.
	 */
	private BlogStatus status = BlogStatus.PENDING;

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
	 * Blog reported by.
	 */
	private Set<String> reportedBy = new HashSet<String>();

	/**
	 * Gets ReportedBy set of user who reported post..
	 *
	 * @return reportedBy
	 */
	public Set<String> getReportedBy() {
		return reportedBy;
	}

	/**
	 * Sets reported by set of user who reported post.
	 *
	 * @param reportedBy
	 */
	public void setReportedBy(final Set<String> reportedBy) {
		this.reportedBy = reportedBy;
	}

	/**
	 * Represent user who liked post.
	 */
	private Set<String> likedBy = new HashSet<String>();
	/**
	 * Represent User who disliked post.
	 */
	private Set<String> disLikedBy = new HashSet<String>();

	/**
	 * List of Comment.
	 */
	private List<String> commentBy = new ArrayList<String>();

	/**
	 * Default constructor for the {@code Blog} class.
	 */
	public Blog() {
		super();
	}

	/**
	 * Gets user who liked.
	 *
	 * @return likedBy
	 */
	public Set<String> getLikedBy() {
		return likedBy;
	}

	/**
	 * Sets user who liked.
	 *
	 * @param likedBy
	 */
	public void setLikedBy(final Set<String> likedBy) {
		this.likedBy = likedBy;
	}

	/**
	 * Gets user who disliked.
	 *
	 * @return dislikedBy
	 */
	public Set<String> getDisLikedBy() {
		return disLikedBy;
	}

	/**
	 * Sets user who disliked.
	 *
	 * @param dislikedBy
	 */
	public void setDisLikedBy(final Set<String> dislikedBy) {
		this.disLikedBy = dislikedBy;
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
	public void setId(final String id) {
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
	public void setTitle(final String title) {
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
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Checks the status of the blog post.
	 *
	 * @return {@code true} if the blog post is active, {@code false} otherwise.
	 */
	public BlogStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status of the blog post.
	 *
	 * @param status The status to set.
	 */
	public void setStatus(final BlogStatus status) {
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
	public void setTechCategory(final TechnologyCategory techCategory) {
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
	public void setCreatedAt(final Date createdAt) {
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * Gets comments of post.
	 *
	 * @return comments
	 */
	public List<String> getCommentBy() {
		return commentBy;
	}

	/**
	 * Sets the comments of post.
	 *
	 * @param comments
	 */
	public void setCommentBy(final List<String> comments) {
		this.commentBy = comments;
	}

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
	public void setEditedAt(final Date editedAt) {
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
	public void setUser(final User author) {
		this.user = author;
	}

	/**
	 * Gets user id.
	 *
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets user id.
	 *
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * Calculates the hash code for this Blog object based on its various
	 * properties, including comments, content, creation date, dislikedBy users,
	 * edited date, id, likedBy users, status, technology category, title, user, and
	 * userId. The hash code calculation considers all these properties to ensure
	 * uniqueness.
	 *
	 * @return The calculated hash code value for this Blog object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(commentBy, content, createdAt, disLikedBy, editedAt, id, likedBy, status, techCategory, title,
				user, userId);
	}

	/**
	 * Compares this Blog object with another object to determine if they are equal.
	 * Two Blog objects are considered equal if all their properties, including
	 * comments, content, creation date, dislikedBy users, edited date, id, likedBy
	 * users, status, technology category, title, user, and userId, are equal.
	 *
	 * @param obj The object to compare with this Blog.
	 * @return true if the objects are equal; false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Blog other = (Blog) obj;
		return Objects.equals(commentBy, other.commentBy)
				&& Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(disLikedBy, other.disLikedBy)
				&& Objects.equals(editedAt, other.editedAt)
				&& Objects.equals(id, other.id)
				&& Objects.equals(likedBy, other.likedBy)
				&& status == other.status
				&& techCategory == other.techCategory
				&& Objects.equals(title, other.title)
				&& Objects.equals(user, other.user)
				&& Objects.equals(userId, other.userId);
	}

	/**
	 * Parameterized constructor of {@code Blog}.
	 *
	 * @param id
	 * @param title
	 * @param content
	 * @param status
	 * @param techCategory
	 * @param createdAt
	 * @param editedAt
	 * @param userId
	 * @param user
	 * @param likedBy
	 * @param dislikedBy
	 * @param commentBy
	 */
	public Blog(final String id, final String title, final String content, final BlogStatus status,
			final TechnologyCategory techCategory,
			final Date createdAt, final Date editedAt,
			final String userId, final User user,
			final Set<String> likedBy,
			final Set<String> dislikedBy,
			final List<String> commentBy) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.techCategory = techCategory;
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
		this.editedAt = (editedAt != null) ? new Date(editedAt.getTime()) : null;
		this.userId = userId;
		this.user = user;
		this.likedBy = likedBy;
		this.disLikedBy = dislikedBy;
		this.commentBy = commentBy;
	}

	/**
	 * Generates a string representation of this Blog object, including all of its
	 * properties, such as id, title, content, status, technology category, creation
	 * date, edited date, userId, user, likedBy users, dislikedBy users, and
	 * comments. This string representation provides a detailed view of a blog
	 * post's attributes.
	 *
	 * @return A string containing the Blog's properties and their values.
	 */
	@Override
	public String toString() {
		return "Blog [id=" + id
				+ ", title=" + title
				+ ", content=" + content
				+ ", status=" + status
				+ ", techCategory=" + techCategory
				+ ", createdAt=" + createdAt
				+ ", editedAt=" + editedAt
				+ ", userId=" + userId
				+ ", user=" + user
				+ ", likedBy=" + likedBy
				+ ", dislikedBy=" + disLikedBy
				+ ", commentBy=" + commentBy + "]";
	}

	/**
	 * Initailizing object with passing one paramether id of the post.
	 *
	 * @param id
	 */
	public Blog(final String id) {
		super();
		this.id = id;
	}

}
