package com.blog.portal.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Date;
import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.requestPayload.PostBlogInDto;

public class PostBlogMapperTest {


    @Test
    public void testInDtoToPost() {
        PostBlogInDto inDto = new PostBlogInDto();
        inDto.setTitle("Sample Blog");
        inDto.setContent("This is a sample post content.");
        inDto.setCreatedAt(new Date());
        inDto.setTechCategory(TechnologyCategory.JAVA);

        Blog blog = PostBlogMapper.inDtoToPost(inDto);

        assertEquals("Sample Blog", blog.getTitle());
        assertEquals("This is a sample post content.", blog.getContent());
        assertEquals(TechnologyCategory.JAVA, blog.getTechCategory());
        assertNotNull(blog.getCreatedAt());
    }


}
