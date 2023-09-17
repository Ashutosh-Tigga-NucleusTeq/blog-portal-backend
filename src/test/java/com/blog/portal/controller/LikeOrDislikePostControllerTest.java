package com.blog.portal.controller;

import com.blog.portal.controller.LikeOrDislikePostController;
import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;
import com.blog.portal.services.LikeOrDislikePostService;
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
    private LikeOrDislikePostService likeOrDislikePostService;

    @InjectMocks
    private LikeOrDislikePostController likeOrDislikePostController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReactOnPost() {
        // Create a sample input DTO
        LikeOrDislikePostInDto inputDto = new LikeOrDislikePostInDto();
        inputDto.setPostId("postId");
        inputDto.setUserId("userId");

        // Create a sample output DTO
        LikeOrDislikePostOutDto outputDto = new LikeOrDislikePostOutDto();
        outputDto.setId("likeId");
        outputDto.setPostId("postId");
        outputDto.setUserId("userId");

        // Mock the behavior of the service
        when(likeOrDislikePostService.doReactOnPost(inputDto)).thenReturn(outputDto);

        // Call the controller method
        ResponseEntity<LikeOrDislikePostOutDto> response = likeOrDislikePostController.reactOnPost(inputDto);

        // Verify that the service method was called
        verify(likeOrDislikePostService, times(1)).doReactOnPost(inputDto);

        // Verify the response status code and content
        assert(response.getStatusCode() == HttpStatus.OK);
        assert(response.getBody() != null);
        assert(response.getBody().getId().equals("likeId"));
        assert(response.getBody().getPostId().equals("postId"));
        assert(response.getBody().getUserId().equals("userId"));
    }
}
