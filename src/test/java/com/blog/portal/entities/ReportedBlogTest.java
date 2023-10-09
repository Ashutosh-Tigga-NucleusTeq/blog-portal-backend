package com.blog.portal.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReportedBlogTest {

    private ReportedBlog reportedBlog;

    @BeforeEach
    public void setUp() {
        reportedBlog = new ReportedBlog(
            "1",
            "post123",
            "user456",
            "This post violates the community guidelines."
        );

        Blog blog = new Blog();
        blog.setId("post456");
        reportedBlog.setPost(blog);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", reportedBlog.getId());
        assertEquals("post123", reportedBlog.getPostId());
        assertEquals("user456", reportedBlog.getUserId());
        assertEquals("This post violates the community guidelines.", reportedBlog.getReportReason());

        Blog newPost = new Blog();
        newPost.setId("post456");

        reportedBlog.setPost(newPost);

        assertEquals("post456", reportedBlog.getPost().getId());

        // Modify the Blog object
        Blog anotherPost = new Blog();
        anotherPost.setId("post789");
        reportedBlog.setPost(anotherPost);

        assertEquals("post789", reportedBlog.getPost().getId());
    }


    @Test
    public void testEqualsAndHashCode() {
        ReportedBlog sameReportedPost = new ReportedBlog(
            "1",
            "post123",
            "user456",
            "This post violates the community guidelines."
        );
        Blog blog = new Blog();
        blog.setId("post456");
        sameReportedPost.setPost(blog);

        ReportedBlog differentReportedPost = new ReportedBlog(
            "2",
            "post789",
            "user789",
            "Another reason"
        );
        Blog differentPost = new Blog();
        differentPost.setId("post999");
        differentReportedPost.setPost(differentPost);

        assertTrue(reportedBlog.equals(reportedBlog));
        assertFalse(reportedBlog.equals(null));
        assertEquals(reportedBlog, sameReportedPost);
        assertNotEquals(reportedBlog, differentReportedPost);

        Object differentObject = new Object();
        assertFalse(reportedBlog.equals(differentObject));

        assertEquals(reportedBlog.hashCode(), sameReportedPost.hashCode());
        assertNotEquals(reportedBlog.hashCode(), differentReportedPost.hashCode());
    }

    @Test
    public void testDefaultConstructor() {
        ReportedBlog reportedBlog = new ReportedBlog();
        assertNotNull(reportedBlog);
        assertNull(reportedBlog.getId());
        assertNull(reportedBlog.getPostId());
        assertNull(reportedBlog.getUserId());
        assertNull(reportedBlog.getReportReason());
        assertNull(reportedBlog.getPost());
    }

    @Test
    public void testToString() {
        String expectedToString = "ReportedBlog [id=1, postId=post123, userId=user456, reportReason=This post violates the community guidelines.]";
        assertEquals(expectedToString, reportedBlog.toString());
    }
}
