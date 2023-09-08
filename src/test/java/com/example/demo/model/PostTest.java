package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.TechnologyCategory;

public class PostTest {
		/**
		 * instance of post object.
		 */
    private Post post;

    /**
     * before each test sets instance of post.
     */
    @BeforeEach
    public void setUp() {
        // Initialize a new Post object before each test
        post = new Post("Sample Post", "This is the content of the post.", new Date(), TechnologyCategory.Java);
    }

    /**
     * setter and getter testing.
     */
    @Test
    public void testGetterAndSetterMethods() {
        // Test getters and setters
        post.setId("12345");
        post.setTitle("Updated Title");
        post.setContent("Updated content.");
        post.setStatus(true);
        post.setTechCategory(TechnologyCategory.HTML);
        post.setCreatedAt(new Date());
        post.setEditedAt(new Date());
        post.setAuthorId("author123");

        Comment comment1 = new Comment("Comment 1");
        Comment comment2 = new Comment("Comment 2");
        List<Comment> comments = new ArrayList<>();
        comments.add(comment1);
        comments.add(comment2);
        post.setComments(comments);

        // Check if values were set correctly
        assertEquals("12345", post.getId());
        assertEquals("Updated Title", post.getTitle());
        assertEquals("Updated content.", post.getContent());
        assertEquals(true, post.isStatus());
        assertEquals(TechnologyCategory.HTML, post.getTechCategory());
        assertNotNull(post.getCreatedAt());
        assertNotNull(post.getEditedAt());
        assertEquals("author123", post.getAuthorId());

        List<Comment> retrievedComments = post.getComments();
        assertNotNull(retrievedComments);
        assertEquals(2, retrievedComments.size());
        assertEquals("Comment 1", retrievedComments.get(0).getContent());
        assertEquals("Comment 2", retrievedComments.get(1).getContent());
    }
}
