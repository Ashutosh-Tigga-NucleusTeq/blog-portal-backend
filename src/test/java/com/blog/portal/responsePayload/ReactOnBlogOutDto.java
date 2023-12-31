package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;

public class ReactOnBlogOutDto {
	
    @Test
    public void testDefaultConstructor() {
        ReactionBlogOutDto dto = new ReactionBlogOutDto();
        assertNull(dto.getId());
        assertNull(dto.getPostId());
        assertNull(dto.getUserId());
        assertNull(dto.getType());
    }

    @Test
    public void testParameterizedConstructor() {
        ReactionBlogOutDto dto = new ReactionBlogOutDto("1", "post1", "user1", React.LIKE);
        assertEquals("1", dto.getId());
        assertEquals("post1", dto.getPostId());
        assertEquals("user1", dto.getUserId());
        assertEquals(React.LIKE, dto.getType());
    }


    @Test
    public void testSetterAndGetterMethods() {
        ReactionBlogOutDto dto = new ReactionBlogOutDto();
        dto.setId("2");
        dto.setPostId("post2");
        dto.setUserId("user2");
        dto.setType(React.DISLIKE);

        assertEquals("2", dto.getId());
        assertEquals("post2", dto.getPostId());
        assertEquals("user2", dto.getUserId());
        assertEquals(React.DISLIKE, dto.getType());
    }


    @Test
    public void testHashCodeAndEquals() {
        ReactionBlogOutDto dto1 = new ReactionBlogOutDto("1", "post1", "user1", React.LIKE);
        ReactionBlogOutDto dto2 = new ReactionBlogOutDto("1", "post1", "user1", React.LIKE);
        ReactionBlogOutDto dto3 = new ReactionBlogOutDto("2", "post2", "user2", React.DISLIKE);

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
    }

    @Test
    public void testToString() {
        ReactionBlogOutDto dto = new ReactionBlogOutDto("1", "post1", "user1", React.LIKE);
        String expectedString = "ReactionBlogOutDto [id=1, postId=post1, userId=user1, type=LIKE]";
        assertEquals(expectedString, dto.toString());
    }
}
