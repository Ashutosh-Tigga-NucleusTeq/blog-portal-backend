package com.blog.portal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.portal.entities.Comment;
import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.CommentBlogMapper;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.repository.CommentRepository;
import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentsOutDto;
import com.blog.portal.services.CommentService;
import com.blog.portal.util.BlogConst;
import com.blog.portal.util.ResponseMessage;
import com.blog.portal.util.UserConst;

/**
 * Implementation of the UserService interface responsible for Comment-related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class CommentServiceImpl implements CommentService {

	/**
	 * Instance of CommentRepo.
	 */
	@Autowired
	private CommentRepository commentRepository;

	/**
	 * Instance of UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Instance of BlogRepository.
	 */
	@Autowired
	private BlogRepository blogRepository;

	/**
	 * This method create the comment on post.
	 * @param inDto
	 * @return outDto
	 */
	@Override
	public ApiResponse doCommentOnBlog(final CommentOnBlogInDto inDto) {
		User fetchedUser = userRepository.findById(inDto.getUserId()).orElseThrow(() ->
			new ResourceNotFoundException(UserConst.CLASS_NAME, UserConst.FIELD_USER_ID, inDto.getUserId()));
		Blog fetchedPost = blogRepository.findById(inDto.getPostId()).orElseThrow(() ->
			new ResourceNotFoundException(BlogConst.CLASS_NAME, BlogConst.FIELD_POST_ID, inDto.getPostId()));
		fetchedPost.getCommentBy().add(inDto.getUserId());
		blogRepository.save(fetchedPost);
		fetchedUser.setPassword(null);
		Comment comment = CommentBlogMapper.inDtoToEntity(inDto);
		comment.setUser(fetchedUser);
		ApiResponse response = new ApiResponse();
		commentRepository.save(comment);
		response.setMessage(ResponseMessage.COMMENT_ON_BLOG_SUCCESS);
		response.setSuccess(true);
		return response;
	}

	/**
	 * This method to get all comments by postId.
	 * @param postId
	 * @return listOutDto
	 */
	@Override
	public List<CommentsOutDto> getComments(final String postId) {
		List<Comment> listOfComment = commentRepository.findByPostId(postId);
		List<CommentsOutDto> listOutDto = new ArrayList<CommentsOutDto>();
		for (Comment comment : listOfComment) {
			listOutDto.add(CommentBlogMapper.entityToOutDto(comment));
		}
		return listOutDto;
	}

}
