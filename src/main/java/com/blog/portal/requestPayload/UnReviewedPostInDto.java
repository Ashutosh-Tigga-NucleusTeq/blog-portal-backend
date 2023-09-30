package com.blog.portal.requestPayload;

import com.blog.portal.enumResource.TechnologyCategory;

public class UnReviewedPostInDto {
	/**
	 * This field for searching by title of post.
	 */
	private String title;

	/**
	 * Technology category.
	 */
	private TechnologyCategory technologyCategory;
	/**
	 * Gets the Category of Technology.
	 * @return technologyCategory
	 */
	public TechnologyCategory getTechnologyCategory() {
		return technologyCategory;
	}
	/**
	 * Sets the category of the Technology.
	 * @param technologyCategory
	 */
	public void setTechnologyCategory(TechnologyCategory technologyCategory) {
		this.technologyCategory = technologyCategory;
	}
	/**
	 * Gets the title.
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Sets the title.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
