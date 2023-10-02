package com.blog.portal.mapper;

import com.blog.portal.entities.Blog;
import com.blog.portal.responsePayload.UnReviewedBlogsOutDto;

/**
 * The {@code UnReviewedBlogMapper} class provides static methods for mapping
 * between DTOs and the Blog entity.
 *
 * @author Ashutosh Tigga
 */
public class UnReviewedBlogMapper {
	/**
	 * This method converts {@code Blog} into UnReviewedBlogsOutDto.
	 * @param blog
	 * @return outDto.
	 */
	public static UnReviewedBlogsOutDto entityToOutDto(final Blog blog) {
		UnReviewedBlogsOutDto outDto = new UnReviewedBlogsOutDto();
		outDto.setUserName(blog.getUser().getFirstName() + " " + blog.getUser().getLastName());
		outDto.setId(blog.getId());
		outDto.setTitle(blog.getTitle());
		outDto.setContent(blog.getContent());
		outDto.setCreatedAt(blog.getCreatedAt());
		outDto.setTechCategory(blog.getTechCategory());
		outDto.setUserDesignation(blog.getUser().getDesignation());
		return outDto;
	}
}
