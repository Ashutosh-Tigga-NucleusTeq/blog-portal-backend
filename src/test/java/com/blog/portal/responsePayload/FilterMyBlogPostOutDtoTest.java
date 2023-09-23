package com.blog.portal.responsePayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;


public class FilterMyBlogPostOutDtoTest {
	/**
	 * Instance of FilterMyBlogPostOutDto.
	 */
    private FilterMyBlogPostOutDto post1;
    /**
  	 * Instance of FilterMyBlogPostOutDto.
  	 */
    private FilterMyBlogPostOutDto post2;

    /**
     * Setting up before testing.
     */
    @Before
    public void setUp() {
        post1 = new FilterMyBlogPostOutDto();
        post1.setId("1");
        post1.setTitle("Post 1");
        post1.setContent("Content of post 1");
        post1.setStatus(PostStatus.Approved);
        post1.setTechnology(TechnologyCategory.Java);
        post1.setCreatedAt(new Date());
        post1.setEditedAt(new Date());

        post2 = new FilterMyBlogPostOutDto();
        post2.setId("2");
        post2.setTitle("Post 2");
        post2.setContent("Content of post 2");
        post2.setStatus(PostStatus.Rejected);
        post2.setTechnology(TechnologyCategory.Blockchain);
        post2.setCreatedAt(new Date());
        post2.setEditedAt(new Date());
    }
    /**
     * Testing Equals.
     */
    @Test
    public void testEquals() {
        FilterMyBlogPostOutDto post1Copy = new FilterMyBlogPostOutDto();
        post1Copy.setId("1");
        post1Copy.setTitle("Post 1");
        post1Copy.setContent("Content of post 1");
        post1Copy.setStatus(PostStatus.Approved);
        post1Copy.setTechnology(TechnologyCategory.Java);
        post1Copy.setCreatedAt(new Date());
        post1Copy.setEditedAt(new Date());

        assertTrue(post1.equals(post1Copy));
        assertFalse(post1.equals(post2));
    }
    /**
     * Testing HashCode.
     */
    @Test
    public void testHashCode() {
        FilterMyBlogPostOutDto post1Copy = new FilterMyBlogPostOutDto();
        post1Copy.setId("1");
        post1Copy.setTitle("Post 1");
        post1Copy.setContent("Content of post 1");
        post1Copy.setStatus(PostStatus.Approved);
        post1Copy.setTechnology(TechnologyCategory.Java);
        post1Copy.setCreatedAt(new Date());
        post1Copy.setEditedAt(new Date());
        assertEquals(post1.hashCode(), post1Copy.hashCode());
    }
    /**
     * Testing compareto.
     */
    @Test
    public void testCompareTo() {
        List<FilterMyBlogPostOutDto> posts = new ArrayList<>();
        posts.add(post2);
        posts.add(post1);

        Collections.sort(posts);

        assertEquals(post1, posts.get(0));
    }
    /**
     * Testing toString.
     */
    @Test
    public void testToString() {
        String expectedToString = "FilterMyBlogPostOutDto [id=1, title=Post 1,"
        		+ " status=Approved, content=Content of post 1, Java=Java,"
        		+ " createdAt=";
        assertTrue(post1.toString().startsWith(expectedToString));
    }
}
