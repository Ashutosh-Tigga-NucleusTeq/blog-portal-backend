package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CommentPostOutDtoTest {

	/**
	 * Instance of CommentPostOutDto.
	 */
    private CommentPostOutDto comment;

    /**
     * Settting up before testing.
     */
    @Before
    public void setUp() {
        comment = new CommentPostOutDto("1", "Test Comment", "user1", "post1");
    }

    /**
     *Testing of setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        assertEquals("1", comment.getId());
        assertEquals("Test Comment", comment.getContent());
        assertEquals("user1", comment.getUserId());
        assertEquals("post1", comment.getPostId());

        comment.setId("2");
        comment.setContent("Updated Comment");
        comment.setUserId("user2");
        comment.setPostId("post2");

        assertEquals("2", comment.getId());
        assertEquals("Updated Comment", comment.getContent());
        assertEquals("user2", comment.getUserId());
        assertEquals("post2", comment.getPostId());
    }

    /**
     * Testing of hashcode.
     */
    @Test
    public void testEqualsAndHashCode() {
        CommentPostOutDto anotherComment = new CommentPostOutDto("1", "Test Comment", "user1", "post1");
        CommentPostOutDto differentComment = new CommentPostOutDto("2", "Different Comment", "user2", "post2");

        assertTrue(comment.equals(anotherComment));
        assertTrue(comment.hashCode() == anotherComment.hashCode());

        assertFalse(comment.equals(differentComment));
        assertFalse(comment.hashCode() == differentComment.hashCode());
    }

    /**
     * Testing of toString.
     */
    @Test
    public void testToString() {
        String expectedString = "CommentPostOutDto [id=1, content=Test Comment, userId=user1, postId=post1]";
        assertEquals(expectedString, comment.toString());
    }
}
