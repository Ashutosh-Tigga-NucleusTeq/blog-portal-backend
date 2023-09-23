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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.messagePayloads.ApiResponse;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.services.BlogPostService;

/**
 * The {@code PostController} class handles HTTP requests related to blog posts.
 * It provides API endpoints for creating and managing blog posts.
 *
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping("/blog")
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
	@PostMapping("/postBlog")
	public ResponseEntity<ApiResponse> postBlog(@Valid @RequestBody PostBlogInDto postBlogInDto) {
		logger.info("Sending postInBlogDto to createPostBlog method in service: " + postBlogInDto);
		ApiResponse response = blogPostService.createPost(postBlogInDto);
		logger.info("Fetching response from createPostBlog: " + response);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	/**
	 * Api to get Post by it's id.
	 *
	 * @param postId
	 * @return ResponseEntity
	 */
	@GetMapping("/getBlogPost/{post_id}")
	public ResponseEntity<GetPostOutDto> getPost(@PathVariable("post_id") String postId) {
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
	@PutMapping("/updateBlogPost")
	public ResponseEntity<ApiResponse> editBlog(@RequestBody UpdatePostInDto inDto) {
		logger.info("Update blog controller called with request payload [" + inDto.getId() + "]");
		ApiResponse response = blogPostService.editBlog(inDto);
		logger.info(" Fetching response from editblog service [" + response + "]");
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

	/**
	 * Gets all post by status status , title , technology category.
	 *
	 * @param inDto
	 * @param pageNumber
	 * @param pageSize
	 * @return ResponseEntity
	 */
	@GetMapping("/filterDashboardBlogPosts")
	public ResponseEntity<List<FilterDashboardOutDto>> getAllPost(@RequestBody FilterDashboardPostInDto inDto,
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
		logger.info("api called filter_all_post controller with request payload [" + inDto + " ]");
		List<FilterDashboardOutDto> response = blogPostService.getAllPostFilter(inDto, pageNumber, pageSize);
		logger.info("Fetched reponse from getAllPost  service [ " + response + " ]");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Gets all post of particular user by status , title , technology category.
	 *
	 * @param inDto
	 * @param pageNumber
	 * @param pageSize
	 * @return ResponseEntity
	 */
	@GetMapping("/filterMyBlogPosts")
	public ResponseEntity<List<FilterMyBlogPostOutDto>> getUserPosts(@RequestBody FilterMyBlogPostInDto inDto,
			@RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
		logger.info("filter_user_post controller calling with request payload [" + inDto + " ]");
		List<FilterMyBlogPostOutDto> response = blogPostService.getAllPostOfUserFilter(inDto, pageNumber, pageSize);
		logger.info("Fetching response from getUserPost service [" + response + "]");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
