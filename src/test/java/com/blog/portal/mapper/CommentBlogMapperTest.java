package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Comment;
import com.blog.portal.requestPayload.CommentOnBlogInDto;
import com.blog.portal.responsePayload.CommentsOutDto;

public class CommentBlogMapperTest {

	
    @Test
    public void testInDtoToEntity() {
        CommentOnBlogInDto inDto = new CommentOnBlogInDto();
        inDto.setContent("This is a test comment");
        inDto.setPostId("1");
        inDto.setUserId("user123");

        Comment comment = CommentBlogMapper.inDtoToEntity(inDto);

        assertEquals("This is a test comment", comment.getContent());
        assertEquals("1", comment.getPostId());
        assertEquals("user123", comment.getUserId());
    }


    @Test
    public void testEntityToOutDto() {
        Comment comment = new Comment();
        comment.setId("comment123");
        comment.setContent("This is a test comment");
        comment.setPostId("1");
        comment.setUserID("user123");

        CommentsOutDto outDto = CommentBlogMapper.entityToOutDto(comment);

        assertEquals("This is a test comment", outDto.getContent());
        assertEquals("1", outDto.getPostId());
        assertEquals("comment123", outDto.getId());
        assertEquals("user123", outDto.getUserId());
    }
}
