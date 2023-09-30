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
    private Reaction likeOrDislike1;
    /**
     * Insatnce2 of LikeorDislike.
     */
    private Reaction likeOrDislike2;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        likeOrDislike1 = new Reaction("1", "post123", "user456", React.LIKE);
        likeOrDislike2 = new Reaction("1", "post123", "user456", React.LIKE);
    }

    @Test
    public void testDefaultConstructor() {
    		Reaction likeOrDislike3 = new Reaction();
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
        likeOrDislike1.setId("2");
        likeOrDislike1.setPostId("post789");
        likeOrDislike1.setUserId("user789");
        likeOrDislike1.setType(React.DISLIKE);

        assertEquals("2", likeOrDislike1.getId());
        assertEquals("post789", likeOrDislike1.getPostId());
        assertEquals("user789", likeOrDislike1.getUserId());
        assertEquals(React.DISLIKE, likeOrDislike1.getType());
    }

    /**
     * Equals and Hashcode testing.
     */
    @Test
    public void testEqualsAndHashCode() {
        assertEquals(likeOrDislike1, likeOrDislike2);
     	 	assertEquals(likeOrDislike1, likeOrDislike1);
        assertFalse(likeOrDislike1.equals(null));
        assertFalse(likeOrDislike1.equals("SomeString")); 
        assertEquals(likeOrDislike1.hashCode(), likeOrDislike2.hashCode());
    }
    /**
     * toString testing.
     */
    @Test
    public void testToString() {
    	Reaction reaction = new Reaction("1", "123", "user123", React.LIKE);
      String expectedString = "LikeOrDislike [id=1, postId=123, userId=user123, type=LIKE]";
      assertEquals(expectedString, reaction.toString());
    }
}
