package com.blog.portal.mapper;

import com.blog.portal.entities.Comment;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;

public class CommentPostMapper {
	/**
	 * This method converts {@code CommentInDto} into {@code Comment}.
	 * @param inDto
	 * @return comment
	 */
	public static Comment inDtoToEntity(CommentPostInDto inDto) {
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
	public static CommentPostOutDto entityToOutDto(Comment comment) {
		CommentPostOutDto outDto = new CommentPostOutDto();
		outDto.setContent(comment.getContent());
		outDto.setPostId(comment.getPostId());
		outDto.setId(comment.getId());
		outDto.setUserId(comment.getUserId());
		outDto.setUser(comment.getUser());
		return outDto;
	}
}
