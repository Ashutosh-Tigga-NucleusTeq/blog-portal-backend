package com.blog.portal.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.portal.requestPayload.ReactionBlogInDto;
import com.blog.portal.responsePayload.ReactionBlogOutDto;
import com.blog.portal.services.ReactionService;
import com.blog.portal.util.RestPathConstants;

/**
 * This class handles HTTP requests related to REACTION on BLOG.
 * It provides API end-points for creating and managing REACTION on BLOGS.
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping(RestPathConstants.REACTON_URL)
public class ReactionController {

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ReactionController.class);

	/**
	 * Instance of ReactionService.
	 */
	@Autowired
	private ReactionService reactionService;

	/**
	 * API end-point to perform like or dislike on BLOG.
	 * @param inDto
	 * @return ResponseEntity.
	 */
	@PostMapping("/")
	public ResponseEntity<ReactionBlogOutDto> reactOnBlog(@Valid @RequestBody final ReactionBlogInDto inDto) {
		LOGGER.info(" like post controller with requestdto [" + inDto + "]");
		ReactionBlogOutDto response = reactionService.reactOnBlog(inDto);
		LOGGER.info(" Fetching response from doReactOnPost service [" + response + "]");
		return new ResponseEntity<ReactionBlogOutDto>(response, HttpStatus.OK);
	}
}
