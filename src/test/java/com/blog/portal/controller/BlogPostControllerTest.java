package com.blog.portal.controller;

import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.services.BlogPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class BlogPostControllerTest {

    @InjectMocks
    private BlogPostController blogPostController;

    @Mock
    private BlogPostService blogPostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPostBlog() {
        // Create a sample input DTO
        PostBlogInDto postBlogInDto = new PostBlogInDto("Sample Title", "Sample Content", new Date(), "user123", TechnologyCategory.Java);
        
        // Mock the service method
        when(blogPostService.createPost(any())).thenReturn(new ApiResponse("Blog post created successfully", true));

        // Call the controller method
        ResponseEntity<ApiResponse> response = blogPostController.postBlog(postBlogInDto);

        // Assert the response
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Blog post created successfully", response.getBody().getMessage());
    }

    @Test
    public void testGetPost() {
        // Mock the service method
        GetPostOutDto mockResponse = new GetPostOutDto("postId123", "Sample Title", "Sample Content", new Date(), "user123", TechnologyCategory.Java);
        when(blogPostService.getPost(anyString())).thenReturn(mockResponse);

        // Call the controller method
        ResponseEntity<GetPostOutDto> response = blogPostController.getPost("postId123");

        // Assert the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        GetPostOutDto responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals("postId123", responseBody.getId());
        assertEquals("Sample Title", responseBody.getTitle());
        assertEquals("Sample Content", responseBody.getContent());
    }

    @Test
    public void testEditBlog() {
        // Create a sample input DTO
        UpdatePostInDto updatePostInDto = new UpdatePostInDto("postId123", "Updated Title", "Updated Content");

        // Mock the service method
        when(blogPostService.editBlog(any())).thenReturn(new ApiResponse("Blog post updated successfully", true));

        // Call the controller method
        ResponseEntity<ApiResponse> response = blogPostController.editBlog(updatePostInDto);

        // Assert the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isSuccess());
        assertEquals("Blog post updated successfully", response.getBody().getMessage());
    }

    @Test
    public void testGetAllPost() {
        // Create a sample input DTO
        FilterDashboardPostInDto filterDto = new FilterDashboardPostInDto();
        filterDto.setTitle("Sample Title");
        filterDto.setTechCategory(TechnologyCategory.Java);

        // Mock the service method
        List<FilterDashboardOutDto> mockResponse = new ArrayList<>();
        mockResponse.add(new FilterDashboardOutDto("postId123", "Sample Title", TechnologyCategory.Java));
        when(blogPostService.getAllPostFilter(any(), anyInt(), anyInt())).thenReturn(mockResponse);

        // Call the controller method
        ResponseEntity<List<FilterDashboardOutDto>> response = blogPostController.getAllPost(filterDto, 1, 3);

        // Assert the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<FilterDashboardOutDto> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(1, responseBody.size());
        assertEquals("postId123", responseBody.get(0).getId());
        assertEquals("Sample Title", responseBody.get(0).getTitle());
    }

    @Test
    public void testGetUserPosts() {
        // Create a sample input DTO
        FilterMyBlogPostInDto filterDto = new FilterMyBlogPostInDto();
        filterDto.setTitle("Sample Title");
        filterDto.setTechCategory(TechnologyCategory.Java);

        // Mock the service method
        List<FilterMyBlogPostOutDto> mockResponse = new ArrayList<>();
        mockResponse.add(new FilterMyBlogPostOutDto("postId123", "Sample Title", TechnologyCategory.Java));
        when(blogPostService.getAllPostOfUserFilter(any(), anyInt(), anyInt())).thenReturn(mockResponse);

        // Call the controller method
        ResponseEntity<List<FilterMyBlogPostOutDto>> response = blogPostController.getUserPosts(filterDto, 1, 3);

        // Assert the response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<FilterMyBlogPostOutDto> responseBody = response.getBody();
        assertNotNull(responseBody);
        assertEquals(1, responseBody.size());
        assertEquals("postId123", responseBody.get(0).getId());
        assertEquals("Sample Title", responseBody.get(0).getTitle());
    }
}
