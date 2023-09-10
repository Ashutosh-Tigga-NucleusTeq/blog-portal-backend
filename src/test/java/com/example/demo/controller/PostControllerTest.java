package com.example.demo.controller;

import com.example.demo.dto.PostInDto;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;
import com.example.demo.payloads.ApiResponse;
import com.example.demo.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

public class PostControllerTest {

		/**
		 * instance of post controller.
		 */
    private PostController postController;

    /**
     * instance of post service.
     */
    @Mock
    private PostService postService;

    /**
     * configure just before calling of every test.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        postController = new PostController();
    }

    /**
     * testing post blog method  of controller.
     */
    @Test
    public void testPostBlog() {
        // Mock the PostInDto and ApiResponse
        PostInDto mockPostInDto = new PostInDto();
        mockPostInDto.setTitle("Test Post");
        mockPostInDto.setContent("postcontent");
        mockPostInDto.setTechCategory(TechnologyCategory.NoSQL);
        mockPostInDto.setCreatedAt(new Date());
        User user = new User();
    		user.setId("userid");
    		mockPostInDto.setAuthorId(user);
        ApiResponse mockApiResponse = new ApiResponse("Post created successfully", true);

        // Mock the postService's createPost method
        when(postService.createPost(any(PostInDto.class))).thenReturn(mockApiResponse);

        // Call the postBlog method
        ResponseEntity<ApiResponse> responseEntity = postController.postBlog(mockPostInDto);

        // Verify that the service method was called with the expected input
        Mockito.verify(postService).createPost(mockPostInDto);

        // Check the response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(mockApiResponse, responseEntity.getBody());
    }
}
