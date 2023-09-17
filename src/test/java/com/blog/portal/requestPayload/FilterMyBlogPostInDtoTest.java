package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class FilterMyBlogPostInDtoTest {

	/**
	 * Testing of setter and getter.
	 */
    @Test
    public void testGetterSetterMethods() {
        FilterMyBlogPostInDto filter = new FilterMyBlogPostInDto();

        // Test userId getter and setter
        filter.setUserId("123");
        assertEquals("123", filter.getUserId());

        // Test title getter and setter
        filter.setTitle("Sample Title");
        assertEquals("Sample Title", filter.getTitle());

        // Test techCategory getter and setter
        filter.setTechCategory(TechnologyCategory.Java);
        assertEquals(TechnologyCategory.Java, filter.getTechCategory());

        // Test status getter and setter
        filter.setStatus(PostStatus.Approved);
        assertEquals(PostStatus.Approved, filter.getStatus());
    }

    /**
     * Testing of equals and hashcode.
     */
    @Test
    public void testEqualsAndHashCode() {
        FilterMyBlogPostInDto filter1 = new FilterMyBlogPostInDto();
        FilterMyBlogPostInDto filter2 = new FilterMyBlogPostInDto();

        // Both objects are empty, so they should be equal
        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        // Test with different values
        filter1.setUserId("123");
        filter1.setTitle("Sample Title");
        filter1.setTechCategory(TechnologyCategory.Java);
        filter1.setStatus(PostStatus.Approved);

        filter2.setUserId("123");
        filter2.setTitle("Sample Title");
        filter2.setTechCategory(TechnologyCategory.Java);
        filter2.setStatus(PostStatus.Approved);

        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        // Test with different userId
        filter2.setUserId("456");
        assertFalse(filter1.equals(filter2));
        assertNotEquals(filter1.hashCode(), filter2.hashCode());
    }

    /**
     * testing tostring method.
     */
    @Test
    public void testToString() {
        FilterMyBlogPostInDto filter = new FilterMyBlogPostInDto();
        filter.setUserId("123");
        filter.setTitle("Sample Title");
        filter.setTechCategory(TechnologyCategory.Java);
        filter.setStatus(PostStatus.Approved);

        String expectedToString = "FilterMyBlogPostInDto [userId=123, title=Sample Title, techCategory=Java, status=Approved]";
        assertEquals(expectedToString, filter.toString());
    }
}
