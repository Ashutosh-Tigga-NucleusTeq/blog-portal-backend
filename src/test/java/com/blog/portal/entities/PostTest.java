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

import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.entities.User;

public class PostTest {

    private Post post;

    @BeforeEach
    public void setUp() {
        post = new Post();
        post.setId("1");
        post.setTitle("Sample Post");
        post.setContent("This is the content of the sample post.");
        post.setStatus(PostStatus.APPROVED);
        post.setTechCategory(TechnologyCategory.HTML);
        post.setCreatedAt(new Date(12));
        post.setEditedAt(new Date(13));
        post.setUserId("user123");
        post.setLikedBy(new HashSet<>(Arrays.asList("user1", "user2")));
        post.setDisLikedBy(new HashSet<>(Arrays.asList("user3", "user4")));
        post.setCommentBy(Arrays.asList("comment1", "comment2"));
        post.setReportedBy(new HashSet<>(Arrays.asList("user5", "user6")));
    }

    @Test
    public void testGettersAndSetters() {
        assertEquals("1", post.getId());
        assertEquals("Sample Post", post.getTitle());
        assertEquals("This is the content of the sample post.", post.getContent());
        assertEquals(PostStatus.APPROVED, post.getStatus());
        assertEquals(TechnologyCategory.HTML, post.getTechCategory());
        assertTrue(post.getCreatedAt() instanceof Date);
        assertTrue(post.getEditedAt() instanceof Date);
        assertEquals("user123", post.getUserId());
        assertEquals(2, post.getLikedBy().size());
        assertEquals(2, post.getDisLikedBy().size());
        assertEquals(2, post.getReportedBy().size());
        assertEquals(2, post.getCommentBy().size());
    }

    @Test
    public void testEqualsAndHashCode() {
        Post anotherPost = new Post();
        anotherPost.setId("1");
        anotherPost.setTitle("Sample Post");
        anotherPost.setContent("This is the content of the sample post.");
        anotherPost.setStatus(PostStatus.APPROVED);
        anotherPost.setTechCategory(TechnologyCategory.HTML);
        anotherPost.setCreatedAt(new Date(12));
        anotherPost.setEditedAt(new Date(13));
        anotherPost.setUserId("user123");
        anotherPost.setLikedBy(new HashSet<>(Arrays.asList("user1", "user2")));
        anotherPost.setDisLikedBy(new HashSet<>(Arrays.asList("user3", "user4")));
        anotherPost.setCommentBy(Arrays.asList("comment1", "comment2"));
        anotherPost.setReportedBy(new HashSet<>(Arrays.asList("user5", "user6")));

        assertEquals(post, anotherPost);
        assertEquals(post.hashCode(), anotherPost.hashCode());
    }

    @Test
    public void testNotEquals() {
        Post anotherPost = new Post();
        anotherPost.setId("2");
        anotherPost.setTitle("Another Post");
        anotherPost.setContent("This is the content of another post.");
        anotherPost.setStatus(PostStatus.PENDING);
        anotherPost.setTechCategory(TechnologyCategory.JAVA);
        anotherPost.setCreatedAt(new Date());
        anotherPost.setEditedAt(new Date());
        anotherPost.setUserId("user789");
        anotherPost.setLikedBy(new HashSet<>(Arrays.asList("user7", "user8")));
        anotherPost.setDisLikedBy(new HashSet<>(Arrays.asList("user9", "user10")));
        anotherPost.setCommentBy(Arrays.asList("comment3", "comment4"));
        anotherPost.setReportedBy(new HashSet<>(Arrays.asList("user11", "user12")));

        assertFalse(post.equals(anotherPost));
        assertFalse(post.hashCode() == anotherPost.hashCode());
    }

    @Test
    public void testToString() {
        String expectedString = "Post [id=1, title=Sample Post, content=This is the content of the sample post., " +
                "status=APPROVED, techCategory=HTML, createdAt=" + post.getCreatedAt() + ", " +
                "editedAt=" + post.getEditedAt() + ", userId=user123, user=null, " +
                "likedBy=[user1, user2], dislikedBy=[user3, user4], commentBy=[comment1, comment2]]";

        assertEquals(expectedString, post.toString());
    }
}
