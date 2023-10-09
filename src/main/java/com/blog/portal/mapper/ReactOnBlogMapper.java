package com.blog.portal.mapper;

import com.blog.portal.entities.Reaction;
import com.blog.portal.requestPayload.ReactionBlogInDto;
import com.blog.portal.responsePayload.ReactionBlogOutDto;

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
	public static Reaction inDtoToEntity(final ReactionBlogInDto inDto) {
		Reaction obj = new Reaction();
		obj.setPostId(inDto.getPostId());
		obj.setUserId(inDto.getUserId());
		obj.setType(inDto.getType());
		return obj;
	}

	/**
	 * This method converts  Reaction into  ReactionBlogOutDto.
	 * @param obj
	 * @return outDto
	 */
	public static ReactionBlogOutDto entityToOutDto(final Reaction obj) {
		ReactionBlogOutDto outDto = new ReactionBlogOutDto();
		outDto.setId(obj.getId());
		outDto.setUserId(obj.getUserId());
		outDto.setPostId(obj.getPostId());
		outDto.setType(obj.getType());
		return outDto;
	}
}
