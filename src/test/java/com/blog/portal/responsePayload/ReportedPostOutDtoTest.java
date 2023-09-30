package com.blog.portal.responsePayload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReportedPostOutDtoTest {

    private ReportedPostOutDto reportedPost1;
    private ReportedPostOutDto reportedPost2;
    private ReportedPostOutDto reportedPost3;

    @BeforeEach
    public void setUp() {
        List<String> reportReason1 = new ArrayList<>();
        reportReason1.add("Spam");
        reportedPost1 = new ReportedPostOutDto("1", "user1", "post1", reportReason1);

        List<String> reportReason2 = new ArrayList<>();
        reportReason2.add("Inappropriate");
        reportedPost2 = new ReportedPostOutDto("2", "user2", "post2", reportReason2);

        List<String> reportReason3 = new ArrayList<>();
        reportReason3.add("Spam");
        reportedPost3 = new ReportedPostOutDto("1", "user1", "post1", reportReason3);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", reportedPost1.getId());
        assertEquals("user1", reportedPost1.getUserId());
        assertEquals("post1", reportedPost1.getPostId());
        assertEquals(1, reportedPost1.getReportReason().size());
        assertEquals("Spam", reportedPost1.getReportReason().get(0));

        // Test setters
        reportedPost1.setId("3");
        reportedPost1.setUserId("user3");
        reportedPost1.setPostId("post3");
        List<String> updatedReportReason = new ArrayList<>();
        updatedReportReason.add("Hate Speech");
        reportedPost1.setReportReason(updatedReportReason);

        assertEquals("3", reportedPost1.getId());
        assertEquals("user3", reportedPost1.getUserId());
        assertEquals("post3", reportedPost1.getPostId());
        assertEquals(1, reportedPost1.getReportReason().size());
        assertEquals("Hate Speech", reportedPost1.getReportReason().get(0));
    }

    @Test
    public void testConstructors() {
        assertEquals("1", reportedPost1.getId());
        assertEquals("user1", reportedPost1.getUserId());
        assertEquals("post1", reportedPost1.getPostId());
        assertEquals(1, reportedPost1.getReportReason().size());
        assertEquals("Spam", reportedPost1.getReportReason().get(0));

        ReportedPostOutDto defaultReportedPost = new ReportedPostOutDto();
        assertNull(defaultReportedPost.getId());
        assertNull(defaultReportedPost.getUserId());
        assertNull(defaultReportedPost.getPostId());
        assertTrue(defaultReportedPost.getReportReason().isEmpty());
    }

    @Test
    public void testEqualsAndHashCode() {
        assertTrue(reportedPost1.equals(reportedPost1));
        assertEquals(reportedPost1.hashCode(), reportedPost1.hashCode());

        assertTrue(reportedPost1.equals(reportedPost3));
        assertTrue(reportedPost3.equals(reportedPost1));
        assertEquals(reportedPost1.hashCode(), reportedPost3.hashCode());

        assertFalse(reportedPost1.equals(null));
        assertFalse(reportedPost1.equals("string"));

        assertFalse(reportedPost1.equals(reportedPost2));
        assertFalse(reportedPost2.equals(reportedPost1));
        assertNotEquals(reportedPost1.hashCode(), reportedPost2.hashCode());

        reportedPost2.setReportReason(new ArrayList<>()); 
        assertFalse(reportedPost1.equals(reportedPost2));
    }

    @Test
    public void testToString() {
        String expectedToString = "ReportedPostInDto [id=1, +userId=user1, postId=post1, reportReason=[Spam]]";
        assertEquals(expectedToString, reportedPost1.toString());
    }
}
