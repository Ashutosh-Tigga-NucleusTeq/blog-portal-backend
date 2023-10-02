package com.blog.portal.requestPayload;

import com.blog.portal.enumResource.TechnologyCategory;

/**
 * This class Represents Request DTO and it's contains some field's like post's
 * title, technology category by using this one's can perform filtering
 * operation on the post which status is Pending.
 *
 * @author Ashutosh Tigga
 */
public class UnReviewedBlogsInDto {
	/**
	 * Title of the BLOG post.
	 */
	private String title;

	/**
	 * Technology category.
	 */
	private TechnologyCategory technologyCategory;

	/**
	 * Gets the Category of Technology.
	 *
	 * @return technologyCategory
	 */
	public TechnologyCategory getTechnologyCategory() {
		return technologyCategory;
	}

	/**
	 * Sets the category of the Technology.
	 *
	 * @param technologyCategory
	 */
	public void setTechnologyCategory(final TechnologyCategory technologyCategory) {
		this.technologyCategory = technologyCategory;
	}

	/**
	 * Gets the title.
	 *
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title
	 */
	public void setTitle(final String title) {
		this.title = title;
	}

}
