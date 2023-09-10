package com.example.demo.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A JUnit test class for the Comment class.
 */
public class CommentTest {

    private Comment comment;

    /**
     * Initializes a new instance of Comment before each test.
     */
    @BeforeEach
    public void setUp() {
    		User user = new User();
    		user.setId("userid");
    		Post post = new Post();
    		post.setId("postid");
        comment = new Comment("1", "Test comment content", user, post);
    }

    /**
     * Test constructor, getter methods, equals(), hashCode(), and toString().
     */
    @Test
    public void testAllMethods() {
        // Test constructor and getter methods
        assertEquals("1", comment.getId());
        assertEquals("Test comment content", comment.getContent());
        assertEquals("user1", comment.getUserId());
        assertEquals("post1", comment.getPostId());

        // Test equals() method
        Comment sameComment = new Comment("1", "Test comment content", "user1", "post1");
        Comment differentComment = new Comment("2", "Different content", "user2", "post2");

        assertEquals(comment, sameComment);
        assertNotEquals(comment, differentComment);

        // Test hashCode() method
        assertEquals(comment.hashCode(), sameComment.hashCode());
        assertNotEquals(comment.hashCode(), differentComment.hashCode());

        // Test toString() method
        String expectedString = "Comment [id=1, content=Test comment content, userId=user1, postId=post1]";
        assertEquals(expectedString, comment.toString());
    }
}
