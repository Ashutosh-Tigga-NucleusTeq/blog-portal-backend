package com.blog.portal.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.blog.portal.entities.Comment;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.repository.BlogPostRepo;
import com.blog.portal.repository.BlogUserRepo;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;
import com.blog.portal.util.ResponseMessage;

@SpringBootTest
public class CommentPostServiceImplTest {

    @Mock
    private CommentPostRepo commentPostRepo;

    @Mock
    private BlogUserRepo blogUserRepo;

    @Mock
    private BlogPostRepo blogPostRepo;

    @InjectMocks
    private CommentPostService commentPostService = new CommentPostServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoCommentOnPost() {
        CommentPostInDto inDto = new CommentPostInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        User mockUser = new User();
        mockUser.setId("user123");
        mockUser.setPassword("password"); 
        when(blogUserRepo.findById("user123")).thenReturn(Optional.of(mockUser));

        Post mockPost = new Post();
        mockPost.setId("post123");
        mockPost.setCommentBy(new ArrayList<>());
        when(blogPostRepo.findById("post123")).thenReturn(Optional.of(mockPost));

        Comment mockComment = new Comment();
        when(commentPostRepo.save(any(Comment.class))).thenReturn(mockComment);

        ApiResponse response = commentPostService.doCommentOnPost(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.COMMENT_ON_BLOG_SUCCESS, response.getMessage());
        assertNull(mockUser.getPassword()); 

        assertTrue(mockPost.getCommentBy().contains("user123"));
    }

    @Test
    public void testDoCommentOnPost_UserNotFound() {
        CommentPostInDto inDto = new CommentPostInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        when(blogUserRepo.findById("user123")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentPostService.doCommentOnPost(inDto);
        });
    }

    @Test
    public void testDoCommentOnPost_PostNotFound() {
        CommentPostInDto inDto = new CommentPostInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        when(blogUserRepo.findById("user123")).thenReturn(Optional.of(new User()));
        when(blogPostRepo.findById("post123")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentPostService.doCommentOnPost(inDto);
        });
    }

    @Test
    public void testGetComments() {
        List<Comment> comments = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setContent("Comment 1");
        Comment comment2 = new Comment();
        comment2.setContent("Comment 2");
        comments.add(comment1);
        comments.add(comment2);

        when(commentPostRepo.findByPostId("post123")).thenReturn(comments);

        List<CommentPostOutDto> response = commentPostService.getComments("post123");

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("Comment 1", response.get(0).getContent());
        assertEquals("Comment 2", response.get(1).getContent());
    }
}
