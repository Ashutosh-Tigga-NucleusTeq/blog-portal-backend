package com.blog.portal.controller;

import com.blog.portal.enumResource.React;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;
import com.blog.portal.services.ReactionPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ReactionPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReactionPostService reactionPostService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReactOnPost() throws Exception {
        ReactionPostInDto requestDto = new ReactionPostInDto("user123", "post456", React.LIKE);
        ReactionPostOutDto responseDto = new ReactionPostOutDto("1", "post456", "user123", React.LIKE);

        when(reactionPostService.doReactOnPost(requestDto)).thenReturn(responseDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/reaction/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"postId\":\"post456\",\"userId\":\"user123\",\"type\":\"LIKE\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        verify(reactionPostService, times(1)).doReactOnPost(requestDto);

        String responseContent = mvcResult.getResponse().getContentAsString();
        assertEquals("{\"id\":\"1\",\"postId\":\"post456\",\"userId\":\"user123\",\"type\":\"LIKE\"}", responseContent);
    }
}
