package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import com.example.demo.enumResource.TechnologyCategory;
import com.example.demo.model.User;

public class PostInDtoTest {

	/**
	 * Setter and Getter testing.
	 */
	@Test
	void testGettersAndSetters() {
		// Create a PostInDto object
		PostInDto postInDto = new PostInDto();

		// Set values using setters
		postInDto.setTitle("title");
		postInDto.setContent("content");
		Date createdAt = new Date();
		postInDto.setCreatedAt(createdAt);
		postInDto.setTechCategory(TechnologyCategory.Java);
		User user = new User();
		user.setId("userid");
		postInDto.setAuthorId(user);

		// Check if values can be retrieved using getters
		assertEquals("title", postInDto.getTitle());
		assertEquals("content", postInDto.getContent());
		assertEquals(createdAt, postInDto.getCreatedAt());
		assertEquals(TechnologyCategory.Java, postInDto.getTechCategory());
		assertEquals(user, postInDto.getAuthorId());
	}

	/**
	 * toString testing.
	 */
	@Test
	void testToString() {
		// Create a PostInDto object and set values
		PostInDto postInDto = new PostInDto();
		postInDto.setTitle("title");
		postInDto.setContent("content");
		Date createdAt = new Date();
		postInDto.setCreatedAt(createdAt);
		postInDto.setTechCategory(TechnologyCategory.Java);
		User user = new User();
		user.setId("userid");
		postInDto.setAuthorId(user);

		String expectedToString = "PostInDto [title=" + postInDto.getTitle()
				+ ", content=" + postInDto.getContent()
				+ ", createdAt=" + postInDto.getCreatedAt()
				+ ", authorId=" + postInDto.getAuthorId()
				+ ", techCategory=" + postInDto.getTechCategory() + "]";

		// Check if toString returns the expected string
		assertEquals(expectedToString, postInDto.toString());
	}
}
