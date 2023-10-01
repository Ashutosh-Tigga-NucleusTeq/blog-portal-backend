package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Post;
import com.blog.portal.entities.Reaction;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReactionPostMapper;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.LikeOrDislikePostRepo;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;
import com.blog.portal.services.ReactionPostService;
import com.blog.portal.serviceimpl.ReactionPostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReactionPostServiceImplTest {

    @Mock
    private LikeOrDislikePostRepo likeAndDislikeRepo;

    @Mock
    private BlogPostRepo blogPostRepo;

    @InjectMocks
    private ReactionPostService reactionPostService = new ReactionPostServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoReactOnPost_ReactLike_NewReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("userId", "postId", React.LIKE);
        Reaction userReaction = null;
        Post post = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(post)).thenReturn(post);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionPostOutDto result = reactionPostService.doReactOnPost(inDto);

        assertNotNull(result);
        assertEquals(React.LIKE, result.getType());
        assertTrue(post.getLikedBy().contains("userId"));
        assertFalse(post.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactDislike_NewReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("userId", "postId", React.DISLIKE);
        Reaction userReaction = null;
        Post post = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(post)).thenReturn(post);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionPostOutDto result = reactionPostService.doReactOnPost(inDto);

        assertNotNull(result);
        assertEquals(React.DISLIKE, result.getType());
        assertFalse(post.getLikedBy().contains("userId"));
        assertTrue(post.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactLike_UpdateReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("userId", "postId", React.LIKE);
        Reaction userReaction = createSampleReaction("userId", "postId", React.DISLIKE);
        Post post = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(post)).thenReturn(post);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionPostOutDto result = reactionPostService.doReactOnPost(inDto);

        assertNotNull(result);
        assertEquals(React.LIKE, result.getType());
        assertTrue(post.getLikedBy().contains("userId"));
        assertFalse(post.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactDislike_UpdateReaction() {
        ReactionPostInDto inDto = new ReactionPostInDto("userId", "postId", React.DISLIKE);
        Reaction userReaction = createSampleReaction("userId", "postId", React.LIKE);
        Post post = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.of(post));
        when(blogPostRepo.save(post)).thenReturn(post);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionPostOutDto result = reactionPostService.doReactOnPost(inDto);

        assertNotNull(result);
        assertEquals(React.DISLIKE, result.getType());
        assertFalse(post.getLikedBy().contains("userId"));
        assertTrue(post.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_PostNotFound() {
        ReactionPostInDto inDto = new ReactionPostInDto("userId", "postId", React.LIKE);
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(null);
        when(blogPostRepo.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            reactionPostService.doReactOnPost(inDto);
        });
    }

    private Post createSamplePost() {
        Post post = new Post();
        post.setId("postId");
        post.setLikedBy(new HashSet<>());
        post.setDisLikedBy(new HashSet<>());
        return post;
    }

    private Reaction createSampleReaction(String userId, String postId, React type) {
        Reaction reaction = new Reaction();
        reaction.setUserId(userId);
        reaction.setPostId(postId);
        reaction.setType(type);
        return reaction;
    }
}
