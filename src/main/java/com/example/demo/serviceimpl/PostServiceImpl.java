package com.example.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.PostInDto;
/*import com.example.demo.dto.PostOutDto;*/
/*import com.example.demo.exception.ResourceNotFoundException;*/
import com.example.demo.mapper.PostMapper;
import com.example.demo.model.Post;
import com.example.demo.payloads.ApiResponse;
/*import com.example.demo.model.User;*/
import com.example.demo.repository.PostRepo;
/*import com.example.demo.repository.UserRepo;*/
import com.example.demo.services.PostService;

import jakarta.validation.Valid;

/**
 * Implementation of the UserService interface responsible for post-related
 * operations.
 *
 * @author Ashutosh Tigga.
 */
@Service
public class PostServiceImpl implements PostService {

	/**
	 * Instance of PostRepo for performing operations on Post related data in
	 * database.
	 */
	@Autowired
	private PostRepo postRepo;
	/**
	 * Method that deal with creation of post API in database.
	 */
	@Override
	public ApiResponse createPost(@Valid PostInDto postInDto) {

		ApiResponse reponse = null;
		/*
		 * User user =
		 * this.userRepo.findById(postInDto.getAuthorId().toString()).orElseThrow(() ->
		 * new ResourceNotFoundException("User", "id",
		 * postInDto.getAuthorId().toString()));
		 */
		Post post = PostMapper.inDtoToPost(postInDto);
		Post savedPost = null;
		try {
			savedPost = this.postRepo.save(post);
			reponse = new  ApiResponse(String.format("Blog post created with id: %s,"
					+ " title: %s,content: %s ",
					post.getId(),
					post.getTitle(),
					post.getContent()), true);
		} catch (Exception e) {
			reponse = new ApiResponse("Blog post not created ", false);
		}
		/* PostOutDto responseDto = PostMapper.postToOutDto(savedPost); */
		return reponse;
	}

}
