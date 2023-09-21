package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.Comment;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.CommentPostMapper;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
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
	 * Instance of BlogUserRepo.
	 */
	@Autowired
	private BlogUserRepo blogUserRepo;
	/**
	 * This method create the comment on post.
	 * @param inDto
	 * @return outDto
	 */
	@Override
	public ApiResponse doCommentOnPost(CommentPostInDto inDto) {
		// TODO Auto-generated method stub
		System.err.println(" doCommentOnPost service implementation " + inDto);
		User fetchedUser = blogUserRepo.findById(inDto.getUserId()).orElseThrow(() ->
		new ResourceNotFoundException("User", "userId", inDto.getUserId()));
		fetchedUser.setPassword(null);
		Comment comment = CommentPostMapper.inDtoToEntity(inDto);
		comment.setUser(fetchedUser);
		Comment savedComment = this.commentPostRepo.save(comment);
		ApiResponse response = new ApiResponse();
		if (savedComment != null) {
			response.setMessage("Post commented ");
			response.setSuccess(true);
		} else {
			response.setMessage("Post Commentation failed");
			response.setSuccess(false);
		}
		return response;
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
