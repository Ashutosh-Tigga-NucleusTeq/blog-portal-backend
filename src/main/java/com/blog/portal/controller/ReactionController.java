package com.blog.portal.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.portal.requestPayload.ReactionInDto;
import com.blog.portal.responsePayload.ReactionOutDto;
import com.blog.portal.services.ReactionService;

/**
 * The {@code UserController} class handles HTTP requests related to Reaction operation done by user on blog.
 *
 * @author Ashutosh Tigga.
 */
@RestController
@RequestMapping("/reaction")
public class ReactionController {

	/**
	 * An instance of the Logger class for logging.
	 */
	private Logger logger = LogManager.getLogger(ReactionController.class);

	/**
	 * Instance of LikeAndDislikeService.
	 */
	@Autowired
	private ReactionService likeAndDislikeService;

	/**
	 * Api to perform like on post.
	 *
	 * @param inDto
	 * @return ResponseEntity.
	 */
	@PostMapping("/reactionOnBlogPost")
	public ResponseEntity<ReactionOutDto> reactOnPost(@RequestBody ReactionInDto inDto) {
		logger.info(" like post controller with requestdto [" + inDto + "]");
		ReactionOutDto response = likeAndDislikeService.doReactOnPost(inDto);
		logger.info(" Fetching response from doReactOnPost service [" + response + "]");
		return new ResponseEntity<ReactionOutDto>(response, HttpStatus.OK);
	}
}
