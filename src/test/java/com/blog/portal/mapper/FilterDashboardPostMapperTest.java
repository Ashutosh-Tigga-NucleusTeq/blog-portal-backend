package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.PostStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.FilterDashboardPostInDto;
import com.blog.portal.responsePayload.FilterDashboardOutDto;

public class FilterDashboardPostMapperTest {

	/**
	 * Testing of inDto to post method.
	 */
    @Test
    public void testInDtoToPost() {
        // Arrange
        FilterDashboardPostInDto inDto = new FilterDashboardPostInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.Java);

        // Act
        Post post = FilterDashboardPostMapper.inDtoToPost(inDto);

        // Assert
        assertEquals("Sample Title", post.getTitle());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());
    }

    /**
     * Testing of post to outDto method.
     */
    @Test
    public void testPostToOutDto() {
        // Arrange
        Post post = new Post();
        post.setId("post123");
        post.setUser(new User());
        post.setStatus(PostStatus.Approved);
        post.setContent("Sample content");
        post.setTechCategory(TechnologyCategory.Java);
        post.setTitle("Sample Title");
        Date date = new Date();
        post.setCreatedAt(date);
        post.setLikedBy(new HashSet<>());
        post.setDislikedBy(new HashSet<>());
        post.setComments(new ArrayList<>());

        // Act
        FilterDashboardOutDto outDto = FilterDashboardPostMapper.postToOutDto(post);

        // Assert
        assertEquals("post123", outDto.getId());
        assertEquals(new User(), outDto.getUser());
        assertEquals(PostStatus.Approved, outDto.getStatus());
        assertEquals("Sample content", outDto.getContent());
        assertEquals(TechnologyCategory.Java, outDto.getTechCategory());
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(date, outDto.getCreatedAt());
        assertEquals(new HashSet<>(), outDto.getLikedBy());
        assertEquals(new HashSet<>(), outDto.getDisLikedBy());
        assertEquals(new ArrayList<>(), outDto.getComments());
    }
}
