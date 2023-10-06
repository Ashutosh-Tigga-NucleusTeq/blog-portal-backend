package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class represents a Approved Blog Response DTO. It contains information
 * about Approved BLOG post.
 * @author [ Ashutosh Tigga]
 */
public class ApprovedBlogsOutDto implements Comparable<ApprovedBlogsOutDto> {

	/**
	 * ID of the BLOG post.
	 */
	private String id;

	/**
	 * The Title of the BLOG post.
	 */
	private String title;

	/**
	 * The Content of the BLOG post.
	 */
	private String content;

	/**
	 * The Creation date of the BLOG post.
	 */
	private Date createdAt;

	/**
	 * The Technology category of the BLOG post.
	 */
	private TechnologyCategory technology;

	/**
	 * The Author's ID associated with the BLOG post.
	 */
	private User user;

	/**
	 * Status of the BLOG post.
	 */
	private BlogStatus status;

	/**
	 * List of comment.
	 */
	private List<String> commentBy;

	/**
	 * Set of user who liked BLOG post.
	 */
	private Set<String> likedBy = new HashSet<String>();

	/**
	 * Sets of user who disliked BLOG post.
	 */
	private Set<String> disLikedBy = new HashSet<String>();
	/**
	 * Sets of user who reported Blog.
	 */
	private Set<String> reportedBy = new HashSet<String>();

	/**
	 * Gets the Collection of user who reported post.
	 * @return reportedBy
	 */
	public Set<String> getReportedBy() {
		return reportedBy;
	}

	/**
	 * Sets the Collection of user who reportedPost.
	 * @param reportedBy
	 */
	public void setReportedBy(final Set<String> reportedBy) {
		this.reportedBy = reportedBy;
	}

	/**
	 * Gets the list of comments.
	 * @return comments
	 */
	public List<String> getCommentBy() {
		return commentBy;
	}

	/**
	 * Sets the user who comment.
	 * @param commentBy
	 */
	public void setCommentBy(final List<String> commentBy) {
		this.commentBy = commentBy;
	}

	/**
	 * Gets the user who liked post.
	 * @return likedBy
	 */
	public Set<String> getLikedBy() {
		return likedBy;
	}

	/**
	 * Sets the user who liked post.
	 * @param likedBy
	 */
	public void setLikedBy(final Set<String> likedBy) {
		this.likedBy = likedBy;
	}

	/**
	 * Gets the user who disliked post.
	 * @return disLikedBy
	 */
	public Set<String> getDisLikedBy() {
		return disLikedBy;
	}

	/**
	 * Sets the user who disliked post.
	 * @param disLikedBy
	 */
	public void setDisLikedBy(final Set<String> disLikedBy) {
		this.disLikedBy = disLikedBy;
	}

	/**
	 * Constructor for creating a `BlogOutDto` object.
	 * @param id           The id of the post.
	 * @param title        The title of the blog post.
	 * @param content      The content of the blog post.
	 * @param status       The status of the post.
	 * @param createdAt    The creation date of the blog post.
	 * @param techCategory The technology category of the blog post.
	 * @param user         The author's ID associated with the blog post.
	 */
	public ApprovedBlogsOutDto(final String id, final String title,
			final String content,
			final BlogStatus status,
			final TechnologyCategory techCategory,
			final Date createdAt,
			final User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
		this.technology = techCategory;
		this.user = user;
		this.status = status;
	}

	/**
	 * Default constructor for the `BlogOutDto` class.
	 */
	public ApprovedBlogsOutDto() {
		super();
	}

	/**
	 * Gets status of the post.
	 * @return The status of the post.
	 */
	public BlogStatus getStatus() {
		return status;
	}

	/**
	 * Sets status of the post.
	 * @param status The status to set.
	 */
	public void setStatus(final BlogStatus status) {
		this.status = status;
	}

	/**
	 * Gets the id of the post.
	 * @return The id of the post.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id of the post.
	 * @param id The id of the post to set.
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the title of the blog post.
	 * @return The blog post title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the blog post.
	 * @param title The title to set.
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the content of the blog post.
	 * @return The blog post content.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the blog post.
	 * @param content The content to set.
	 */
	public void setContent(final String content) {
		this.content = content;
	}

	/**
	 * Gets the creation date of the blog post.
	 * @return The creation date.
	 */
	public Date getCreatedAt() {
		return new Date(createdAt.getTime());
	}

	/**
	 * Sets the creation date of the blog post.
	 * @param createdAt The creation date to set.
	 */
	public void setCreatedAt(final Date createdAt) {
		this.createdAt = (createdAt != null) ? new Date(createdAt.getTime()) : null;
	}

	/**
	 * Gets the technology category of the blog post.
	 * @return The technology category.
	 */
	public TechnologyCategory getTechnology() {
		return technology;
	}

	/**
	 * Sets the technology category of the blog post.
	 * @param techCategory The technology category to set.
	 */
	public void setTechnology(final TechnologyCategory techCategory) {
		this.technology = techCategory;
	}

	/**
	 * Gets the author's ID associated with the blog post.
	 * @return The author's ID.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the author's ID associated with the blog post.
	 * @param user The author's ID to set.
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * Overriding compareTo method for sorting object by created date.
	 */
	@Override
	public int compareTo(final ApprovedBlogsOutDto other) {
		int createdAtComparison = other.createdAt.compareTo(this.createdAt);
		return createdAtComparison;
	}

	/**
	 * Computes and returns the hash code for the ApprovedBlogsOutDto object. This
	 * method combines the hash codes of various fields using Objects.hash.
	 * @return The computed hash code value.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(commentBy, content, createdAt, disLikedBy,
				id, likedBy, status, technology, title, user);
	}

	/**
	 * Compares this ApprovedBlogsOutDto object to another object to check for
	 * equality.
	 * @param obj The object to compare with.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ApprovedBlogsOutDto other = (ApprovedBlogsOutDto) obj;
		return Objects.equals(commentBy, other.commentBy)
				&& Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(disLikedBy, other.disLikedBy)
				&& Objects.equals(id, other.id)
				&& Objects.equals(likedBy, other.likedBy)
				&& status == other.status
				&& technology == other.technology
				&& Objects.equals(title, other.title)
				&& Objects.equals(user, other.user);
	}

	/**
	 * Generates a human-readable string representation of the ApprovedBlogsOutDto
	 * object. The string includes details about the object's fields, such as id,
	 * title, content, etc.
	 * @return A string representation of the object.
	 */
	@Override
	public String toString() {
		return "ApprovedBlogsOutDto [id=" + id
				+ ", title=" + title
				+ ", content=" + content
				+ ", createdAt=" + createdAt
				+ ", technology=" + technology
				+ ", user=" + user
				+ ", status=" + status
				+ ", commentBy=" + commentBy
				+ ", likedBy=" + likedBy
				+ ", disLikedBy=" + disLikedBy + "]";
	}

}
