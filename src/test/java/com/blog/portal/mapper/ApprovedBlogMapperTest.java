package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Blog;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.BlogStatus;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.ApprovedBlogsInDto;
import com.blog.portal.responsePayload.ApprovedBlogsOutDto;

public class ApprovedBlogMapperTest {


    @Test
    public void testInDtoToPost() {
        ApprovedBlogsInDto inDto = new ApprovedBlogsInDto();
        inDto.setTitle("Sample Title");
        inDto.setTechCategory(TechnologyCategory.JAVA);

        Blog blog = ApprovedBlogMapper.inDtoToPost(inDto);

        assertEquals("Sample Title", blog.getTitle());
        assertEquals(TechnologyCategory.JAVA, blog.getTechCategory());
    }


    @Test
    public void testPostToOutDto() {
        Blog blog = new Blog();
        blog.setId("post123");
        blog.setUser(new User());
        blog.setStatus(BlogStatus.APPROVED);
        blog.setContent("Sample content");
        blog.setTechCategory(TechnologyCategory.JAVA);
        blog.setTitle("Sample Title");
        Date date = new Date();
        blog.setCreatedAt(date);
        blog.setLikedBy(new HashSet<>());
        blog.setDisLikedBy(new HashSet<>());
        blog.setCommentBy(new ArrayList<>());

        ApprovedBlogsOutDto outDto = ApprovedBlogMapper.postToOutDto(blog);

        assertEquals("post123", outDto.getId());
        assertEquals(new User(), outDto.getUser());
        assertEquals(BlogStatus.APPROVED, outDto.getStatus());
        assertEquals("Sample content", outDto.getContent());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechnology());
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals(date, outDto.getCreatedAt());
        assertEquals(new HashSet<>(), outDto.getLikedBy());
        assertEquals(new HashSet<>(), outDto.getDisLikedBy());
        assertEquals(new ArrayList<>(), outDto.getCommentBy());
    }
}
