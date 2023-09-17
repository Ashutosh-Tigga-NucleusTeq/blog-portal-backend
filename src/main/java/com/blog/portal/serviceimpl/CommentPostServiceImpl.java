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
	 * @param inDto
	 * @return outDto
	 */
	@Override
	public CommentPostOutDto doCommentOnPost(CommentPostInDto inDto) {
		// TODO Auto-generated method stub
		System.err.println(" doCommentOnPost service implementation " + inDto);
		Comment comment = CommentPostMapper.inDtoToEntity(inDto);
		Comment savedComment = this.commentPostRepo.save(comment);
		System.err.println(" doCommentOnPost service implementation " + savedComment);
		CommentPostOutDto outDto = CommentPostMapper.entityToOutDto(savedComment);
		return outDto;
	}

	/**
	 * This method to get all comments by postId.
	 * @param postId
	 * @return listOutDto
	 */
	@Override
	public List<CommentPostOutDto> getComments(String postId) {
		// TODO Auto-generated method stub
		System.err.println(" getcomment service implementation " + postId);
		List<Comment> listOfComment = this.commentPostRepo.findByPostId(postId);
		System.err.println(" doCommentOnPost service implementation " + listOfComment);
		List<CommentPostOutDto> listOutDto = new ArrayList<CommentPostOutDto>();
		for (Comment comment : listOfComment) {
			listOutDto.add(CommentPostMapper.entityToOutDto(comment));
		}
		System.out.println("response dto " + listOfComment);
		return listOutDto;
	}

}
