package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.GetPostOutDto;

public class GetPostMapperTest {
	
    @Test
    public void testEntityToOutDto() {
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Title");
        post.setContent("Sample Content");
        post.setTechCategory(TechnologyCategory.JAVA);

        GetPostOutDto outDto = GetPostMapper.entityToOutDto(post);

        assertEquals("Sample Title", outDto.getTitle());
        assertEquals("Sample Content", outDto.getContent());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechCategory());
        assertEquals("post123", outDto.getId());
    }
}
