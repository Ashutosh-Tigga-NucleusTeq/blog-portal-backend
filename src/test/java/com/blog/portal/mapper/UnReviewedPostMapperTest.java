package com.blog.portal.mapper;

import com.blog.portal.entities.Post;
import com.blog.portal.entities.User;
import com.blog.portal.enumResource.Designation;
import com.blog.portal.enumResource.TechnologyCategory;
import com.blog.portal.responsePayload.UnReviewedPostOutDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class UnReviewedPostMapperTest {

    private Post createMockPost() {
        Post post = new Post();
        post.setId("123");
        post.setTitle("Sample Title");
        post.setContent("Sample Content");
        post.setCreatedAt(new Date(12));
        post.setTechCategory(TechnologyCategory.JAVA);

        User user = new User();
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setDesignation(Designation.INTERN);
        post.setUser(user);

        return post;
    }

    @Test
    public void testEntityToOutDto() {
        Post post = createMockPost();

        UnReviewedPostOutDto outDto = UnReviewedPostMapper.entityToOutDto(post);

        assertEquals("firstname lastname", outDto.getUserName());
        assertEquals("123", outDto.getId());
        assertEquals("Sample Title", outDto.getTitle());
        assertEquals("Sample Content", outDto.getContent());
        assertEquals(new Date(12), outDto.getCreatedAt());
        assertEquals(TechnologyCategory.JAVA, outDto.getTechCategory());
        assertEquals(Designation.INTERN, outDto.getUserDesignation());
    }
}
