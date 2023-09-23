package com.blog.portal.requestPayload;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CommentPostInDtoTest {
	/**
	 * Instance of CommentPostInDto.
	 */
    private CommentPostInDto comment;

    /**
     * Setting up before testing.
     */
    @Before
    public void setUp() {
        comment = new CommentPostInDto("This is a comment.", "user123", "post456");
    }

    /**
     * Testing Getter and Setter.
     */
    @Test
    public void testGetterSetterMethods() {
        assertEquals("This is a comment.", comment.getContent());
        assertEquals("user123", comment.getUserId());
        assertEquals("post456", comment.getPostId());

        comment.setContent("Updated comment.");
        comment.setUserId("newUser");
        comment.setPostId("newPost");

        assertEquals("Updated comment.", comment.getContent());
        assertEquals("newUser", comment.getUserId());
        assertEquals("newPost", comment.getPostId());
    }

    /**
     * Testing equals and Hashcode.
     */
    @Test
    public void testEqualsAndHashCode() {
        CommentPostInDto sameComment = new CommentPostInDto("This is a comment.", "user123", "post456");
        CommentPostInDto differentComment = new CommentPostInDto("Different comment.", "user789", "post123");

        assertEquals(comment, sameComment);

        assertNotEquals(comment, differentComment);

        assertEquals(comment.hashCode(), sameComment.hashCode());

        assertNotEquals(comment.hashCode(), differentComment.hashCode());
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        String expected = "CommentPostInDto [content=This is a comment., userId=user123, postId=post456]";
        assertEquals(expected, comment.toString());
    }
}
