package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.FilterMyBlogPostInDto;
import com.blog.portal.responsePayload.FilterMyBlogPostOutDto;

public class FilterMyBlogPostMapperTest {

	/**
	 * Testing of inDto to Post mapper method.
	 */
    @Test
    public void testInDtoToPost() {
        // Arrange
        FilterMyBlogPostInDto inDto = new FilterMyBlogPostInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.Java);
        inDto.setUserId("user123");
        inDto.setStatus(PostStatus.Approved);

        // Act
        Post post = FilterMyBlogPostMapper.inDtoToPost(inDto);

        // Assert
        assertEquals("Sample Title", post.getTitle());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());
        assertEquals("user123", post.getUserId());
        assertEquals(PostStatus.Approved, post.getStatus());
    }

    /**
     * Testing of Post to OutDto mapper method.
     */
    @Test
    public void testPostToOutDto() {
        // Arrange
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Title");
        post.setTechCategory(TechnologyCategory.Java);
        post.setStatus(PostStatus.Approved);
        post.setCreatedAt(new Date());
        post.setEditedAt(new Date());
        post.setContent("Sample content");
        post.setComments(new ArrayList<>());

        // Act
        FilterMyBlogPostOutDto outDto = FilterMyBlogPostMapper.postToOutDto(post);

        // Assert
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(TechnologyCategory.Java, outDto.getTechnology());
        assertEquals(PostStatus.Approved, outDto.getStatus());
        assertEquals(new Date(), outDto.getCreatedAt());
        assertEquals(new Date(), outDto.getEditedAt());
        assertEquals("Sample content", outDto.getContent());
        assertEquals("post123", outDto.getId());
        assertEquals(new ArrayList<>(), outDto.getComments());
    }
}
