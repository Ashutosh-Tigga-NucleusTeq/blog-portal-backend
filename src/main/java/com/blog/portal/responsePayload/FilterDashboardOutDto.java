package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.blog.portal.entities.Comment;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class FilterDashboardOutDto implements Comparable<FilterDashboardOutDto> {

  /**
   * Id of the post.
   */
  private String id;

  /**
   * The minimum size of the title.
   */
  private static final int MINTITLE = 5;

  /**
   * The title of the blog post.
   */
  @Size(min = MINTITLE,
          message = "Post title size must be between 5-100 characters")
  private String title;

  /**
   * The minimum size of the blog content.
   */
  private static final int MINCONTENT = 25;

  /**
   * The content of the blog post.
   */
  @Size(min = MINCONTENT,
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
  private User user;

  /**
   * Status of the post.
   */
  private PostStatus status;

  /**
   * List of comment.
   */
  private List<Comment> comments;


	/**
   * Set of user who liked post.
   */
  private Set<String> likedBy = new HashSet<String>();

  /**
   * Sets of usre who disliked post.
   */
  private Set<String> disLikedBy = new HashSet<String>();

  /**
   * Gets the list of comments.
   * @return comments
   */
  public List<Comment> getComments() {
		return comments;
	}
  /**
   * Sets the list of comments.
   * @param comments
   */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
	public void setLikedBy(Set<String> likedBy) {
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
	public void setDisLikedBy(Set<String> disLikedBy) {
		this.disLikedBy = disLikedBy;
	}

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
  public FilterDashboardOutDto(String id, String title, String content, PostStatus status,
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
  public FilterDashboardOutDto() {
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
   * Overriding compareTo method for sorting object by created date.
   */
  @Override
  public int compareTo(FilterDashboardOutDto other) {
      int createdAtComparison = other.createdAt.compareTo(this.createdAt);
      return createdAtComparison;
  }
  /**
   * Computes and returns the hash code for the FilterDashboardOutDto object.
   * This method combines the hash codes of various fields using Objects.hash.
   *
   * @return The computed hash code value.
   */
  @Override
  public int hashCode() {
      return Objects.hash(comments, content, createdAt, disLikedBy, id, likedBy, status, techCategory, title, user);
  }

  /**
   * Compares this FilterDashboardOutDto object to another object to check for equality.
   *
   * @param obj The object to compare with.
   * @return true if the objects are equal, false otherwise.
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
      FilterDashboardOutDto other = (FilterDashboardOutDto) obj;
      return Objects.equals(comments, other.comments) && Objects.equals(content, other.content)
              && Objects.equals(createdAt, other.createdAt) && Objects.equals(disLikedBy, other.disLikedBy)
              && Objects.equals(id, other.id) && Objects.equals(likedBy, other.likedBy) && status == other.status
              && techCategory == other.techCategory && Objects.equals(title, other.title) && Objects.equals(user, other.user);
  }

  /**
   * Generates a human-readable string representation of the FilterDashboardOutDto object.
   * The string includes details about the object's fields, such as id, title, content, etc.
   *
   * @return A string representation of the object.
   */
  @Override
  public String toString() {
      return "FilterDashboardOutDto [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
              + ", techCategory=" + techCategory + ", user=" + user + ", status=" + status + ", comments=" + comments
              + ", likedBy=" + likedBy + ", disLikedBy=" + disLikedBy + "]";
  }

}
