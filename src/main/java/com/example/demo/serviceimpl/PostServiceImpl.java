package com.example.demo.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.UserController;
import com.example.demo.dto.PostInDto;
import com.example.demo.dto.ShowPostOutDto;
import com.example.demo.dto.UserPostInDto;
import com.example.demo.dto.UserPostOutDto;
import com.example.demo.enumResource.PostStatus;
import com.example.demo.dto.ShowPostInDto;
import com.example.demo.mapper.PostMapper;
import com.example.demo.mapper.ShowPostMapper;
import com.example.demo.mapper.UserPostMapper;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.repository.PostRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.services.PostService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

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
	 * Instance of UserRepo for performing operation on User.
	 */
	@Autowired
	private UserRepo userRepo;

	/**
	 * An instance of the Logger class for logging.
	 */
	private Logger logger = LogManager.getLogger(UserController.class);

	/**
	 * Method that deal with creation of post API in database.
	 */
	@Override
	public ApiResponse createPost(@Valid PostInDto postInDto) {

		ApiResponse reponse = null;
		User user = this.userRepo.findById(postInDto.getUserId()).orElseThrow();
		user.setPassword(null);
		Post post = PostMapper.inDtoToPost(postInDto);
		post.setUser(user);
		post.setUserId(user.getId());
		logger.info(" post service implement " + postInDto);
		try {
			this.postRepo.save(post);
			reponse = new ApiResponse(String.format("Blog post created with id: %s," + " title: %s, content: %s ",
					post.getId(), post.getTitle(), post.getContent()), true);
		} catch (RuntimeException ex) {
			throw new RuntimeException();
		} catch (Exception e) {
			reponse = new ApiResponse("Blog post not created ", false);
		}
		return reponse;
	}

	/**
	 * Get All Posts by filtering by status = approved , title and techcategory.
	 * @param inDto
	 * @return List<ShowPostDto>
	 */
	public List<ShowPostOutDto> getAllPost(@Valid ShowPostInDto inDto) throws IllegalArgumentException {
		Post post = ShowPostMapper.inDtoToPost(inDto);
		post.setStatus(PostStatus.Approved);
		logger.info(" get all post service implement ");
		List<Post> fetchedPost = new ArrayList<Post>();
		List<ShowPostOutDto> outDtoList = new ArrayList<ShowPostOutDto>();

		if (inDto.getTitle() == null && inDto.getTechCategory() == null) {
			fetchedPost = this.postRepo.findByStatus(post.getStatus());
			logger.info(" get by null " + fetchedPost);
		} else if (inDto.getTechCategory() != null && inDto.getTitle() == null) {
			logger.info("get by category");
			fetchedPost = this.postRepo.findByTechCategoryAndStatus(post.getTechCategory(), post.getStatus());
		} else if (inDto.getTitle() != "" && inDto.getTechCategory() == null) {
			List<Post> listOfPost = this.postRepo.findByTitleContainingIgnoreCaseAndStatus(post.getTitle(),
					post.getStatus());
			logger.info(" Get by Title :[ " + listOfPost + " ]");
			fetchedPost = this.postRepo.findByTitleContainingIgnoreCaseAndStatus(post.getTitle(), post.getStatus());
		} else if ((inDto.getTitle() != "") && (inDto.getTechCategory() != null)) {
			logger.info("get by category and title");
			fetchedPost = this.postRepo.findByTitleContainingIgnoreCaseAndStatusAndTechCategory(post.getTitle(),
					post.getStatus(), post.getTechCategory());
		}
		for (Post p : fetchedPost) {
			ShowPostOutDto outDto = ShowPostMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}
		return outDtoList;
	}
	/**
	 * This Serviceimpl method gets user post.
	 * @param inDto
	 * @return List<UserPostOutDto>
	 */
	@Override
	public List<UserPostOutDto> getUserPosts(UserPostInDto inDto) {
		logger.info("get User posts method called in service implement method with data "
				+ "[" + inDto + "]");
		Post post = UserPostMapper.inDtoToPost(inDto);
		List<Post> fetchedPost = new ArrayList<Post>();
		if (inDto.getTitle() == null
				&& inDto.getTechCategory() == null
				&& inDto.getStatus() == null) {
			fetchedPost = this.postRepo.findByUserId(post.getUserId());
			logger.info(" fetching All post without filtering with response ["
			+ fetchedPost + "");
		} else if (
				inDto.getTitle() != null
				&& inDto.getStatus() == null
				&& inDto.getTechCategory() == null) {
			fetchedPost = this.postRepo.findByTitleContainingIgnoreCaseAndUserId(post.getTitle(), post.getUserId());
			logger.info(" Fetching post by Title and user id with response data [" + fetchedPost + "]");
		} else if (inDto.getTechCategory() != null
				&& inDto.getStatus() == null
				&& inDto.getTitle() == null) {
			fetchedPost = this.postRepo.findByTechCategoryAndUserId(post.getTechCategory(), post.getUserId());
			logger.info(" Fetching post By Techcategory and user id with response data [" + fetchedPost + "]");
		} else if (inDto.getStatus() != null
				&& inDto.getTechCategory() == null
				&& inDto.getTitle() == null
				) {
			fetchedPost = this.postRepo.findByStatusAndUserId(post.getStatus(), post.getUserId());
			logger.info(" Fetching post By Status and userid with response data [" + fetchedPost + "]");
		} else if (inDto.getStatus() != null
				&& inDto.getTechCategory() != null
				&& inDto.getTitle() == null
				) {
			fetchedPost = this.postRepo.findByStatusAndTechCategoryAndUserId(post.getStatus(), post.getTechCategory(),
					post.getUserId());
			logger.info(" Fetching post by Status and techCategory and userid with response data ["
					+ fetchedPost + "]");
		} else if (inDto.getStatus() == null
				&& inDto.getTechCategory() != null
				&& inDto.getTitle() != null) {
			fetchedPost = this.postRepo.findByTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					post.getTechCategory(),
					post.getTitle(),
					post.getUserId());
			logger.info(" Fetching post By techcategory , title and user id with response data ["
					+ fetchedPost + "]");
		}	else if (inDto.getStatus() != null
				&& inDto.getTechCategory() == null
				&& inDto.getTitle() != null) {
			fetchedPost = this.postRepo.findByStatusAndTitleContainingIgnoreCaseAndUserId(
					post.getStatus(),
					post.getTitle(),
					post.getUserId());
			logger.info(" Fetching post By Status , Title and userid with response data [" + fetchedPost + "]");
		} else if (inDto.getStatus() != null
				&& inDto.getTechCategory() != null
				&& inDto.getTitle() != null) {
			fetchedPost = this.postRepo.findByStatusAndTechCategoryAndTitleContainingIgnoreCaseAndUserId(
					post.getStatus(),
					post.getTechCategory(),
					post.getTitle(),
					post.getUserId());
			logger.info(" Fetching post by Status, title, techCategory and userid with response data ["
					+ fetchedPost + "]");
		}
		List<UserPostOutDto> outDtoList = new ArrayList<UserPostOutDto>();
		for (Post p : fetchedPost) {
			UserPostOutDto outDto = UserPostMapper.postToOutDto(p);
			outDtoList.add(outDto);
		}

		return outDtoList;
	}


}
