package com.blog.portal.responsePayload;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Date;

public class UnReviewedPostOutDtoTest {
    
    private UnReviewedPostOutDto postDto;
    
    @Before
    public void setUp() {
        // Create a sample UnReviewedPostOutDto object for testing
        postDto = new UnReviewedPostOutDto("fullname", "Test Post", "This is a test post.", new Date(), "12345");
    }

    @Test
    public void testGettersAndSetters() {
        // Test all getters and setters
        
        // Test getUserName and setUserName
        assertEquals("fullname", postDto.getUserName());
        postDto.setUserName("JaneSmith");
        assertEquals("JaneSmith", postDto.getUserName());

        // Test getTitle and setTitle
        assertEquals("Test Post", postDto.getTitle());
        postDto.setTitle("Updated Post");
        assertEquals("Updated Post", postDto.getTitle());

        // Test getContent and setContent
        assertEquals("This is a test post.", postDto.getContent());
        postDto.setContent("Updated content.");
        assertEquals("Updated content.", postDto.getContent());

        // Test getCreatedAt
        assertNotNull(postDto.getCreatedAt());
    }

    @Test
    public void testHashCode() {
        // Create another UnReviewedPostOutDto object with the same values
        UnReviewedPostOutDto identicalDto = new UnReviewedPostOutDto("fullname", "Test Post", "This is a test post.", postDto.getCreatedAt(), "12345");

        // Ensure that the hash codes of both objects are equal
        assertEquals(postDto.hashCode(), identicalDto.hashCode());
    }

    @Test
    public void testEquals() {
        // Create another UnReviewedPostOutDto object with the same values
        UnReviewedPostOutDto identicalDto = new UnReviewedPostOutDto("fullname", "Test Post", "This is a test post.", postDto.getCreatedAt(), "12345");

        // Create a different UnReviewedPostOutDto object
        UnReviewedPostOutDto differentDto = new UnReviewedPostOutDto("JaneSmith", "Different Post", "This is a different post.", new Date(), "54321");

        // Test equality with an identical object
        assertTrue(postDto.equals(identicalDto));

        // Test equality with a different object
        assertFalse(postDto.equals(differentDto));
    }

    @Test
    public void testToString() {
        String expectedToString = "UnReviewedPostOutDto [userName=fullname, title=Test Post, content=This is a test post., createdAt=" + postDto.getCreatedAt() + ", id=12345]";
        assertEquals(expectedToString, postDto.toString());
    }
}
