package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdatePostInDtoTest {
	/**
	 * Instance of UpdatePostInDto.
	 */
    private UpdatePostInDto post1;
    /**
  	 * Instance2 of UpdatePostInDto.
  	 */
    private UpdatePostInDto post2;
    /**
  	 * Instance3 of UpdatePostInDto.
  	 */
    private UpdatePostInDto post3;

    /**
     * Setting up before tesing.
     */
    @BeforeEach
    public void setUp() {
        post1 = new UpdatePostInDto("1", "Title 1", "Content 1");
        post2 = new UpdatePostInDto("2", "Title 2", "Content 2");
        post3 = new UpdatePostInDto("1", "Title 1", "Content 1");
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        assertEquals("UpdatePostInDto [id=1, title=Title 1, content=Content 1]", post1.toString());
    }
    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCode() {
        assertEquals(post1.hashCode(), post3.hashCode());
        assertNotEquals(post1.hashCode(), post2.hashCode());
    }

    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        assertTrue(post1.equals(post3));
        assertTrue(post3.equals(post1));
        assertNotEquals(post1, post2);
        assertNotEquals(post2, post1);
    }
}
