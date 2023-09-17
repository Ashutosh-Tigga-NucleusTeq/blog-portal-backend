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
        LikeOrDislikePostOutDto dto = new LikeOrDislikePostOutDto();
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
        LikeOrDislikePostOutDto dto = new LikeOrDislikePostOutDto("1", "post1", "user1", React.Like);
        assertEquals("1", dto.getId());
        assertEquals("post1", dto.getPostId());
        assertEquals("user1", dto.getUserId());
        assertEquals(React.Like, dto.getType());
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testSetterAndGetterMethods() {
        LikeOrDislikePostOutDto dto = new LikeOrDislikePostOutDto();
        dto.setId("2");
        dto.setPostId("post2");
        dto.setUserId("user2");
        dto.setType(React.Dislike);

        assertEquals("2", dto.getId());
        assertEquals("post2", dto.getPostId());
        assertEquals("user2", dto.getUserId());
        assertEquals(React.Dislike, dto.getType());
    }

    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCodeAndEquals() {
        LikeOrDislikePostOutDto dto1 = new LikeOrDislikePostOutDto("1", "post1", "user1", React.Like);
        LikeOrDislikePostOutDto dto2 = new LikeOrDislikePostOutDto("1", "post1", "user1", React.Like);
        LikeOrDislikePostOutDto dto3 = new LikeOrDislikePostOutDto("2", "post2", "user2", React.Dislike);

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
        LikeOrDislikePostOutDto dto = new LikeOrDislikePostOutDto("1", "post1", "user1", React.Like);
        String expectedString = "LikeOrDislikePostOutDto [id=1, postId=post1, userId=user1, type=Like]";
        assertEquals(expectedString, dto.toString());
    }
}
