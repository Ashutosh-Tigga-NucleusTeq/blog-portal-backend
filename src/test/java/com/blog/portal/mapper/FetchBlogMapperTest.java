package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Blog;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.BlogOutDto;

public class FetchBlogMapperTest {
	
    @Test
    public void testEntityToOutDto() {
        Blog blog = new Blog();
        blog.setId("post123");
        blog.setTitle("Sample Title");
        blog.setContent("Sample Content");
        blog.setTechCategory(TechnologyCategory.JAVA);

        BlogOutDto outDto = FetchBlogMapper.entityToOutDto(blog);

        assertEquals("Sample Title", outDto.getTitle());
        assertEquals("Sample Content", outDto.getContent());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechCategory());
        assertEquals("post123", outDto.getId());
    }
}
