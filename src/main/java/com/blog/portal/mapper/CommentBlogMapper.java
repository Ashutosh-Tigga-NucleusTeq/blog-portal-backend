package com.blog.portal.mapper;

import com.blog.portal.entities.Comment;
import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responsePayload.CommentsOutDto;

/**
 * The {@code CommentBlogMapper} class provides static methods for mapping
 * between Comment related DTOs and the Comment entity.
 *
 * @author Ashutosh Tigga
 */
public class CommentBlogMapper {
	/**
	 * This method converts {@code CommentInDto} into {@code Comment}.
	 * @param inDto
	 * @return comment
	 */
	public static Comment inDtoToEntity(final CommentOnBlogInDto inDto) {
		Comment comment = new Comment();
		comment.setContent(inDto.getContent());
		comment.setPostId(inDto.getPostId());
		comment.setUserID(inDto.getUserId());
		return comment;
	}
	/**
	 * This method Converts {@code Comment} into {@code CommentOutDto}.
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
