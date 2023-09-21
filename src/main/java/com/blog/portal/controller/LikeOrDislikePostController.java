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

import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;
import com.blog.portal.services.LikeOrDislikePostService;

@RestController
@RequestMapping("/blog/portal")
public class LikeOrDislikePostController {

  /**
   * An instance of the Logger class for logging.
   */
  private Logger logger = LogManager.getLogger(LikeOrDislikePostController.class);

  /**
   * Instance of LikeAndDislikeService.
   */
  @Autowired
  private LikeOrDislikePostService likeAndDislikeService;

  /**
   * Api to perform like on post.
   * @param inDto
   * @return ResponseEntity.
   */
  @PostMapping("/like/dislike/post")
  public ResponseEntity<LikeOrDislikePostOutDto> reactOnPost(@Valid @RequestBody LikeOrDislikePostInDto inDto) {
  	logger.info(" like post controller with requestdto [" + inDto + "]");
  	LikeOrDislikePostOutDto response = this.likeAndDislikeService.doReactOnPost(inDto);
  	logger.info(" Fetching response from doReactOnPost service [" + response + "]");
  	return new ResponseEntity<LikeOrDislikePostOutDto>(response, HttpStatus.OK);
  }
}
