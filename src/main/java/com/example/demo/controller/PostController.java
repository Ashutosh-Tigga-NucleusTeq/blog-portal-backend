package com.example.demo.controller;

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
import com.example.demo.payloads.ApiResponse;
import com.example.demo.services.PostService;

import jakarta.validation.Valid;

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
     * @param postInBlogDto The input DTO containing blog post data.
     * @return ResponseEntity containing the created blog post DTO.
     */
    @PostMapping("/post_blog")
    public ResponseEntity<ApiResponse> postBlog(@Valid @RequestBody PostInDto postInBlogDto) {
        logger.info("Sending postInBlogDto to createPostBlog method in service: " + postInBlogDto);
        ApiResponse response = this.postService.createPost(postInBlogDto);
        logger.info("Fetching response from createPostBlog: " + response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
