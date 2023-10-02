package com.blog.portal.requestPayload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class UserBlogsInDtoTest {


    @Test
    public void testGetterSetterMethods() {
        UserBlogsInDto filter = new UserBlogsInDto();

        filter.setUserId("123");
        assertEquals("123", filter.getUserId());

        filter.setTitle("Sample Title");
        assertEquals("Sample Title", filter.getTitle());

        filter.setTechCategory(TechnologyCategory.JAVA);
        assertEquals(TechnologyCategory.JAVA, filter.getTechCategory());

        filter.setStatus(BlogStatus.APPROVED);
        assertEquals(BlogStatus.APPROVED, filter.getStatus());
    }


    @Test
    public void testEqualsAndHashCode() {
        UserBlogsInDto filter1 = new UserBlogsInDto();
        UserBlogsInDto filter2 = new UserBlogsInDto();

        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        filter1.setUserId("123");
        filter1.setTitle("Sample Title");
        filter1.setTechCategory(TechnologyCategory.JAVA);
        filter1.setStatus(BlogStatus.APPROVED);

        filter2.setUserId("123");
        filter2.setTitle("Sample Title");
        filter2.setTechCategory(TechnologyCategory.JAVA);
        filter2.setStatus(BlogStatus.APPROVED);

        assertTrue(filter1.equals(filter2));
        assertEquals(filter1.hashCode(), filter2.hashCode());

        filter2.setUserId("456");
        assertFalse(filter1.equals(filter2));
        assertNotEquals(filter1.hashCode(), filter2.hashCode());
    }


    @Test
    public void testToString() {
        UserBlogsInDto filter = new UserBlogsInDto();
        filter.setUserId("123");
        filter.setTitle("Sample Title");
        filter.setTechCategory(TechnologyCategory.JAVA);
        filter.setStatus(BlogStatus.APPROVED);

        String expectedToString = "UserBlogsInDto [userId=123, title=Sample Title, techCategory=JAVA, status=APPROVED]";
        assertEquals(expectedToString, filter.toString());
    }
}
