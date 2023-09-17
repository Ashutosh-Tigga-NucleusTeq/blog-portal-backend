package com.blog.portal.responsePayload;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.blog.portal.entities.Comment;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class represents a User Post Response DTO.
 * It contains information about a user's post, including title, status, technology,
 * creation date and time, and edit date and time.
 */
public class FilterMyBlogPostOutDto implements Comparable<FilterMyBlogPostOutDto> {
		/**
		 * The id of the post.
		 */
		private String id;

		/**
     * The title of the post.
     */
    private String title;

    /**
     * The status of the post.
     */
    private PostStatus status;

    /**
     * The description of the post.
     */
    private String content;

    /**
     * The technology category of the post.
     */
    private TechnologyCategory technology;

    /**
     * The date and time when the post was created.
     */
    private Date createdAt;

    /**
     * The date and time when the post was last edited.
     */
    private Date editedAt;
    /**
     * Set of user who liked post.
     */
    private Set<String> likedBy = new HashSet<String>();

    /**
     * Sets of usre who disliked post.
     */
    private Set<String> disLikedBy = new HashSet<String>();
    /**
     * List of comment.
     */
    private List<Comment> comments;

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
		 * Gets the id of the post.
		 * @return id
		 */
    public String getId() {
			return id;
		}

    /**
     * Sets the id of the post.
     * @param id
     */
		public void setId(String id) {
			this.id = id;
		}

    /**
     * Gets Description of post.
     * @return content
     */
    public String getContent() {
			return content;
		}

    /**
     * Sets the content of the post.
     * @param content
     */
		public void setContent(String content) {
			this.content = content;
		}

		/**
     * Get the title of the post.
     *
     * @return The title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the post.
     *
     * @param title The title of the post.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the status of the post.
     *
     * @return The status of the post.
     */
    public PostStatus getStatus() {
        return status;
    }

    /**
     * Set the status of the post.
     *
     * @param status The status of the post.
     */
    public void setStatus(PostStatus status) {
        this.status = status;
    }

    /**
     * Get the technology category of the post.
     *
     * @return The technology category of the post.
     */
    public TechnologyCategory getTechnology() {
        return technology;
    }

    /**
     * Set the technology category of the post.
     *
     * @param technology The technology category of the post.
     */
    public void setTechnology(TechnologyCategory technology) {
        this.technology = technology;
    }

    /**
     * Get the date and time when the post was created.
     *
     * @return The date and time when the post was created.
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the date and time when the post was created.
     *
     * @param createdAt The date and time when the post was created.
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Get the date and time when the post was last edited.
     *
     * @return The date and time when the post was last edited.
     */
    public Date getEditedAt() {
        return editedAt;
    }

    /**
     * Set the date and time when the post was last edited.
     *
     * @param editedAt The date and time when the post was last edited.
     */
    public void setEditedAt(Date editedAt) {
        this.editedAt = editedAt;
    }
    /**
     * Overriding compareTo method.
     */
    @Override
    public int compareTo(FilterMyBlogPostOutDto other) {
        // First, compare by edited date (descending order)
        int editedComparison = other.getEditedAt().compareTo(this.editedAt);
        if (editedComparison != 0) {
            return editedComparison;
        }
        // If edited dates are the same, compare by created date (descending order)
        return other.getCreatedAt().compareTo(this.createdAt);
    }
    /**
     * Overrides the hashCode method to calculate the hash code based on specific fields.
     * This method combines the hash codes of various properties, including comments, content,
     * createdAt, disLikedBy, editedAt, id, likedBy, status, technology, and title.
     *
     * @return The computed hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comments, content, createdAt, disLikedBy, editedAt, id, likedBy, status, technology, title);
    }

    /**
     * Overrides the equals method to compare this object with another object for equality.
     * It checks if the two objects are of the same class and then compares their properties,
     * including comments, content, createdAt, disLikedBy, editedAt, id, likedBy, status, technology, and title.
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
        FilterMyBlogPostOutDto other = (FilterMyBlogPostOutDto) obj;
        return Objects.equals(comments, other.comments) && Objects.equals(content, other.content)
                && Objects.equals(createdAt, other.createdAt) && Objects.equals(disLikedBy, other.disLikedBy)
                && Objects.equals(editedAt, other.editedAt) && Objects.equals(id, other.id)
                && Objects.equals(likedBy, other.likedBy) && status == other.status && technology == other.technology
                && Objects.equals(title, other.title);
    }

    /**
     * Generates a human-readable string representation of the FilterMyBlogPostOutDto object.
     * The string includes details about the object's fields, such as id, title, status, content, technology,
     * createdAt, editedAt, likedBy, disLikedBy, and comments.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "FilterMyBlogPostOutDto [id=" + id + ", title=" + title + ", status=" + status + ", content=" + content
                + ", technology=" + technology + ", createdAt=" + createdAt + ", editedAt=" + editedAt + ", likedBy="
                + likedBy + ", disLikedBy=" + disLikedBy + ", comments=" + comments + "]";
    }

}
