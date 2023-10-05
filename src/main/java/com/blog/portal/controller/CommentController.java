package com.blog.portal.controller;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responsePayload.CommentsOutDto;
import com.blog.portal.responsePayload.ResponseOutDTO;
import com.blog.portal.services.CommentService;
import com.blog.portal.util.RequestMappingConst;

/**
 * This class handles HTTP requests related to COMMENT of  posts.
 * It provides API end-points for creating COMMENTS.
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping(RequestMappingConst.COMMENT_URL)
public class CommentController {

	/**
	 * Instance CommentService.
	 */
	@Autowired
	private CommentService commentService;

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(CommentController.class);

	/**
	 * API end-point to perform Comment Functionality on BLOG.
	 * @param inDto
	 * @return ResponseEntity<CommentOutDto>
	 */
	@PostMapping("/")
	public ResponseEntity<ResponseOutDTO> doComment(@RequestBody final CommentOnBlogInDto inDto) {
		LOGGER.info(" do comment controller called with inDto [" + inDto + "]");
		ResponseOutDTO response = commentService.doCommentOnBlog(inDto);
		LOGGER.info("Fetcing response from doCommentOnPost service [" + response + "]");
		return new ResponseEntity<ResponseOutDTO>(response, HttpStatus.CREATED);
	}

	/**
	 * API end-point for fetching all the comments commented on Blog.
	 * @param postId
	 * @return ResponseEntity
	 */
	@GetMapping("/{postId}")
	public ResponseEntity<List<CommentsOutDto>> getComments(@PathVariable final String postId) {
		LOGGER.info("get comment controoler called with path variable [" + postId + "]");
		List<CommentsOutDto> response = commentService.getComments(postId);
		LOGGER.info("Fetching response from get comment service [" + response + "]");
		return new ResponseEntity<List<CommentsOutDto>>(response, HttpStatus.OK);
	}
}
