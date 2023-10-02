package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.TechnologyCategory;


public class GetBlogOutDtoTest {
		
    @Test
    public void testToString() {
        BlogOutDto post = new BlogOutDto();
        post.setId("1");
        post.setTitle("Sample Blog");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.JAVA);

        String expected = "BlogOutDto [id=1, title=Sample Blog, content=This is a sample post content., techCategory=JAVA]";
        assertEquals(expected, post.toString());
    }

    @Test
    public void testHashCode() {
        BlogOutDto post1 = new BlogOutDto();
        post1.setId("1");
        post1.setTitle("Sample Blog");
        post1.setContent("This is a sample post content.");
        post1.setTechCategory(TechnologyCategory.JAVA);

        BlogOutDto post2 = new BlogOutDto();
        post2.setId("1");
        post2.setTitle("Sample Blog");
        post2.setContent("This is a sample post content.");
        post2.setTechCategory(TechnologyCategory.JAVA);

        assertEquals(post1.hashCode(), post2.hashCode());
    }

    @Test
    public void testEquals() {
        BlogOutDto post1 = new BlogOutDto();
        post1.setId("1");
        post1.setTitle("Sample Blog");
        post1.setContent("This is a sample post content.");
        post1.setTechCategory(TechnologyCategory.JAVA);

        BlogOutDto post2 = new BlogOutDto();
        post2.setId("1");
        post2.setTitle("Sample Blog");
        post2.setContent("This is a sample post content.");
        post2.setTechCategory(TechnologyCategory.JAVA);

        assertTrue(post1.equals(post2));
    }

    @Test
    public void testGetterAndSetter() {
        BlogOutDto post = new BlogOutDto();
        post.setId("1");
        post.setTitle("Sample Blog");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.JAVA);

        assertEquals("1", post.getId());
        assertEquals("Sample Blog", post.getTitle());
        assertEquals("This is a sample post content.", post.getContent());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());
        post.setId("2");
        post.setTitle("Updated Blog");
        post.setContent("Updated content");
        post.setTechCategory(TechnologyCategory.PYTHON);

        assertEquals("2", post.getId());
        assertEquals("Updated Blog", post.getTitle());
        assertEquals("Updated content", post.getContent());
        assertEquals(TechnologyCategory.PYTHON, post.getTechCategory());
    }
}
