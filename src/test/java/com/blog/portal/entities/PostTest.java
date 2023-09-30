package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;

public class PostTest {

    private Post post;

    @BeforeEach
    public void setUp() {
        post = new Post();
    }

    @Test
    public void testGetterSetter() {
        post.setId("1");
        post.setTitle("Test Post");
        post.setContent("This is a test post.");
        post.setStatus(PostStatus.APPROVED);
        post.setTechCategory(TechnologyCategory.JAVA);
        Date createdAt = new Date();
        post.setCreatedAt(createdAt);
        Date editedAt = new Date();
        post.setEditedAt(editedAt);
        post.setUserId("user123");
        User user = new User();
        post.setUser(user);
        Set<String> likedBy = new HashSet<String>(Set.of("user1", "user2"));
        post.setLikedBy(likedBy);
        Set<String> dislikedBy = new HashSet<>(Set.of("user3", "user4"));
        post.setDisLikedBy(dislikedBy);
        List<String> comments = new ArrayList<>(List.of(new String("user1")));
        post.setCommentBy(comments);

        assertEquals("1", post.getId());
        assertEquals("Test Post", post.getTitle());
        assertEquals("This is a test post.", post.getContent());
        assertEquals(PostStatus.APPROVED, post.getStatus());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());
        assertEquals(createdAt, post.getCreatedAt());
        assertEquals(editedAt, post.getEditedAt());
        assertEquals("user123", post.getUserId());
        assertEquals(user, post.getUser());
        assertEquals(likedBy, post.getLikedBy());
        assertEquals(dislikedBy, post.getDisLikedBy());
        assertEquals(comments, post.getCommentBy());
    }

  
    @Test
    public void testGetEditedAtNotNull() {
        Post post = new Post();
        post.setEditedAt(new Date()); 

        Date editedAt = post.getEditedAt();

        assertNotNull(editedAt);
    }

    @Test
    public void testGetEditedAtNull() {
        Post post = new Post();
        post.setEditedAt(null); 

        Date editedAt = post.getEditedAt();

        assertNull(editedAt);
    }

    @Test
    public void testToString() {
        post.setId("1");
        post.setTitle("Test Post");
        post.setContent("This is a test post.");
        post.setStatus(PostStatus.APPROVED);
        post.setTechCategory(TechnologyCategory.JAVA);
        Date createdAt = new Date();
        post.setCreatedAt(createdAt);
        Date editedAt = new Date();
        post.setEditedAt(editedAt);
        post.setUserId("user123");
        User user = new User();
        post.setUser(user);
        Set<String> likedBy = new HashSet<>(Set.of("user1", "user2"));
        post.setLikedBy(likedBy);
        Set<String> dislikedBy = new HashSet<>(Set.of("user3", "user4"));
        post.setDisLikedBy(dislikedBy);
        List<String> comments = new ArrayList<>(List.of(new String("user1")));
        post.setCommentBy(comments);

        String expectedToString = "Post [id=1, title=Test Post, content=This is a test post., " +
                "status=APPROVED, techCategory=JAVA, " +
                "createdAt=" + createdAt + ", editedAt=" + editedAt + ", " +
                "userId=user123, user=" + user + ", " +
                "likedBy=[" + String.join(", ", likedBy) + "], " +
                "dislikedBy=[" + String.join(", ", dislikedBy) + "], " +
                "commentBy=[" + comments.get(0).toString() + "]]";

        assertEquals(expectedToString, post.toString());
    }
    @Test
    public void testHashCode() {
        Post post1 = new Post("1", "Test Post", "This is a test post.", PostStatus.APPROVED,
                TechnologyCategory.JAVA, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of("user1")));

        Post post2 = new Post("1", "Test Post", "This is a test post.", PostStatus.APPROVED,
                TechnologyCategory.JAVA, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of("user1")));

        assertEquals(post1.hashCode(), post2.hashCode());
    }

    @Test
    public void testEquals() {
        Post post1 = new Post("1", "Test Post", "This is a test post.", PostStatus.APPROVED,
                TechnologyCategory.JAVA, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of("user1")));

        Post post2 = new Post("1", "Test Post", "This is a test post.", PostStatus.APPROVED,
                TechnologyCategory.JAVA, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of("user1")));

        assertTrue(post1.equals(post2));
    }

    @Test
    public void testNotEquals() {
        Post post1 = new Post("1", "Test Post 1", "This is a test post.", PostStatus.APPROVED,
                TechnologyCategory.JAVA, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of("user1")));

        Post post2 = new Post("2", "Test Post 2", "This is another test post.", PostStatus.PENDING,
                TechnologyCategory.PYTHON, new Date(), null, "user456", new User(),
                new HashSet<>(Set.of("user5")), new HashSet<>(Set.of("user6")),
                new ArrayList<>(List.of("user2")));

        assertFalse(post1.equals(post2));
    }

}
