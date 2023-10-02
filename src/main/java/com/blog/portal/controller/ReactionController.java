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

import com.blog.portal.requestPayload.ReactOnBlogInDto;
import com.blog.portal.responsePayload.ReactionOnBlogOutDto;
import com.blog.portal.services.ReactionService;
import com.blog.portal.util.RequestMappingConst;

/**
 * The {@code ReactionController} class handles HTTP requests related to REACTION on BLOG.
 * It provides API end-points for creating and managing REACTION on BLOGS.
 *
 * @author [Ashutosh Tigga]
 */
@RestController
@RequestMapping(RequestMappingConst.REACTON_URL)
public class ReactionController {

	/**
	 * An instance of the Logger class for logging.
	 */
	private static final Logger LOGGER = LogManager.getLogger(ReactionController.class);

	/**
	 * Instance of LikeAndDislikeService.
	 */
	@Autowired
	private ReactionService likeAndDislikeService;

	/**
	 * API end-point to perform like or dislike on BLOG.
	 *
	 * @param inDto
	 * @return ResponseEntity.
	 */
	@PostMapping("/")
	public ResponseEntity<ReactionOnBlogOutDto> reactOnBlog(@Valid @RequestBody final ReactOnBlogInDto inDto) {
		LOGGER.info(" like post controller with requestdto [" + inDto + "]");
		ReactionOnBlogOutDto response = likeAndDislikeService.doReactOnBlog(inDto);
		LOGGER.info(" Fetching response from doReactOnPost service [" + response + "]");
		return new ResponseEntity<ReactionOnBlogOutDto>(response, HttpStatus.OK);
	}
}
