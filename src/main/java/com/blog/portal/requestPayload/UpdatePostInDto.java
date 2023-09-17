package com.blog.portal.requestPayload;

import java.util.Objects;

public class UpdatePostInDto {
	/**
	 * Id of the post.
	 */
	private String id;
	/**
	 * Title of the post.
	 */
	private String title;
	/**
	 * Content of the post.
	 */
	private String content;
	/**
	 * Gets the id of the String.
	 * @return id
	 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the id of the Post.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Gets the title of the post.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the tile of the post.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Gets the content of the post.
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * Sets the Content of the post.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Parameterized Constructor.
	 * @param id
	 * @param title
	 * @param content
	 */
	public UpdatePostInDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	/**
	 * Default contructor.
	 */
	public UpdatePostInDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Generates a string representation of the UpdatePostInDto object.
	 *
	 * @return A string containing information about the post ID, title, and content.
	 */
	@Override
	public String toString() {
	    return "UpdatePostInDto [id=" + id + ", title=" + title + ", content=" + content + "]";
	}

	/**
	 * Calculates the hash code for the UpdatePostInDto object based on its properties.
	 *
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
	    return Objects.hash(content, id, title);
	}

	/**
	 * Compares this UpdatePostInDto object with another object to determine if they are equal.
	 *
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    UpdatePostInDto other = (UpdatePostInDto) obj;
	    return Objects.equals(content, other.content) && Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}


}
