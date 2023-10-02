package com.blog.portal.controller;

import com.blog.portal.enumResource.React;
import com.blog.portal.requestPayload.ReactOnBlogInDto;
import com.blog.portal.responsePayload.ReactionOnBlogOutDto;
import com.blog.portal.services.ReactionService;
import com.blog.portal.util.RequestMappingConst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReactionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReactionService reactionService;
    
    @InjectMocks
    private ReactionController reactionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reactionController).build();
    }

    @Test
    public void testReactOnPost() throws Exception {
        ReactOnBlogInDto requestDto = new ReactOnBlogInDto("user123", "post456", React.LIKE);
        ReactionOnBlogOutDto responseDto = new ReactionOnBlogOutDto("1", "post456", "user123", React.LIKE);

        when(reactionService.doReactOnBlog(requestDto)).thenReturn(responseDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post(RequestMappingConst.REACTON_URL +"/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"postId\":\"post456\",\"userId\":\"user123\",\"type\":\"LIKE\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(reactionService, times(1)).doReactOnBlog(requestDto);

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals("{\"id\":\"1\",\"postId\":\"post456\",\"userId\":\"user123\",\"type\":\"LIKE\"}", responseContent);
    }
}
