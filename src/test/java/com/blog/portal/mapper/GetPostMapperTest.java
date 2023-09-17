package com.blog.portal.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.blog.portal.entities.Post;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.GetPostOutDto;

public class GetPostMapperTest {
		/**
		 * Testing of entity to outDto method mapper.
		 */
    @Test
    public void testEntityToOutDto() {
        // Arrange
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Title");
        post.setContent("Sample Content");
        post.setTechCategory(TechnologyCategory.Java);

        // Act
        GetPostOutDto outDto = GetPostMapper.entityToOutDto(post);

        // Assert
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals("Sample Content", outDto.getContent());
        assertEquals(TechnologyCategory.Java, outDto.getTechCategory());
        assertEquals("post123", outDto.getId());
    }
}
