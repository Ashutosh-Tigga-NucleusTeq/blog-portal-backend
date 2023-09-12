package com.example.demo.dto;

import com.example.demo.enumResource.TechnologyCategory;

/**
 * This Dto fetches the data title and techcateory from Client.
 */
public class ShowPostInDto {
		/**
		 *Title of the Post.
		 */
		private String title;

		/**
		 *Technology category of the post.
		 */
		private TechnologyCategory techCategory;

		/**
		 * This Represents the override method toString of {@code ShowPostInDto}.
		 */
		@Override
		public String toString() {
			return "ShowPostInDto [title=" + title + ", techCategory=" + techCategory + "]";
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
		public ShowPostInDto(String title, TechnologyCategory techCategory) {
			super();
			this.title = title;
			this.techCategory = techCategory;
		}

		/**
		 * Default constructor.
		 */
		public ShowPostInDto() {
			super();
			// TODO Auto-generated constructor stub
		}


}