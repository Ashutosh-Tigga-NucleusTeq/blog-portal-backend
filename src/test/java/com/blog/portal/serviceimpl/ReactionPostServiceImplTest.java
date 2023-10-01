package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Reaction;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReactionPostMapper;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;
import com.blog.portal.services.ReactionPostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class LikeOrDislikePostServiceImplTest {

    @Mock
    private LikeOrDislikePostRepo likeOrDislikePostRepo;

    @Mock
    private BlogPostRepo blogPostRepo;

    @InjectMocks
    private ReactionPostServiceImpl likeOrDislikePostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(blogPostRepo.findById(any())).thenReturn(Optional.empty());

        Reaction reaction = new Reaction();
        reaction.setId("sampleId");
        reaction.setUserId("sampleUserId");
        reaction.setPostId("samplePostId");
        reaction.setType(React.LIKE);

        when(likeOrDislikePostRepo.findByUserIdAndPostId(any(), any())).thenReturn(reaction);

        when(blogPostRepo.findById("samplePostId")).thenReturn(Optional.of(new Post()));

        when(likeOrDislikePostRepo.save(any(Reaction.class))).thenReturn(reaction);
    }

    @Test
    public void testDoReactOnPost_NewReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("sampleUserId", "samplePostId", React.DISLIKE);

        ReactionPostOutDto outDto = likeOrDislikePostService.doReactOnPost(inDto);

        assertNotNull(outDto);
        assertEquals("sampleUserId", outDto.getUserId());
        assertEquals("samplePostId", outDto.getPostId());
        assertEquals(React.DISLIKE, outDto.getType());
    }

    @Test
    public void testDoReactOnPost_ExistingReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("sampleUserId", "samplePostId", React.LIKE);

        ReactionPostOutDto outDto = likeOrDislikePostService.doReactOnPost(inDto);

        assertNotNull(outDto);
        assertEquals("sampleUserId", outDto.getUserId());
        assertEquals("samplePostId", outDto.getPostId());
        assertEquals(React.LIKE, outDto.getType());
    }

    @Test
    public void testDoReactOnPost_PostNotFound() {
        ReactionPostInDto inDto = new ReactionPostInDto("sampleUserId", "nonExistentPostId", React.LIKE);

        assertThrows(ResourceNotFoundException.class, () -> {
            likeOrDislikePostService.doReactOnPost(inDto);
        });
    }
}
