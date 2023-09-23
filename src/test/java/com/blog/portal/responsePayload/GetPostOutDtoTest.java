package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.TechnologyCategory;


public class GetPostOutDtoTest {
		/**
		 * Testing to string.
		 */
    @Test
    public void testToString() {
        GetPostOutDto post = new GetPostOutDto();
        post.setId("1");
        post.setTitle("Sample Post");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.Java);

        String expected = "GetPostOutDto [id=1, title=Sample Post, content=This is a sample post content., techCategory=Java]";
        assertEquals(expected, post.toString());
    }
    /**
     * Testing hashcode.
     */
    @Test
    public void testHashCode() {
        GetPostOutDto post1 = new GetPostOutDto();
        post1.setId("1");
        post1.setTitle("Sample Post");
        post1.setContent("This is a sample post content.");
        post1.setTechCategory(TechnologyCategory.Java);

        GetPostOutDto post2 = new GetPostOutDto();
        post2.setId("1");
        post2.setTitle("Sample Post");
        post2.setContent("This is a sample post content.");
        post2.setTechCategory(TechnologyCategory.Java);

        assertEquals(post1.hashCode(), post2.hashCode());
    }
    /**
     * Testing equals.
     */
    @Test
    public void testEquals() {
        GetPostOutDto post1 = new GetPostOutDto();
        post1.setId("1");
        post1.setTitle("Sample Post");
        post1.setContent("This is a sample post content.");
        post1.setTechCategory(TechnologyCategory.Java);

        GetPostOutDto post2 = new GetPostOutDto();
        post2.setId("1");
        post2.setTitle("Sample Post");
        post2.setContent("This is a sample post content.");
        post2.setTechCategory(TechnologyCategory.Java);

        assertTrue(post1.equals(post2));
    }
    /**
     * Testing Getter and Setter.
     */
    @Test
    public void testGetterAndSetter() {
        GetPostOutDto post = new GetPostOutDto();
        post.setId("1");
        post.setTitle("Sample Post");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.Java);

        assertEquals("1", post.getId());
        assertEquals("Sample Post", post.getTitle());
        assertEquals("This is a sample post content.", post.getContent());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());
        // Modify properties using setters
        post.setId("2");
        post.setTitle("Updated Post");
        post.setContent("Updated content");
        post.setTechCategory(TechnologyCategory.Python);

        assertEquals("2", post.getId());
        assertEquals("Updated Post", post.getTitle());
        assertEquals("Updated content", post.getContent());
        assertEquals(TechnologyCategory.Python, post.getTechCategory());
    }
}
