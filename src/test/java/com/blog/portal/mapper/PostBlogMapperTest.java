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

		/**
		 * Testing of inDto to Post mathod mapper.
		 */
    @Test
    public void testInDtoToPost() {
        // Create a PostBlogInDto for testing
        PostBlogInDto inDto = new PostBlogInDto();
        inDto.setTitle("Sample Post");
        inDto.setContent("This is a sample post content.");
        inDto.setCreatedAt(new Date());
        inDto.setTechCategory(TechnologyCategory.Java);

        // Call the inDtoToPost method
        Post post = PostBlogMapper.inDtoToPost(inDto);

        // Check if the Post object is created with the correct values
        assertEquals("Sample Post", post.getTitle());
        assertEquals("This is a sample post content.", post.getContent());
        assertEquals(TechnologyCategory.Java, post.getTechCategory());
        assertNotNull(post.getCreatedAt());
    }
    /**
     * Testing of Post to OutDto mapper method.
     */
    @Test
    public void testPostToOutDto() {
        // Create a Post object for testing
        Post post = new Post();
        post.setId("post123");
        post.setTitle("Sample Post");
        post.setContent("This is a sample post content.");
        post.setTechCategory(TechnologyCategory.Java);
        post.setCreatedAt(new Date());

        // Call the postToOutDto method
        PostBlogOutDto outDto = PostBlogMapper.postToOutDto(post);

        // Check if the PostBlogOutDto object is created with the correct values
        assertEquals("post123", outDto.getId());
        assertEquals("Sample Post", outDto.getTitle());
        assertEquals("This is a sample post content.", outDto.getContent());
        assertEquals(TechnologyCategory.Java, outDto.getTechCategory());
        assertNotNull(outDto.getCreatedAt());
    }
}
