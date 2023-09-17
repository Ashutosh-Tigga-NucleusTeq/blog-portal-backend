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
        // Create two Comment objects with the same values for testing equals and hashCode
        comment1 = new Comment("1", "Test Content", "user123", "post456");
        comment2 = new Comment("1", "Test Content", "user123", "post456");
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testSetterAndGetters() {
        // Set values using setters
        comment1.setId("2");
        comment1.setContent("Updated Content");
        comment1.setUserId("newUser");
        comment1.setPostId("newPost");

        // Test getters to ensure values were set correctly
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

        // Test hashCode method
        assertEquals(comment1.hashCode(), comment2.hashCode());
    }

    /**
     * Testing toString method.
     */
    @Test
    public void testToString() {
        // Test toString method
        String expectedToString = "Comment [id=1, content=Test Content, userId=user123, postId=post456]";
        assertEquals(expectedToString, comment1.toString());
    }
    @Test
    public void testEqualsMethod() {
        // Create a comment object
        Comment comment = new Comment("Test Comment");

        // Test if the comment is equal to itself
        assertTrue(comment.equals(comment));
    }
    @Test
    public void testEquals() {
        // Create two comment objects with the same content, userId, and postId
        Comment comment1 = new Comment("1", "Test Comment", "user123", "post123");
        Comment comment2 = new Comment("1", "Test Comment", "user123", "post123");

        // Check if the comments are equal
        assertTrue(comment1.equals(comment2));
    }

    @Test
    public void testNotEquals() {
        // Create two comment objects with different content
        Comment comment1 = new Comment("1", "Test Comment 1", "user123", "post123");
        Comment comment2 = new Comment("2", "Test Comment 2", "user123", "post123");

        // Check if the comments are not equal
        assertFalse(comment1.equals(comment2));
    }

    @Test
    public void testNotEqualsWithNull() {
        // Create a comment object
        Comment comment1 = new Comment("1", "Test Comment", "user123", "post123");

        // Check if the comment is not equal to null
        assertFalse(comment1.equals(null));
    }

    @Test
    public void testDefaultConstructor() {
        // Create a comment object using the default constructor
        Comment comment = new Comment();

        // Check if the comment is not null
        assertNotNull(comment);
        // Check if the id is null (default value)
        assertNull(comment.getId());
        // Check if the content is null (default value)
        assertNull(comment.getContent());
        // Check if the userId is null (default value)
        assertNull(comment.getUserId());
        // Check if the postId is null (default value)
        assertNull(comment.getPostId());
    }

    @Test
    public void testSingleParameterConstructor() {
        // Create a comment object using the single-parameter constructor
        Comment comment = new Comment("Test Comment");

        // Check if the comment is not null
        assertNotNull(comment);
        // Check if the id is null (default value)
        assertNull(comment.getId());
        // Check if the content is set correctly
        assertEquals("Test Comment", comment.getContent());
        // Check if the userId is null (default value)
        assertNull(comment.getUserId());
        // Check if the postId is null (default value)
        assertNull(comment.getPostId());
    }
}
