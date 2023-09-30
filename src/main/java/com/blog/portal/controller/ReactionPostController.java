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

import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;
import com.blog.portal.services.ReactionPostService;
import com.blog.portal.util.RequestMappingConst;

@RestController
@RequestMapping(RequestMappingConst.REACTON_URL)
public class ReactionPostController {

  /**
   * An instance of the Logger class for logging.
   */
  private Logger logger = LogManager.getLogger(ReactionPostController.class);

  /**
   * Instance of LikeAndDislikeService.
   */
  @Autowired
  private ReactionPostService likeAndDislikeService;

  /**
   * Api to perform like or dislike on post.
   * @param inDto
   * @return ResponseEntity.
   */
  @PostMapping("/")
  public ResponseEntity<ReactionPostOutDto> reactOnPost(@Valid @RequestBody ReactionPostInDto inDto) {
  	logger.info(" like post controller with requestdto [" + inDto + "]");
  	ReactionPostOutDto response = likeAndDislikeService.doReactOnPost(inDto);
  	logger.info(" Fetching response from doReactOnPost service [" + response + "]");
  	return new ResponseEntity<ReactionPostOutDto>(response, HttpStatus.OK);
  }
}
