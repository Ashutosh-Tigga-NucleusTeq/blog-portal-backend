package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;

public class LikeOrDislikePostOutDtoTest {
		/**
		 * Testing Default constructor.
		 */
    @Test
    public void testDefaultConstructor() {
        ReactionPostOutDto dto = new ReactionPostOutDto();
        assertNull(dto.getId());
        assertNull(dto.getPostId());
        assertNull(dto.getUserId());
        assertNull(dto.getType());
    }
    /**
     * Testing parameterized constructor.
     */
    @Test
    public void testParameterizedConstructor() {
        ReactionPostOutDto dto = new ReactionPostOutDto("1", "post1", "user1", React.LIKE);
        assertEquals("1", dto.getId());
        assertEquals("post1", dto.getPostId());
        assertEquals("user1", dto.getUserId());
        assertEquals(React.LIKE, dto.getType());
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testSetterAndGetterMethods() {
        ReactionPostOutDto dto = new ReactionPostOutDto();
        dto.setId("2");
        dto.setPostId("post2");
        dto.setUserId("user2");
        dto.setType(React.DISLIKE);

        assertEquals("2", dto.getId());
        assertEquals("post2", dto.getPostId());
        assertEquals("user2", dto.getUserId());
        assertEquals(React.DISLIKE, dto.getType());
    }

    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCodeAndEquals() {
        ReactionPostOutDto dto1 = new ReactionPostOutDto("1", "post1", "user1", React.LIKE);
        ReactionPostOutDto dto2 = new ReactionPostOutDto("1", "post1", "user1", React.LIKE);
        ReactionPostOutDto dto3 = new ReactionPostOutDto("2", "post2", "user2", React.DISLIKE);

        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());

        assertEquals(dto1, dto2);
        assertNotEquals(dto1, dto3);
    }
    /**
     * Testing tostring.
     */
    @Test
    public void testToString() {
        ReactionPostOutDto dto = new ReactionPostOutDto("1", "post1", "user1", React.LIKE);
        String expectedString = "ReactionPostOutDto [id=1, postId=post1, userId=user1, type=LIKE]";
        assertEquals(expectedString, dto.toString());
    }
}
