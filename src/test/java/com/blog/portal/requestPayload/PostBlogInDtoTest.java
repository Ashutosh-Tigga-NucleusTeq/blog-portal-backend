package com.blog.portal.requestPayload;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.blog.portal.enumResource.TechnologyCategory;

public class PostBlogInDtoTest {

	/**
	 * Instance of PostBlogInDto.
	 */
    private PostBlogInDto post;

    /**
     * Setting up before testing.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a sample PostBlogInDto object for testing
        post = new PostBlogInDto("Sample Title", "Sample Content", new Date(), "sampleUserId", TechnologyCategory.Java);
        post.setId("sampleId");
    }

    /**
     * Testing setter and getter.
     */
    @Test
    public void testGettersAndSetters() {
        // Test getters and setters for all properties
        assertEquals("sampleId", post.getId());
        assertEquals("Sample Title", post.getTitle());
        assertEquals("Sample Content", post.getContent());
        assertNotNull(post.getCreatedAt());
        assertEquals("sampleUserId", post.getUserId());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());

        // Modify the properties using setters
        post.setId("newId");
        post.setTitle("New Title");
        post.setContent("New Content");
        post.setCreatedAt(new Date());
        post.setUserID("newUserId");
        post.setTechCategory(TechnologyCategory.HTML);

        // Check if the properties have been updated
        assertEquals("newId", post.getId());
        assertEquals("New Title", post.getTitle());
        assertEquals("New Content", post.getContent());
        assertNotNull(post.getCreatedAt());
        assertEquals("newUserId", post.getUserId());
        assertEquals(TechnologyCategory.HTML, post.getTechCategory());
    }

    /**
     * Testing hashcode and equals.
     */
    @Test
    public void testHashCodeAndEquals() {
        // Create a new PostBlogInDto with the same properties as the original
        PostBlogInDto samePost = new PostBlogInDto("Sample Title", "Sample Content",
        		new Date(), "sampleUserId", TechnologyCategory.Java);
        samePost.setId("sampleId");

        // Check if the two objects have the same hash code and are equal
        assertEquals(post.hashCode(), samePost.hashCode());
        assertEquals(post, samePost);
    }

    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        // Check the string representation of the object
        String expectedToString = "PostBlogInDto [id=sampleId,"
        		+ " title=Sample Title, content=Sample Content, createdAt="
        		+ post.getCreatedAt() + ", userId=sampleUserId, techCategory=Java]";
        assertEquals(expectedToString, post.toString());
    }
}
