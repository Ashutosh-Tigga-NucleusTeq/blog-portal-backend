package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.entities.User;

public class BlogTest {

    private Blog blog;

    @BeforeEach
    public void setUp() {
        blog = new Blog();
        blog.setId("1");
        blog.setTitle("Sample Blog");
        blog.setContent("This is the content of the sample blog.");
        blog.setStatus(BlogStatus.APPROVED);
        blog.setTechCategory(TechnologyCategory.HTML);
        blog.setCreatedAt(new Date(12));
        blog.setEditedAt(new Date(13));
        blog.setUserId("user123");
        blog.setLikedBy(new HashSet<>(Arrays.asList("user1", "user2")));
        blog.setDisLikedBy(new HashSet<>(Arrays.asList("user3", "user4")));
        blog.setCommentBy(Arrays.asList("comment1", "comment2"));
        blog.setReportedBy(new HashSet<>(Arrays.asList("user5", "user6")));
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", blog.getId());
        assertEquals("Sample Blog", blog.getTitle());
        assertEquals("This is the content of the sample blog.", blog.getContent());
        assertEquals(BlogStatus.APPROVED, blog.getStatus());
        assertEquals(TechnologyCategory.HTML, blog.getTechCategory());
        assertTrue(blog.getCreatedAt() instanceof Date);
        assertTrue(blog.getEditedAt() instanceof Date);
        assertEquals("user123", blog.getUserId());
        assertEquals(2, blog.getLikedBy().size());
        assertEquals(2, blog.getDisLikedBy().size());
        assertEquals(2, blog.getReportedBy().size());
        assertEquals(2, blog.getCommentBy().size());
    }

    @Test
    public void testEqualsAndHashCode() {
        Blog anotherPost = new Blog();
        anotherPost.setId("1");
        anotherPost.setTitle("Sample Blog");
        anotherPost.setContent("This is the content of the sample blog.");
        anotherPost.setStatus(BlogStatus.APPROVED);
        anotherPost.setTechCategory(TechnologyCategory.HTML);
        anotherPost.setCreatedAt(new Date(12));
        anotherPost.setEditedAt(new Date(13));
        anotherPost.setUserId("user123");
        anotherPost.setLikedBy(new HashSet<>(Arrays.asList("user1", "user2")));
        anotherPost.setDisLikedBy(new HashSet<>(Arrays.asList("user3", "user4")));
        anotherPost.setCommentBy(Arrays.asList("comment1", "comment2"));
        anotherPost.setReportedBy(new HashSet<>(Arrays.asList("user5", "user6")));

        assertEquals(blog, anotherPost);
        assertEquals(blog.hashCode(), anotherPost.hashCode());
    }

    @Test
    public void testNotEquals() {
        Blog anotherPost = new Blog();
        anotherPost.setId("2");
        anotherPost.setTitle("Another Blog");
        anotherPost.setContent("This is the content of another blog.");
        anotherPost.setStatus(BlogStatus.PENDING);
        anotherPost.setTechCategory(TechnologyCategory.JAVA);
        anotherPost.setCreatedAt(new Date());
        anotherPost.setEditedAt(new Date());
        anotherPost.setUserId("user789");
        anotherPost.setLikedBy(new HashSet<>(Arrays.asList("user7", "user8")));
        anotherPost.setDisLikedBy(new HashSet<>(Arrays.asList("user9", "user10")));
        anotherPost.setCommentBy(Arrays.asList("comment3", "comment4"));
        anotherPost.setReportedBy(new HashSet<>(Arrays.asList("user11", "user12")));

        assertFalse(blog.equals(anotherPost));
        assertFalse(blog.hashCode() == anotherPost.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Blog [id=1, title=Sample Blog, content=This is the content of the sample blog., " +
                "status=APPROVED, techCategory=HTML, createdAt=" + blog.getCreatedAt() + ", " +
                "editedAt=" + blog.getEditedAt() + ", userId=user123, user=null, " +
                "likedBy=[user1, user2], dislikedBy=[user3, user4], commentBy=[comment1, comment2]]";

        assertEquals(expectedString, blog.toString());
    }
}
