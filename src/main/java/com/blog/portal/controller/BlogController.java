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
import com.blog.portal.requestPayload.ApprovedBlogsInDto;
import com.blog.portal.requestPayload.UserBlogsInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.ActOnUnReviewedBlogInDto;
import com.blog.portal.requestPayload.UnReviewedBlogsInDto;
import com.blog.portal.requestPayload.UpdateBlogInDto;
import com.blog.portal.responsePayload.ApprovedBlogsOutDto;
import com.blog.portal.responsePayload.UserBlogsOutDto;
import com.blog.portal.responsePayload.BlogOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.responsePayload.UnReviewedBlogsOutDto;
import com.blog.portal.services.BlogService;
import com.blog.portal.util.RestPathConstants;

/**
 * This class handles HTTP requests related to BLOG posts. It provides API
 * end-points for creating and managing BLOG posts.
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping(RestPathConstants.BLOG_URL)
public class BlogController {

	/**
	 * An instance of the BlogService class for handling blog post operations.
	 */
	@Autowired
	private BlogService blogService;

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(BlogController.class);

	/**
	 * API end-point to create a new BLOG post.
	 * @param postBlogInDto The input DTO containing BLOG post data.
	 * @return ResponseEntity containing the created BLOG post DTO.
	 */
	@PostMapping("/")
	public ResponseEntity<ResponseOutDTO> postBlog(@Valid @RequestBody final PostBlogInDto postBlogInDto) {
		LOGGER.info("Sending postInBlogDto to createPostBlog method in service: " + postBlogInDto);
		ResponseOutDTO response = blogService.createPost(postBlogInDto);
		LOGGER.info("Fetching response from createPostBlog: " + response);
		return new ResponseEntity<ResponseOutDTO>(response, HttpStatus.CREATED);
	}

	/**
	 * API end-point to get BLOG by it's id.
	 * @param postId
	 * @return ResponseEntity
	 */
	@GetMapping("/{postId}")
	public ResponseEntity<BlogOutDto> getBlog(@PathVariable("postId") final String postId) {
		LOGGER.info("get post by it's id controller called with  request payload [" + postId + "]");
		BlogOutDto response = blogService.getBlogById(postId);
		LOGGER.info("Fetching response from getpost service [" + response + "]");
		return new ResponseEntity<BlogOutDto>(response, HttpStatus.OK);
	}

	/**
	 * API end-point to update already existing BLOG post.
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PutMapping("/")
	public ResponseEntity<ResponseOutDTO> editBlog(@Valid @RequestBody final UpdateBlogInDto inDto) {
		LOGGER.info("Update blog controller called with request payload [" + inDto.getId() + "]");
		ResponseOutDTO response = blogService.editBlog(inDto);
		LOGGER.info(" Fetching response from editblog service [" + response + "]");
		return new ResponseEntity<ResponseOutDTO>(response, HttpStatus.OK);
	}

	/**
	 * API end-point to Gets all Approved post based on filtering status, title,
	 * technology category.
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PostMapping("/all/approved/blogs")
	public ResponseEntity<List<ApprovedBlogsOutDto>> getApprovedBlogs(
			@Valid @RequestBody final ApprovedBlogsInDto inDto) {
		LOGGER.info("api called filter_all_post controller with request payload [" + inDto + " ]");
		List<ApprovedBlogsOutDto> response = blogService.getApprovedBlog(inDto);
		LOGGER.info("Fetched reponse from getAllPost  service [ " + response + " ]");
		return new ResponseEntity<List<ApprovedBlogsOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * Gets all post of particular user by status , title , technology category.
	 * @param inDto
	 * @return ResponseEntity
	 */
	@PostMapping("/all/user/blogs")
	public ResponseEntity<List<UserBlogsOutDto>> getUserBlogs(@Valid @RequestBody final UserBlogsInDto inDto) {
		LOGGER.info("filter_user_post controller calling with request payload [" + inDto + " ]");
		List<UserBlogsOutDto> response = blogService.getUserBlogs(inDto);
		LOGGER.info("Fetching response from getUserPost service [" + response + "]");
		return new ResponseEntity<List<UserBlogsOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * API to Gets all the post which status is Not Approved yet by ADMIN side.
	 * @param inDto Contains the status for filtering.
	 * @return response Collection of post which is not approved yet.
	 */
	@PostMapping("/all/unreviewed/blogs")
	public ResponseEntity<List<UnReviewedBlogsOutDto>> getUnreviewedBlogs(
			@Valid @RequestBody final UnReviewedBlogsInDto inDto) {
		LOGGER.info("Get Unreviewed Blog controller invoking with request data [" + inDto + "]");
		List<UnReviewedBlogsOutDto> response = blogService.getUnreviewedBlogs(inDto);
		LOGGER.info("Fetching response from getUnreviewedPosts method of service [" + "]");
		return new ResponseEntity<List<UnReviewedBlogsOutDto>>(response, HttpStatus.OK);
	}

	/**
	 * API to approve the BLOG posted by employee from ADMIN. Based on postId it
	 * will search for BLOG and approved.
	 * @param inDto
	 * @return response message if approved then successful Or else failed.
	 */
	@PutMapping("/action/unreview/blog")
	public ResponseEntity<ResponseOutDTO> actOnUnreviewedBlog(
			@Valid @RequestBody final ActOnUnReviewedBlogInDto inDto) {
		LOGGER.info(" Act on unreviewed post invoked with request payload [" + inDto + "]");
		ResponseOutDTO response = blogService.actOnUnreviewedBlog(inDto);
		LOGGER.info(" fetching response from actOnUnreviewedPost method of service  [" + response + "]");
		return new ResponseEntity<ResponseOutDTO>(response, HttpStatus.OK);
	}
}
