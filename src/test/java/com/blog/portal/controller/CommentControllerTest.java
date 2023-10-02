package com.blog.portal.controller;

import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentsOutDto;
import com.blog.portal.services.CommentService;
import com.blog.portal.util.RequestMappingConst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class CommentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;
    
		@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentController).build();
    }

    @Test
    public void testDoComment() throws Exception {
        new CommentOnBlogInDto("Sample Comment", "user123", "post456");

        ApiResponse apiResponse = new ApiResponse("Comment added successfully", true);

        when(commentService.doCommentOnBlog(any(CommentOnBlogInDto.class))).thenReturn(apiResponse);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post(RequestMappingConst.COMMENT_URL +"/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"content\":\"Sample Comment\",\"userId\":\"user123\",\"postId\":\"post456\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();

        String content = result.getResponse().getContentAsString();
         assertTrue(content.contains("Comment added successfully"));
    }

    @Test
    public void testGetComments() throws Exception {
        String postId = "post123";

        List<CommentsOutDto> commentList = Collections.singletonList(
                new CommentsOutDto("comment123", "Sample Comment", "user123", postId));

        when(commentService.getComments(postId)).thenReturn(commentList);

        mockMvc.perform(MockMvcRequestBuilders
                .get(RequestMappingConst.COMMENT_URL +"/{postId}", postId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(commentList.size()));
    }
}
