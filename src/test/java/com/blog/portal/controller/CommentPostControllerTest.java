package com.blog.portal.controller;

import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
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


public class CommentPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CommentPostService commentPostService;

    @InjectMocks
    private CommentPostController commentPostController;
    
		@BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(commentPostController).build();
    }

    @Test
    public void testDoComment() throws Exception {
        new CommentPostInDto("Sample Comment", "user123", "post456");

        ApiResponse apiResponse = new ApiResponse("Comment added successfully", true);

        when(commentPostService.doCommentOnPost(any(CommentPostInDto.class))).thenReturn(apiResponse);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/comment/blog")
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

        List<CommentPostOutDto> commentList = Collections.singletonList(
                new CommentPostOutDto("comment123", "Sample Comment", "user123", postId));

        when(commentPostService.getComments(postId)).thenReturn(commentList);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/comment/{postId}", postId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(commentList.size()));
    }
}
