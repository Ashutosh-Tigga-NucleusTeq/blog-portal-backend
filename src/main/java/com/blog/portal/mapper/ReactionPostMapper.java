package com.blog.portal.mapper;

import com.blog.portal.entities.Reaction;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;

public class ReactionPostMapper {
	/**
	 * This method converts {@code LikeOrDislikeInDto} into {@code LikeOrDislike}.
	 * @param inDto
	 * @return obj
	 */
	public static Reaction inDtoToEntity(ReactionPostInDto inDto) {
		Reaction obj = new Reaction();
		obj.setPostId(inDto.getPostId());
		obj.setUserId(inDto.getUserId());
		obj.setType(inDto.getType());
		return obj;
	}

	/**
	 * This method converts {@code LikeOrDislike} into {@code LikeOrDislike}.
	 * @param obj
	 * @return outDto
	 */
	public static ReactionPostOutDto entityToOutDto(Reaction obj) {
		ReactionPostOutDto outDto = new ReactionPostOutDto();
		outDto.setId(obj.getId());
		outDto.setUserId(obj.getUserId());
		outDto.setPostId(obj.getPostId());
		outDto.setType(obj.getType());
		return outDto;
	}
}
