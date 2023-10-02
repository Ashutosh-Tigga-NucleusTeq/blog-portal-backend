package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Blog;
import com.blog.portal.entities.Reaction;
import com.blog.portal.enumResource.React;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.mapper.ReactOnBlogMapper;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.ReactionRepository;
import com.blog.portal.requestPayload.ReactOnBlogInDto;
import com.blog.portal.responsePayload.ReactionOnBlogOutDto;
import com.blog.portal.services.ReactionService;
import com.blog.portal.serviceimpl.ReactionServiceImpl;
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

public class ReactionServiceImplTest {

    @Mock
    private ReactionRepository likeAndDislikeRepo;

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private ReactionService reactionService = new ReactionServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoReactOnPost_ReactLike_NewReaction() {
        ReactOnBlogInDto inDto = new ReactOnBlogInDto("userId", "postId", React.LIKE);
        Reaction userReaction = null;
        Blog blog = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(blog)).thenReturn(blog);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionOnBlogOutDto result = reactionService.doReactOnBlog(inDto);

        assertNotNull(result);
        assertEquals(React.LIKE, result.getType());
        assertTrue(blog.getLikedBy().contains("userId"));
        assertFalse(blog.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactDislike_NewReaction() {
        ReactOnBlogInDto inDto = new ReactOnBlogInDto("userId", "postId", React.DISLIKE);
        Reaction userReaction = null;
        Blog blog = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(blog)).thenReturn(blog);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionOnBlogOutDto result = reactionService.doReactOnBlog(inDto);

        assertNotNull(result);
        assertEquals(React.DISLIKE, result.getType());
        assertFalse(blog.getLikedBy().contains("userId"));
        assertTrue(blog.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactLike_UpdateReaction() {
        ReactOnBlogInDto inDto = new ReactOnBlogInDto("userId", "postId", React.LIKE);
        Reaction userReaction = createSampleReaction("userId", "postId", React.DISLIKE);
        Blog blog = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(blog)).thenReturn(blog);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionOnBlogOutDto result = reactionService.doReactOnBlog(inDto);

        assertNotNull(result);
        assertEquals(React.LIKE, result.getType());
        assertTrue(blog.getLikedBy().contains("userId"));
        assertFalse(blog.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_ReactDislike_UpdateReaction() {
        ReactOnBlogInDto inDto = new ReactOnBlogInDto("userId", "postId", React.DISLIKE);
        Reaction userReaction = createSampleReaction("userId", "postId", React.LIKE);
        Blog blog = createSamplePost();
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(userReaction);
        when(blogRepository.findById("postId")).thenReturn(Optional.of(blog));
        when(blogRepository.save(blog)).thenReturn(blog);
        when(likeAndDislikeRepo.save(any(Reaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ReactionOnBlogOutDto result = reactionService.doReactOnBlog(inDto);

        assertNotNull(result);
        assertEquals(React.DISLIKE, result.getType());
        assertFalse(blog.getLikedBy().contains("userId"));
        assertTrue(blog.getDisLikedBy().contains("userId"));
    }

    @Test
    public void testDoReactOnPost_PostNotFound() {
        ReactOnBlogInDto inDto = new ReactOnBlogInDto("userId", "postId", React.LIKE);
        when(likeAndDislikeRepo.findByUserIdAndPostId("userId", "postId")).thenReturn(null);
        when(blogRepository.findById("postId")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            reactionService.doReactOnBlog(inDto);
        });
    }

    private Blog createSamplePost() {
        Blog blog = new Blog();
        blog.setId("postId");
        blog.setLikedBy(new HashSet<>());
        blog.setDisLikedBy(new HashSet<>());
        return blog;
    }

    private Reaction createSampleReaction(String userId, String postId, React type) {
        Reaction reaction = new Reaction();
        reaction.setUserId(userId);
        reaction.setPostId(postId);
        reaction.setType(type);
        return reaction;
    }
}
