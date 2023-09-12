package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.dto.PostInDto;
import com.example.demo.dto.ShowPostInDto;
import com.example.demo.dto.ShowPostOutDto;
import com.example.demo.dto.UserPostInDto;
import com.example.demo.dto.UserPostOutDto;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.services.PostService;


/**
 * The {@code PostController} class handles HTTP requests related to blog posts.
 * It provides API endpoints for creating and managing blog posts.

 * @author [Author Name]
 */
@RestController
@RequestMapping("/blog-portal/api")
public class PostController {

    /**
     * An instance of the {@link PostService} class for handling blog post operations.
     */
    @Autowired
    private PostService postService;


    /**
     * An instance of the Logger class for logging.
     */
    private Logger logger = LogManager.getLogger(UserController.class);

    /**
     * API endpoint to create a new blog post.
     *
     * @param postInDto The input DTO containing blog post data.
     * @return ResponseEntity containing the created blog post DTO.
     */
    @PostMapping("/post_blog")
    public ResponseEntity<ApiResponse> postBlog(@Valid @RequestBody PostInDto postInDto) {
        logger.info("Sending postInBlogDto to createPostBlog method in service: " + postInDto);
        ApiResponse response = this.postService.createPost(postInDto);
        logger.info("Fetching response from createPostBlog: " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Gets all post by status status , title , technology category.
     * @param inDto
     * @return ResponseEntity
     */
    @PostMapping("/filter_all_post")
    public ResponseEntity<List<ShowPostOutDto>> getAllPosts(@RequestBody ShowPostInDto inDto) {
    	logger.info("api called filter_all_post controller with inDto[ " + inDto + " ]");
    	List<ShowPostOutDto> outDto = this.postService.getAllPost(inDto);
    	logger.info("Fetched reponse from Serivce implementation class into controller back with res [ " + outDto + " ]");
    	return new ResponseEntity<>(outDto, HttpStatus.OK);
    }

    /**
     * Gets all post of particular user by status  , title , technology category.
     * @param inDto
     * @return ResponseEntity
     */
    @PostMapping("/filter_user_post")
    public ResponseEntity<List<UserPostOutDto>> getUserPosts(@RequestBody UserPostInDto inDto) {
    	logger.info("filter_user_post calling with data [" + inDto + " ]");
    	List<UserPostOutDto> outDto = this.postService.getUserPosts(inDto);
    	logger.info("After getting the response from PostService for getUserPost data [" + outDto + "]");
    	return new ResponseEntity<>(outDto, HttpStatus.OK);
    }
}
