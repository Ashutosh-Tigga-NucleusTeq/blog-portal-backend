package com.example.demo.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.PostStatus;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;


/**
 * A JUnit test class for the PostOutDto class.
 */
public class PostOutDtoTest {

		/**
		 * Instance of {@code PostOutDto}.
		 */
    private PostOutDto postOutDto;

    /**
     * Initializes a new instance of PostOutDto before each test.
     */
    @BeforeEach
    public void setUp() {
        postOutDto = new PostOutDto();
    }

    /**
     * Test the getter and setter methods of PostOutDto.
     * This method sets various properties of the PostOutDto object and verifies
     * if the getter methods retrieve the expected values.
     */
    @Test
    public void testGetterSetterMethods() {
        // Test data
        String id = "12345";
        String title = "Title";
        String content = "Content";
        Date createdAt = new Date();
        TechnologyCategory techCategory = TechnologyCategory.Java;
        User authorId = new User();
        PostStatus status = PostStatus.Pending;

        // Test setId and getId
        postOutDto.setId(id);
        assertEquals(id, postOutDto.getId());

        // Test setTitle and getTitle
        postOutDto.setTitle(title);
        assertEquals(title, postOutDto.getTitle());

        // Test setContent and getContent
        postOutDto.setContent(content);
        assertEquals(content, postOutDto.getContent());

        // Test setCreatedAt and getCreatedAt
        postOutDto.setCreatedAt(createdAt);
        assertEquals(createdAt, postOutDto.getCreatedAt());

        // Test setTechCategory and getTechCategory
        postOutDto.setTechCategory(techCategory);
        assertEquals(techCategory, postOutDto.getTechCategory());

        // Test setAuthorId and getAuthorId
        postOutDto.setAuthorId(authorId);
        assertEquals(authorId, postOutDto.getAuthorId());

        // Test setStatus and getStatus
        postOutDto.setStatus(status);
        assertEquals(status, postOutDto.getStatus());
    }

    /**
     * Test the equals() method of PostOutDto.
     * This method creates two PostOutDto objects with the same property values and
     * verifies if they are considered equal by the equals() method.
     */
    @Test
    public void testEquals() {
        PostOutDto post1 = new PostOutDto("12345", "Title", "Content", PostStatus.Pending,
                TechnologyCategory.Java, new Date(), new User());
        PostOutDto post2 = new PostOutDto("12345", "Title", "Content", PostStatus.Pending,
                TechnologyCategory.Java, new Date(), new User());
        PostOutDto post3 = new PostOutDto("54321", "Different", "Content", PostStatus.Approved,
                TechnologyCategory.HTML, new Date(), new User());

        assertEquals(post1, post2);  // Should be equal
        assertNotEquals(post1, post3);  // Should not be equal
    }

    /**
     * Test the hashCode() method of PostOutDto.
     * This method creates two PostOutDto objects with the same property values and
     * verifies if their hash codes are equal.
     */
    @Test
    public void testHashCode() {
        PostOutDto post1 = new PostOutDto("12345", "Title", "Content", PostStatus.Pending,
                TechnologyCategory.Java, new Date(), new User());
        PostOutDto post2 = new PostOutDto("12345", "Title", "Content", PostStatus.Pending,
                TechnologyCategory.Java, new Date(), new User());

        assertEquals(post1.hashCode(), post2.hashCode());  // Hash codes should be equal
    }

    /**
     * Test the toString() method of PostOutDto.
     * This method creates a PostOutDto object with specific property values and
     * compares its toString() representation with the expected string.
     */
    @Test
    public void testToString() {
        Date createdAt = new Date();
        User authorId = new User();

        PostOutDto post = new PostOutDto("12345", "Title", "Content", PostStatus.Approved,
                TechnologyCategory.Java, createdAt, authorId);

        String expectedString = "PostOutDto [id=12345, title=Title, content=Content, createdAt=" + createdAt
        		+ ", techCategory=Java, authorId=" + authorId + ", status=Approved]";
        assertEquals(expectedString, post.toString());
    }
}
