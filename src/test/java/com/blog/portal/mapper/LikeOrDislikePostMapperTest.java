package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Reaction;
import com.blog.portal.enumResource.React;
import com.blog.portal.requestPayload.ReactionPostInDto;
import com.blog.portal.responsePayload.ReactionPostOutDto;

public class LikeOrDislikePostMapperTest {
		
    @Test
    public void testInDtoToEntity() {
        ReactionPostInDto inDto = new ReactionPostInDto();
        inDto.setPostId("post123");
        inDto.setUserId("user123");
        inDto.setType(React.LIKE);

        Reaction reaction = ReactionPostMapper.inDtoToEntity(inDto);

        assertEquals("post123", reaction.getPostId());
        assertEquals("user123", reaction.getUserId());
        assertEquals(React.LIKE, reaction.getType());
    }

    @Test
    public void testEntityToOutDto() {
        Reaction reaction = new Reaction();
        reaction.setId("like123");
        reaction.setPostId("post123");
        reaction.setUserId("user123");
        reaction.setType(React.LIKE);

        ReactionPostOutDto outDto = ReactionPostMapper.entityToOutDto(reaction);

        assertEquals("like123", outDto.getId());
        assertEquals("post123", outDto.getPostId());
        assertEquals("user123", outDto.getUserId());
        assertEquals(React.LIKE, outDto.getType());
    }
}
