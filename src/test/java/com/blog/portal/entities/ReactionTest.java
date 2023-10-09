package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.React;


public class ReactionTest {

		/**
		 * Instance1 of  LikeOrDislike.
		 */
    private Reaction reaction1;
    /**
     * Insatnce2 of LikeorDislike.
     */
    private Reaction reaction2;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        reaction1 = new Reaction("1", "post123", "user456", React.LIKE);
        reaction2 = new Reaction("1", "post123", "user456", React.LIKE);
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
        reaction1.setId("2");
        reaction1.setPostId("post789");
        reaction1.setUserId("user789");
        reaction1.setType(React.DISLIKE);

        assertEquals("2", reaction1.getId());
        assertEquals("post789", reaction1.getPostId());
        assertEquals("user789", reaction1.getUserId());
        assertEquals(React.DISLIKE, reaction1.getType());
    }

    /**
     * Equals and Hashcode testing.
     */
    @Test
    public void testEqualsAndHashCode() {
        assertEquals(reaction1, reaction2);
     	 	assertEquals(reaction1, reaction1);
        assertFalse(reaction1.equals(null));
        assertFalse(reaction1.equals("SomeString")); 
        assertEquals(reaction1.hashCode(), reaction2.hashCode());
    }
    /**
     * toString testing.
     */
    @Test
    public void testToString() {
    	Reaction reaction = new Reaction("1", "123", "user123", React.LIKE);
      String expectedString = "Reaction [id=1, postId=123, userId=user123, type=LIKE]";
      assertEquals(expectedString, reaction.toString());
    }
}
