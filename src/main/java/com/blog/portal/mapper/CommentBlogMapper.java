package com.blog.portal.mapper;

import com.blog.portal.entities.Comment;
import com.blog.portal.requestPayload.CommentBlogInDto;
import com.blog.portal.responsePayload.CommentsOutDto;

/**
 * This class provides static methods for mapping
 * between Comment related DTOs and the Comment entity.
 * @author Ashutosh Tigga
 */
public class CommentBlogMapper {
	/**
	 * This method converts  CommentInDto into  Comment.
	 * @param inDto
	 * @return comment
	 */
	public static Comment inDtoToEntity(final CommentBlogInDto inDto) {
		Comment comment = new Comment();
		comment.setContent(inDto.getContent());
		comment.setPostId(inDto.getPostId());
		comment.setUserID(inDto.getUserId());
		return comment;
	}
	/**
	 * This method Converts  Comment into  CommentOutDto.
	 * @param comment
	 * @return outDto
	 */
	public static CommentsOutDto entityToOutDto(final Comment comment) {
		CommentsOutDto outDto = new CommentsOutDto();
		outDto.setContent(comment.getContent());
		outDto.setPostId(comment.getPostId());
		outDto.setId(comment.getId());
		outDto.setUserId(comment.getUserId());
		outDto.setUser(comment.getUser());
		return outDto;
	}
}
