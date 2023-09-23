package com.blog.portal.controller;

import com.blog.portal.controller.ReactionController;
import com.blog.portal.requestPayload.ReactionInDto;
import com.blog.portal.responsePayload.ReactionOutDto;
import com.blog.portal.services.ReactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class LikeOrDislikePostControllerTest {

    @Mock
    private ReactionService reactionService;

    @InjectMocks
    private ReactionController reactionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReactOnPost() {
        // Create a sample input DTO
        ReactionInDto inputDto = new ReactionInDto();
        inputDto.setPostId("postId");
        inputDto.setUserId("userId");

        // Create a sample output DTO
        ReactionOutDto outputDto = new ReactionOutDto();
        outputDto.setId("likeId");
        outputDto.setPostId("postId");
        outputDto.setUserId("userId");

        // Mock the behavior of the service
        when(reactionService.doReactOnPost(inputDto)).thenReturn(outputDto);

        // Call the controller method
        ResponseEntity<ReactionOutDto> response = reactionController.reactOnPost(inputDto);

        // Verify that the service method was called
        verify(reactionService, times(1)).doReactOnPost(inputDto);

        // Verify the response status code and content
        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody() != null);
        assert(response.getBody().getId().equals("likeId"));
        assert(response.getBody().getPostId().equals("postId"));
        assert(response.getBody().getUserId().equals("userId"));
    }
}
