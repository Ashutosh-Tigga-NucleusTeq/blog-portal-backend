package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.Comment;
import com.blog.portal.mapper.CommentPostMapper;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;

@Service
public class CommentPostServiceImpl implements CommentPostService {

	/**
	 * Instance of CommentRepo.
	 */
	@Autowired
	private CommentPostRepo commentPostRepo;

	/**
	 * This method create the comment on post.
	 *
	 * @param inDto
	 * @return outDto
	 */
	@Override
	public CommentPostOutDto doCommentOnPost(CommentPostInDto inDto) {
		Comment comment = CommentPostMapper.inDtoToEntity(inDto);
		Comment savedComment = commentPostRepo.save(comment);
		CommentPostOutDto outDto = CommentPostMapper.entityToOutDto(savedComment);
		return outDto;
	}

	/**
	 * This method to get all comments by postId.
	 *
	 * @param postId
	 * @return listOutDto
	 */
	@Override
	public List<CommentPostOutDto> getComments(String postId) {
		List<Comment> listOfComment = commentPostRepo.findByPostId(postId);
		List<CommentPostOutDto> listOutDto = new ArrayList<CommentPostOutDto>();
		for (Comment comment : listOfComment) {
			listOutDto.add(CommentPostMapper.entityToOutDto(comment));
		}
		return listOutDto;
	}

}
