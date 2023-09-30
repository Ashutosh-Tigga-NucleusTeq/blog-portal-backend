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
        FilterDashboardPostInDto inDto = new FilterDashboardPostInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.JAVA);

        Post post = FilterDashboardPostMapper.inDtoToPost(inDto);

        assertEquals("Sample Title", post.getTitle());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());
    }

    /**
     * Testing of post to outDto method.
     */
    @Test
    public void testPostToOutDto() {
        Post post = new Post();
        post.setId("post123");
        post.setUser(new User());
        post.setStatus(PostStatus.APPROVED);
        post.setContent("Sample content");
        post.setTechCategory(TechnologyCategory.JAVA);
        post.setTitle("Sample Title");
        Date date = new Date();
        post.setCreatedAt(date);
        post.setLikedBy(new HashSet<>());
        post.setDisLikedBy(new HashSet<>());
        post.setCommentBy(new ArrayList<>());

        FilterDashboardOutDto outDto = FilterDashboardPostMapper.postToOutDto(post);

        assertEquals("post123", outDto.getId());
        assertEquals(new User(), outDto.getUser());
        assertEquals(PostStatus.APPROVED, outDto.getStatus());
        assertEquals("Sample content", outDto.getContent());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechnology());
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(date, outDto.getCreatedAt());
        assertEquals(new HashSet<>(), outDto.getLikedBy());
        assertEquals(new HashSet<>(), outDto.getDisLikedBy());
        assertEquals(new ArrayList<>(), outDto.getCommentBy());
    }
}
