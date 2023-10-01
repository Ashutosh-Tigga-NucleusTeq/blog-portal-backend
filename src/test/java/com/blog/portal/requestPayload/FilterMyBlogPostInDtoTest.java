package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class FilterMyBlogPostInDtoTest {


    @Test
    public void testGetterSetterMethods() {
        FilterMyBlogPostInDto filter = new FilterMyBlogPostInDto();

        filter.setUserId("123");
        assertEquals("123", filter.getUserId());

        filter.setTitle("Sample Title");
        assertEquals("Sample Title", filter.getTitle());

        filter.setTechCategory(TechnologyCategory.JAVA);
        assertEquals(TechnologyCategory.JAVA, filter.getTechCategory());

        filter.setStatus(PostStatus.APPROVED);
        assertEquals(PostStatus.APPROVED, filter.getStatus());
    }


    @Test
    public void testEqualsAndHashCode() {
        FilterMyBlogPostInDto filter1 = new FilterMyBlogPostInDto();
        FilterMyBlogPostInDto filter2 = new FilterMyBlogPostInDto();

        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        filter1.setUserId("123");
        filter1.setTitle("Sample Title");
        filter1.setTechCategory(TechnologyCategory.JAVA);
        filter1.setStatus(PostStatus.APPROVED);

        filter2.setUserId("123");
        filter2.setTitle("Sample Title");
        filter2.setTechCategory(TechnologyCategory.JAVA);
        filter2.setStatus(PostStatus.APPROVED);

        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        filter2.setUserId("456");
        assertFalse(filter1.equals(filter2));
        assertNotEquals(filter1.hashCode(), filter2.hashCode());
    }


    @Test
    public void testToString() {
        FilterMyBlogPostInDto filter = new FilterMyBlogPostInDto();
        filter.setUserId("123");
        filter.setTitle("Sample Title");
        filter.setTechCategory(TechnologyCategory.JAVA);
        filter.setStatus(PostStatus.APPROVED);

        String expectedToString = "FilterMyBlogPostInDto [userId=123, title=Sample Title, techCategory=JAVA, status=APPROVED]";
        assertEquals(expectedToString, filter.toString());
    }
}
