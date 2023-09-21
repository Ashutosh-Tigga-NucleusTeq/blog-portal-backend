package com.blog.portal.mapper;

import com.blog.portal.entities.Post;
import com.blog.portal.responsePayload.UnReviewedPostOutDto;

public class UnReviewedPostMapper {
	/**
	 * This method converts {@code Post} into UnReviewedPostOutDto.
	 * @param post
	 * @return outDto.
	 */
	public static UnReviewedPostOutDto entityToOutDto(Post post) {
		UnReviewedPostOutDto outDto = new UnReviewedPostOutDto();
		outDto.setUserName(post.getUser().getFirstName() + " " + post.getUser().getLastName());
		outDto.setId(post.getId());
		outDto.setTitle(post.getTitle());
		outDto.setContent(post.getContent());
		outDto.setCreatedAt(post.getCreatedAt());
		outDto.setTechCategory(post.getTechCategory());
		outDto.setUserDesignation(post.getUser().getDesignation());
		return outDto;
	}
}
