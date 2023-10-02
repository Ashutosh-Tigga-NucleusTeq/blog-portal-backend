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
import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.exception.ResourceNotFoundException;
import com.blog.portal.repository.BlogRepository;
import com.blog.portal.repository.UserRepository;
import com.blog.portal.repository.CommentRepository;
import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responseMessage.ApiResponse;
import com.blog.portal.responsePayload.CommentsOutDto;
import com.blog.portal.services.CommentService;
import com.blog.portal.util.ResponseMessage;

@SpringBootTest
public class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private CommentService commentService = new CommentServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoCommentOnPost() {
        CommentOnBlogInDto inDto = new CommentOnBlogInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        User mockUser = new User();
        mockUser.setId("user123");
        mockUser.setPassword("password"); 
        when(userRepository.findById("user123")).thenReturn(Optional.of(mockUser));

        Blog mockPost = new Blog();
        mockPost.setId("post123");
        mockPost.setCommentBy(new ArrayList<>());
        when(blogRepository.findById("post123")).thenReturn(Optional.of(mockPost));

        Comment mockComment = new Comment();
        when(commentRepository.save(any(Comment.class))).thenReturn(mockComment);

        ApiResponse response = commentService.doCommentOnBlog(inDto);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals(ResponseMessage.COMMENT_ON_BLOG_SUCCESS, response.getMessage());
        assertNull(mockUser.getPassword()); 

        assertTrue(mockPost.getCommentBy().contains("user123"));
    }

    @Test
    public void testDoCommentOnPost_UserNotFound() {
        CommentOnBlogInDto inDto = new CommentOnBlogInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        when(userRepository.findById("user123")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.doCommentOnBlog(inDto);
        });
    }

    @Test
    public void testDoCommentOnPost_PostNotFound() {
        CommentOnBlogInDto inDto = new CommentOnBlogInDto();
        inDto.setUserId("user123");
        inDto.setPostId("post123");
        inDto.setContent("This is a test comment");

        when(userRepository.findById("user123")).thenReturn(Optional.of(new User()));
        when(blogRepository.findById("post123")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            commentService.doCommentOnBlog(inDto);
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

        when(commentRepository.findByPostId("post123")).thenReturn(comments);

        List<CommentsOutDto> response = commentService.getComments("post123");

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("Comment 1", response.get(0).getContent());
        assertEquals("Comment 2", response.get(1).getContent());
    }
}
