package com.blog.portal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentPostOutDto;

@Service
public interface CommentPostService {

	/**
	 * THis method to do comment on post.
	 * @param inDto
	 * @return CommentOutDto
	 */
	ApiResponse doCommentOnPost(CommentPostInDto inDto);

	/**
	 * This method gets all comment of particular post.
	 * @param postId
	 * @return List<CommentOutDto>.
	 */
	List<CommentPostOutDto> getComments(String postId);

}
