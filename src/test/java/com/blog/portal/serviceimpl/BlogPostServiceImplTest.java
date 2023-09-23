package com.blog.portal.serviceimpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.Gender;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.FilterDashboardPostMapper;
import com.blog.portal.mapper.FilterMyBlogPostMapper;
import com.blog.portal.mapper.GetPostMapper;
import com.blog.portal.mapper.PostBlogMapper;
import com.blog.portal.messagePayloads.ApiResponse;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.requestPayload.UpdatePostInDto;
import com.blog.portal.responsePayload.FilterDashboardOutDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;
import com.blog.portal.responsePayload.GetPostOutDto;
import com.blog.portal.services.BlogPostService;

@SpringBootTest
public class BlogPostServiceImplTest {

    @InjectMocks
    private BlogPostServiceImpl blogPostService;

    @Mock
    private BlogPostRepo blogPostRepo;

    @Mock
    private BlogUserRepo blogUserRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePostSuccess() {
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        // Initialize postBlogInDto with required data
        postBlogInDto.setTechCategory(TechnologyCategory.Java);
        postBlogInDto.setCreatedAt(new Date());
        postBlogInDto.setTitle("title");
        postBlogInDto.setUserID("userid");
        postBlogInDto.setContent("content");
        User user = new User();
        // Initialize user with expected data
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setDesignation(Designation.Intern);
        user.setEmail("test@nucleusteq.com");
        user.setId("userid");
        user.setContactNumber("1234567890");
        user.setGender(Gender.Male);
        user.

        when(blogUserRepo.findById(postBlogInDto.getUserId())).thenReturn(Optional.of(user));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

        ApiResponse actualApiResponse = blogPostService.createPost(postBlogInDto);

        assertTrue(actualApiResponse.isSuccess());
        assertEquals("Blog created With pending status and Waiting for Admin Approval", actualApiResponse.getMessage());
    }

    @Test
    public void testCreatePostUserNotFound() {
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        // Initialize postBlogInDto with required data

        when(blogUserRepo.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> blogPostService.createPost(postBlogInDto));
    }

    @Test
    public void testCreatePost_SaveFailed() {
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        // Initialize postBlogInDto with required data

        User user = new User();
        // Initialize user with expected data

        when(blogUserRepo.findById(anyLong())).thenReturn(Optional.of(user));
        when(blogPostRepo.save(any(Post.class))).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> blogPostService.createPost(postBlogInDto));
    }

    @Test
    public void testGetAllPostFilter_NoFilters_Success() {
        FilterDashboardPostInDto inDto = new FilterDashboardPostInDto();
        int pageNumber = 0;
        int pageSize = 10;

        when(blogPostRepo.findByStatus(eq(PostStatus.Approved), any(Pageable.class))).thenReturn(page);

        List<FilterDashboardOutDto> actualOutDtoList = blogPostService.getAllPostFilter(inDto, pageNumber, pageSize);

        assertEquals(1, actualOutDtoList.size()); // Adjust the expected size accordingly
    }

    // Add more test cases for getAllPostFilter based on different filter scenarios

    @Test
    public void testGetAllPostOfUserFilter_NoFilters_Success() {
        FilterMyBlogPostInDto inDto = new FilterMyBlogPostInDto();
        int pageNumber = 0;
        int pageSize = 10;



        when(blogPostRepo.findByUserId(eq(inDto.getUserId()), any(Pageable.class))).thenReturn(page);

        List<FilterMyBlogPostOutDto> actualOutDtoList = blogPostService.getAllPostOfUserFilter(inDto, pageNumber, pageSize);

        // Add assertions based on your test data
    }

    // Add more test cases for getAllPostOfUserFilter based on different filter scenarios

    @Test
    public void testEditBlog_Success() {
        UpdatePostInDto inDto = new UpdatePostInDto();
        // Initialize inDto with required data

        Post postEntity = new Post();
        // Initialize postEntity with expected data

        when(blogPostRepo.findById(eq(inDto.getId()))).thenReturn(Optional.of(postEntity));
        when(blogPostRepo.save(any(Post.class))).thenReturn(new Post());

        ApiResponse actualApiResponse = blogPostService.editBlog(inDto);

        assertTrue(actualApiResponse.isSuccess());
        assertEquals("Blog updated ", actualApiResponse.getMessage());
    }

    @Test
    public void testEditBlog_PostNotFound() {
        UpdatePostInDto inDto = new UpdatePostInDto();
        // Initialize inDto with required data

        when(blogPostRepo.findById(eq(inDto.getId()))).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> blogPostService.editBlog(inDto));
    }

    // Add more test cases for editBlog based on different scenarios

    @Test
    public void testGetPost_Success() {
        String postId = "postId"; // Replace with a valid post ID

        Post postEntity = new Post();
        // Initialize postEntity with expected data

        when(blogPostRepo.findById(eq(postId))).thenReturn(Optional.of(postEntity));

        GetPostOutDto actualOutDto = blogPostService.getPost(postId);

        // Add assertions based on your test data
    }

    @Test
    public void testGetPost_PostNotFound() {
        String postId = "nonExistentId"; // Replace with a non-existent post ID

        when(blogPostRepo.findById(eq(postId))).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> blogPostService.getPost(postId));
    }

    // Add more test cases for getPost based on different scenarios
}
