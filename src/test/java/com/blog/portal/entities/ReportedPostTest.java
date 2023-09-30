package com.blog.portal.entities;

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
            "This post violates the community guidelines."
        );

        Post post = new Post();
        post.setId("post456");
        reportedPost.setPost(post);
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", reportedPost.getId());
        assertEquals("post123", reportedPost.getPostId());
        assertEquals("user456", reportedPost.getUserId());
        assertEquals("This post violates the community guidelines.", reportedPost.getReportReason());

        Post newPost = new Post();
        newPost.setId("post456");

        reportedPost.setPost(newPost);

        assertEquals("post456", reportedPost.getPost().getId());

        // Modify the Post object
        Post anotherPost = new Post();
        anotherPost.setId("post789");
        reportedPost.setPost(anotherPost);

        assertEquals("post789", reportedPost.getPost().getId());
    }


    @Test
    public void testEqualsAndHashCode() {
        ReportedPost sameReportedPost = new ReportedPost(
            "1",
            "post123",
            "user456",
            "This post violates the community guidelines."
        );
        Post post = new Post();
        post.setId("post456");
        sameReportedPost.setPost(post);

        ReportedPost differentReportedPost = new ReportedPost(
            "2",
            "post789",
            "user789",
            "Another reason"
        );
        Post differentPost = new Post();
        differentPost.setId("post999");
        differentReportedPost.setPost(differentPost);

        assertTrue(reportedPost.equals(reportedPost));
        assertFalse(reportedPost.equals(null));
        assertEquals(reportedPost, sameReportedPost);
        assertNotEquals(reportedPost, differentReportedPost);

        Object differentObject = new Object();
        assertFalse(reportedPost.equals(differentObject));

        assertEquals(reportedPost.hashCode(), sameReportedPost.hashCode());
        assertNotEquals(reportedPost.hashCode(), differentReportedPost.hashCode());
    }

    @Test
    public void testDefaultConstructor() {
        ReportedPost reportedPost = new ReportedPost();
        assertNotNull(reportedPost);
        assertNull(reportedPost.getId());
        assertNull(reportedPost.getPostId());
        assertNull(reportedPost.getUserId());
        assertNull(reportedPost.getReportReason());
        assertNull(reportedPost.getPost());
    }

    @Test
    public void testToString() {
        String expectedToString = "ReportedPost [id=1, postId=post123, userId=user456, reportReason=This post violates the community guidelines.]";
        assertEquals(expectedToString, reportedPost.toString());
    }
}
