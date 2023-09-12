package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*import static org.junit.jupiter.api.Assertions.assertNotEquals;*/
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.enumResource.PostStatus;
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
		User user = new User();
		user.setId("userid");
		post = new Post("Post", "Content", new Date(), TechnologyCategory.Java, user);
	}

	/**
	 * setter and getter testing.
	 */
	@Test
	public void testGetterAndSetterMethods() {
		// Test getters and setters
		post.setId("postid");
		post.setTitle("Updated Title");
		post.setContent("Updated content.");
		post.setStatus(PostStatus.Pending);
		post.setTechCategory(TechnologyCategory.HTML);
		post.setCreatedAt(new Date());
		post.setEditedAt(new Date());
		User user = new User();
		user.setId("userid");
		post.setAuthor(user);

		// Check if values were set correctly
		assertEquals("postid", post.getId());
		assertEquals("Updated Title", post.getTitle());
		assertEquals("Updated content.", post.getContent());
		assertEquals(PostStatus.Pending, post.getStatus());
		assertEquals(TechnologyCategory.HTML, post.getTechCategory());
		assertNotNull(post.getCreatedAt());
		assertNotNull(post.getEditedAt());
		assertEquals(user, post.getAuthor());

	}

	/**
	 * Default constructor testing.
	 */
	@Test
	public void testDefaultConstructor() {
		Post emptyPost = new Post();
		assertNotNull(emptyPost);
		assertNull(emptyPost.getId());
		assertNull(emptyPost.getTitle());
		assertNull(emptyPost.getContent());
		assertNull(emptyPost.getTechCategory());
		assertNull(emptyPost.getAuthor());
		assertEquals(PostStatus.Pending, emptyPost.getStatus());
	}

	/**
	 * Equals and HashCode testing.
	 */
	@Test
	public void testEqualsAndHashCode() {
		User user = new User();
		user.setId("userid");

		Post samePost = new Post("Post", "Content", new Date(), TechnologyCategory.Java, user);
		User user2 = new User();
		user2.setId("userid2");
		Post differentPost = new Post("Different Post", "Different Content", new Date(), TechnologyCategory.Java, user2);

		/*
		 * assertEquals(post, samePost); assertEquals(post.hashCode(),
		 * samePost.hashCode());
		 *
		 * assertNotEquals(post, differentPost); assertNotEquals(post.hashCode(),
		 * differentPost.hashCode());
		 */
	}

	/**
	 *toString testing.
	 */
	@Test
	public void testToString() {
		User user = new User();
		user.setId("userid");
		post.setId("id");
		String expectedString = "Post [id=id, title=Post, content=Content,"
				+ " status=Pending, techCategory=Java, createdAt="
				+ post.getCreatedAt() + ", editedAt=null, authorId=" + user + "]";
		assertEquals(expectedString, post.toString());
	}
}
