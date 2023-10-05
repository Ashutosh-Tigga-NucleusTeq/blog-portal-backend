package com.blog.portal.mapper;

import com.blog.portal.entities.Blog;
import com.blog.portal.responsePayload.BlogOutDto;

/**
 * The FetchBlogMapper class provides static methods for mapping
 * between FetchBlogMapper related DTOs and the Blog entity.
 * @author Ashutosh Tigga
 */
public class FetchBlogMapper {

	/**
	 * This method converts  Blog into  BlogOutDto.
	 * @param blog
	 * @return outDto
	 */
	public static BlogOutDto entityToOutDto(final Blog blog) {
		BlogOutDto outDto = new BlogOutDto();
		outDto.setId(blog.getId());
		outDto.setTitle(blog.getTitle());
		outDto.setContent(blog.getContent());
		outDto.setTechCategory(blog.getTechCategory());
		return outDto;
	}
}
