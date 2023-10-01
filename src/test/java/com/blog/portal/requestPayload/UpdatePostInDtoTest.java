package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UpdatePostInDtoTest {
	
    private UpdatePostInDto post1;
    
    private UpdatePostInDto post2;
    
    private UpdatePostInDto post3;


    @BeforeEach
    public void setUp() {
        post1 = new UpdatePostInDto("1", "Title 1", "Content 1");
        post2 = new UpdatePostInDto("2", "Title 2", "Content 2");
        post3 = new UpdatePostInDto("1", "Title 1", "Content 1");
    }


    @Test
    public void testToString() {
        assertEquals("UpdatePostInDto [id=1, title=Title 1, content=Content 1]", post1.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(post1.hashCode(), post3.hashCode());
        assertNotEquals(post1.hashCode(), post2.hashCode());
    }

   @Test
    public void testEquals() {
        assertTrue(post1.equals(post3));
        assertTrue(post3.equals(post1));
        assertNotEquals(post1, post2);
        assertNotEquals(post2, post1);
    }
}
