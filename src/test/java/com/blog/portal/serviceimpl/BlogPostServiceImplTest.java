package com.blog.portal.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.FilterDashboardPostMapper;
import com.blog.portal.mapper.FilterMyBlogPostMapper;
import com.blog.portal.mapper.GetPostMapper;
import com.blog.portal.mapper.PostBlogMapper;
import com.blog.portal.mapper.UnReviewedPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.services.BlogPostService;
import com.blog.portal.util.ResponseMessage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BlogPostServiceImplTest {

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @Mock
    private BlogPostRepo blogPostRepo;

    @Mock
    private BlogUserRepo blogUserRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePost() {
        // Create a sample PostBlogInDto
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        postBlogInDto.setUserID("user123");
        postBlogInDto.setTitle("Sample Title");
        postBlogInDto.setContent("Sample Content");
        postBlogInDto.setCreatedAt(new Date());
        postBlogInDto.setTechCategory(TechnologyCategory.JAVA);
        // Mock the UserRepo to return a user
        User mockUser = new User();
        mockUser.setId("user123");
        Post post = new Post("postid");
        when(blogUserRepo.findById("user123")).thenReturn(Optional.of(mockUser));

        // Mock the PostBlogMapper
        when(blogPostRepo.save(any())).thenReturn(post);

        // Call the createPost method
        ApiResponse response = blogPostService.createPost(postBlogInDto);

        // Assert the response
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_POST_SUCCESS, response.getMessage());
    }

    @Test
    public void testCreatePostWithInvalidUser() {
        // Create a sample PostBlogInDto with an invalid user ID
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        postBlogInDto.setUserID("invalidUser");
        postBlogInDto.setTitle("Sample Title");
        postBlogInDto.setContent("Sample Content");

        // Mock the UserRepo to throw a ResourceNotFoundException
        when(blogUserRepo.findById("invalidUser")).thenThrow(new ResourceNotFoundException("User", "userId", "userId"));

    }

    @Test
    public void testGetAllPostFilter() {
        FilterDashboardPostInDto inDto = new FilterDashboardPostInDto();
        inDto.setTitle("Sample Title");

        when(blogPostRepo.findByStatus(PostStatus.APPROVED)).thenReturn(new ArrayList<>());

        List<FilterDashboardOutDto> result = blogPostService.getAllPostFilter(inDto);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetAllPostOfUserFilter() {
        FilterMyBlogPostInDto inDto = new FilterMyBlogPostInDto();
        inDto.setUserId("user123");
        inDto.setTitle("Sample Title");

        // Mock the blogPostRepo to return an empty list of posts
        when(blogPostRepo.findByTitleContainingIgnoreCaseAndUserId("Sample Title", "user123")).thenReturn(new ArrayList<>());

        // Call the getAllPostOfUserFilter method
        List<FilterMyBlogPostOutDto> result = blogPostService.getAllPostOfUserFilter(inDto);

        // Assert the result
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void testEditBlog() {
        // Create a sample UpdatePostInDto
        UpdatePostInDto inDto = new UpdatePostInDto();
        inDto.setId("post123");
        inDto.setTitle("Updated Title");
        inDto.setContent("Updated Content");

        // Mock the blogPostRepo to return a post
        Post mockPost = new Post();
        mockPost.setId("post123");
        when(blogPostRepo.findById("post123")).thenReturn(Optional.of(mockPost));

        // Mock the blogPostRepo.save method
        when(blogPostRepo.save(any())).thenReturn(new Post());

        // Call the editBlog method
        ApiResponse response = blogPostService.editBlog(inDto);

        // Assert the response
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.BLOG_UPDATE_SUCCESS, response.getMessage());
    }

    @Test
    public void testEditBlogWithInvalidPostId() {
        // Create a sample UpdatePostInDto with an invalid post ID
        UpdatePostInDto inDto = new UpdatePostInDto();
        inDto.setId("invalidPost");
        inDto.setTitle("Updated Title");
        inDto.setContent("Updated Content");

        // Mock the blogPostRepo to throw a ResourceNotFoundException
        when(blogPostRepo.findById("invalidPost")).thenThrow(new ResourceNotFoundException(null, null, null));

    }

    @Test
    public void testGetPost() {
        // Create a sample post ID
        String postId = "post123";

        // Mock the blogPostRepo to return a post
        Post mockPost = new Post();
        mockPost.setId("post123");
        when(blogPostRepo.findById(postId)).thenReturn(Optional.of(mockPost));

        // Call the getPost method
        GetPostOutDto result = blogPostService.getPost(postId);

        // Assert the result
        assertNotNull(result);
        assertEquals("post123", result.getId());
    }

    @Test
    public void testGetPostWithInvalidPostId() {
        // Create an invalid post ID
        String invalidPostId = "invalidPost";

        // Mock the blogPostRepo to throw a ResourceNotFoundException
        when(blogPostRepo.findById(invalidPostId)).thenThrow(new ResourceNotFoundException(null, null, null));

        // Call the getPost method
        assertThrows(ResourceNotFoundException.class, () -> blogPostService.getPost(invalidPostId));
    }

}
