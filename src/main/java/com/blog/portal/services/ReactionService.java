package com.blog.portal.services;

import org.springframework.stereotype.Service;

import com.blog.portal.requestPayload.ReactionInDto;
import com.blog.portal.responsePayload.ReactionOutDto;

@Service
public interface ReactionService {

	/**
	 *perform like or dislike on post.
	 * @param inDto
	 * @return LikeOrDislikeOutDto.
	 */
	ReactionOutDto doReactOnPost(ReactionInDto inDto);
}
