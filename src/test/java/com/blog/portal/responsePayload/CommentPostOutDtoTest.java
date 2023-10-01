package com.blog.portal.responsePayload;

import com.blog.portal.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CommentPostOutDtoTest {

    private CommentPostOutDto comment1;
    private CommentPostOutDto comment2;
    private CommentPostOutDto comment3;

    @BeforeEach
    public void setUp() {
        comment1 = new CommentPostOutDto("1", "Great post!", "user1", "post1");
        comment2 = new CommentPostOutDto("2", "Nice article.", "user2", "post1");
        comment3 = new CommentPostOutDto("1", "Great post!", "user1", "post1");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", comment1.getId());
        assertEquals("Great post!", comment1.getContent());
        assertEquals("user1", comment1.getUserId());
        assertEquals("post1", comment1.getPostId());

        // Test setters
        comment1.setId("3");
        comment1.setContent("Updated comment");
        comment1.setUserId("user3");
        comment1.setPostId("post3");

        assertEquals("3", comment1.getId());
        assertEquals("Updated comment", comment1.getContent());
        assertEquals("user3", comment1.getUserId());
        assertEquals("post3", comment1.getPostId());
    }

    @Test
    public void testConstructors() {
        assertEquals("1", comment1.getId());
        assertEquals("Great post!", comment1.getContent());
        assertEquals("user1", comment1.getUserId());
        assertEquals("post1", comment1.getPostId());

        CommentPostOutDto defaultComment = new CommentPostOutDto();
        assertNull(defaultComment.getId());
        assertNull(defaultComment.getContent());
        assertNull(defaultComment.getUserId());
        assertNull(defaultComment.getPostId());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(comment1.equals(comment1));
        assertEquals(comment1.hashCode(), comment1.hashCode());

        assertTrue(comment1.equals(comment3));
        assertTrue(comment3.equals(comment1));
        assertEquals(comment1.hashCode(), comment3.hashCode());

        assertFalse(comment1.equals(null));
        assertFalse(comment1.equals("string"));

        assertFalse(comment1.equals(comment2));
        assertFalse(comment2.equals(comment1));
        assertNotEquals(comment1.hashCode(), comment2.hashCode());

        comment2.setContent("Updated comment");
        assertFalse(comment1.equals(comment2));
    }

    @Test
    public void testToString() {
        String expectedToString = "CommentPostOutDto [id=1, content=Great post!, userId=user1, postId=post1]";
        assertEquals(expectedToString, comment1.toString());
    }
}
