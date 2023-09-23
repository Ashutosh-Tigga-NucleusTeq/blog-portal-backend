	package com.blog.portal.requestPayload;

	import java.util.Objects;

import com.blog.portal.enumResource.TechnologyCategory;

	/**
	 * This Dto fetches the data title and techcateory from Client.
	 */
	public class FilterDashboardPostInDto {
			/**
			 *Title of the Post.
			 */
			private String title;

			/**
			 *Technology category of the post.
			 */
			private TechnologyCategory techCategory;

			/**
			 * Override toString.
			 * @return toString
			 */
			@Override
			public String toString() {
				return "FilterDashboardPostInDto [title=" + title + ", techCategory=" + techCategory + "]";
			}
			/**
			 *Gets the Title of the post.
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
			public void setTechCategory(TechnologyCategory techCategory) {
				this.techCategory = techCategory;
			}
			/**
			 * Constructor sets title and techCategory.
			 * @param title
			 * @param techCategory
			 */
			public FilterDashboardPostInDto(String title, TechnologyCategory techCategory) {
				super();
				this.title = title;
				this.techCategory = techCategory;
			}

			/**
			 * Default constructor.
			 */
			public FilterDashboardPostInDto() {
				super();
			}

			/**
			 * Generates a hash code for this {@code FilterDashboardPostInDto} object based on its
			 * techCategory and title.
			 *
			 * @return The generated hash code.
			 */
			@Override
			public int hashCode() {
			    return Objects.hash(techCategory, title);
			}

			/**
			 * Compares this {@code FilterDashboardPostInDto} object with another object to determine
			 * if they are equal. Two {@code FilterDashboardPostInDto} objects are considered equal if
			 * their techCategory and title are the same.
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
			    FilterDashboardPostInDto other = (FilterDashboardPostInDto) obj;
			    return techCategory == other.techCategory && Objects.equals(title, other.title);
			}


	}