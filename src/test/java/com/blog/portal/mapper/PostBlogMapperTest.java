package com.blog.portal.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.PostBlogInDto;
import com.blog.portal.responsePayload.PostBlogOutDto;

public class PostBlogMapperTest {


    @Test
    public void testInDtoToPost() {
        PostBlogInDto inDto = new PostBlogInDto();
        inDto.setTitle("Sample Post");
        inDto.setContent("This is a sample post content.");
        inDto.setCreatedAt(new Date());
        inDto.setTechCategory(TechnologyCategory.JAVA);

        Post post = PostBlogMapper.inDtoToPost(inDto);

        assertEquals("Sample Post", post.getTitle());
        assertEquals("This is a sample post content.", post.getContent());
        assertEquals(TechnologyCategory.JAVA, post.getTechCategory());
        assertNotNull(post.getCreatedAt());
    }

    @Test
    public void testPostToOutDto() {
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Post");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.JAVA);
        post.setCreatedAt(new Date());

        PostBlogOutDto outDto = PostBlogMapper.postToOutDto(post);

        assertEquals("post123", outDto.getId());
        assertEquals("Sample Post", outDto.getTitle());
        assertEquals("This is a sample post content.", outDto.getContent());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechCategory());
        assertNotNull(outDto.getCreatedAt());
    }
}
