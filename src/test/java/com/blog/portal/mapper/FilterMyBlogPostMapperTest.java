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


    @Test
    public void testInDtoToPost() {
        FilterMyBlogPostInDto inDto = new FilterMyBlogPostInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.JAVA);
        inDto.setUserId("user123");
        inDto.setStatus(PostStatus.APPROVED);

        Post post = FilterMyBlogPostMapper.inDtoToPost(inDto);

        assertEquals("Sample Title", post.getTitle());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());
        assertEquals("user123", post.getUserId());
        assertEquals(PostStatus.APPROVED, post.getStatus());
    }


    @Test
    public void testPostToOutDto() {
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Title");
        post.setTechCategory(TechnologyCategory.JAVA);
        post.setStatus(PostStatus.APPROVED);
        post.setCreatedAt(new Date(12));
        post.setEditedAt(new Date(13));
        post.setContent("Sample content");
        post.setCommentBy(new ArrayList<>());

        FilterMyBlogPostOutDto outDto = FilterMyBlogPostMapper.postToOutDto(post);

        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechnology());
        assertEquals(PostStatus.APPROVED, outDto.getStatus());
        assertEquals(new Date(12), outDto.getCreatedAt());
        assertEquals(new Date(13), outDto.getEditedAt());
        assertEquals("Sample content", outDto.getContent());
        assertEquals("post123", outDto.getId());
        assertEquals(new ArrayList<>(), outDto.getCommentBy());
    }
}
