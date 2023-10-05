package com.blog.portal.mapper;

import com.blog.portal.entities.Reaction;
import com.blog.portal.requestPayload.ReactOnBlogInDto;
import com.blog.portal.responsePayload.ReactionOnBlogOutDto;

/**
 * The ReactOnBlogMapper class provides static methods for mapping
 * between ReactOnBlogMapper related DTOs and the Reaction entity.
 * @author Ashutosh Tigga
 */
public class ReactOnBlogMapper {
	/**
	 * This method converts  ReactionOnBlogInDto into  Reaction.
	 * @param inDto
	 * @return obj
	 */
	public static Reaction inDtoToEntity(final ReactOnBlogInDto inDto) {
		Reaction obj = new Reaction();
		obj.setPostId(inDto.getPostId());
		obj.setUserId(inDto.getUserId());
		obj.setType(inDto.getType());
		return obj;
	}

	/**
	 * This method converts  Reaction into  ReactionOnBlogOutDto.
	 * @param obj
	 * @return outDto
	 */
	public static ReactionOnBlogOutDto entityToOutDto(final Reaction obj) {
		ReactionOnBlogOutDto outDto = new ReactionOnBlogOutDto();
		outDto.setId(obj.getId());
		outDto.setUserId(obj.getUserId());
		outDto.setPostId(obj.getPostId());
		outDto.setType(obj.getType());
		return outDto;
	}
}
