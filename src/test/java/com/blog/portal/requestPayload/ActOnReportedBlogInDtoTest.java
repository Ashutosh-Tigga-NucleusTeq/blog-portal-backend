package com.blog.portal.requestPayload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.ReportedBlogAction;

import static org.junit.jupiter.api.Assertions.*;

public class ActOnReportedBlogInDtoTest {

    private ActOnReportedBlogInDto action1;
    private ActOnReportedBlogInDto action2;

    @BeforeEach
    public void setUp() {
        action1 = new ActOnReportedBlogInDto("1", ReportedBlogAction.DELETE);
        action2 = new ActOnReportedBlogInDto("2", ReportedBlogAction.IGNORE);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", action1.getPostId());
        assertEquals(ReportedBlogAction.DELETE, action1.getAdminAction());
        assertEquals("2", action2.getPostId());
        assertEquals(ReportedBlogAction.IGNORE, action2.getAdminAction());

        action1.setPostId("3");
        action1.setAdminAction(ReportedBlogAction.DELETE);

        assertEquals("3", action1.getPostId());
        assertEquals(ReportedBlogAction.DELETE, action1.getAdminAction());
    }

    @Test
    public void testConstructor() {
        assertEquals("1", action1.getPostId());
        assertEquals(ReportedBlogAction.DELETE, action1.getAdminAction());

        ActOnReportedBlogInDto defaultAction = new ActOnReportedBlogInDto();
        assertNull(defaultAction.getPostId());
        assertNull(defaultAction.getAdminAction());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(action1.equals(action1));
        assertEquals(action1.hashCode(), action1.hashCode());

        assertTrue(action1.equals(action1));
        assertTrue(action2.equals(action2));
        assertEquals(action1.hashCode(), action1.hashCode());

        assertFalse(action1.equals(null));
        assertFalse(action1.equals("string"));

        action2.setPostId("4");
        assertFalse(action1.equals(action2));
    }

    @Test
    public void testToString() {
        String expectedToString = "ActOnReportedBlogInDto [postId=1, reportedBlogAction=DELETE]";
        assertEquals(expectedToString, action1.toString());
    }
}
