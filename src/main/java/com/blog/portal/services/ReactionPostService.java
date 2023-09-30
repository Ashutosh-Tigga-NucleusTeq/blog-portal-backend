package com.blog.portal.services;

import org.springframework.stereotype.Service;

import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;

@Service
public interface ReactionPostService {

	/**
	 *perform like or dislike on post.
	 * @param inDto
	 * @return LikeOrDislikeOutDto.
	 */
	ReactionPostOutDto doReactOnPost(ReactionPostInDto inDto);
}
