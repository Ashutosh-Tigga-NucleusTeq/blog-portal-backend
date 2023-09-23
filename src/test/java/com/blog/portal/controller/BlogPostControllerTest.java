package com.blog.portal.controller;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.requestPayload.*;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.*;
import com.blog.portal.services.BlogPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class BlogPostControllerTest {

    @Mock
    private BlogPostService blogPostService;

    @InjectMocks
    private BlogPostController blogPostController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(blogPostController).build();
    }

    @Test
    void testPostBlog() throws Exception {
        PostBlogInDto postBlogInDto = new PostBlogInDto();
        postBlogInDto.setTitle("Test Title");
        postBlogInDto.setContent("Test Content");

        ApiResponse response = new ApiResponse("Blog post created successfully.", true);

        when(blogPostService.createPost(any())).thenReturn(response);

        mockMvc.perform(post("/blog/portal/post/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Test Title\",\"content\":\"Test Content\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"message\":\"Blog post created successfully.\",\"success\":true}"));
    }

    @Test
    void testGetPost() throws Exception {
        GetPostOutDto response = new GetPostOutDto();
        response.setId("1");
        response.setTitle("Sample Title");
        response.setContent("Sample Content");

        when(blogPostService.getPost("1")).thenReturn(response);

        mockMvc.perform(get("/blog/portal/get/post/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"1\",\"title\":\"Sample Title\",\"content\":\"Sample Content\"}"));
    }

    @Test
    void testEditBlog() throws Exception {
        UpdatePostInDto updatePostInDto = new UpdatePostInDto();
        updatePostInDto.setId("1");
        updatePostInDto.setTitle("Updated Title");
        updatePostInDto.setContent("Updated Content");

        ApiResponse response = new ApiResponse("Blog post updated successfully.", true);

        when(blogPostService.editBlog(any())).thenReturn(response);

        mockMvc.perform(put("/blog/portal/update/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1\",\"title\":\"Updated Title\",\"content\":\"Updated Content\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Blog post updated successfully.\",\"success\":true}"));
    }

    @Test
    void testFilterDashboardPost() throws Exception {
        FilterDashboardPostInDto filterDashboardPostInDto = new FilterDashboardPostInDto();
        //filterDashboardPostInDto.setStatus("PUBLISHED");

        List<FilterDashboardOutDto> response = new ArrayList<>();
        // Fill response list with sample data

        when(blogPostService.getAllPostFilter(any())).thenReturn(response);

        mockMvc.perform(post("/blog/portal/filter/dashboard/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"PUBLISHED\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // Replace with JSON containing your sample data
    }

    @Test
    void testFilterMyBlogPost() throws Exception {
        FilterMyBlogPostInDto filterMyBlogPostInDto = new FilterMyBlogPostInDto();
        filterMyBlogPostInDto.setStatus(PostStatus.Approved);

        List<FilterMyBlogPostOutDto> response = new ArrayList<>();
        // Fill response list with sample data

        when(blogPostService.getAllPostOfUserFilter(any())).thenReturn(response);

        mockMvc.perform(post("/blog/portal/filter/myblog/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"Approved\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // Replace with JSON containing your sample data
    }

    @Test
    void testGetUnreviewedPost() throws Exception {
        UnReviewedPostInDto unReviewedPostInDto = new UnReviewedPostInDto();
      //  unReviewedPostInDto.setStatus("");

        List<UnReviewedPostOutDto> response = new ArrayList<>();
        // Fill response list with sample data

        when(blogPostService.getUnreviewedPosts(any())).thenReturn(response);

        mockMvc.perform(post("/blog/portal/get/unreviewed/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"status\":\"NOT_APPROVED\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]")); // Replace with JSON containing your sample data
    }

    @Test
    void testApprovePost() throws Exception {
        ApproveOrRejectPostInDto approveOrRejectPostInDto = new ApproveOrRejectPostInDto();
        approveOrRejectPostInDto.setPostId("1");
        approveOrRejectPostInDto.setPostStatus(PostStatus.Approved);

        ApiResponse response = new ApiResponse("Blog post approved successfully.", true);

        when(blogPostService.responseUnreviewedPost(any())).thenReturn(response);

        mockMvc.perform(put("/blog/portal/response/unreviewed/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"postId\":\"1\",\"postStatus\":\"Approved\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Blog post approved successfully.\",\"success\":true}"));
    }
}
