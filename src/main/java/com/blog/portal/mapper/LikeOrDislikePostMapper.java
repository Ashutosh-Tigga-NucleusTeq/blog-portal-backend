package com.blog.portal.mapper;

import com.blog.portal.entities.LikeOrDislike;
import com.blog.portal.requestPayload.ReactionInDto;
import com.blog.portal.responsePayload.ReactionOutDto;

public class LikeOrDislikePostMapper {
	/**
	 * This method converts {@code LikeOrDislikeInDto} into {@code LikeOrDislike}.
	 * @param inDto
	 * @return obj
	 */
	public static LikeOrDislike inDtoToEntity(ReactionInDto inDto) {
		LikeOrDislike obj = new LikeOrDislike();
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
	public static ReactionOutDto entityToOutDto(LikeOrDislike obj) {
		ReactionOutDto outDto = new ReactionOutDto();
		outDto.setId(obj.getId());
		outDto.setUserId(obj.getUserId());
		outDto.setPostId(obj.getPostId());
		outDto.setType(obj.getType());
		return outDto;
	}
}
