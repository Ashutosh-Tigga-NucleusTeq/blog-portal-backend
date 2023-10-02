package com.blog.portal.responsePayload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UnReviewedBlogsOutDtoTest {

    private UnReviewedBlogsOutDto post1;
    private UnReviewedBlogsOutDto post2;

    @BeforeEach
    public void setUp() {
        Date createdAt = new Date(12);
        post1 = new UnReviewedBlogsOutDto("User1", "Title1", "Content1", createdAt, "1");
        post2 = new UnReviewedBlogsOutDto("User2", "Title2", "Content2", createdAt, "2");
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("User1", post1.getUserName());
        assertEquals("Title1", post1.getTitle());
        assertEquals("Content1", post1.getContent());
        assertEquals("1", post1.getId());
        assertEquals("User2", post2.getUserName());
        assertEquals("Title2", post2.getTitle());
        assertEquals("Content2", post2.getContent());
        assertEquals("2", post2.getId());

        Date newCreatedAt = new Date();
        post1.setUserName("User3");
        post1.setTitle("Title3");
        post1.setContent("Content3");
        post1.setCreatedAt(newCreatedAt);
        post1.setId("3");

        assertEquals("User3", post1.getUserName());
        assertEquals("Title3", post1.getTitle());
        assertEquals("Content3", post1.getContent());
        assertEquals("3", post1.getId());
        assertEquals(newCreatedAt, post1.getCreatedAt());
    }

    @Test
    public void testConstructors() {
        assertEquals("User1", post1.getUserName());
        assertEquals("Title1", post1.getTitle());
        assertEquals("Content1", post1.getContent());
        assertEquals("1", post1.getId());
        assertNotNull(post1.getCreatedAt());

        UnReviewedBlogsOutDto defaultPost = new UnReviewedBlogsOutDto();
        assertNull(defaultPost.getUserName());
        assertNull(defaultPost.getTitle());
        assertNull(defaultPost.getContent());
        assertNull(defaultPost.getId());
        assertNull(null);
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(post1.equals(post1));
        assertEquals(post1.hashCode(), post1.hashCode());

        assertFalse(post1.equals(post2));
        assertFalse(post2.equals(post1));
        assertEquals(post1.hashCode(), post1.hashCode());

        assertFalse(post1.equals(null));
        assertFalse(post1.equals("string"));

        post2.setUserName("User4");
        assertFalse(post1.equals(post2));
    }

    @Test
    public void testToString() {
        String expectedToString = "UnReviewedBlogsOutDto [userName=User1, title=Title1, content=Content1, createdAt="
                + post1.getCreatedAt() + ", id=1]";
        assertEquals(expectedToString, post1.toString());
    }
}
