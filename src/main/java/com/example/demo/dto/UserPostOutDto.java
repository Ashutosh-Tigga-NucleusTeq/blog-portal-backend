package com.example.demo.dto;

import java.util.Date;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;

/**
 * This class represents a User Post Response DTO.
 * It contains information about a user's post, including title, status, technology,
 * creation date and time, and edit date and time.
 */
public class UserPostOutDto {
    /**
     * The title of the post.
     */
    private String title;

    /**
     * The status of the post.
     */
    private PostStatus status;

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
}
