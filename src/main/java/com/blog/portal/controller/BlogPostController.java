package com.blog.portal.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.ApproveOrRejectPostInDto;
import com.blog.portal.requestPayload.UnReviewedPostInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.responsePayload.UnReviewedPostOutDto;
import com.blog.portal.services.BlogPostService;
import com.blog.portal.util.RequestMappingConst;

/**
 * The {@code PostController} class handles HTTP requests related to blog posts.
 * It provides API endpoints for creating and managing blog posts.
 *
 * @author [Author Name]
 */
@RestController
@RequestMapping(RequestMappingConst.POST_URL)
public class BlogPostController {

	/**
	 * An instance of the {@link BlogPostService} class for handling blog post
	 * operations.
	 */
	@Autowired
	private BlogPostService blogPostService;

	/**
	 * An instance of the Logger class for logging.
	 */
	private Logger logger = LogManager.getLogger(BlogPostController.class);

	/**
	 * API endpoint to create a new blog post.
	 *
	 * @param postBlogInDto The input DTO containing blog post data.
	 * @return ResponseEntity containing the created blog post DTO.
	 */
	@PostMapping("/write")
	public ResponseEntity<ApiResponse> postBlog(@Valid @RequestBody PostBlogInDto postBlogInDto) {
		logger.info("Sending postInBlogDto to createPostBlog method in service: " + postBlogInDto);
		ApiResponse response = blogPostService.createPost(postBlogInDto);
		logger.info("Fetching response from createPostBlog: " + response);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
	}

	/**
	 * Api to get Post by it's id.
	 *
	 * @param postId
	 * @return ResponseEntity
	 */
	@GetMapping("/read/{post_id}")
	public ResponseEntity<GetPostOutDto> getPostById(@PathVariable("post_id") String postId) {
		logger.info("get post by it's id controller called with  request payload [" + postId + "]");
		GetPostOutDto response = blogPostService.getPost(postId);
		logger.info("Fetching response from getpost service [" + response + "]");
		return new ResponseEntity<GetPostOutDto>(response, HttpStatus.OK);
	}

	/**
	 * Api to update already existing blog post.
	 *
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PutMapping("/update")
	public ResponseEntity<ApiResponse> editBlog(@Valid @RequestBody UpdatePostInDto inDto) {
		logger.info("Update blog controller called with request payload [" + inDto.getId() + "]");
		ApiResponse response = blogPostService.editBlog(inDto);
		logger.info(" Fetching response from editblog service [" + response + "]");
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets all post by status status , title , technology category.
	 *
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PostMapping("/read-approved")
	public ResponseEntity<List<FilterDashboardOutDto>> getApprovedPosts(
			@Valid @RequestBody FilterDashboardPostInDto inDto) {
		logger.info("api called filter_all_post controller with request payload [" + inDto + " ]");
		List<FilterDashboardOutDto> response = blogPostService.getAllPostFilter(inDto);
		logger.info("Fetched reponse from getAllPost  service [ " + response + " ]");
		return new ResponseEntity<List<FilterDashboardOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * Gets all post of particular user by status , title , technology category.
	 *
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PostMapping("/user")
	public ResponseEntity<List<FilterMyBlogPostOutDto>> getUserPosts(@Valid @RequestBody FilterMyBlogPostInDto inDto) {
		logger.info("filter_user_post controller calling with request payload [" + inDto + " ]");
		List<FilterMyBlogPostOutDto> response = blogPostService.getAllPostOfUserFilter(inDto);
		logger.info("Fetching response from getUserPost service [" + response + "]");
		return new ResponseEntity<List<FilterMyBlogPostOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * API to Gets all the post which status is Not Approved yet by admin side.
	 *
	 * @param inDto Contains the status for filtering.
	 * @return response Collection of post which is not approved yet.
	 */
	@PostMapping("/unreviewed")
	public ResponseEntity<List<UnReviewedPostOutDto>> getUnreviewedPost(@Valid @RequestBody UnReviewedPostInDto inDto) {
		logger.info("Get Unreviewed Post controller invoking with request data [" + inDto + "]");
		List<UnReviewedPostOutDto> response = blogPostService.getUnreviewedPosts(inDto);
		logger.info("Fetching response from getUnreviewedPosts method of service [" + "]");
		return new ResponseEntity<List<UnReviewedPostOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * API to approve the blog posted by employee from admin. Based on postId it
	 * will search for blog and approved.
	 *
	 * @param inDto
	 * @return response message if approved then successfull Or else failed.
	 */
	@PutMapping("/action-unreview")
	public ResponseEntity<ApiResponse> responseUnreviewedPost(@Valid @RequestBody ApproveOrRejectPostInDto inDto) {
		logger.info(" Response on unreviewed post invoked with request payload [" + inDto + "]");
		ApiResponse response = blogPostService.responseUnreviewedPost(inDto);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
}
