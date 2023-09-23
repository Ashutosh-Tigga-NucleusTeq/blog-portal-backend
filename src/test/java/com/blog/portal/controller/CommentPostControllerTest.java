package com.blog.portal.controller;

import com.blog.portal.controller.CommentPostController;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CommentPostControllerTest {

    @InjectMocks
    private CommentPostController commentPostController;

    @Mock
    private CommentPostService commentPostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoComment() {
        // Create a sample input DTO
        CommentPostInDto inDto = new CommentPostInDto("Sample Comment", "user123", "post123");

        // Create a sample output DTO
        CommentPostOutDto outDto = new CommentPostOutDto("comment123", "Sample Comment", "user123", "post123");

        // Mock the service method to return the sample output DTO when called with the input DTO
        Mockito.when(commentPostService.doCommentOnPost(inDto)).thenReturn(outDto);

        // Call the controller method
        ResponseEntity<CommentPostOutDto> responseEntity = commentPostController.doComment(inDto);

        // Verify the response
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        CommentPostOutDto responseDto = responseEntity.getBody();
        assertEquals(outDto, responseDto);
    }

    @Test
    public void testGetComments() {
        // Define a sample postId
        String postId = "post123";

        // Create a sample list of CommentPostOutDto objects
        List<CommentPostOutDto> commentList = Collections.singletonList(
                new CommentPostOutDto("comment123", "Sample Comment", "user123", "post123"));

        // Mock the service method to return the sample list of CommentPostOutDto when called with postId
        Mockito.when(commentPostService.getComments(postId)).thenReturn(commentList);

        // Call the controller method
        ResponseEntity<List<CommentPostOutDto>> responseEntity = commentPostController.getComments(postId);

        // Verify the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<CommentPostOutDto> responseList = responseEntity.getBody();
        assertEquals(commentList, responseList);
    }
}
