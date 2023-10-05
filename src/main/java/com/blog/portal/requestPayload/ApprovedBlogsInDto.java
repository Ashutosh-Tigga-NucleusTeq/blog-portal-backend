package com.blog.portal.requestPayload;

import java.util.Objects;
import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class Represents Request DTO contains the data title and TECHCATEORY
 * from Client. based on this they can perform filtering on approved Blog.
 * @author [ Ashutosh Tigga]
 */
public class ApprovedBlogsInDto {
	/**
	 * Title of the Blog. No need of validation bcz we can fetch BLOG based on empty
	 * value too.
	 */
	private String title;

	/**
	 * Technology category of the post.
	 */
	private TechnologyCategory techCategory;

	/**
	 * Override toString.
	 * @return toString
	 */
	@Override
	public String toString() {
		return "ApprovedBlogsInDto [title=" + title
				+ ", techCategory=" + techCategory + "]";
	}

	/**
	 * Gets the Title of the post.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the post.
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

	/**
	 * Gets the Technology Category of the post.
	 * @return techCategory
	 */
	public TechnologyCategory getTechCategory() {
		return techCategory;
	}

	/**
	 * Sets the Technology Category of the post.
	 * @param techCategory
	 */
	public void setTechCategory(final TechnologyCategory techCategory) {
		this.techCategory = techCategory;
	}

	/**
	 * Constructor sets title and techCategory.
	 * @param title
	 * @param techCategory
	 */
	public ApprovedBlogsInDto(final String title, final TechnologyCategory techCategory) {
		super();
		this.title = title;
		this.techCategory = techCategory;
	}

	/**
	 * Default constructor.
	 */
	public ApprovedBlogsInDto() {
		super();
	}

	/**
	 * Generates a hash code for this ApprovedBlogsInDto object based on its
	 * techCategory and title.
	 * @return The generated hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(techCategory, title);
	}

	/**
	 * Compares this ApprovedBlogsInDto object with another object to
	 * determine if they are equal. Two ApprovedBlogsInDto objects are
	 * considered equal if their techCategory and title are the same.
	 * @param obj The object to compare with.
	 * @return {@code true} if the objects are equal; {@code false} otherwise.
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		ApprovedBlogsInDto other = (ApprovedBlogsInDto) obj;
		return techCategory == other.techCategory
				&& Objects.equals(title, other.title);
	}

}