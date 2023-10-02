package com.blog.portal.mapper;

import com.blog.portal.entities.Blog;
import com.blog.portal.requestPayload.UserBlogsInDto;
import com.blog.portal.responsePayload.UserBlogsOutDto;

/**
 * The {@code UserBlogMapper} class provides static methods for mapping
 * between DTOs and the Blog entity.
 *
 * @author Ashutosh Tigga
 */
public class UserBlogMapper {
	/**
	 *This methods convert {@code UserPostInDto} into {@code Blog}.
	 * @param inDto
	 * @return post
	 */
	public static Blog inDtoToPost(final UserBlogsInDto inDto) {
		Blog blog = new Blog();
		blog.setTitle(inDto.getTitle());
		blog.setTechCategory(inDto.getTechCategory());
		blog.setUserId(inDto.getUserId());
		blog.setStatus(inDto.getStatus());
		return blog;
	}

	/**
	 * This method converts {@code post} into {@code UserPostOutDto}.
	 * @param blog
	 * @return outDto
	 */
	public static UserBlogsOutDto postToOutDto(final Blog blog) {
		UserBlogsOutDto outDto = new UserBlogsOutDto();
		outDto.setTitle(blog.getTitle());
		outDto.setTechnology(blog.getTechCategory());
		outDto.setStatus(blog.getStatus());
		outDto.setCreatedAt(blog.getCreatedAt());
		outDto.setEditedAt(blog.getEditedAt());
		outDto.setContent(blog.getContent());
		outDto.setId(blog.getId());
		outDto.setCommentBy(blog.getCommentBy());
		outDto.setLikedBy(blog.getLikedBy());
		outDto.setDisLikedBy(blog.getDisLikedBy());
		outDto.setReportedBy(blog.getReportedBy());
		return outDto;
	}
}
