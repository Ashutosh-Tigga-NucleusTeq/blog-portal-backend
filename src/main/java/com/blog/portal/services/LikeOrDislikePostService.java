package com.blog.portal.services;

import org.springframework.stereotype.Service;

import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;

@Service
public interface LikeOrDislikePostService {

	/**
	 *perform like or dislike on post.
	 * @param inDto
	 * @return LikeOrDislikeOutDto.
	 */
	LikeOrDislikePostOutDto doReactOnPost(LikeOrDislikePostInDto inDto);
}
