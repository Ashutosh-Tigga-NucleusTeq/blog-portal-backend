package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PostInDto;
import com.example.demo.dto.PostOutDto;
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
     * @param userId        The ID of the user creating the blog post.
     * @return ResponseEntity containing the created blog post DTO.
     */
    @PostMapping("/post_blog/{user_id}")
    public ResponseEntity<PostOutDto> postBlog(@Valid @RequestBody PostInDto postInBlogDto,
            @PathVariable(value = "user_id") String userId) {
        logger.info("Sending postInBlogDto to createPostBlog method in service: " + postInBlogDto);
        PostOutDto response = this.postService.createPost(postInBlogDto, userId);
        logger.info("Fetching response from createPostBlog: " + response);
        return new ResponseEntity<PostOutDto>(response, HttpStatus.CREATED);
    }
}
