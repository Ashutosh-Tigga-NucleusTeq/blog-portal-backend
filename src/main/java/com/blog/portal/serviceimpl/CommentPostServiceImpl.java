package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.Comment;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.CommentPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;
import com.blog.portal.util.ResponseMessage;

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
	 * Instance of BlogPostRepo.
	 */
	@Autowired
	private BlogPostRepo blogPostRepo;
	/**
	 * This method create the comment on post.
	 * @param inDto
	 * @return outDto
	 */
	@Override
	public ApiResponse doCommentOnPost(CommentPostInDto inDto) {
		User fetchedUser = blogUserRepo.findById(inDto.getUserId()).orElseThrow(() ->
		new ResourceNotFoundException("User", "userId", inDto.getUserId()));
		Post fetchedPost = blogPostRepo.findById(inDto.getPostId()).orElseThrow(() ->
		new ResourceNotFoundException("Post", "postId", inDto.getPostId()));
		fetchedPost.getCommentBy().add(inDto.getUserId());
		blogPostRepo.save(fetchedPost);
		fetchedUser.setPassword(null);
		Comment comment = CommentPostMapper.inDtoToEntity(inDto);
		comment.setUser(fetchedUser);
		ApiResponse response = new ApiResponse();
		try {
		commentPostRepo.save(comment);
		response.setMessage(ResponseMessage.COMMENT_ON_BLOG_SUCCESS);
		response.setSuccess(true);
		} catch (RuntimeException ex) {
			response.setMessage(ResponseMessage.COMMENT_ON_BLOG_FAILED);
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
		List<Comment> listOfComment = commentPostRepo.findByPostId(postId);
		List<CommentPostOutDto> listOutDto = new ArrayList<CommentPostOutDto>();
		for (Comment comment : listOfComment) {
			listOutDto.add(CommentPostMapper.entityToOutDto(comment));
		}
		return listOutDto;
	}

}
