package com.blog.portal.services;

import org.springframework.stereotype.Service;
import com.blog.portal.requestPayload.ReactionBlogInDto;
import com.blog.portal.responsePayload.ReactionBlogOutDto;

/**
 * Interface ReactionService that represent the rule of Reaction that would follow by it's child.
 * @author {Ashutosh Tigga]
 */
@Service
public interface ReactionService {

	/**
	 * perform like or dislike on post.
	 * @param inDto
	 * @return LikeOrDislikeOutDto.
	 */
	ReactionBlogOutDto reactOnBlog(ReactionBlogInDto inDto);
}
