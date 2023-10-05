package com.blog.portal.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.blog.portal.requestPayload.CommentBlogInDto;
import com.blog.portal.responsePayload.CommentsOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;

/**
 * Interface CommentService that represent the rule of Comment that would follow by it's child.
 * @author {Ashutosh Tigga]
 */
@Service
public interface CommentService {

	/**
	 * This method to do comment on post.
	 * @param inDto
	 * @return CommentOutDto
	 */
	ResponseOutDTO postComment(CommentBlogInDto inDto);

	/**
	 * This method gets all comment of particular post.
	 * @param postId
	 * @return List<CommentOutDto>.
	 */
	List<CommentsOutDto> getComments(String postId);

}
