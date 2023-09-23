package com.blog.portal.mapper;

import com.blog.portal.entities.Post;
import com.blog.portal.responsePayload.GetPostOutDto;

public class GetPostMapper {

	/**
	 * This method converts {@coe Post} into {@code GetPostOutDto}.
	 * @param post
	 * @return outDto
	 */
	public static GetPostOutDto entityToOutDto(Post post) {
		GetPostOutDto outDto = new GetPostOutDto();
		outDto.setId(post.getId());
		outDto.setTitle(post.getTitle());
		outDto.setContent(post.getContent());
		outDto.setTechCategory(post.getTechCategory());
		System.out.println(" Mapper responsing " + outDto.getContent());
		System.out.println(" Mapper responsing " + outDto.getTitle());
		System.out.println(" Mapper responsing " + outDto.getTechCategory());
		return outDto;
	}
}
