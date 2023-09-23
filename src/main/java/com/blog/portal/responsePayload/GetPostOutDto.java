package com.blog.portal.responsePayload;

import java.util.Objects;

import com.blog.portal.enumResource.TechnologyCategory;

public class GetPostOutDto {
	/**
	 *Id of the post.
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
	 * Technology Category of the post.
	 */
	private TechnologyCategory techCategory;

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
	 * Gets the title of the post.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the title of the post.
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
	 * Sets the content of the post.
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * Gets the technology category.
	 * @return techCategory
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}
	/**
	 * Sets the Technology CAtegory.
	 * @param techCategory
	 */
	public void setTechCategory(TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}    /**
   * Generates a human-readable string representation of the GetPostOutDto object.
   * The string includes details about the object's fields, such as id, title, content, and techCategory.
   *
   * @return A string representation of the object.
   */
  @Override
  public String toString() {
      return "GetPostOutDto [id=" + id + ", title=" + title + ", content=" + content + ", techCategory=" + techCategory + "]";
  }

  /**
   * Calculates the hash code for the GetPostOutDto object.
   * This method combines the hash codes of various properties, including content, id, techCategory, and title.
   *
   * @return The computed hash code value.
   */
  @Override
  public int hashCode() {
      return Objects.hash(content, id, techCategory, title);
  }

  /**
   * Compares this GetPostOutDto object to another object for equality.
   * It checks if the two objects are of the same class and then compares their properties,
   * including content, id, techCategory, and title.
   *
   * @param obj The object to compare with.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
          return false;
      }
      GetPostOutDto other = (GetPostOutDto) obj;
      return Objects.equals(content, other.content) && Objects.equals(id, other.id)
              && techCategory == other.techCategory && Objects.equals(title, other.title);
  }

}
