package com.blog.portal.mapper;

import com.blog.portal.entities.Post;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;

public class FilterMyBlogPostMapper {
	/**
	 *This methods convert {@code UserPostInDto} into {@code Post}.
	 * @param inDto
	 * @return post
	 */
	public static Post inDtoToPost(FilterMyBlogPostInDto inDto) {
		Post post = new Post();
		post.setTitle(inDto.getTitle());
		post.setTechCategory(inDto.getTechCategory());
		post.setUserId(inDto.getUserId());
		post.setStatus(inDto.getStatus());
		return post;
	}

	/**
	 * This method converts {@code post} into {@code UserPostOutDto}.
	 * @param post
	 * @return outDto
	 */
	public static FilterMyBlogPostOutDto postToOutDto(Post post) {
		FilterMyBlogPostOutDto outDto = new FilterMyBlogPostOutDto();
		outDto.setTitle(post.getTitle());
		outDto.setTechnology(post.getTechCategory());
		outDto.setStatus(post.getStatus());
		outDto.setCreatedAt(post.getCreatedAt());
		outDto.setEditedAt(post.getEditedAt());
		outDto.setContent(post.getContent());
		outDto.setId(post.getId());
		outDto.setComments(post.getComments());
		return outDto;
	}
}
