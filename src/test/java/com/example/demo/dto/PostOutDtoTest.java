package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

public class PostOutDtoTest {
		/**
		 * Setter and Getter testing.
		 */
    @Test
    void testGettersAndSetters() {
        // Create a PostOutDto object
        PostOutDto postOutDto = new PostOutDto();
        User user = new User();
        user.setId("userid");
        // Set values using setters
        postOutDto.setTitle("title");
        postOutDto.setContent("content");
        Date createdAt = new Date();
        postOutDto.setCreatedAt(createdAt);
        postOutDto.setTechCategory(TechnologyCategory.Java);
        postOutDto.setAuthorId(user);

        // Check if values can be retrieved using getters
        assertEquals("title", postOutDto.getTitle());
        assertEquals("content", postOutDto.getContent());
        assertEquals(createdAt, postOutDto.getCreatedAt());
        assertEquals(TechnologyCategory.Java, postOutDto.getTechCategory());
        assertEquals("userid", postOutDto.getAuthorId());
    }

    /**
     * toString method testing.
     */
    @Test
    void testToString() {
        // Create a PostOutDto object and set values
        PostOutDto postOutDto = new PostOutDto();
        postOutDto.setTitle("title");
        postOutDto.setContent("content");
        Date createdAt = new Date();
        postOutDto.setCreatedAt(createdAt);
        postOutDto.setTechCategory(TechnologyCategory.Java);

        // Define the expected string representation
        String expectedToString = "PostOutDto [minTitle=5, maxTitle=100, title=title, "
        + "minContent=25, maxContent=500, content=content, createdAt=" + createdAt
        + ", techCategory=Java]";

        // Check if toString returns the expected string
        assertEquals(expectedToString, postOutDto.toString());
    }
}
