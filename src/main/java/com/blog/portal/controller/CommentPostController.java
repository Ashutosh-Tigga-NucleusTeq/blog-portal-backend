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

import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;

/**
 * The {@code UserController} class handles HTTP requests related to Comment operations done by user.
 *
 * @author Ashutosh Tigga.
 */
@RestController
@RequestMapping("/comment")
public class CommentPostController {

	/**
	 * Instance of CommentService.
	 */
	@Autowired
	private CommentPostService commentPostService;
	/**
	 * An instance of the Logger class for logging.
	 */
	private Logger logger = LogManager.getLogger(CommentPostController.class);

	/**
	 * This controller fetch the request from client side when user click on like or
	 * dislike button.
	 *
	 * @param inDto
	 * @return ResponseEntity<CommentOutDto>
	 */
	@PostMapping("/doComment")
	public ResponseEntity<CommentPostOutDto> doComment(@RequestBody CommentPostInDto inDto) {
		logger.info(" do comment controller called with inDto [" + inDto + "]");
		CommentPostOutDto response = commentPostService.doCommentOnPost(inDto);
		logger.info("Fetcing response from doCommentOnPost service [" + response + "]");
		return new ResponseEntity<CommentPostOutDto>(response, HttpStatus.CREATED);
	}

	/**
	 * This controller to gets Comment.
	 *
	 * @param postId
	 * @return ResponseEntity
	 */
	@GetMapping("/getComment/{postId}")
	public ResponseEntity<List<CommentPostOutDto>> getComments(@PathVariable String postId) {
		logger.info("get comment controoler called with path variable [" + postId + "]");
		List<CommentPostOutDto> response = commentPostService.getComments(postId);
		logger.info("Fetching response from get comment service [" + response + "]");
		return new ResponseEntity<List<CommentPostOutDto>>(response, HttpStatus.OK);
	}
}
