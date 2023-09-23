package com.blog.portal.entities;

import com.blog.portal.enumResource.ReportAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportedPostTest {

    private ReportedPost reportedPost;

    @BeforeEach
    public void setUp() {
        reportedPost = new ReportedPost(
            "1",
            "post123",
            "user456",
            "This post violates the community guidelines.",
            ReportAction.Delete
        );
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", reportedPost.getId());
        assertEquals("post123", reportedPost.getPostId());
        assertEquals("user456", reportedPost.getUserId());
        assertEquals("This post violates the community guidelines.", reportedPost.getReportReason());
        assertEquals(ReportAction.Delete, reportedPost.getAdminAction());

        reportedPost.setId("2");
        reportedPost.setPostId("post789");
        reportedPost.setUserId("user789");
        reportedPost.setReportReason("Another reason");
        reportedPost.setAdminAction(ReportAction.Ignore);

        assertEquals("2", reportedPost.getId());
        assertEquals("post789", reportedPost.getPostId());
        assertEquals("user789", reportedPost.getUserId());
        assertEquals("Another reason", reportedPost.getReportReason());
        assertEquals(ReportAction.Ignore, reportedPost.getAdminAction());
    }

    @Test
    public void testEqualsAndHashCode() {
        ReportedPost sameReportedPost = new ReportedPost(
            "1",
            "post123",
            "user456",
            "This post violates the community guidelines.",
            ReportAction.Delete
        );

        ReportedPost differentReportedPost = new ReportedPost(
            "2",
            "post789",
            "user789",
            "Another reason",
            ReportAction.Ignore
        );
        assertTrue(reportedPost.equals(reportedPost));
        assertFalse(reportedPost.equals(null));
        assertEquals(reportedPost, sameReportedPost);
        assertNotEquals(reportedPost, differentReportedPost);
        Object differentObject = new Object(); // Create an object of a different class
        assertFalse(reportedPost.equals(differentObject));
        assertEquals(reportedPost.hashCode(), sameReportedPost.hashCode());
        assertNotEquals(reportedPost.hashCode(), differentReportedPost.hashCode());
    }

    @Test
    public void testDefaultConstructor() {
        ReportedPost reportedPost = new ReportedPost(); // Create an instance using the default constructor
        assertNotNull(reportedPost); // Check that the object is not null
        assertNull(reportedPost.getId()); // Check that id is initialized to null
        assertNull(reportedPost.getPostId()); // Check that postId is initialized to null
        assertNull(reportedPost.getUserId()); // Check that userId is initialized to null
        assertNull(reportedPost.getReportReason()); // Check that reportReason is initialized to null
        assertNull(reportedPost.getAdminAction()); // Check that adminAction is initialized to null
    }
    
    @Test
    public void testToString() {
        String expectedToString = "ReportedPost [id=1, postId=post123, userId=user456, reportReason=This post violates the community guidelines., adminAction=Delete]";
        assertEquals(expectedToString, reportedPost.toString());
    }
}
