package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;


public class LikeOrDislikeTest {

		/**
		 * Instance1 of  LikeOrDislike.
		 */
    private LikeOrDislike likeOrDislike1;
    /**
     * Insatnce2 of LikeorDislike.
     */
    private LikeOrDislike likeOrDislike2;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        // Create two LikeOrDislike objects with the same values for testing equals and hashCode
        likeOrDislike1 = new LikeOrDislike("1", "post123", "user456", React.Like);
        likeOrDislike2 = new LikeOrDislike("1", "post123", "user456", React.Like);
    }

    @Test
    public void testDefaultConstructor() {
    		LikeOrDislike likeOrDislike3 = new LikeOrDislike();
        // Verify that properties are in their initial state
        assertNull(likeOrDislike3.getId());
        assertNull(likeOrDislike3.getPostId());
        assertNull(likeOrDislike3.getUserId());
        assertNull(likeOrDislike3.getType());
    }

    /**
     * Setter and Getter testing.
     */
    @Test
    public void testSetterAndGetters() {
        // Set values using setters
        likeOrDislike1.setId("2");
        likeOrDislike1.setPostId("post789");
        likeOrDislike1.setUserId("user789");
        likeOrDislike1.setType(React.Dislike);

        // Test getters to ensure values were set correctly
        assertEquals("2", likeOrDislike1.getId());
        assertEquals("post789", likeOrDislike1.getPostId());
        assertEquals("user789", likeOrDislike1.getUserId());
        assertEquals(React.Dislike, likeOrDislike1.getType());
    }

    /**
     * Equals and Hashcode testing.
     */
    @Test
    public void testEqualsAndHashCode() {
        // Test equals method
        assertEquals(likeOrDislike1, likeOrDislike2);
     	 	assertEquals(likeOrDislike1, likeOrDislike1);
        assertFalse(likeOrDislike1.equals(null));
        assertFalse(likeOrDislike1.equals("SomeString")); // Assuming "SomeString" is of a different class
        // Test hashCode method
        assertEquals(likeOrDislike1.hashCode(), likeOrDislike2.hashCode());
    }
    /**
     * toString testing.
     */
    @Test
    public void testToString() {
    	LikeOrDislike likeOrDislike = new LikeOrDislike("1", "123", "user123", React.Like);
      String expectedString = "LikeOrDislike [id=1, postId=123, userId=user123, type=Like]";
      assertEquals(expectedString, likeOrDislike.toString());
    }
}
