package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.dto.PostInDto;
import com.example.demo.dto.PostOutDto;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.enumResource.TechnologyCategory;

import java.util.Date;

public class PostMapperTest {

		/**
		 * testing of InDto to Entity method.
		 */
    @Test
    public void testInDtoToPost() {
        PostInDto inDto = new PostInDto();
        inDto.setTitle("Test Post");
        inDto.setContent("This is a test post content.");
        inDto.setCreatedAt(new Date());
        inDto.setTechCategory(TechnologyCategory.HTML);
        User user = new User();
        user.setId("userid");
        inDto.setAuthor(user);

        Post post = PostMapper.inDtoToPost(inDto);
        assertEquals(inDto.getTitle(), post.getTitle());
        assertEquals(inDto.getContent(), post.getContent());
        assertEquals(inDto.getCreatedAt(), post.getCreatedAt());
        assertEquals(TechnologyCategory.HTML, post.getTechCategory());
        assertEquals(inDto.getAuthor(), post.getAuthor());
    }

    /**
     * Testing of Entity to OutDto method.
     */
    @Test
    public void testPostToOutDto() {
    		User user = new User();
    		user.setId("userid");
        Post post = new Post("Test Post", "This is a test post content.", new Date(), TechnologyCategory.HTML, user);
        PostOutDto outDto = PostMapper.postToOutDto(post);

        assertEquals("Test Post", outDto.getTitle());
        assertEquals("This is a test post content.", outDto.getContent());
        assertEquals(post.getCreatedAt(), outDto.getCreatedAt());
        assertEquals(TechnologyCategory.HTML, outDto.getTechCategory());
        assertEquals(user, outDto.getAuthor());
    }
}
