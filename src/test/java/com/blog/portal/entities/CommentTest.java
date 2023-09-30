package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommentTest {
		/**
		 * Instance 1 of Comment.
		 */
    private Comment comment1;
    /**
     * Instance 2 of Comment.
     */
    private Comment comment2;

    /**
     * Setup before testing.
     */
    @BeforeEach
    public void setUp() {
        comment1 = new Comment("1", "Test Content", "user123", "post456");
        comment2 = new Comment("1", "Test Content", "user123", "post456");
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testSetterAndGetters() {
        comment1.setId("2");
        comment1.setContent("Updated Content");
        comment1.setUserID("newUser");
        comment1.setPostId("newPost");

        assertEquals("2", comment1.getId());
        assertEquals("Updated Content", comment1.getContent());
        assertEquals("newUser", comment1.getUserId());
        assertEquals("newPost", comment1.getPostId());
    }

    /**
     * Test hashcode.
     */
    @Test
    public void testHashCode() {

        assertEquals(comment1.hashCode(), comment2.hashCode());
    }

    /**
     * Testing toString method.
     */
    @Test
    public void testToString() {
        String expectedToString = "Comment [id=1, content=Test Content, userId=user123, postId=post456]";
        assertEquals(expectedToString, comment1.toString());
    }
    @Test
    public void testEqualsMethod() {
        Comment comment = new Comment("Test Comment");

        assertTrue(comment.equals(comment));
    }
    @Test
    public void testEquals() {
        Comment comment1 = new Comment("1", "Test Comment", "user123", "post123");
        Comment comment2 = new Comment("1", "Test Comment", "user123", "post123");

        assertTrue(comment1.equals(comment2));
    }

    @Test
    public void testNotEquals() {
        Comment comment1 = new Comment("1", "Test Comment 1", "user123", "post123");
        Comment comment2 = new Comment("2", "Test Comment 2", "user123", "post123");

        assertFalse(comment1.equals(comment2));
    }

    @Test
    public void testNotEqualsWithNull() {
        Comment comment1 = new Comment("1", "Test Comment", "user123", "post123");

        assertFalse(comment1.equals(null));
    }

    @Test
    public void testDefaultConstructor() {
        Comment comment = new Comment();

        assertNotNull(comment);
        assertNull(comment.getId());
        assertNull(comment.getContent());
        assertNull(comment.getUserId());
        assertNull(comment.getPostId());
    }

    @Test
    public void testSingleParameterConstructor() {
        Comment comment = new Comment("Test Comment");

        assertNotNull(comment);
        assertNull(comment.getId());
        assertEquals("Test Comment", comment.getContent());
        assertNull(comment.getUserId());
        assertNull(comment.getPostId());
    }
}
