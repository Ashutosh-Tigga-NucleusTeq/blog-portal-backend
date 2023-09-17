package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.LikeOrDislike;
import com.blog.portal.enumResource.React;
import com.blog.portal.requestPayload.LikeOrDislikePostInDto;
import com.blog.portal.responsePayload.LikeOrDislikePostOutDto;

public class LikeOrDislikePostMapperTest {
		/**
		 * Testing inDto to Entity method mapper.
		 */
    @Test
    public void testInDtoToEntity() {
        // Arrange
        LikeOrDislikePostInDto inDto = new LikeOrDislikePostInDto();
        inDto.setPostId("post123");
        inDto.setUserId("user123");
        inDto.setType(React.Like);

        // Act
        LikeOrDislike likeOrDislike = LikeOrDislikePostMapper.inDtoToEntity(inDto);

        // Assert
        assertEquals("post123", likeOrDislike.getPostId());
        assertEquals("user123", likeOrDislike.getUserId());
        assertEquals(React.Like, likeOrDislike.getType());
    }
    /**
     * Testing of Entity to OutDto method mapper.
     */
    @Test
    public void testEntityToOutDto() {
        // Arrange
        LikeOrDislike likeOrDislike = new LikeOrDislike();
        likeOrDislike.setId("like123");
        likeOrDislike.setPostId("post123");
        likeOrDislike.setUserId("user123");
        likeOrDislike.setType(React.Like);

        // Act
        LikeOrDislikePostOutDto outDto = LikeOrDislikePostMapper.entityToOutDto(likeOrDislike);

        // Assert
        assertEquals("like123", outDto.getId());
        assertEquals("post123", outDto.getPostId());
        assertEquals("user123", outDto.getUserId());
        assertEquals(React.Like, outDto.getType());
    }
}
