package com.blog.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

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
        post.setStatus(PostStatus.Approved);
        post.setTechCategory(TechnologyCategory.Java);
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
        post.setDislikedBy(dislikedBy);
        List<Comment> comments = new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1")));
        post.setComments(comments);

        assertEquals("1", post.getId());
        assertEquals("Test Post", post.getTitle());
        assertEquals("This is a test post.", post.getContent());
        assertEquals(PostStatus.Approved, post.getStatus());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());
        assertEquals(createdAt, post.getCreatedAt());
        assertEquals(editedAt, post.getEditedAt());
        assertEquals("user123", post.getUserId());
        assertEquals(user, post.getUser());
        assertEquals(likedBy, post.getLikedBy());
        assertEquals(dislikedBy, post.getDislikedBy());
        assertEquals(comments, post.getComments());
    }

    @Test
    public void testHashCode() {
        Post post1 = new Post("1", "Test Post", "This is a test post.", PostStatus.Approved,
                TechnologyCategory.Java, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1"))));
        Post post2 = new Post("1", "Test Post", "This is a test post.", PostStatus.Approved,
                TechnologyCategory.Java, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1"))));

        assertEquals(post1.hashCode(), post2.hashCode());
    }

    @Test
    public void testGetEditedAtNotNull() {
        // Create a Post object with a non-null 'editedAt' field
        Post post = new Post();
        post.setEditedAt(new Date()); // Set a non-null 'editedAt'

        // Get the 'editedAt' value
        Date editedAt = post.getEditedAt();

        // Assert that 'editedAt' is not null
        assertNotNull(editedAt);
    }

    @Test
    public void testGetEditedAtNull() {
        // Create a Post object with a null 'editedAt' field
        Post post = new Post();
        post.setEditedAt(null); // Set 'editedAt' to null

        // Get the 'editedAt' value
        Date editedAt = post.getEditedAt();

        // Assert that 'editedAt' is null
        assertNull(editedAt);
    }
    
    @Test
    public void testEquals() {
        Post post1 = new Post("1", "Test Post", "This is a test post.", PostStatus.Approved,
                TechnologyCategory.Java, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1"))));
        Post post2 = new Post("1", "Test Post", "This is a test post.", PostStatus.Approved,
                TechnologyCategory.Java, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1"))));
        
        assertTrue(post1.equals(post2));
    }

    @Test
    public void testNotEquals() {
        Post post1 = new Post("1", "Test Post 1", "This is a test post.", PostStatus.Approved,
                TechnologyCategory.Java, new Date(), new Date(), "user123", new User(),
                new HashSet<>(Set.of("user1", "user2")), new HashSet<>(Set.of("user3", "user4")),
                new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1"))));
        Post post2 = new Post("2", "Test Post 2", "This is another test post.", PostStatus.Pending,
                TechnologyCategory.Python, new Date(), new Date(), "user456", new User(),
                new HashSet<>(Set.of("user5", "user6")), new HashSet<>(Set.of("user7", "user8")),
                new ArrayList<>(List.of(new Comment("2", "Comment 2", "user2", "post2"))));

        assertFalse(post1.equals(post2));
    }

    @Test
    public void testToString() {
        post.setId("1");
        post.setTitle("Test Post");
        post.setContent("This is a test post.");
        post.setStatus(PostStatus.Approved);
        post.setTechCategory(TechnologyCategory.Java);
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
        post.setDislikedBy(dislikedBy);
        List<Comment> comments = new ArrayList<>(List.of(new Comment("1", "Comment 1", "user1", "post1")));
        post.setComments(comments);

        String expectedToString = "Post [id=1, title=Test Post, content=This is a test post., " +
                "status=Approved, techCategory=Java, " +
                "createdAt=" + createdAt + ", editedAt=" + editedAt + ", " +
                "userId=user123, user=" + user + ", " +
                "likedBy=[" + String.join(", ", likedBy) + "], " +
                "dislikedBy=[" + String.join(", ", dislikedBy) + "], " +
                "comments=[" + comments.get(0).toString() + "]]";

        assertEquals(expectedToString, post.toString());
    }
}
