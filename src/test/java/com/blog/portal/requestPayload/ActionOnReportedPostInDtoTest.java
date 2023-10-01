package com.blog.portal.requestPayload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.AdminAction;

import static org.junit.jupiter.api.Assertions.*;

public class ActionOnReportedPostInDtoTest {

    private ActionOnReportedPostInDto action1;
    private ActionOnReportedPostInDto action2;

    @BeforeEach
    public void setUp() {
        action1 = new ActionOnReportedPostInDto("1", AdminAction.DELETE);
        action2 = new ActionOnReportedPostInDto("2", AdminAction.IGNORE);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", action1.getPostId());
        assertEquals(AdminAction.DELETE, action1.getAdminAction());
        assertEquals("2", action2.getPostId());
        assertEquals(AdminAction.IGNORE, action2.getAdminAction());

        action1.setPostId("3");
        action1.setAdminAction(AdminAction.DELETE);

        assertEquals("3", action1.getPostId());
        assertEquals(AdminAction.DELETE, action1.getAdminAction());
    }

    @Test
    public void testConstructor() {
        assertEquals("1", action1.getPostId());
        assertEquals(AdminAction.DELETE, action1.getAdminAction());

        ActionOnReportedPostInDto defaultAction = new ActionOnReportedPostInDto();
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
        String expectedToString = "ActionOnReportedPostInDto [postId=1, adminAction=DELETE]";
        assertEquals(expectedToString, action1.toString());
    }
}
