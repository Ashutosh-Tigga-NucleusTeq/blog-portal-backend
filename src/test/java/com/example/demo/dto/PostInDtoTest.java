package com.example.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;


/**
 * A JUnit test class for the PostInDto class.
 */
public class PostInDtoTest {

		/**
		 * Instance of {@code PostInDto}.
		 */
    private PostInDto postInDto;

    /**
     * Initializes a new instance of PostInDto before each test.
     */
    @BeforeEach
    public void setUp() {
        postInDto = new PostInDto();
    }

    /**
     * Test the getter and setter methods of PostInDto.
     * This method sets various properties of the PostInDto object and verifies
     * if the getter methods retrieve the expected values.
     */
    @Test
    public void testGetterSetterMethods() {
        // Test data
        String title = "title";
        String content = "content";
        Date createdAt = new Date();
        User authorId = new User();
        TechnologyCategory techCategory = TechnologyCategory.Java;

        // Test setTitle and getTitle
        postInDto.setTitle(title);
        assertEquals(title, postInDto.getTitle());

        // Test setContent and getContent
        postInDto.setContent(content);
        assertEquals(content, postInDto.getContent());

        // Test setCreatedAt and getCreatedAt
        postInDto.setCreatedAt(createdAt);
        assertEquals(createdAt, postInDto.getCreatedAt());

        // Test setAuthorId and getAuthorId
        postInDto.setAuthorId(authorId);
        assertEquals(authorId, postInDto.getAuthorId());

        // Test setTechCategory and getTechCategory
        postInDto.setTechCategory(techCategory);
        assertEquals(techCategory, postInDto.getTechCategory());
    }

    /**
     * Test the equals() method of PostInDto.
     * This method creates two PostInDto objects with the same property values and
     * verifies if they are considered equal by the equals() method.
     */
    @Test
    public void testEquals() {
        PostInDto post1 = new PostInDto("Title", "Content", new Date(), new User(), TechnologyCategory.Java);
        PostInDto post2 = new PostInDto("Title", "Content", new Date(), new User(), TechnologyCategory.Java);
        PostInDto post3 = new PostInDto("Different", "Content", new Date(), new User(), TechnologyCategory.HTML);

        assertEquals(post1, post2);  // Should be equal
        assertNotEquals(post1, post3);  // Should not be equal
    }

    /**
     * Test the hashCode() method of PostInDto.
     * This method creates two PostInDto objects with the same property values and
     * verifies if their hash codes are equal.
     */
    @Test
    public void testHashCode() {
        PostInDto post1 = new PostInDto("Title", "Content", new Date(), new User(), TechnologyCategory.Java);
        PostInDto post2 = new PostInDto("Title", "Content", new Date(), new User(), TechnologyCategory.Java);

        assertEquals(post1.hashCode(), post2.hashCode());  // Hash codes should be equal
    }

    /**
     * Test the toString() method of PostInDto.
     * This method creates a PostInDto object with specific property values and
     * compares its toString() representation with the expected string.
     */
    @Test
    public void testToString() {
        Date createdAt = new Date();
        User authorId = new User();

        PostInDto post = new PostInDto("Title", "Content", createdAt, authorId, TechnologyCategory.Java);

        String expectedString = "PostInDto [title=Title, content=Content, createdAt=" + createdAt
        		+ ", authorId=" + authorId + ", techCategory=Java]";
        assertEquals(expectedString, post.toString());
    }
}
