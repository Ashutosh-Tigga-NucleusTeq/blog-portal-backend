package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.UserBlogsInDto;
import com.blog.portal.responsePayload.UserBlogsOutDto;

public class UserBlogMapperTest {


    @Test
    public void testInDtoToPost() {
        UserBlogsInDto inDto = new UserBlogsInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.JAVA);
        inDto.setUserId("user123");
        inDto.setStatus(BlogStatus.APPROVED);

        Blog blog = UserBlogMapper.inDtoToPost(inDto);

        assertEquals("Sample Title", blog.getTitle());
        assertEquals(TechnologyCategory.JAVA, blog.getTechCategory());
        assertEquals("user123", blog.getUserId());
        assertEquals(BlogStatus.APPROVED, blog.getStatus());
    }


    @Test
    public void testPostToOutDto() {
        Blog blog = new Blog();
        blog.setId("post123");
        blog.setTitle("Sample Title");
        blog.setTechCategory(TechnologyCategory.JAVA);
        blog.setStatus(BlogStatus.APPROVED);
        blog.setCreatedAt(new Date(12));
        blog.setEditedAt(new Date(13));
        blog.setContent("Sample content");
        blog.setCommentBy(new ArrayList<>());

        UserBlogsOutDto outDto = UserBlogMapper.postToOutDto(blog);

        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechnology());
        assertEquals(BlogStatus.APPROVED, outDto.getStatus());
        assertEquals(new Date(12), outDto.getCreatedAt());
        assertEquals(new Date(13), outDto.getEditedAt());
        assertEquals("Sample content", outDto.getContent());
        assertEquals("post123", outDto.getId());
        assertEquals(new ArrayList<>(), outDto.getCommentBy());
    }
}
