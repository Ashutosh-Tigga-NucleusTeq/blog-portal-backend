package com.blog.portal.serviceimpl;

import com.blog.portal.entities.Comment;
import com.blog.portal.mapper.CommentPostMapper;
import com.blog.portal.repository.CommentPostRepo;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;
import com.blog.portal.services.CommentPostService;
import com.blog.portal.serviceimpl.CommentPostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@SpringBootTest
public class CommentPostServiceImplTest {

    @InjectMocks
    private CommentPostServiceImpl commentPostService;

    @Mock
    private CommentPostRepo commentPostRepo;

    @BeforeEach
    public void setup() {
        Mockito.when(commentPostRepo.save(any(Comment.class))).thenAnswer(invocation -> {
            Comment comment = invocation.getArgument(0);
            comment.setId("comment123"); // Set a sample ID for the saved comment
            return comment;
        });
    }

    @Test
    public void testDoCommentOnPost() {
        // Create a sample input DTO
        CommentPostInDto inDto = new CommentPostInDto("Sample Comment", "user123", "post123");

        // Call the service method
        CommentPostOutDto outDto = commentPostService.doCommentOnPost(inDto);

        // Verify the response
        assertEquals("comment123", outDto.getId());
        assertEquals("Sample Comment", outDto.getContent());
        assertEquals("user123", outDto.getUserId());
        assertEquals("post123", outDto.getPostId());
    }

    @Test
    public void testGetComments() {
        // Define a sample postId
        String postId = "post123";

        // Create a sample list of Comment entities
        List<Comment> commentList = new ArrayList<>();
        commentList.add(new Comment("comment1", "Sample Comment 1", "user123", "post123"));
        commentList.add(new Comment("comment2", "Sample Comment 2", "user456", "post123"));

        // Mock the repository to return the sample list when called with postId
        Mockito.when(commentPostRepo.findByPostId(eq(postId))).thenReturn(commentList);

        // Call the service method
        List<CommentPostOutDto> outDtoList = commentPostService.getComments(postId);

        // Verify the response
        assertEquals(2, outDtoList.size());
        assertEquals("comment1", outDtoList.get(0).getId());
        assertEquals("Sample Comment 1", outDtoList.get(0).getContent());
        assertEquals("user123", outDtoList.get(0).getUserId());
        assertEquals("post123", outDtoList.get(0).getPostId());
    }
}
