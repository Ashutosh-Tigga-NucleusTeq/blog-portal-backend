package com.blog.portal.mapper;

import com.blog.portal.entities.LikeOrDislike;
import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;

public class LikeOrDislikePostMapper {
	/**
	 * This method converts {@code LikeOrDislikeInDto} into {@code LikeOrDislike}.
	 * @param inDto
	 * @return obj
	 */
	public static LikeOrDislike inDtoToEntity(LikeOrDislikePostInDto inDto) {
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
	public static LikeOrDislikePostOutDto entityToOutDto(LikeOrDislike obj) {
		LikeOrDislikePostOutDto outDto = new LikeOrDislikePostOutDto();
		outDto.setId(obj.getId());
		outDto.setUserId(obj.getUserId());
		outDto.setPostId(obj.getPostId());
		outDto.setType(obj.getType());
		return outDto;
	}
}
