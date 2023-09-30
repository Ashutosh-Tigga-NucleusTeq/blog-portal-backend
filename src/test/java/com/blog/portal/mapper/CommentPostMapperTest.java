package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Comment;
import com.blog.portal.requestPayload.CommentPostInDto;
import com.blog.portal.responsePayload.CommentPostOutDto;

public class CommentPostMapperTest {

	/**
	 * Testing of inDto to Entity.
	 */
    @Test
    public void testInDtoToEntity() {
        CommentPostInDto inDto = new CommentPostInDto();
        inDto.setContent("This is a test comment");
        inDto.setPostId("1");
        inDto.setUserId("user123");

        Comment comment = CommentPostMapper.inDtoToEntity(inDto);

        assertEquals("This is a test comment", comment.getContent());
        assertEquals("1", comment.getPostId());
        assertEquals("user123", comment.getUserId());
    }

    /**
     * Testing of Entity to outDto.
     */
    @Test
    public void testEntityToOutDto() {
        Comment comment = new Comment();
        comment.setId("comment123");
        comment.setContent("This is a test comment");
        comment.setPostId("1");
        comment.setUserID("user123");

        CommentPostOutDto outDto = CommentPostMapper.entityToOutDto(comment);

        assertEquals("This is a test comment", outDto.getContent());
        assertEquals("1", outDto.getPostId());
        assertEquals("comment123", outDto.getId());
        assertEquals("user123", outDto.getUserId());
    }
}
