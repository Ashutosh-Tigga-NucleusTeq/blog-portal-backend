package com.blog.portal.serviceimpl;

import com.blog.portal.entities.LikeOrDislike;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.LikeOrDislikePostMapper;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;
import com.blog.portal.services.LikeOrDislikePostService;
import com.blog.portal.serviceimpl.LikeOrDislikePostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LikeOrDislikePostServiceImplTest {

    @Mock
    private LikeOrDislikePostRepo likeOrDislikePostRepo;

    @Mock
    private BlogPostRepo blogPostRepo;

    @InjectMocks
    private LikeOrDislikePostService likeOrDislikePostService = new LikeOrDislikePostServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoReactOnPost() {
        // Create a sample input DTO
        LikeOrDislikePostInDto inputDto = new LikeOrDislikePostInDto();
        inputDto.setPostId("postId");
        inputDto.setUserId("userId");
        inputDto.setType(React.Like);

        // Create a sample post entity
        Post post = new Post();
        post.setId("postId");

        // Create a sample user reaction entity
        LikeOrDislike userReaction = new LikeOrDislike();
        userReaction.setUserId("userId");
        userReaction.setPostId("postId");

        // Mock the behavior of the repositories
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(likeOrDislikePostRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);

        // Mock the behavior of the mapper
        when(LikeOrDislikePostMapper.entityToOutDto(any(LikeOrDislike.class))).thenReturn(
                new LikeOrDislikePostOutDto("id", "user123", "postId", React.Like)); // Replace with actual values

        // Call the service method
        LikeOrDislikePostOutDto response = likeOrDislikePostService.doReactOnPost(inputDto);

        // Verify that the service method was called
        verify(blogPostRepo, times(1)).findById(post.getId());
        verify(likeOrDislikePostRepo, times(1)).findByUserIdAndPostId("userId", "postId");
        verify(blogPostRepo, times(1)).save(post);
        verify(likeOrDislikePostRepo, times(1)).save(userReaction);

        // Verify the response
        assertNotNull(response);
        assertEquals("id", response.getId());
        assertEquals("postId", response.getPostId());
        assertEquals("userId", response.getUserId());
        assertEquals(React.Like, response.getType());
    }


}
